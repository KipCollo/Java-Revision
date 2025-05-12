# Gradle

Gradle Build Tool is a fast,dependable and adaptable open-source build automation tool with an elegant and extensible declarative build language.
Gradle automates building, testing, and deployment of software from information in build scripts.

Gradle supports Android,Java,C/C++,Kotlin Multiplatform,Scala,Javascript,Groovy.

Compatible IDE's includes:- Android studio,Intellij IDEA,Visual Studio Code,Eclipse and NetBeans.
You can also invoke Gradle via its command-line interface (CLI) in your terminal or through your continuous integration (CI) server.

## Core concepts

1. `Projects` - A Gradle project is a piece of software that can be built,such as application or library.Single project build includes a single project called the root project.Multi-project builds include one root project and number of subprojects.
2. `Build scripts` - Build scripts detail to Gradle what steps to take to build the project.Each project can include one or more build scripts.
3. `Dependencies and Dependency Management` - Dependency management is an automated technique for declaring and resolving external resources required by a project.Each 
4. `Tasks`:- Tasks are a basic unit of work such as compiling code or running your test.Each project contains one or more tasks defined inside a build script or a plugin.
5. `Plugins`:- Plugins are used to extend Gradle’s capability.Plugins optionally contribute tasks to a project.

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

## Invoking Gradle

- In the IDE:- Gradle is built-in to many IDEs including Android Studio, IntelliJ IDEA, Visual Studio Code, Eclipse, and NetBeans.
Gradle can be automatically invoked when you build, clean, or run your app in the IDE.

- Gradle can be invoked in the command line once installed:

```bash
gradle build
```

Most projects do not use the installed version of Gradle but rather the Gradle Wrapper.

- With the Gradle Wrapper:- The wrapper is a script that invokes a declared version of Gradle and is the recommended way to execute a Gradle build:

```bash
/gradlew build
```

## wrapper basics

The recommended way to execute any Gradle build is with the Gradle Wrapper.The wrapper script invokes a declared version of Gradle, downloading it beforehand if necessary.

It is available as a gradlew or gradlew.bat file in the project root directory:

root
├── gradlew     // THE WRAPPER
├── gradlew.bat // THE WRAPPER
└── ...

The wrapper is not something you download from the internet. You must generate it by running gradle wrapper from a machine with Gradle installed.

The wrapper provides the following benefits:

1. Automatically downloads and uses a specific Gradle version.
2. Standardizes a project on a given Gradle version.
3. Provisions the same Gradle version for different users and environments (IDEs, CI servers…​).
4. Makes it easy to run Gradle builds without installing Gradle manually.

- Using the Gradle Wrapper:- It’s important to distinguish between two ways of running Gradle:

1. Using a system-installed Gradle distribution — by running the gradle command.
2. Using the Gradle Wrapper — by running the gradlew or gradlew.bat script included in a Gradle project.

The Gradle Wrapper is always the recommended to execute a build with the wrapper to ensure a reliable, controlled, and standardized execution of the build.

Using a system-installed Gradle distribution:

```bash
gradle build
```

Using the Gradle Wrapper:

Wrapper invocation on a Linux or OSX machine:

```bash
./gradlew build
```

Wrapper invocation on Windows PowerShell:

```bash
$ gradlew.bat build
```

If you want to run the command in a different directory, you must provide the relative path to the wrapper:

```bash
$ ../gradlew build
```

The following console output demonstrates the use of the wrapper on a Windows machine, in the command prompt (cmd), for a Java-based project:

```bash
$ gradlew.bat build

Downloading https://services.gradle.org/distributions/gradle-5.0-all.zip
.....................................................................................
Unzipping C:\Documents and Settings\Claudia\.gradle\wrapper\dists\gradle-5.0-all\ac27o8rbd0ic8ih41or9l32mv\gradle-5.0-all.zip to C:\Documents and Settings\Claudia\.gradle\wrapper\dists\gradle-5.0-al\ac27o8rbd0ic8ih41or9l32mv
Set executable permissions for: C:\Documents and Settings\Claudia\.gradle\wrapper\dists\gradle-5.0-all\ac27o8rbd0ic8ih41or9l32mv\gradle-5.0\bin\gradle

BUILD SUCCESSFUL in 12s
1 actionable task: 1 executed
```

- wrapper files:- The following files are part of the Gradle Wrapper:

.
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar  
│       └── gradle-wrapper.properties
├── gradlew
└── gradlew.bat

- gradle-wrapper.jar: This is a small JAR file that contains the Gradle Wrapper code. It is responsible for downloading and installing the correct version of Gradle for a project if it’s not already installed.
- gradle-wrapper.properties: This file contains configuration properties for the Gradle Wrapper, such as the distribution URL (where to download Gradle from) and the distribution type (ZIP or TARBALL).
- gradlew: This is a shell script (Unix-based systems) that acts as a wrapper around gradle-wrapper.jar. It is used to execute Gradle tasks on Unix-based systems without needing to manually install Gradle.
- gradlew.bat: This is a batch script (Windows) that serves the same purpose as gradlew but is used on Windows systems.

NOTE:- You should never alter these files.

If you want to view or update the Gradle version of your project, use the command line:

```bash
./gradlew --version
./gradlew wrapper --gradle-version 7.2

gradlew.bat --version
gradlew.bat wrapper --gradle-version 7.2
```

## Command-Line Interface Basics

The command-line interface is the primary method of interacting with Gradle outside the IDE.

The Gradle CLI is the primary way to interact with a Gradle build from the terminal. You can use it to run tasks, inspect the build, manage dependencies, and control logging, all through flexible and powerful command-line options.

- Running commands:- To execute Gradle commands, use the following simple structure:

```bash
gradle [taskName...] [--option-name...]
```

You can specify one or more tasks separated by spaces.

```bash
gradle [taskName1 taskName2...] [--option-name...]
```

For example, to run a task named build, simply type:

```bash
gradle build
```

To clean first, and then build:

```bash
gradle clean build
```

## Build File Basics

Generally, a build script (build.gradle(.kts)) details build configuration, tasks, and plugins.
Every Gradle build comprises at least one build script.

`Build scripts` - The build script is either a build.gradle file written in Groovy or a build.gradle.kts file in Kotlin.

The Groovy DSL and the Kotlin DSL are the only accepted languages for Gradle scripts.
In multi-project builds, each subproject typically has its own build file located in its root directory.

Inside a build script, you’ll typically specify:

1. Plugins: Tools that extend Gradle’s functionality for tasks like compiling code, running tests, or packaging artifacts.
2. Dependencies: External libraries and tools your project uses.

Specifically, build scripts contain two main types of dependencies:

1. Gradle and Build Script Dependencies: These include plugins and libraries required by Gradle itself or the build script logic.
2. Project Dependencies: Libraries required directly by your project’s source code to compile and run correctly.

Example and break it down:

```groovy
//--app/build.gradle
plugins {   
    // Apply the application plugin to add support for building a CLI application in Java.
    id 'application'
}
dependencies {  
    // Use JUnit Jupiter for testing.
    testImplementation libs.junit.jupiter

    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'

    // This dependency is used by the application.
    implementation libs.guava
}
application {   
    // Define the main class for the application.
    mainClass = 'org.example.App'
}
```

```groovy
//--app/build.gradle.kts
plugins {   
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}
dependencies {  
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)
}
application {   
    // Define the main class for the application.
    mainClass = "org.example.App"
}
```
