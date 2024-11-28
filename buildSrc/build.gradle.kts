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
    //여기서 가지고와야 하나?
    maven("https://repo.spring.io/milestone")
}

//configurations {
//    compileOnly {
//        extendsFrom(configurations.annotationProcessor.get())
//    }
//}



dependencies {
    implementation("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    implementation("io.spring.gradle:dependency-management-plugin:${springDependencyManagementVersion}")
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.springframework.boot:spring-boot-starter-data-redis")
//    implementation("org.springframework.boot:spring-boot-starter-validation")
//    implementation("org.springframework.boot:spring-boot-starter-web")

//    runtimeOnly("com.mysql:mysql-connector-j")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

//tasks.withType<Test> {
//    useJUnitPlatform()
//}
