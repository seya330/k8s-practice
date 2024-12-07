plugins {
    id("java-convention")
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":user:core"))
    implementation("org.springframework:spring-tx");
}