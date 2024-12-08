plugins {
    id("java-convention")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":user:application"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    runtimeOnly ("com.mysql:mysql-connector-j")
}