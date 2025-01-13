# Lombok

Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.

## Introduction

"Boilerplate" is a term used to describe code that is repeated in many parts of an application with little alteration. One of the most frequently voiced criticisms of the Java language is the volume of this type of code that is found in most projects. This problem is frequently a result of design decisions in various libraries, but it's exacerbated by limitations in the language itself. Lombok aims to reduce the prevalence of some of the worst offenders by replacing them with a simple set of annotations.

While it is not uncommon for annotations to be used to indicate usage, to implement bindings, or even to generate code used by frameworks, they are generally not used for the generation of code that is directly utilized by the application. This is partly because doing so would require that the annotations be eagerly processed at development time. Project Lombok does just that. By integrating into the IDE, Project Lombok is able to inject code that is immediately available to the developer. For example, simply adding the @Data annotation to a data class, as below, results in a number of new methods in the IDE:
Data Annotation
Installation

Project Lombok is available as a single jar file on the project site. It includes the APIs for development as an installer for IDE integration. On most systems, simply double-clicking the jar file will launch the installer. If the system is not configured to correctly launch jar files, it can also be run from the command line as follows:

java -jar lombok.jar

The installer will attempt to detect the location of a supported IDE. If it cannot correctly determine where the IDE is installed, the location can be specified manually. Simply click "Install/Update," and IDE integration is complete.

At the time of this article's writing, only Eclipse and NetBeans are supported. However, the release of the IntelliJ IDEA source code has placed IDEA support as a possibility for future releases, and limited success has already been reported with JDeveloper.
Lombok Installer

The jar file will still need to be included in the classpath of any projects that will use Project Lombok annotations. Maven users can include Lombok as a dependency by adding this to the project pom.xml file:

```xml
    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>0.9.2</version>
        </dependency>
    </dependencies>
    <repositories>
        <repository>
            <id>projectlombok.org</id>
            <url>http://projectlombok.org/mavenrepo</url>
        </repository>
    </repositories>
```

## Lombok Annotations

There are a number of annotations in Project Lombok to allow for more fine grained control over the structure and behavior of a class.

- @Getter and @Setter:- The @Getter and @Setter annotations generate a getter and setter for a field, respectively.
The getters generated correctly follow convention for boolean properties, resulting in an isFoo getter method name instead of getFoo for any boolean field foo. It should be noted that if the class to which the annotated field belongs contains a method of the same name as the getter or setter to be generated, regardless of parameter or return types, no corresponding method will be generated.

Both the @Getter and @Setter annotations take an optional parameter to specify the access level for the generated method.

```java
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
public class GetterSetterExample {
/**
* Age of the person. Water is wet.
*
* @param age New value for this person's age. Sky is blue.
* @return The current value of this person's age. Circles are round.
*/
@Getter 
@Setter 
private int age = 10;
/**
* Name of the person.
* -- SETTER --
* Changes the name of this person.
*
* @param name The new value.
*/
@Setter(AccessLevel.PROTECTED) 
private String name;

@Override public String toString() {
return String.format("%s (age: %d)", name, age);
}
}
```

```java
public class GetterSetterExample {
/**
* Age of the person. Water is wet.
*/
private int age = 10;
/**
* Name of the person.
*/
private String name;
@Override public String toString() {
    return String.format("%s (age: %d)", name, age);
}
/**
* Age of the person. Water is wet.
*
* @return The current value of this person's age. Circles are round.
*/
public int getAge() {
    return age;
}
/**
* Age of the person. Water is wet.
*
* @param age New value for this person's age. Sky is blue.
*/
public void setAge(int age) {
    this.age = age;
}
/**
* Changes the name of this person.
*
* @param name The new value.
*/
protected void setName(String name) {
    this.name = name;
}
}
```

- @NoArgsConstructor, @RequiredArgsConstructor,@AllArgsConstructor:-

@NoArgsConstructor will generate a constructor with no parameters. If this is not possible (because of final fields), a compiler error will result instead, unless @NoArgsConstructor(force = true) is used, then all final fields are initialized with 0 / false / null . For �fields with constraints, such as @NonNull fields, no check is
generated,so be aware that these constraints will generally not be ful�lled until those �elds are properly initialized later. Certain java constructs, such as hibernate and the Service Provider Interface require a no-args constructor. This annotation is useful primarily in combination with either @Data or one of the other
constructor generating annotations.

@RequiredArgsConstructor generates a constructor with 1 parameter for each �eld that requires special handling. All non-initialized final �elds get a parameter, as well as any �elds that are marked as @NonNull that aren't initialized where they are declared. For those �elds marked with @NonNull , an explicit null check is also generated. The constructor will throw a NullPointerException if any of the parameters intended for the �elds marked with @NonNull contain null . The order of the parameters match the order in which the �elds appear in your class.

@AllArgsConstructor generates a constructor with 1 parameter for each �eld in your class. Fields marked with @NonNull result in null checks on those parameters.

Each of these annotations allows an alternate form, where the generated constructor is always private, and an additional static factory method that wraps around the private constructor is generated. This mode is enabled by supplying the staticName value for the annotation, like so:
@RequiredArgsConstructor(staticName="of") . Such a static factory method will infer generics, unlike a normal constructor. This means your API users get write MapEntry.of("foo", 5) instead of the much longer new MapEntry<String, Integer>("foo", 5) .

```java
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NonNull;
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ConstructorExample<T> {
    private int x, y;
    @NonNull private T description;

    @NoArgsConstructor
    public static class NoArgsExample {
        @NonNull private String field;
}
}
```

```java
public class ConstructorExample<T> {
    private int x, y;
    @NonNull private T description;

    private ConstructorExample(T description) {
        if (description == null) throw new NullPointerException("description")
        this.description = description;
    }

    public static <T> ConstructorExample<T> of(T description) {
        return new ConstructorExample<T>(description);
    }
    @java.beans.ConstructorProperties({"x", "y", "description"})
    protected ConstructorExample(int x, int y, T description) {
        if (description == null) throw new NullPointerException("description")
        this.x = x;
        this.y = y;
        this.description = description;
    }

public static class NoArgsExample {
    @NonNull private String field;
    public NoArgsExample() {
    }
    }
}
```

- @NonNull:- The @NonNull annotation is used to indicate the need for a fast-fail null check on the corresponding member. When placed on a field for which Lombok is generating a setter method, a null check will be generated that will result in a NullPointerException, should a null value be provided.

Additionally, if Lombok is generating a constructor for the owning class, then the field will be added to the constructor signature and the null check will be included in the generated constructor code.

This annotation mirrors @NotNull and @NonNull annotations found in IntelliJ IDEA and FindBugs, among others. Lombok is annotation agnostic with regards to these variations on the theme. If Lombok comes across any member annotated with any annotation of the name @NotNull or @NonNull, it will honor it by generating the appropriate corresponding code. The authors of Project Lombok further comment that, in the event that annotation of this type is added to Java, the Lombok version will be subject to removal.

Lombok annotated code from the class Family:

```java
@Getter 
@Setter
@NonNull
private List<Person> members;
```

Equivalent Java source code:

```java
@NonNull
private List<Person> members;
     
public Family(@NonNull final List<Person> members) {
    if (members == null) throw new java.lang.NullPointerException("members");
    this.members = members;
}
     
@NonNull
public List<Person> getMembers() {
    return members;
}
     
public void setMembers(@NonNull final List<Person> members) {
    if (members == null) throw new java.lang.NullPointerException("members");
    this.members = members;
}
```

- @ToString:- This annotation generates an implementation of the toString method.

By default, any non-static fields will be included in the output of the method in name-value pairs. If desired, the inclusion of the property names in the output can be suppressed by setting the annotation parameter includeFieldNames to false.

Specific fields can be excluded from the output of the generated method by including their field names in the exclude parameter. Alternatively, the of parameter can be used to list only those fields desired in the output.

The output of the toString method of a superclass can also be included by setting the callSuper parameter to true.

Lombok annotated code:

```java
@ToString(callSuper=true,exclude="someExcludedField")
public class Foo extends Bar {
    private boolean someBoolean = true;
    private String someStringField;
    @ToString.Exclude
    private float someExcludedField;
}
```

Equivalent Java source code:

```java
public class Foo extends Bar {
    private boolean someBoolean = true;
    private String someStringField;
    private float someExcludedField;
     
    @java.lang.Override
    public java.lang.String toString() {
        return "Foo(super=" + super.toString() +
            ", someBoolean=" + someBoolean +
            ", someStringField=" + someStringField + ")";
    }
}

```

- @EqualsAndHashCode:- This class level annotation will cause Lombok to generate both equals and hashCode methods, as the two are tied together intrinsically by the hashCode contract.

By default, any field in the class that is not static or transient will be considered by both methods. Much like @ToString, the exclude parameter is provided to prevent a field from being included in the generated logic. One can also use the of parameter to list only those fields that should be considered.

Also like @ToString, there is a callSuper parameter for this annotation. Setting it to true will cause equals to verify equality by calling the equals from the superclass before considering fields in the current class. For the hashCode method, it results in the incorporation of the results of the superclass's hashCode in the calculation of the hash.

When setting callSuper to true, be careful to make sure that the equals method in the parent class properly handles instance type checking. If the parent class checks that the class is of a specific type and not merely that the classes of the two objects are the same, this can result in undesired results. If the superclass is using a Lombok generated equals method, this is not an issue. However, other implementations may not handle this situation correctly.

Also note that setting callSuper to true cannot be done when the class only extends Object, as it would result in an instance equality check that short-circuits the comparison of fields. This is due to the generated method calling the equals implementation on Object, which returns false if the two instances being compared are not the same instance. As a result, Lombok will generate a compile time error in this situation.

Lombok annotated code:

```java
    @EqualsAndHashCode(callSuper=true,exclude={"address","city","state","zip"})
    public class Person extends SentientBeing {
        enum Gender { Male, Female }
     
        @NonNull private String name;
        @NonNull private Gender gender;
     
        private String ssn;
        private String address;
        private String city;
        private String state;
        private String zip;
    }
```

Equivalent Java source code:

```java
    public class Person extends SentientBeing {
     
        enum Gender {
            /*public static final*/ Male /* = new Gender() */,
            /*public static final*/ Female /* = new Gender() */;
        }
        @NonNull
        private String name;
        @NonNull
        private Gender gender;
        private String ssn;
        private String address;
        private String city;
        private String state;
        private String zip;
     
        @java.lang.Override
        public boolean equals(final java.lang.Object o) {
            if (o == this) return true;
            if (o == null) return false;
            if (o.getClass() != this.getClass()) return false;
            if (!super.equals(o)) return false;
            final Person other = (Person)o;
            if (this.name == null ? other.name != null : !this.name.equals(other.name)) return false;
            if (this.gender == null ? other.gender != null : !this.gender.equals(other.gender)) return false;
            if (this.ssn == null ? other.ssn != null : !this.ssn.equals(other.ssn)) return false;
            return true;
        }
     
        @java.lang.Override
        public int hashCode() {
            final int PRIME = 31;
            int result = 1;
            result = result * PRIME + super.hashCode();
            result = result * PRIME + (this.name == null ? 0 : this.name.hashCode());
            result = result * PRIME + (this.gender == null ? 0 : this.gender.hashCode());
            result = result * PRIME + (this.ssn == null ? 0 : this.ssn.hashCode());
            return result;
        }
    }
```

- @Data:-  It combines the functionality of @ToString, @EqualsAndHashCode, @Getter, @Setter and @RequiredArgsConstructor.

Essentially, using @Data on a class is the same as annotating the class with a default @ToString and @EqualsAndHashCode, as well as annotating each field with both @Getter and @Setter. Annotating a class with @Data also triggers Lombok's constructor generation. This adds a public constructor that takes any @NonNull or final fields as parameters. This provides everything needed for a Plain Old Java Object (POJO).

While @Data is extremely useful, it does not provide the same granularity of control as the other Lombok annotations. In order to override the default method generation behaviors, annotate the class, field, or method with one of the other Lombok annotations and specify the necessary parameter values to achieve the desired effect.

@Data does provide a single parameter option that can be used to generate a static factory method. Setting the value of the staticConstructor parameter to the desired method name will cause Lombok to make the generated constructor private and expose a a static factory method of the given name.

Lombok annotated code:

```java
@Data(staticConstructor="of")
public class Company {
    private final Person founder;
    private String name;
    private List<Person> employees;
}
```

Equivalent Java source code:

```java
public class Company {
    private final Person founder;
    private String name;
    private List<Person> employees;
     
    private Company(final Person founder) {
        this.founder = founder;
    }
     
    public static Company of(final Person founder) {
        return new Company(founder);
    }
     
    public Person getFounder() {
        return founder;
    }
     
    public String getName() {
        return name;
    }
     
    public void setName(final String name) {
        this.name = name;
    }
     
    public List<Person> getEmployees() {
        return employees;
    }
     
    public void setEmployees(final List<Person> employees) {
        this.employees = employees;
    }
     
    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        final Company other = (Company)o;
        if (this.founder == null ? other.founder != null : !this.founder.equals(other.founder)) return false;
        if (this.name == null ? other.name != null : !this.name.equals(other.name)) return false;
        if (this.employees == null ? other.employees != null : !this.employees.equals(other.employees)) return false;
        return true;
        }
     
    @java.lang.Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = result * PRIME + (this.founder == null ? 0 : this.founder.hashCode());
        result = result * PRIME + (this.name == null ? 0 : this.name.hashCode());
        result = result * PRIME + (this.employees == null ? 0 : this.employees.hashCode());
        return result;
    }
     
    @java.lang.Override
    public java.lang.String toString() {
        return "Company(founder=" + founder + ", name=" + name + ", employees=" + employees + ")";
    }
}
```

- @Cleanup

The @Cleanup annotation can be used to ensure that allocated resources are released. When a local variable is annotated with @Cleanup, any subsequent code is wrapped in a try/finally block that guarantees that the cleanup method is called at the end of the current scope.

By default @Cleanup assumes that the cleanup method is named "close," as with input and output streams. However, a different method name can be provided to the annotation's value parameter. Only cleanup methods that  take no parameters are able to be used with this annotation.

There is also a caveat to consider when using the @Cleanup annotation. In the event that an exception is thrown by the cleanup method, it will preempt any exception that was thrown in the method body. This can result in the actual cause of an issue being buried and should be considered when choosing to use Project Lombok's resource management. Furthermore, with automatic resource management on the horizon in Java 7, this particular annotation is likely to be relatively short-lived.

Lombok annotated code:

```java
    public void testCleanUp() {
        try {
            @Cleanup ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(new byte[] {'Y','e','s'});
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```

Equivalent Java source code:

```java
    public void testCleanUp() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                baos.write(new byte[]{'Y', 'e', 's'});
                System.out.println(baos.toString());
            } finally {
                baos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```

- @Synchronized:-

@Synchronized is a safer variant of the synchronized method modi�er. Like synchronized , the annotation
can be used on static and instance methods only. It operates similarly to the synchronized keyword, but it
locks on di�erent objects. The keyword locks on this , but the annotation locks on a �eld named $lock ,
which is private.
If the �eld does not exist, it is created for you. If you annotate a static method, the annotation locks on a
static �eld named $LOCK instead.
If you want, you can create these locks yourself. The $lock and $LOCK �elds will of course not be generated
if you already created them yourself. You can also choose to lock on another �eld, by specifying it as
parameter to the @Synchronized annotation. In this usage variant, the �elds will not be created
automatically, and you must explicitly create them yourself, or an error will be emitted.

Using the synchronized keyword on a method can result in unfortunate effects, as any developer who has worked on multi-threaded software can attest.

The synchronized keyword will lock on the current object (this) in the case of an instance method or on the class object for a static method. This means that there is the potential for code outside of the control of the developer to lock on the same object, resulting in a deadlock.

It is generally advisable to instead lock explicitly on a separate object that is dedicated solely to that purpose and not exposed in such a way as to allow unsolicited locking. Project Lombok provides the @Synchronized annotation for that very purpose.

Annotating an instance method with @Synchronized will prompt Lombok to generate a private locking field named $lock on which the method will lock prior to executing. Similarly, annotating a static method in the same way will generate a private static object named $LOCK for the static method to use in an identical fashion. A different locking object can be specified by providing a field name to the annotation's value parameter. When a field name is provided, the developer must define the property because Lombok will not generate it.

Lombok annotated code:

```java
import lombok.Synchronized;
public class SynchronizedExample {
    private final Object readLock = new Object();

    @Synchronized
    public static void hello() {
        System.out.println("world");
    }

    @Synchronized
    public int answerToLife() {
        return 42;
    }

    @Synchronized("readLock")
    public void foo() {
        System.out.println("bar");
    }
}
```

Equivalent Java source code:

```java
public class SynchronizedExample {
    private static final Object $LOCK = new Object[0];
    private final Object $lock = new Object[0];
    private final Object readLock = new Object();

    public static void hello() {
        synchronized($LOCK) {
         System.out.println("world");
     }
    }
    public int answerToLife() {
        synchronized($lock) {
         return 42;
        }
    }
    public void foo() {
        synchronized(readLock) {
            System.out.println("bar");
        }
    }
}
```

- @SneakyThrows

@SneakyThrows is probably the Project Lombok annotation with the most detractors, since it is a direct assault on checked exceptions. There is a lot of disagreement with regards to the use of checked exceptions, with a large number of developers holding that they are a failed experiment. These developers will love @SneakyThrows. Those developers on the other side of the checked/unchecked exception fence will most likely view this as hiding potential problems.

Throwing IllegalAccessException would normally generate an "Unhandled exception" error if IllegalAccessException, or some parent class, is not listed in a throws clause:
Unhandled Exception

When annotated with @SneakyThrows, the error goes away.
Sneaky Throws

By default, @SneakyThrows will allow any checked exception to be thrown without declaring in the throws clause. This can be limited to a particular set of exceptions by providing an array of throwable classes ( Class) to the value parameter of the annotation.

Lombok annotated code:

```java
    @SneakyThrows
    public void testSneakyThrows() {
        throw new IllegalAccessException();
    }
```

Equivalent Java source code:

```java
    public void testSneakyThrows() {
        try {
            throw new IllegalAccessException();
        } catch (java.lang.Throwable $ex) {
            throw lombok.Lombok.sneakyThrow($ex);
        }
```

A look at the above code and the signature of Lombok.sneakyThrow(Throwable) would lead most to believe that the exception is being wrapped in a RuntimeException and re-thrown; however this is not the case. The sneakyThrow method will never return normally and will instead throw the provided throwable completely unaltered.
Costs and Benefits

As with any technology choice, there are both positive and negative effects of using Project Lombok. Incorporating Lombok's annotations in a project can greatly reduce the number of lines of boilerplate code that are either generated in the IDE or written by hand. This results in reduced maintenance overhead, fewer bugs, and more readable classes.

That is not to say that there are not downsides to using Project Lombok annotations in your project.

Project Lombok is largely aimed at filling gaps in the Java language. As such, there is the possibility that changes to the language will take place that preclude the use of Lombok's annotations, such as the addition of first class property support.

Additionally, when used in combination with annotation-based object-relational mapping (ORM) frameworks, the number of annotations on data classes can begin to get unwieldy. This is largely offset by the amount of code that is superseded by the Lombok annotations. However, those who shun the frequent use of annotations may choose to look the other way.
What is missing?

Project Lombok provides the delombok utility for replacing the Lombok annotations with equivalent source code. This can be done for an entire source directory via the command line.

java -jar lombok.jar delombok src -d src-delomboked

Alternatively, an Ant task is provided for incorporation into a build process.

    <target name="delombok">
        <taskdef classname="lombok.delombok.ant.DelombokTask"
            classpath="WebRoot/WEB-INF/lib/lombok.jar" name="delombok" ></taskdef>
        <mkdir dir="src-delomboked" ></mkdir>
        <delombok verbose="true" encoding="UTF-8" to="src-delomboked"
            from="src" ></delombok>
    </target>
     

Both delombok and the corresponding Ant task come packaged in the core lombok.jar download. Along with allowing Lombok annotations to be useful in applications built using Google Web Toolkit (GWT) or other incompatible frameworks, running delombok on the Person class makes it easy to contrast the class as written using the Lombok annotations against code that includes the equivalent boilerplate inline.
```java
    package com.ociweb.jnb.lombok;
     
    import java.util.Date;
     
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.NonNull;
     
    @Data
    @EqualsAndHashCode(exclude={"address","city","state","zip"})
    public class Person {
        enum Gender { Male, Female }
     
        @NonNull private String firstName;
        @NonNull private String lastName;
        @NonNull private final Gender gender;
        @NonNull private final Date dateOfBirth;
     
        private String ssn;
        private String address;
        private String city;
        private String state;
        private String zip;
    }
```
The code utilizing the Project Lombok annotations is significantly more concise than the equivalent class with the boilerplate included.
```java
    package com.ociweb.jnb.lombok;
     
    import java.util.Date;
    import lombok.NonNull;
     
    public class Person {
     
        enum Gender {
            /*public static final*/ Male /* = new Gender() */,
            /*public static final*/ Female /* = new Gender() */;
        }
        @NonNull
        private String firstName;
        @NonNull
        private String lastName;
        @NonNull
        private final Gender gender;
        @NonNull
        private final Date dateOfBirth;
        private String ssn;
        private String address;
        private String city;
        private String state;
        private String zip;
     
        public Person(@NonNull final String firstName, @NonNull final String lastName,
                @NonNull final Gender gender, @NonNull final Date dateOfBirth) {
            if (firstName == null)
                throw new java.lang.NullPointerException("firstName");
            if (lastName == null)
                throw new java.lang.NullPointerException("lastName");
            if (gender == null)
                throw new java.lang.NullPointerException("gender");
            if (dateOfBirth == null)
                throw new java.lang.NullPointerException("dateOfBirth");
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.dateOfBirth = dateOfBirth;
        }
     
        @NonNull
        public String getFirstName() {
            return firstName;
        }
     
        public void setFirstName(@NonNull final String firstName) {
            if (firstName == null)
                throw new java.lang.NullPointerException("firstName");
            this.firstName = firstName;
        }
     
        @NonNull
        public String getLastName() {
            return lastName;
        }
     
        public void setLastName(@NonNull final String lastName) {
            if (lastName == null)
                throw new java.lang.NullPointerException("lastName");
            this.lastName = lastName;
        }
     
        @NonNull
        public Gender getGender() {
            return gender;
        }
     
        @NonNull
        public Date getDateOfBirth() {
            return dateOfBirth;
        }
     
        public String getSsn() {
            return ssn;
        }
     
        public void setSsn(final String ssn) {
            this.ssn = ssn;
        }
     
        public String getAddress() {
            return address;
        }
     
        public void setAddress(final String address) {
            this.address = address;
        }
     
        public String getCity() {
            return city;
        }
     
        public void setCity(final String city) {
            this.city = city;
        }
     
        public String getState() {
            return state;
        }
     
        public void setState(final String state) {
            this.state = state;
        }
     
        public String getZip() {
            return zip;
        }
     
        public void setZip(final String zip) {
            this.zip = zip;
        }
     
        @java.lang.Override
        public java.lang.String toString() {
            return "Person(firstName=" + firstName + ", lastName=" + lastName + 
                ", gender=" + gender + ", dateOfBirth=" + dateOfBirth +
                ", ssn=" + ssn + ", address=" + address + ", city=" + city +
                ", state=" + state + ", zip=" + zip + ")";
        }
     
        @java.lang.Override
        public boolean equals(final java.lang.Object o) {
            if (o == this) return true;
            if (o == null) return false;
            if (o.getClass() != this.getClass()) return false;
            final Person other = (Person)o;
            if (this.firstName == null
                    ? other.firstName != null
                    : !this.firstName.equals(other.firstName))
                return false;
            if (this.lastName == null
                    ? other.lastName != null
                    : !this.lastName.equals(other.lastName))
                return false;
            if (this.gender == null
                    ? other.gender != null
                    : !this.gender.equals(other.gender))
                return false;
            if (this.dateOfBirth == null
                    ? other.dateOfBirth != null
                    : !this.dateOfBirth.equals(other.dateOfBirth))
                return false;
            if (this.ssn == null
                    ? other.ssn != null
                    : !this.ssn.equals(other.ssn))
                return false;
            return true;
        }
     
        @java.lang.Override
        public int hashCode() {
            final int PRIME = 31;
            int result = 1;
            result = result * PRIME +
                (this.firstName == null ? 0 : this.firstName.hashCode());
            result = result * PRIME +
                (this.lastName == null ? 0 : this.lastName.hashCode());
            result = result * PRIME +
                (this.gender == null ? 0 : this.gender.hashCode());
            result = result * PRIME +
                (this.dateOfBirth == null ? 0 : this.dateOfBirth.hashCode());
            result = result * PRIME +
                (this.ssn == null ? 0 : this.ssn.hashCode());
            return result;
        }
    }
 ```    

Keep in mind that this is not just code that normally has to be written, but must also be read by maintaining developers. This means that, when using the annotations provided by Project Lombok, developers do not have to wade through countless lines of code in order to determine if the class in question is a simple data class or something more sinister.
Limitations

While Project Lombok does some dramatic things to make a developer's life easier, it has its limitations. Browsing the issues list will quickly illuminate some of the current shortcomings, most of which are minor.

One important problem is the inability to detect the constructors of a superclass. This means that if a superclass has no default constructor, any subclasses cannot use the @Data annotation without explicitly writing a constructor to make use of the available superclass constructor. Since Project Lombok respects any methods that match the name of a method to be generated, the majority of its feature shortcomings can be overcome using this approach.
Controversy

A number of issues have been raised against the use of Project Lombok. The most common argument holds that annotations were intended for "meta" information and are not to be used in such a way that would leave the codebase unable to be compiled were they removed. This is certainly the situation with Lombok annotations. New methods result from these annotations that are intended to be used not only by a framework, but by other parts of the application. Project Lombok's development-time support is its bread and butter, but this does have consequences, not the least of which is limited IDE support.

As previously stated, @SneakyThrows is bound to stir up the age-old argument over checked and unchecked exceptions. Opinions on this debate are often almost religious in their ferocity. As such, the arguments against the use of @SneakyThrows are also sure to excite fervor among the passionate.

Another point of contention is the implementation of both the code supporting IDE integration as well as the javac annotation processor. Both of these pieces of Project Lombok make use of non-public APIs to accomplish their sorcery. This means that there is a risk that Project Lombok will be broken with subsequent IDE or JDK releases.

Here is how one of the project founders, Reinier Zwitserloot described the situation:

    "It's a total hack. Using non-public API. Presumptuous casting (knowing that an annotation processor running in javac will get an instance of JavacAnnotationProcessor, which is the internal implementation of AnnotationProcessor (an interface), which so happens to have a couple of extra methods that are used to get at the live AST). On eclipse, it's arguably worse (and yet more robust) – a java agent is used to inject code into the eclipse grammar and parser class, which is of course entirely non-public API and totally off limits. If you could do what lombok does with standard API, I would have done it that way, but you can't. Still, for what its worth, I developed the eclipse plugin for eclipse v3.5 running on java 1.6, and without making any changes it worked on eclipse v3.4 running on java 1.5 as well, so it's not completely fragile."

Summary

Project Lombok is a powerful tool for the pragmatic developer. It provides a set of useful annotations for eliminating a tremendous amount of boilerplate code from your Java classes. In the best cases, a mere five characters can replace hundreds of lines of code. The result is Java classes that are clean, concise, and easy to maintain.

These benefits do come with a cost however. Using Project Lombok in an IntelliJ IDEA shop is simply not yet a viable option. There is a risk of breakage with IDE and JDK upgrades, as well as controversy surrounding the goals and implementation of the project.

What all this translates to is no different than what must be considered for any technology choice. There are always gains to be made and losses to be had. The question is simply whether or not Project Lombok can provide more value than cost for the project at hand. If nothing else, Project Lombok is sure to inject some new life into the discussion of language features that have withered on the vine thus far, and that is a win from any perspective.

- @Builder:- Implements the builder pattern,making object creation easier and more readable.
@Builder lets you automatically produce the code required to have your class be instantiable with code such as:

```java
Person.builder()
    .name("Adam Savage")
    .city("San Francisco")
    .job("Mythbusters")
    .job("Unchained Reaction")
    .build();
```

@Builder can be placed on a class, or on a constructor, or on a method. While the "on a class" and "on a constructor" mode are the most common use-case, @Builder is most easily explained with the "method" use-case.

A method annotated with @Builder (from now on called the target) causes the following 7 things to be generated:

    An inner static class named FooBuilder, with the same type arguments as the static method (called the builder).
    In the builder: One private non-static non-final field for each parameter of the target.
    In the builder: A package private no-args empty constructor.
    In the builder: A 'setter'-like method for each parameter of the target: It has the same type as that parameter and the same name. It returns the builder itself, so that the setter calls can be chained, as in the above example.
    In the builder: A build() method which calls the method, passing in each field. It returns the same type that the target returns.
    In the builder: A sensible toString() implementation.
    In the class containing the target: A builder() method, which creates a new instance of the builder.

Each listed generated element will be silently skipped if that element already exists (disregarding parameter counts and looking only at names). This includes the builder itself: If that class already exists, lombok will simply start injecting fields and methods inside this already existing class, unless of course the fields / methods to be injected already exist. You may not put any other method (or constructor) generating lombok annotation on a builder class though; for example, you can not put @EqualsAndHashCode on the builder class.

@Builder can generate so-called 'singular' methods for collection parameters/fields. These take 1 element instead of an entire list, and add the element to the list. For example:

```java
    Person.builder()
    .job("Mythbusters")
    .job("Unchained Reaction")
    .build();
```

would result in the List<String> jobs field to have 2 strings in it. To get this behavior, the field/parameter needs to be annotated with @Singular. The feature has its own documentation.

Now that the "method" mode is clear, putting a @Builder annotation on a constructor functions similarly; effectively, constructors are just static methods that have a special syntax to invoke them: Their 'return type' is the class they construct, and their type parameters are the same as the type parameters of the class itself.

Finally, applying @Builder to a class is as if you added @AllArgsConstructor(access = AccessLevel.PACKAGE) to the class and applied the @Builder annotation to this all-args-constructor. This only works if you haven't written any explicit constructors yourself or allowed lombok to create one such as with @NoArgsConstructor. If you do have an explicit constructor, put the @Builder annotation on the constructor instead of on the class. Note that if you put both `@Value` and `@Builder` on a class, the package-private constructor that `@Builder` wants to generate 'wins' and suppresses the constructor that `@Value` wants to make.

If using @Builder to generate builders to produce instances of your own class (this is always the case unless adding @Builder to a method that doesn't return your own type), you can use @Builder(toBuilder = true) to also generate an instance method in your class called toBuilder(); it creates a new builder that starts out with all the values of this instance. You can put the @Builder.ObtainVia annotation on the parameters (in case of a constructor or method) or fields (in case of @Builder on a type) to indicate alternative means by which the value for that field/parameter is obtained from this instance. For example, you can specify a method to be invoked: @Builder.ObtainVia(method = "calculateFoo").

The name of the builder class is FoobarBuilder, where Foobar is the simplified, title-cased form of the return type of the target - that is, the name of your type for @Builder on constructors and types, and the name of the return type for @Builder on methods. For example, if @Builder is applied to a class named com.yoyodyne.FancyList<T>, then the builder name will be FancyListBuilder<T>. If @Builder is applied to a method that returns void, the builder will be named VoidBuilder.

The configurable aspects of builder are:

    The builder's class name (default: return type + 'Builder')
    The build() method's name (default: "build")
    The builder() method's name (default: "builder")
    If you want toBuilder() (default: no)
    The access level of all generated elements (default: public).
    (discouraged) If you want your builder's 'set' methods to have a prefix, i.e. Person.builder().setName("Jane").build() instead of Person.builder().name("Jane").build() and what it should be.

Example usage where all options are changed from their defaults:
@Builder(builderClassName = "HelloWorldBuilder", buildMethodName = "execute", builderMethodName = "helloWorld", toBuilder = true, access = AccessLevel.PRIVATE, setterPrefix = "set")

Looking to use your builder with Jackson, the JSON/XML tool? We have you covered: Check out the @Jacksonized feature.
@Builder.Default

If a certain field/parameter is never set during a build session, then it always gets 0 / null / false. If you've put @Builder on a class (and not a method or constructor) you can instead specify the default directly on the field, and annotate the field with @Builder.Default:
@Builder.Default private final long created = System.currentTimeMillis();
Calling Lombok-generated constructors such as @NoArgsConstructor will also make use of the defaults specified using @Builder.Default however explicit constructors will no longer use the default values and will need to be set manually or call a Lombok-generated constructor such as this(); to set the defaults.
@Singular

By annotating one of the parameters (if annotating a method or constructor with @Builder) or fields (if annotating a class with @Builder) with the @Singular annotation, lombok will treat that builder node as a collection, and it generates 2 'adder' methods instead of a 'setter' method. One which adds a single element to the collection, and one which adds all elements of another collection to the collection. No setter to just set the collection (replacing whatever was already added) will be generated. A 'clear' method is also generated. These 'singular' builders are very complicated in order to guarantee the following properties:

    When invoking build(), the produced collection will be immutable.
    Calling one of the 'adder' methods, or the 'clear' method, after invoking build() does not modify any already generated objects, and, if build() is later called again, another collection with all the elements added since the creation of the builder is generated.
    The produced collection will be compacted to the smallest feasible format while remaining efficient.

@Singular can only be applied to collection types known to lombok. Currently, the supported types are:

    java.util:
        Iterable, Collection, and List (backed by a compacted unmodifiable ArrayList in the general case).
        Set, SortedSet, and NavigableSet (backed by a smartly sized unmodifiable HashSet or TreeSet in the general case).
        Map, SortedMap, and NavigableMap (backed by a smartly sized unmodifiable HashMap or TreeMap in the general case).
    Guava's com.google.common.collect:
        ImmutableCollection and ImmutableList (backed by the builder feature of ImmutableList).
        ImmutableSet and ImmutableSortedSet (backed by the builder feature of those types).
        ImmutableMap, ImmutableBiMap, and ImmutableSortedMap (backed by the builder feature of those types).
        ImmutableTable (backed by the builder feature of ImmutableTable).

If your identifiers are written in common english, lombok assumes that the name of any collection with @Singular on it is an english plural and will attempt to automatically singularize that name. If this is possible, the add-one method will use this name. For example, if your collection is called statuses, then the add-one method will automatically be called status. You can also specify the singular form of your identifier explicitly by passing the singular form as argument to the annotation like so: @Singular("axis") List<Line> axes;.
If lombok cannot singularize your identifier, or it is ambiguous, lombok will generate an error and force you to explicitly specify the singular name.

The snippet below does not show what lombok generates for a @Singular field/parameter because it is rather complicated. You can view a snippet here.

If also using setterPrefix = "with", the generated names are, for example, withName (add 1 name), withNames (add many names), and clearNames (reset all names).

Ordinarily, the generated 'plural form' method (which takes in a collection, and adds each element in this collection) will check if a null is passed the same way @NonNull does (by default, throws a NullPointerException with an appropriate message). However, you can also tell lombok to ignore such collection (so, add nothing, return immediately): @Singular(ignoreNullCollections = true.
With Jackson

You can customize parts of your builder, for example adding another method to the builder class, or annotating a method in the builder class, by making the builder class yourself. Lombok will generate everything that you do not manually add, and put it into this builder class. For example, if you are trying to configure jackson to use a specific subtype for a collection, you can write something like:

```java
@Value
@Builder
@JsonDeserialize(builder = JacksonExample.JacksonExampleBuilder.class)
public class JacksonExample {
	@Singular(nullBehavior = NullCollectionBehavior.IGNORE) private List<Foo> foos;
	
	@JsonPOJOBuilder(withPrefix = "")
	public static class JacksonExampleBuilder implements JacksonExampleBuilderMeta {
	}
	
	private interface JacksonExampleBuilderMeta {
		@JsonDeserialize(contentAs = FooImpl.class) JacksonExampleBuilder foos(List<? extends Foo> foos)
	}
}
```
With Lombok
```java
import lombok.Builder;
import lombok.Singular;
import java.util.Set;

@Builder
public class BuilderExample {
  @Builder.Default private long created = System.currentTimeMillis();
  private String name;
  private int age;
  @Singular private Set<String> occupations;
}
Vanilla Java
import java.util.Set;

public class BuilderExample {
  private long created;
  private String name;
  private int age;
  private Set<String> occupations;
  
  BuilderExample(String name, int age, Set<String> occupations) {
    this.name = name;
    this.age = age;
    this.occupations = occupations;
  }
  
  private static long $default$created() {
    return System.currentTimeMillis();
  }
  
  public static BuilderExampleBuilder builder() {
    return new BuilderExampleBuilder();
  }
  
  public static class BuilderExampleBuilder {
    private long created;
    private boolean created$set;
    private String name;
    private int age;
    private java.util.ArrayList<String> occupations;
    
    BuilderExampleBuilder() {
    }
    
    public BuilderExampleBuilder created(long created) {
      this.created = created;
      this.created$set = true;
      return this;
    }
    
    public BuilderExampleBuilder name(String name) {
      this.name = name;
      return this;
    }
    
    public BuilderExampleBuilder age(int age) {
      this.age = age;
      return this;
    }
    
    public BuilderExampleBuilder occupation(String occupation) {
      if (this.occupations == null) {
        this.occupations = new java.util.ArrayList<String>();
      }
      
      this.occupations.add(occupation);
      return this;
    }
    
    public BuilderExampleBuilder occupations(Collection<? extends String> occupations) {
      if (this.occupations == null) {
        this.occupations = new java.util.ArrayList<String>();
      }

      this.occupations.addAll(occupations);
      return this;
    }
    
    public BuilderExampleBuilder clearOccupations() {
      if (this.occupations != null) {
        this.occupations.clear();
      }
      
      return this;
    }

    public BuilderExample build() {
      // complicated switch statement to produce a compact properly sized immutable set omitted.
      Set<String> occupations = ...;
      return new BuilderExample(created$set ? created : BuilderExample.$default$created(), name, age, occupations);
    }
    
    @java.lang.Override
    public String toString() {
      return "BuilderExample.BuilderExampleBuilder(created = " + this.created + ", name = " + this.name + ", age = " + this.age + ", occupations = " + this.occupations + ")";
    }
  }
}
```

- @Slf4j: Adds a logger to the class without the need to manually create one

- @Value: Immutable classes can be easily created using this annotation.
- @Delegate: Delegates methods to another field or class, reducing the need for wrapper methods.
- @With: Generates methods that return a copy of the object with one or more fields modified.
- @Singular: Used with @Builder to create collections with singular elements.

Log:- There is multiple annotations for every logging library or packages.It will generate a logger field named log

- @CommonsLog - org.apache.commons.logging.log
- @Flogger - com.google.common.flogger.FluentLogger
- @JBossLog - org.jboss.logging.Logger
- @Log - java.util.logging.Logger
- @Log4j - org.apache.log4j.Logger
- @Log4j2 - org.apache.logging.log4j.Logger
- @Slf4j - org.slf4j.Logger.log
- @XSlf4j - org.slf4j.ext.XLogger

TODO @Accessors

## Variables

- val:- Can be used as type of local variable declaration instead of writing the type.The variables are marked as final.

```java
val map =new HashMap<Integer, String>();
map.put(0,"Lombok");
map.put(1,"Java");

for(val entry: map.entrySet()){
    System.out.println(entry.getKey() + entry.getValue());
}
```

```java
final Map<Integer, String> map =new HashMap<Integer, String>();
map.put(0,"Lombok");
map.put(1,"Java");

for(final Map.Entry<Integer, String> entry: map.entrySet()){
    System.out.println(entry.getKey() + entry.getValue());
}
```

- var:- Can be used as type of local variable declaration instead of writing the type.The variables are not marked as final and can be re-initialized.

```java
var map =new HashMap<Integer, String>();
map.put(0,"Lombok");
map.put(1,"Java");

for(var entry: map.entrySet()){
    System.out.println(entry.getKey() + entry.getValue());
}
```

```java
Map<Integer, String> map =new HashMap<Integer, String>();
map.put(0,"Lombok");
map.put(1,"Java");

for(Map.Entry<Integer, String> entry: map.entrySet()){
    System.out.println(entry.getKey() + entry.getValue());
}
```

## Benefits of Using Lombok

1. Reduces Boilerplate Code: Lombok significantly reduces the amount of repetitive code, making your codebase smaller and easier to manage.
2. Improves Readability and Maintainability: By eliminating boilerplate code, Lombok makes it easier to read and understand your classes. This can be especially helpful
in large projects.
3. Saves Development Time: With Lombok handling common tasks automatically, developers can focus on more complex and meaningful aspects of their code.
4. Supports Immutability: Lombok’s @Value annotation makes it easy to create immutable classes, promoting best practices in Java development.
5. Integration with IDEs: Lombok integrates well with most major Java IDEs (like IntelliJ IDEA, Eclipse, and VSCode), offering real-time feedback and support for code generation.

## Disadvantage of Lombok

1. Increased Compilation Time: Lombok can increase compilation time because it processes annotations during the compile phase, generating additional bytecode.
2. IDE Compatibility Issues: While Lombok supports most major IDEs,there can be occasional issues with IDEs not recognizing Lombok annotations properly, leading to confusion.
3. Learning Curve: Developers unfamiliar with Lombok might find the annotations confusing at first, especially when debugging or understanding code written by others.
4. Potential for Overuse: It's easy to overuse Lombok, leading to a lack of clarity in how objects are constructed or modified, particularly when using advanced features like @Builder and @Delegate.
5. Reduced Control: Automatically generated code can sometimes behave differently than hand-written code, particularly in edge cases,reducing the developer’s control over their codebase.

## When to Use and Avoid Lombok

- Use Lombok When:
    1. You’re working on a large project with a lot of repetitive code (getters, setters, etc.).
    2. You want to increase code readability and maintainability.
    3. You need quick prototyping with Java classes.
- Avoid Lombok When:
    1. You require complete control over generated code and how it behaves.
    2. You’re working with a team unfamiliar with Lombok, which might cause confusion.
    3. You’re facing issues with IDE compatibility or build processes due to Lombok.
