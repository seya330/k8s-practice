plugins {
    id("api-convention")
}

extra["createdImageName"] = "local/order-api"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":order:application"))
    implementation(project(":order:adapter-web"))
    implementation(project(":order:adapter-persistence"))
}