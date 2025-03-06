# JUnit

JUnit 5 is composed of several different modules from three different sub-projects.

JUnit5 = JUnit platform + JUnit Jupiter + JUnit Vintage

1. JUnit Platform -serves as a foundation for launching testing frameworks on the JVM. It also defines the TestEngine API for developing a testing framework that runs on the platform. Furthermore, the platform provides a Console Launcher to launch the platform from the command line and the JUnit Platform Suite Engine for running a custom test suite using one or more test engines on the platform. First-class support for the JUnit Platform also exists in popular IDEs (see IntelliJ IDEA, Eclipse, NetBeans, and Visual Studio Code) and build tools (see Gradle, Maven, and Ant).
2. JUnit Jupiter - Is the combination of the programming model and extension model for writing tests and extensions in JUnit 5. The Jupiter sub-project provides a TestEngine for running Jupiter based tests on the platform
3. JUnit Vintage - provides a TestEngine for running JUnit 3 and JUnit 4 based tests on the platform. It requires JUnit 4.12 or later to be present on the class path or module path.

* JUnit 5 requires Java 8 (or higher) at runtime. However, you can still test code that has been compiled with previous versions of the JDK.

JUnit is a unit testing framework to write and run repeatable automated tests on Java. It provides a robust environment to write, organize, and execute automated tests, ensuring code reliability and repeatability. Its user-friendly annotations and assert methods facilitate the development and running of test cases, making it a foundational tool for Java developers focusing on quality assurance and test-driven development.

JUnit stands for Java Unit Testing.Main goal for Junit testing is developer can test his/her code to see if its working properly.

Unit could be:

1. Class
2. Collaborations of classes
3. Piece of code
4. Block of a code

## JUnit Annotations

1. @Test-Denotes that a method is a test method.Unlike JUnit 4's @Test annotation,this annotation does not declare any attributes,since test extensions in JUnit Jupiter operate based on their own dedicated annotations.Such methods are inherited unless overridden.Used to execute testcase
2. @BeforeClass - This annotation is used if you want to execute some statements before all the test cases for e.g. test connection must be executed before all the test cases.
3. AfterClass-This annotation can be used if you want to execute some statements after all test cases for e.g. Releasing resources after executing all test cases.
4. @RunWith - To execute group of Junit class at once
5. @Before - The method with this annotation gets executed before all the other tests.
6. @After - The method with this annotation gets executed after all the other tests are executed.
7. @Ignore - It is used to ignore a few test cases during execution.

## Project Structure

```js
projectName
    |-src/main/java
     -src/main/resource
     
     -src/test/java
     -src/test/resource
    |pom.xml
```

* The code under test folder(Junit source code & Junit resource file) will not be included in jar or war files.i.e not moved to production.Its not packaged/bundled in deployable artifact

## Advantages of Unit Testing

1. Reduced bugs
2. Quality code
3. Hundreds Testcase can be executed in milliseconds
4. Minor feature enhancements istead of depending on QA.

## Installations

It is an open-source software inform of jar file.

## Enabling Junit

1. Without Maven: Add jars file to the clsspath,so that we can access all classes of JUnit.
2. With Maven:Add JUnit dependency to pom.xml,so that jar file can be loaded automatically.

## Coding Standards

1. Every Junit class should be suffix with Test:

```java

//source code
public class Student{

}

//Unit test class
public class StudentTest{

}
```

- Controller----------->ControllerTest
- Service-------------->ServiceTest

2. Every junit method shoul be prefix with test.

```java

//source code
public class Student{

    public void getName(){
        
    }
}

//Unit test class
public class StudentTest{

 public void testGetName(){
        
    }
}
```

3. Every junit method access specifier should be public and return type void.

### Assertions

JUnit Jupiter comes with many of the assertion methods that JUnit 4 has and adds a few that lend themselves well to being used with Java 8 lambdas. All JUnit Jupiter assertions are static methods in the org.junit.jupiter.api.Assertions class.

Assertion methods optionally accept the assertion message as their third parameter, which can be either a String or a Supplier<String> .
When using a Supplier<String> (e.g., a lambda expression), the message is evaluated lazily. This can provide a performance benefit, especially if message construction is complex or time-consuming, as it is only evaluated when the assertion fails.
