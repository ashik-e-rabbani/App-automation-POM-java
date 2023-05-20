plugins {
    id("java")
}

group = "com.ashik"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
// https://mvnrepository.com/artifact/io.appium/java-client
    implementation("io.appium:java-client:7.6.0")
// https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.5.1")

}

tasks.test {
    useTestNG {
        suites(*arrayOf("src/test/resources/testSuites.xml"))
    }
}


