plugins {
    `kotlin-dsl`
}

group = "com.honeybug"
version = "0.0.1-SNAPSHOT"
var springBootVersion = "3.4.0"
var springDependencyManagementVersion = "1.1.6"

repositories {
    mavenCentral()
    gradlePluginPortal()
}



dependencies {
    implementation("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    implementation("io.spring.gradle:dependency-management-plugin:${springDependencyManagementVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}
