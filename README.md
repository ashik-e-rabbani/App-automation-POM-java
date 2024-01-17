# App Automation with Page Object Model (POM) in Java

## Overview

This project is an Android automation framework developed in Java using the Page Object Model (POM) design pattern. It utilizes the Appium framework for mobile automation and TestNG for test execution. The structure follows a modular approach, making it easy to maintain and scale as the application evolves.

## Dependencies

- [Appium Java Client](https://mvnrepository.com/artifact/io.appium/java-client) - Version 7.6.0
- [TestNG](https://mvnrepository.com/artifact/org.testng/testng) - Version 7.5.1

## Configuration

### Plugins
```groovy
plugins {
    id("java")
}

group = "com.ashik"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.appium:java-client:7.6.0")
    testImplementation("org.testng:testng:7.5.1")
}

tasks.test {
    useTestNG {
        suites(*arrayOf("src/test/resources/testSuites.xml"))
    }
}
```
#### Contributing
Feel free to contribute to this project by forking and creating pull requests. Issues and feature requests can be submitted through the GitHub issue tracker.
