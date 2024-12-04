plugins {
    id("java-convention")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":order:application"))
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
}