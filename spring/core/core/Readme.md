# Spring Core

Provides the fundamental parts of the framework, including IoC and Dependency Injection features.It is base for all other modules.It is used to manage object dependencies.In dev with multiple classes,if we want to communicate one object to other we use interface.Using this module spring will create required objects and supply to app.

To implement spring core,use the steps:
- configurations
- Dependency injector
- getting beans

## Configurations

In Spring, configurations are used to define beans and their dependencies. This can be done using XML configuration files, Java-based configuration, or annotations. The most common approach is using Java-based configuration with @Configuration and @Bean annotations.It does not create objects instead it just provides instruction of:
* Objects to be created
* How to be created
* What dependencies to inject

1. Java-based Configuration

@Configuration: Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests.

```java
@Configuration
public class AppConfig {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
```

@Bean: Indicates that a method produces a bean to be managed by the Spring container.

```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
```

2. XML-based Configuration

Defining Beans: Beans can be defined in an XML configuration file using the <bean> tag.

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="objectName" class="com.example.MyBean"/>
</beans>
```

3. Annotation-based Configuration

@ComponentScan: Configures component scanning directives for use with @Configuration classes.
```java
@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
}
```

@Component: Indicates that a class is a Spring component.

```java
@Component
public class MyComponent {
}
```

@Autowired: Marks a constructor, field, setter method, or config method to be autowired by Spring's dependency injection facilities.
```java
@Component
public class MyService {
    private final MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
}
```

The configurations will be given to Dependency injector

    Configurations(i.e config.xml)--------->Dependency injector

## Dependency Injector

It reads the configurations files and validates it and creates container to store BeanFactory reference.If you want object you just get it from the container intead of creating manually.


### Container overview

The container gets its instructions on what objects to instantiate, configure, and assemble by reading configuration metadata. The configuration metadata is represented in XML, Java annotations, or Java code. It allows you to express the objects that compose your application and the rich interdependencies between such objects.

Container is just like HashMap<Key, Value> where key is id and value is classname.Spring uses Reflection to create objects in JVM.


### The IoC container

It includes:
1. BeanFactory
2. ApplicationContext

The org.springframework.beans and org.springframework.context packages are the basis for Spring Framework’s IoC container. The BeanFactory interface provides an advanced configuration mechanism capable of managing any type of object. ApplicationContext is a sub-interface of BeanFactory. It adds easier integration with Spring’s AOP features; message resource handling (for use in internationalization), event publication; and application-layer specific contexts such as the WebApplicationContext for use in web applications.

### The BeanFactory

The BeanFactory is the actual container which instantiates, configures, and manages a number of beans. These beans typically collaborate with one another, and thus have dependencies between themselves.These dependencies are reflected in the configuration data used by the BeanFactory (although some dependencies may not be visible as configuration data, but rather be a function of programmatic interactions between beans at runtime).

A BeanFactory is represented by the interface org.springframework.beans.factory.BeanFactory, for which there are multiple implementations. The most commonly used simple BeanFactory implementation is org.springframework.beans.factory.xml.XmlBeanFactory. (This should be qualified with the reminder that ApplicationContexts are a subclass of BeanFactory, and most users end up using XML variants of ApplicationContext).

* XMLBeanFactory implements BeanFactory(Mostly for standalone applications)
* ApplcationContext extends BeanFactory and implements several classes:(Mostly standalone,web apps,I18n apps,AOP,Application Events)
   - FileSystemXmlApplicationContext
   - ClassPathXmlApplicationContext(XML config)
   - AnnotationConfigApplicationContext(Java config)

```java
ApplicationContext context = new ClassPathXmlApplicationContext("config.xml")//XML based
ApplicationContext context = new AnnotationConfigApplicationContext("JavaCponfig.class")//Java based config
```


```
BeanFactory factory = new XmlBeanFactory(new ClassPathresource("config.xml"));
```

```xml
ClassPathResource res = new ClassPathResource("beans.xml");
XmlBeanFactory factory = new XmlBeanFactory(res);
```
* Processes:
1. Reads and validates xml config files
2. If valid, the XMLBeanFactory creates inmemory logical partition in JVM
3. It loads the springbean configs and place metadata for config in logical partition.
4. Logical memory created is called IoC and returns reference of IoC container as BeanFactory
5. You can access the object

```
Object obj = beanFactory.getBean("objectName")
```
* The beanFactory searches the bean from the container by its id name if not found it throws exception and exits.If found it will load the class into JVM memory and instantiates the object of the class.

BeanFactory provides the configuration framework and basic functionality, and the ApplicationContext adds more enterprise-specific functionality. The ApplicationContext is a complete superset of the BeanFactory, and is used exclusively in this chapter in descriptions of Spring’s IoC container.

In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are called beans. A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container. Otherwise, a bean is simply one of many objects in your application. Beans, and the dependencies among them, are reflected in the configuration metadata used by a container.

Several implementations of the ApplicationContext interface are supplied out-of-the-box with Spring. In standalone applications it is common to create an instance of ClassPathXmlApplicationContext or FileSystemXmlApplicationContext. While XML has been the traditional format for defining configuration metadata you can instruct the container to use Java annotations or code as the metadata format by providing a small amount of XML configuration to declaratively enable support for these additional metadata formats.

The interface org.springframework.context.ApplicationContext represents the Spring IoC container and is responsible for instantiating, configuring, and assembling the aforementioned beans. 

## Getting the Objects

Managing dependencies can include:
1. Dependency Lookup: The developer writes code to manually get the object from container.
2. Dependency Injection: Automatic provision of objects from container.

### IoC(Inversion of Controller)

* Inversion A--->B---->C If class have multiple  dependencies and is accessed by one class.

Can be:
1. DI
2. Guice


NB: Objects reference is stored in containers and objects stred in JVM

### Dependency Injection

A typical enterprise application does not consist of a single object (or bean in the Spring parlance). Even the simplest application has a few objects that work together to present what the end-user sees as a coherent application.

Dependency injection (DI) is a specialized form of IoC, whereby objects define their dependencies (that is, the other objects they work with) only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. The IoC container then injects those dependencies when it creates the bean. It is a process whereby objects define their dependencies, that is, the other objects they work with, only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. The container then injects those dependencies when it creates the bean. This process is fundamentally the inverse, hence the name Inversion of Control (IoC), of the bean itself controlling the instantiation or location of its dependencies by using direct construction of classes, or a mechanism such as the Service Locator pattern.

dependent(target): It is an object which is depending on another object to get some info.
dependency(source): It is an object required by another object to carry out the functionality.


#### Types of Dependency Injection in Spring

Spring supports three types of dependency injection:

1. Constructor Injection: Dependencies are provided through a class constructor.

```java
@Component
public class MyService {
    private final MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
}
```

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myRepository" class="com.example.MyRepositoryImpl"/>

    <bean id="myService" class="com.example.MyService">
        <constructor-arg ref="myRepository"/>
    </bean>
</beans>
```

```java
@Configuration
public class AppConfig {
    
    @Bean
    public MyRepository myRepository() {
        return new MyRepositoryImpl();
    }

    @Bean
    public MyService myService(MyRepository myRepository) {
        return new MyService(myRepository);
    }
}
```

2. Setter Injection: Dependencies are provided through setter methods.

```java
@Component
public class MyService {
    private MyRepository myRepository;

    @Autowired
    public void setMyRepository(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
}
```

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myRepository" class="com.example.MyRepositoryImpl"/>

    <bean id="myService" class="com.example.MyService">
        <property name="myRepository" ref="myRepository"/>
    </bean>
</beans>
```

```java
@Configuration
public class AppConfig {
    
    @Bean
    public MyRepository myRepository() {
        return new MyRepositoryImpl();
    }

    @Bean
    public MyService myService(Repository myRepository) {
        MyService myservice= new MyService();
        myService.setRepository(myRepository);
        return myService;
    }
}
```

3. Field Injection: Dependencies are provided directly to fields.

It is not recommended since unit testing will be hard as dependencies is hidden

```java
@Component
public class MyService {
    @Autowired
    private MyRepository myRepository;
}
```

Field injection is not directly supported in XML configuration. However, you can achieve similar functionality by using setter injection.

### Drawbacks of XML
1. Need to learn xml to work with xml configurations.
2. It is not type safety.Can't recognize error during compile time
3. Less readble
4. It has many configurations properties
5. Difficult to maintain

To make objects during startup you can use **component scan**.You don't need to define beans in xml or configuration instead you use the annotations @Component(To create an object) and @Autowired(For dependency injection).

1. xml

```xml
<component-scan basepackage="com.kipcollo.*"/>
```

2. java-based Config

```java
@Componenetscan(basepackage="com.kipcollo")
```

NOTE:
1. Manual Config: Developer writes config manually
 - xml config
 - java based config

2. Automatic Config
- Using Spring Annotations.

To achieve identifying presence of @Component and creating an object is called component scan.It is disabled by default.

The @ComponentScan can work withot the @Component and work with @Bean annotations only.i.e JdbcTemplate,RestTamplate,Datasource doesn't have @Component instead it uses @Bean.

## Loading PROPERTIES file and Getting values.

```properties file
userName=collo
password = collo
```

```java

Java.util.Properties p = new Properties();
p.load("properties file");

String userName = p.getProperty("userName");
String password = p.getProperty("password");
```

* Instead of writing the Java code you can use **@PropertySource Annotation**. Used to load properties file.


```java
PropertySource(classpath:{filename path})
```

- Reading value from properties file.

1. Using Environment Class Object - provided by spring.

- org.springframework.core.env.Environment class is configured as bean in spring container,this happens during app startup.To get the bean from container,
you use @Autowired

```file.properties
name=collo
pass=collo
```

```java

@PropertySource(classpath:file.properties)
public class Config{

    @Autowired
    Environment environment;

    environment.getProperty("name");

}

```

2. Using @Value annotation

```java

@Value("${name}")
```

- PropertySourcesPlaceholderConfigurer will recognize the @Value annotation.
- You can set deafult values in @Value(${propertyKey:value})