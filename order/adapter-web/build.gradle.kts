plugins {
    id("java-convention")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":order:application"))
}