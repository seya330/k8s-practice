import java.io.ByteArrayOutputStream
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
import java.nio.charset.Charset

plugins {
    id("java-convention")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}

//todo dependsOn으로 변경 및 플러그인으로 api-convention 으로 빼기?
val gitCommitHash: String by lazy {
    try {
        val stdout = ByteArrayOutputStream()
        exec {
            commandLine("git", "rev-parse", "--short", "HEAD")
            standardOutput = stdout
            errorOutput = ByteArrayOutputStream()
            isIgnoreExitValue = true
        }
        val gitHash = stdout.toString(Charset.defaultCharset()).trim()
        if (gitHash.isEmpty()) "unknown" else gitHash
    } catch (e: Exception) {
        "unknown"
    }
}

tasks.getByName<BootBuildImage>("bootBuildImage") {
    imageName = "local/order-api:$gitCommitHash"
    publish = false
}

tasks {
    bootJar { enabled = true }
    jar { enabled = false }
    bootBuildImage { enabled = true }
}