plugins {
    id("java-convention")
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":order:core"))
}