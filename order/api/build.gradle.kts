plugins {
    id("api-convention")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":order:application"))
    implementation(project(":order:adapter-web"))
    implementation(project(":order:adapter-persistence"))
}