import com.honeybug.gradle.GitCommitHashTask
import org.gradle.kotlin.dsl.*
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    id("java-convention")
}

val gitCommitHashTask = tasks.register<GitCommitHashTask>("gitCommitHashTask")

tasks.getByName<BootBuildImage>("bootBuildImage") {
    dependsOn(gitCommitHashTask)

    val gitCommitHashProvider = gitCommitHashTask
        .flatMap { task -> providers.fileContents(task.outputFile).asText.map { it.trim() } }

    imageName.set(gitCommitHashProvider.map { hash -> "local/order-api:${hash}" })
    publish = false
}

tasks {
    bootJar { enabled = true }
    jar { enabled = false }
    bootBuildImage { enabled = true }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}