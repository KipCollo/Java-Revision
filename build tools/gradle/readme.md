# Gradle

Gradle automates building, testing, and deployment of software from information in build scripts.

## Gradle project structure

The presence of the gradlew and gradlew.bat files in the root directory of a project is a clear indicator that Gradle is used.

A Gradle project will look similar to the following:

project
├── gradle                              
│   ├── libs.versions.toml              
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew                             
├── gradlew.bat                         
├── settings.gradle(.kts)               
├── subproject-a
│   ├── build.gradle(.kts)              
│   └── src                             
└── subproject-b
    ├── build.gradle(.kts)              
    └── src 

## Dependency Management

Dependency management is an automated technique for declaring and resolving external resources required by a project.
Gradle build scripts define the process to build projects that may require external dependencies. Dependencies refer to JARs, plugins, libraries, or source code that support building your project

### Version Catalog

Version catalogs provide a way to centralize your dependency declarations in a libs.versions.toml file.
The catalog makes sharing dependencies and version configurations between subprojects simple. It also allows teams to enforce versions of libraries and plugins in large projects.
The version catalog typically contains four sections:
 - [versions] to declare the version numbers that plugins and libraries will reference.
 - [libraries] to define the libraries used in the build files.
 - [bundles] to define a set of dependencies.
 - [plugins] to define plugins.

```[versions]
androidGradlePlugin = "7.4.1"
mockito = "2.16.0"

[libraries]
googleMaterial = { group = "com.google.android.material", name = "material", version = "1.1.0-alpha05" }
mockitoCore = { module = "org.mockito:mockito-core", version.ref = "mockito" }

[plugins]
androidApplication = { id = "com.android.application", version.ref = "androidGradlePlugin" }
```
The file is located in the gradle directory so that it can be used by Gradle and IDEs automatically. The version catalog should be checked into source control: gradle/libs.versions.toml.

 ### Declaring dependencies

To add a dependency to your project, specify a dependency in the dependencies block of your build.gradle(.kts) file.
The following build.gradle.kts file adds a plugin and two dependencies to the project using the version catalog above:

```gradle
plugins {
   alias(libs.plugins.androidApplication)  
}

dependencies {
    // Dependency on a remote binary to compile and run the code
    implementation(libs.googleMaterial)    

    // Dependency on a remote binary to compile and run the test code
    testImplementation(libs.mockitoCore)   
}
```

Dependencies in Gradle are grouped by configurations.
- The material library is added to the implementation configuration, which is used for compiling and running production code.
- The mockito-core library is added to the testImplementation configuration, which is used for compiling and running test code

 ### Viewing Project Dependencies
You can view your dependency tree in the terminal using the ./gradlew :app:dependencies command

```build.gradle
plugins {
  id 'java'
  id 'org.springframework.boot' version '3.3.4'
  id 'io.spring.dependency-management' version '1.1.6'
}

group = 'com.kipcollo'
version = '0.0.1-SNAPSHOT'

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

configurations {
  compileOnly {
    extendsFrom annotationProcessor
  }
}

repositories {
  mavenCentral()
}

dependencies {
  implementation 'org.springframework.boot:spring-boot-starter-web'
  compileOnly 'org.projectlombok:lombok'
  annotationProcessor 'org.projectlombok:lombok'
  testImplementation 'org.springframework.boot:spring-boot-starter-test'
  testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}

tasks.named('test') {
  useJUnitPlatform()
}
```