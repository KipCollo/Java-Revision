# JUnit

JUnit is a testing framework for java.It is used to write and run repeatable tests.It helps verify that individual units of code work as expected.
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

## Junit features

Has annotations which make test management easy.
Assertions are used to check expected results
Test runners execute your tests and report results
Supports build tools i.e Maven,Gradle

* The class or system we want to test is known as `System Under Test SUT` or `Class Under Test`.The method or function we want to test is known as `Method Under Test`.
* A `test class` in JUnit is a regular Java class that contains one or more test methods.These test methods are annotated with @Test and contain logic to test a specific piece of code.
* A `test method` is a method within test class that is annotated with @Test.This method contains assertions that check the expected outcomes of the code being executed.Test method can be public,protected, or default(package-private) visibility.
* Assertions are used to check whether the code under test behaves as expected.JUnit provides several assertion methods such as `assertEquals`, `assertTrue`,`assertFalse` and `assertThrows`.
* The `test runner` is responsible for executing test methods in a test class and reporting the results.In JUnit,test runner is typically provided by an IDE or build tool such as Eclipse,Maven,Gradle.

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
4. Minor feature enhancements instead of depending on QA.

## Installations

It is an open-source software inform of jar file.

Enabling Junit

1. Without Maven: Add jars file to the classpath,so that we can access all classes of JUnit.
2. With Maven:Add JUnit dependency to pom.xml,so that jar file can be loaded automatically.

## Coding Standards

1. Every Junit class should be suffix with Test:
    * Controller----------->ControllerTest
    * Service-------------->ServiceTest

2. Every junit method should be prefix with test.
3. Every junit method access specifier should be public and return type void.

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

`Annotations`:-

JUnit provides annotations to define test execution lifecycle methods.These methods help set up and clean up resources for tests.Includes `@BeforeEach`,`@AfterEach`,`@BeforeAll`,`@AfterAll`.

@BeforeEach - Runs before every single test method in our class.i.e getting everything ready before starting a task.Useful for setting up test environments such as initializing objects and setting initial conditions.Avoids duplicate code and ensures clean state for every test method.
@AfterEach - Runs right after each test method finishes.It's like cleaning up after you finish a task.Useful for cleaning test environments,such as resetting variables or closing connections
@BeforeAll - Runs once before all tests in a class.Different from @BeforeEach because it only runs one time.Useful for setting up shared resources such as establishing database connection or starting a server.Must be a static method.Ideal for expensive setup that don't need to be repeated.
@AfterAll - Runs once after all tests in a class have finished.Different from @AfterEach because it only runs one time.Useful for cleaning shared resources i.e database connection,shutting down server.Method must be static.

1. @Test-Denotes that a method is a test method.Unlike JUnit 4's @Test annotation,this annotation does not declare any attributes,since test extensions in JUnit Jupiter operate based on their own dedicated annotations.Such methods are inherited unless overridden.Used to execute testcase.It marks a method as test method.JUnit automatically runs all methods annotated with `@Test`.
2. @BeforeClass - This annotation is used if you want to execute some statements before all the test cases for e.g. test connection must be executed before all the test cases.
3. @AfterClass-This annotation can be used if you want to execute some statements after all test cases for e.g. Releasing resources after executing all test cases.
4. @RunWith - To execute group of Junit class at once
5. @Before - The method with this annotation gets executed before all the other tests.
6. @After - The method with this annotation gets executed after all the other tests are executed.
7. @Ignore - It is used to ignore a few test cases during execution.
8. @DisplayName - Used to define custom name for a test method or a test class.It helps to provide descriptive names that can improve readability of test results.By default,the test class name and test method names get printed when the test case is executed.Takes strings with spaces between words,special characters and emojis.
9. @Disabled - It used to disable a test method or a test class.JUnit will skip the execution of @Disabled annotated test methods or all test methods within the annotated class.
    * Test is disabled because:- Known issues,Incomplete features,Refactoring,External dependencies.

`Assertions`:-Assertions are used to check whether results are as expected.
JUnit Jupiter comes with many of the assertion methods that JUnit 4 has and adds a few that lend themselves well to being used with Java 8 lambdas. All JUnit Jupiter assertions are static methods in the org.junit.jupiter.api.Assertions class.

Assertion methods optionally accept the assertion message as their third parameter, which can be either a String or a Supplier<String> .
When using a Supplier<String> (e.g., a lambda expression), the message is evaluated lazily. This can provide a performance benefit, especially if message construction is complex or time-consuming, as it is only evaluated when the assertion fails.

* JUnit Assertions class includes static methods:-
    1. `assertTrue method`:- Helps us validate that the value supplied to it is true.It takes an actual value and checks whether it is true or not.If actual value is true,the test will pass else if false, test will fail.It is an overloaded method.
    2. `assertFalse method`:-
    3. `assertNull method`:- Helps us validate actual object is null.It takes an actual object and checks whether it is null.If the object is null,test case will pass else it will fail.
    4. `assertNotNull method`:- Checks that the actual object is not null.Takes an actual object and checks whether it is not null.If object is not null,test case will pass else it will fail.
    5. `assertEquals method`:- Is used to verify that two values are equal(actual value and expected value).If actual value is equal to expected value,test case passes else fails.
    6. `assertNotEquals method`:- Is used to verify that two values are not equal(actual value and expected value).If actual value is not equal to expected value,test case will pass else it fails.
    7. `assertThrows method`:- Used to assert that a block of code throws a specific type of exception.If code does not throw exception the assertion fails,and the test is marked as failed.If code throws the expected exception,assertion passes and test is marked as passed.It follows an inheritance hierarchy:the assertion will pass if expected type is the superclass(parent) of actual exception type(subclass).

`Test runners` execute tests and report results.

JUnit can be integrated with IDEs and build tools for easy execution.

## Examples

```java
public class Student{

    private int id;
    private String name;

    public Student(String name,int id){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String message){
        super(message);
    }
}

public class StudentService{

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents(){
        return this.students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public Student getStudentById(int id){
        return students.stream()
        .filter((student) -> student.getId())
        .findFirst()
        .orElse(null);
    }

    public Student getStudentByName(String name){
        students.stream()
        .filter((student) -> student.getName().equals(name))
        .findFirst()
        .orElseThrow(() -> new StudentNotFoundException("Student not found with the name: " + name));
    }
}
```

Test classes

```java
@DisplayName("Student Service Test")
public StudentServiceTest{

    private Student student;
    private static Student studs;

    @BeforeEach
    void setUp(){
        student = new Student(1,"Collins");
    }

    @BeforeAll
    static void setUpBeforeClass(){
        studs = new Student(1,"Collins")
    }

    @AfterEach
    void destroy(){
        student = null;
    }

    @afterAll
    static void destroyAfterClass(){
        studs = null;
    }

    @Test
    @DisplayName("testing assertTrue")
    public void getStudentsTest(){//using assertTrue
        StudentService studentService = new StudentService();

        List<Student> listOfStudents = studentService.getStudents();
        studentService.addStudent(student);
        boolean actualResult = listOfStudents.isEmpty();

        assertTrue(actualResult);//Test Fails since student is not empty
        assertTrue(()-> actualResult);
        assertTrue(actualResult,"List of Students is Empty");
        assertTrue(() -> actualResult,"List of Students is Empty");
        assertTrue(actualResult,() -> "List of Student is Empty");
        assertTrue(() -> actualResult,() -> "List of student is empty");
    }

    @Test
    @DisplayName("Testing assertFalse method")
    public void getStudentsTest(){//using assertFalse
        StudentService studentService = new StudentService();

        List<Student> listOfStudents = studentService.getStudents();
        studentService.addStudent(student);
        boolean actualResult = listOfStudents.isEmpty();

        assertFalse(actualResult);//Test passes since student is not empty
        assertFalse(()-> actualResult);
        assertFalse(actualResult,"List of Students is Empty");
        assertFalse(() -> actualResult,"List of Students is Empty");
        assertFalse(actualResult,() -> "List of Student is Empty");
        assertFalse(() -> actualResult,() -> "List of student is empty");
    }

    @Test
    @DisplayName("Testing assertNull")
    public void getStudentByIdTest(){//using assertNull

        StudentService studentService = new StudentService();

        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(1);
        Student anotherObject = studentService.getStudentById(2);

        assertNull(actualObject);//Fails as student exists
        assertNull(anotherObject);//Passes as there's no object with given ID.

        assertNull(actualObject,"Student object is null!");
        assertNull(actualObject,() -> "Student object is null");

    }

    @Test
    @DisplayName("Testing assertNotNull")
    public void getStudentByIdTest(){//using assertNotNull

        StudentService studentService = new StudentService();

        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(1);
        Student anotherObject = studentService.getStudentById(2);

        assertNotNull(actualObject);//Passes as student exists
        assertNotNull(anotherObject);//Fails as there's no object with given ID.

        assertNotNull(actualObject,"Student object is null!");
        assertNotNull(actualObject,() -> "Student object is null");

    }


    @Test
    @DisplayName("Testing assertEquals")
    public void getStudentByIdTest(){//using assertEquals

        StudentService studentService = new StudentService();

        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(1);
        Student anotherObject = studentService.getStudentById(2);

        assertEquals(1,actualObject.getId());//Passes as student ID exists
        assertEquals("Collins",actualObject.getName());//Passes as there's an object with given name.
        assertEquals(student,actualObject);
        assertEquals(1,actualObject.getId(),"Student ID is not Equal");
        assertEquals("Collins",actualObject.getName(),() -> "Student name is not Equal");

    }

    @Test
    @DisplayName("Testing assertNotEquals")
    public void getStudentByIdTest(){//using assertNotEquals

        StudentService studentService = new StudentService();

        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(1);
        Student anotherObject = studentService.getStudentById(2);

        assertNotEquals(1,actualObject.getId());//Fails as student ID exists
        assertNotEquals(2,actualObject.getId());//Passes as student ID doesn't exists
        assertNotEquals("Collins",actualObject.getName());//Fails as there's an object with given name.
        assertNotEquals(student,another Object);
        assertNotEquals(1,actualObject.getId(),"Student ID is Equal");
        assertNotEquals("Collins",actualObject.getName(),() -> "Student name is Equal");

    }

    @Test
    @Disabled
    @DisplayName("Testing assertThrows")
    public void getStudentByNameTest(){//using assertThrows

    StudentService studentService = new StudentService();

    studentService.addStudent(student);

    assertThrows(StudentNotFoundException.class,() -> {
        studentService.getStudentByName("Collins");
    })

     assertThrows(StudentNotFoundException.class,() -> {
        studentService.getStudentByName("Collins");
    },"StudentFoundException should be thrown.But it wasn't.")

    }


}
```
