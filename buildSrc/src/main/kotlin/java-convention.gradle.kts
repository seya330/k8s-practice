plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("java")
    id("java-library")
}

var mapstructVersion = "1.6.3"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.compileJava {
    options.compilerArgs.addAll(listOf(
        "-Amapstruct.suppressGeneratorTimestamp=true",
        "-Amapstruct.suppressGeneratorVersionInfoComment=true",
        "-Amapstruct.verbose=true",
        "-Amapstruct.defaultComponentModel=spring",
        "-Amapstruct.unmappedTargetPolicy=ERROR",
        "-Amapstruct.unmappedSourcePolicy=WARN",
    ))
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2024.0.0")
    }
}

dependencies {
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.mapstruct:mapstruct")
    annotationProcessor("org.mapstruct:mapstruct-processor")
    implementation("org.mapstruct:mapstruct:${mapstructVersion}")
    annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")
    testImplementation("com.navercorp.fixturemonkey:fixture-monkey-starter:1.1.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks {
    bootJar { enabled = false }
    jar { enabled = true }
    bootBuildImage { enabled = false }
}

tasks.withType<Test> {
    useJUnitPlatform()
}