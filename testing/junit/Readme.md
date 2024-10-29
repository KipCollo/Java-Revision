# JUnit

JUnit is a unit testing framework to write and run repeatable automated tests on Java. It provides a robust environment to write, organize, and execute automated tests, ensuring code reliability and repeatability. Its user-friendly annotations and assert methods facilitate the development and running of test cases, making it a foundational tool for Java developers focusing on quality assurance and test-driven development. 

JUnit stands for Java Unit Testing.Main goal forr Junit testing is developer can test his/her code to see if its working properly.

Unit could be:
1. Class
2. Collaborations of classes
3. Piece of code
4. Block of a code

## Project Structure

```
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

## JUnit Annotations
1. @RunWith - To execute group of Junit class at once
2. @BeforeClass - This annotation is used if you want to execute some statements before all the test cases for e.g. test connection must be executed before all the test cases.
3. AfterClass-This annotation can be used if you want to execute some statements after all test cases for e.g. Releasing resources after executing all test cases.
4. @Test-Used to execute testcase
5. @Before - The method with this annotation gets executed before all the other tests.
6. @After - The method with this annotation gets executed after all the other tests are executed.
7. @Ignore - It is used to ignore a few test cases during execution.