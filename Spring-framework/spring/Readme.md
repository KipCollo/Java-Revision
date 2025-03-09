# Spring

The Spring Framework is a lightweight solution for building your enterprise-ready applications.Spring is modular, allowing you to use only those parts that you need, without having to bring in the rest. You can use the IoC container, with any web framework on top, but you can also use only the Hibernate integration code or the JDBC abstraction layer. The Spring Framework supports declarative transaction management, remote access to your logic through RMI or web services, and various options for persisting your data. It offers a full-featured MVC framework, and enables you to integrate AOP transparently into your software.

Spring is designed to be non-intrusive, meaning that your domain logic code generally has no dependencies on the framework itself. In your integration layer (such as the data access layer), some dependencies on the data access technology and the Spring libraries will exist. However, it should be easy to isolate these dependencies from the rest of your code base.

Spring enables you to build applications from "plain old Java objects" (POJOs) and to apply enterprise services non-invasively to POJOs. This capability applies to the Java SE programming model and to full and partial Java EE.It makes J2EE app development easier.

* Drawbacks of J2EE

1. Tightly coupled - Applications should extend Servlet,EJB
2. HeavyWeight - app startup takes more extra processing
3. Boilerplate code - Common code is repeated in multiple places todo some activities
4. Cross cutting concerns - Doesn't support security,transaction.., needs to be implemented manually.

Rod Johnson developed Spring due to J2EE drawbacks.It was originally called interace21.

* Advantages of spring

1. Makes app dev easier.
2. Light weight
3. Modularity
4. POJO development: Doesn't need extending or implementing any spring f/w classes.
5. Loosely coupled

Spring can be used to develop:

1. Standalone apps
2. Web applications
3. Distributed Apps
4. Reactive Programming
5. Batch Apps
6. Security

To develop diff types of apps, Spring teams introduced many modules is spring framework.

## Modules

The Spring Framework consists of features organized into about 20 modules. These modules are grouped into Core Container, Data Access/Integration, Web, AOP (Aspect Oriented Programming), Instrumentation, and Test.

Spring Framework Runtime:

1. Data access/Intergration: JDBC, ORM, OXM, JMS, Transactions
2. Web: Websocket,Servlet,Web,Portlet
3. AOP
4. Aspects
5. Instrumentation
6. Messaging
7. Core Container: Beans,Core,Context,SpEL
8. Test

## Dependency Injection and Inversion of Control

Java applications — a loose term that runs the gamut from constrained applets to n-tier server-side enterprise applications — typically consist of objects that collaborate to form the application proper. Thus the objects in an application have dependencies on each other.

Although the Java platform provides a wealth of application development functionality, it lacks the means to organize the basic building blocks into a coherent whole, leaving that task to architects and developers. True, you can use design patterns such as Factory, Abstract Factory, Builder, Decorator, and Service Locator to compose the various classes and object instances that make up an application. However, these patterns are simply that: best practices given a name, with a description of what the pattern does, where to apply it, the problems it addresses, and so forth. Patterns are formalized best practices that you must implement yourself in your application.

The Spring Framework Inversion of Control (IoC) component addresses this concern by providing a formalized means of composing disparate components into a fully working application ready for use. The Spring Framework codifies formalized design patterns as first-class objects that you can integrate into your own application(s). Numerous organizations and institutions use the Spring Framework in this manner to engineer robust, maintainable applications.

## Dependency Management and Naming Conventions

Dependency management and dependency injection are different things. To get those nice features of Spring into your application (like dependency injection) you need to assemble all the libraries needed (jar files) and get them onto your classpath at runtime, and possibly at compile time. These dependencies are not virtual components that are injected, but physical resources in a file system (typically). The process of dependency management involves locating those resources, storing them and adding them to classpaths. Dependencies can be direct (e.g. my application depends on Spring at runtime), or indirect (e.g. my application depends on commons-dbcp which depends on commons-pool). The indirect dependencies are also known as "transitive" and it is those dependencies that are hardest to identify and manage.

To refer to Spring library modules in this guide we use a shorthand naming convention spring-* or spring-*.jar, where * represents the short name for the module (e.g. spring-core, spring-webmvc, spring-jms, etc.). The actual jar file name that you use is normally the module name concatenated with the version number (e.g. spring-core-4.0.9.RELEASE.jar).

Each release of the Spring Framework will publish artifacts to the following places:

    Maven Central, which is the default repository that Maven queries, and does not require any special configuration to use. Many of the common libraries that Spring depends on also are available from Maven Central and a large section of the Spring community uses Maven for dependency management, so this is convenient for them. The names of the jars here are in the form spring-*-<version>.jar and the Maven groupId is org.springframework.
    In a public Maven repository hosted specifically for Spring. In addition to the final GA releases, this repository also hosts development snapshots and milestones. The jar file names are in the same form as Maven Central, so this is a useful place to get development versions of Spring to use with other libraries deployed in Maven Central. This repository also contains a bundle distribution zip file that contains all Spring jars bundled together for easy download. 

## Maven "Bill Of Materials" Dependency

It is possible to accidentally mix different versions of Spring JARs when using Maven. For example, you may find that a third-party library, or another Spring project, pulls in a transitive dependency to an older release. If you forget to explicitly declare a direct dependency yourself, all sorts of unexpected issues can arise.

To overcome such problems Maven supports the concept of a "bill of materials" (BOM) dependency. You can import the spring-framework-bom in your dependencyManagement section to ensure that all spring dependencies (both direct and transitive) are at the same version.

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-framework-bom</artifactId>
            <version>4.0.9.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

An added benefit of using the BOM is that you no longer need to specify the <version> attribute when depending on Spring Framework artifacts:

<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
    </dependency>
<dependencies>

### Gradle Dependency Management

To use the Spring repository with the Gradle build system, include the appropriate URL in the repositories section:

repositories {
    mavenCentral()
    // and optionally...
    maven { url "http://repo.spring.io/release" }
}

You can change the repositories URL from /release to /milestone or /snapshot as appropriate. Once a repository has been configured, you can declare dependencies in the usual Gradle way:

dependencies {
    compile("org.springframework:spring-context:4.0.9.RELEASE")
    testCompile("org.springframework:spring-test:4.0.9.RELEASE")
}

### Ivy Dependency Management

If you prefer to use Ivy to manage dependencies then there are similar configuration options.

To configure Ivy to point to the Spring repository add the following resolver to your ivysettings.xml:

<resolvers>
    <ibiblio name="io.spring.repo.maven.release"
            m2compatible="true"
            root="http://repo.spring.io/release/"/>
</resolvers>

You can change the root URL from /release/ to /milestone/ or /snapshot/ as appropriate.

Once configured, you can add dependencies in the usual way. For example (in ivy.xml):

<dependency org="org.springframework"
    name="spring-core" rev="4.0.9.RELEASE" conf="compile->runtime"/>

## Distribution Zip Files

Although using a build system that supports dependency management is the recommended way to obtain the Spring Framework, it is still possible to download a distribution zip file.

Distribution zips are published to the Spring Maven Repository (this is just for our convenience, you don’t need Maven or any other build system in order to download them).

To download a distribution zip open a web browser to http://repo.spring.io/release/org/springframework/spring and select the appropriate subfolder for the version that you want. Distribution files end -dist.zip, for example spring-framework-4.0.9.RELEASE-RELEASE-dist.zip. Distributions are also published for milestones and snapshots.


Logging

Logging is a very important dependency for Spring because a) it is the only mandatory external dependency, b) everyone likes to see some output from the tools they are using, and c) Spring integrates with lots of other tools all of which have also made a choice of logging dependency. One of the goals of an application developer is often to have unified logging configured in a central place for the whole application, including all external components. This is more difficult than it might have been since there are so many choices of logging framework.

The mandatory logging dependency in Spring is the Jakarta Commons Logging API (JCL). We compile against JCL and we also make JCL Log objects visible for classes that extend the Spring Framework. It’s important to users that all versions of Spring use the same logging library: migration is easy because backwards compatibility is preserved even with applications that extend Spring. The way we do this is to make one of the modules in Spring depend explicitly on commons-logging (the canonical implementation of JCL), and then make all the other modules depend on that at compile time. If you are using Maven for example, and wondering where you picked up the dependency on commons-logging, then it is from Spring and specifically from the central module called spring-core.

The nice thing about commons-logging is that you don’t need anything else to make your application work. It has a runtime discovery algorithm that looks for other logging frameworks in well known places on the classpath and uses one that it thinks is appropriate (or you can tell it which one if you need to). If nothing else is available you get pretty nice looking logs just from the JDK (java.util.logging or JUL for short). You should find that your Spring application works and logs happily to the console out of the box in most situations, and that’s important.
Not Using Commons Logging

Unfortunately, the runtime discovery algorithm in commons-logging, while convenient for the end-user, is problematic. If we could turn back the clock and start Spring now as a new project it would use a different logging dependency. The first choice would probably be the Simple Logging Facade for Java ( SLF4J), which is also used by a lot of other tools that people use with Spring inside their applications.

There are basically two ways to switch off commons-logging:

    Exclude the dependency from the spring-core module (as it is the only module that explicitly depends on commons-logging)
    Depend on a special commons-logging dependency that replaces the library with an empty jar (more details can be found in the SLF4J FAQ) 

To exclude commons-logging, add the following to your dependencyManagement section:

<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>4.0.9.RELEASE</version>
        <exclusions>
            <exclusion>
                <groupId>commons-logging</groupId>
                <artifactId>commons-logging</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
</dependencies>

Now this application is probably broken because there is no implementation of the JCL API on the classpath, so to fix it a new one has to be provided. In the next section we show you how to provide an alternative implementation of JCL using SLF4J as an example.
Using SLF4J

SLF4J is a cleaner dependency and more efficient at runtime than commons-logging because it uses compile-time bindings instead of runtime discovery of the other logging frameworks it integrates. This also means that you have to be more explicit about what you want to happen at runtime, and declare it or configure it accordingly. SLF4J provides bindings to many common logging frameworks, so you can usually choose one that you already use, and bind to that for configuration and management.

SLF4J provides bindings to many common logging frameworks, including JCL, and it also does the reverse: bridges between other logging frameworks and itself. So to use SLF4J with Spring you need to replace the commons-logging dependency with the SLF4J-JCL bridge. Once you have done that then logging calls from within Spring will be translated into logging calls to the SLF4J API, so if other libraries in your application use that API, then you have a single place to configure and manage logging.

A common choice might be to bridge Spring to SLF4J, and then provide explicit binding from SLF4J to Log4J. You need to supply 4 dependencies (and exclude the existing commons-logging): the bridge, the SLF4J API, the binding to Log4J, and the Log4J implementation itself. In Maven you would do that like this

<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>4.0.9.RELEASE</version>
        <exclusions>
            <exclusion>
                <groupId>commons-logging</groupId>
                <artifactId>commons-logging</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>jcl-over-slf4j</artifactId>
        <version>1.5.8</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.5.8</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-log4j12</artifactId>
        <version>1.5.8</version>
    </dependency>
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.14</version>
    </dependency>
</dependencies>

That might seem like a lot of dependencies just to get some logging. Well it is, but it is optional, and it should behave better than the vanilla commons-logging with respect to classloader issues, notably if you are in a strict container like an OSGi platform. Allegedly there is also a performance benefit because the bindings are at compile-time not runtime.

A more common choice amongst SLF4J users, which uses fewer steps and generates fewer dependencies, is to bind directly to Logback. This removes the extra binding step because Logback implements SLF4J directly, so you only need to depend on two libraries not four ( jcl-over-slf4j and logback). If you do that you might also need to exclude the slf4j-api dependency from other external dependencies (not Spring), because you only want one version of that API on the classpath.
Using Log4J

Many people use Log4j as a logging framework for configuration and management purposes. It’s efficient and well-established, and in fact it’s what we use at runtime when we build and test Spring. Spring also provides some utilities for configuring and initializing Log4j, so it has an optional compile-time dependency on Log4j in some modules.

To make Log4j work with the default JCL dependency ( commons-logging) all you need to do is put Log4j on the classpath, and provide it with a configuration file ( log4j.properties or log4j.xml in the root of the classpath). So for Maven users this is your dependency declaration:

<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>4.0.9.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.14</version>
    </dependency>
</dependencies>

And here’s a sample log4j.properties for logging to the console:
```java
log4j.rootCategory=INFO, stdout

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{ABSOLUTE} %5p %t %c{2}:%L - %m%n

log4j.category.org.springframework.beans.factory=DEBUG
```
Runtime Containers with Native JCL

Many people run their Spring applications in a container that itself provides an implementation of JCL. IBM Websphere Application Server (WAS) is the archetype. This often causes problems, and unfortunately there is no silver bullet solution; simply excluding commons-logging from your application is not enough in most situations.

To be clear about this: the problems reported are usually not with JCL per se, or even with commons-logging: rather they are to do with binding commons-logging to another framework (often Log4J). This can fail because commons-logging changed the way they do the runtime discovery in between the older versions (1.0) found in some containers and the modern versions that most people use now (1.1). Spring does not use any unusual parts of the JCL API, so nothing breaks there, but as soon as Spring or your application tries to do any logging you can find that the bindings to Log4J are not working.

In such cases with WAS the easiest thing to do is to invert the class loader hierarchy (IBM calls it "parent last") so that the application controls the JCL dependency, not the container. That option isn’t always open, but there are plenty of other suggestions in the public domain for alternative approaches, and your mileage may vary depending on the exact version and feature set of the container.

## Features

1. Core technologies: dependency injection, events, resources, i18n, validation, data binding, type conversion, SpEL, AOP.
2. Testing: mock objects, TestContext framework, Spring MVC Test, WebTestClient.
3. Data Access: transactions, DAO support, JDBC, ORM, Marshalling XML.
4. Spring MVC and Spring WebFlux web frameworks.
5. Integration: remoting, JMS, JCA, JMX, email, tasks, scheduling, cache and observability.
6. Languages: Kotlin, Groovy, dynamic languages.

## Core Technologies

This part of the reference documentation covers all the technologies that are absolutely integral to the Spring Framework.

Foremost amongst these is the Spring Framework’s Inversion of Control (IoC) container. A thorough treatment of the Spring Framework’s IoC container is closely followed by comprehensive coverage of Spring’s Aspect-Oriented Programming (AOP) technologies. The Spring Framework has its own AOP framework, which is conceptually easy to understand and which successfully addresses the 80% sweet spot of AOP requirements in Java enterprise programming.

Coverage of Spring’s integration with AspectJ (currently the richest — in terms of features — and certainly most mature AOP implementation in the Java enterprise space) is also provided.

AOT processing can be used to optimize your application ahead-of-time. It is typically used for native image deployment using GraalVM.

## Three-Tier app

A multitier architecture provides our application with a more production-ready look.Most real-world applications follow this architecture pattern.They include:

1. `Client tier`:- Responsible for user interfaces.Maps to frontend.
2. `Application tier`:- It contains all business logic together with the interfaces to interact with it nd the data interfaces for persistence.Maps with what we call backend.
3. `Data store`:- It is database,file system,etc that persists application's data.

The applications tier is designed using layers:

1. `Business Layer`:-The classes that model our domain and business specifics.It's where intelligence of the application resides.Composed of entities and services providing business logic.Sometimes this layer is divided into two parts domains(entities) and applications(services).
2. `Presentation Layer`:- Represented by Controller classes,which will provide functionality to Web Client.REST API implementation resides here.
3. `Data Layer`:- Responsible for persisting entities in data storage,usually database.It can typically include Data Access Object(DAO) classes,which work with direct representation of database models or repository classes,which are domain-centric and translate from domains to database layer.

## Best practises

* `Controller(API Layer)`: This folder contains REST APIs endpoints.Marked with @RestController annotation,it handles HTTP requests(GET,PUT,DELETE,POST)
It calls the Service layer and returns the results to user in JSON format.
E.g

  1. /products endpoints returns list of products
  2. /products/{id} endpoint displays a specific products

* `Service Layer(Business Logic)`: This layer handles business rules and logic.Processes data received from the Controller.
All dependencies are injected using using constructor injection
E.g
 When adding a new product,stock and price limitations are checked here

* `Repository layer(Database Operations)`: Establishes a connection with he database.It provides CRUD operations through JpaRepository or CrudRepository.
E.g
  productRepository is used to query product objects from database.

* `Model Layer(Entity and DTO Objects)`: This layer stores both entity and DTO classes.Entity objects corresponds to database tables.DTO objects are used for data transfers and prevent direct sharing of Entities with the API
E.g
  ProductEntity
  ProductDTO: Object that Returns only necessary information

* `Mapper Layer(Entity-DTO conversion)`: This layer handles conversation between Entity and DTO.Can utilize MapStruct or manual mapper classes
E.g
  The ProductMapper class converts  product object to ProductDTO.

* `Exception Layer(error Handling)`: This layer contains specific exception classes and a Global Exception Handler to manage errors occurring in project
Global error management is ensured with @ControllerAdvice annotation
E.g
  ProductNotFoundException: thrown when a product is not found
  GlobalExceptionHandler: Returns a standard response for all errors occurring in project
