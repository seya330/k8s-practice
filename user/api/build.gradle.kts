plugins {
    id("api-convention")
}

extra["createdImageName"] = "local/user-api"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":user:application"))
    implementation(project(":user:adapter-persistence"))
    implementation("org.springframework.security:spring-security-core")
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    implementation("org.springframework.security:spring-security-config")
    implementation("org.springframework.security:spring-security-core")
    implementation("org.springframework.security:spring-security-web")
    implementation("org.springframework.security:spring-security-crypto")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    implementation("org.zalando:problem-spring-web-starter:0.29.1")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
}