# Beans

- **POJO**:- This is a plain Java Object

```java
class Pojo{
    private String name;
    private int Id;

    public String toString(){
        return text + ";" + Id;
    }
}
```

SOLID Principle:

- SRP - Single Responsibilty Principle- "Every class should have one responsibility"

**Java Beans(EJB)**:-
  
- Must contain a constructor with no arguements.
- Doesn't declare any public instance variables.
- Must contain getters and setters methods for properties
- It is common ,though not required, for Java bean to implement **Serializable Interfaces**.

NB: Serializable interface is a tagging interface in java.io package that indicates that a class contains get, set and is methods that another class can use to read and write an object's instance to and from persistent database.As result some servlet engines can save and restore this objects if necessary i.e Tomcat containers save objects's state before it shutdowns and restore when it starts.

```java
class JaavaBean implements Serializable{

    private String name;
    private int Id;

    //NoargsConstructor
    public JavaBean(){

    }

    //getters and setters
    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
}

```

- **Spring Beans**:-Any Java Object managed by Spring.Spring uses IoC(Bean factory or Application Context) to manage these objects.

## Spring Bean Annotations

The core package implementing Spring's lightweight Inversion of Control (IoC) container.

1. @AnnotatedBeanDefinition - Extended BeanDefinition interface that exposes AnnotationMetadata about its bean class - without requiring the class to be loaded yet.
2. @Qualifier - This annotation may be used on a field or parameter as a qualifier for candidate beans when autowiring.
3. @Autowired - Marks a constructor, field, setter method, or config method as to be autowired by Spring's dependency injection facilities.
4. @Lookup - An annotation that indicates 'lookup' methods, to be overridden by the container to redirect them back to the BeanFactory for a getBean call.
5. @Value - Annotation used at the field or method/constructor parameter level that indicates a default value expression for the annotated element.

## Bean Overview

A Spring IoC container manages one or more beans. These beans are created with the configuration metadata that you supply to the container (for example, in the form of XML <bean/> definitions).

Within the container itself, these bean definitions are represented as BeanDefinition objects, which contain (among other information) the following metadata:

A package-qualified class name: typically, the actual implementation class of the bean being defined.

Bean behavioral configuration elements, which state how the bean should behave in the container (scope, lifecycle callbacks, and so forth).

References to other beans that are needed for the bean to do its work. These references are also called collaborators or dependencies.

Other configuration settings to set in the newly created object — for example, the size limit of the pool or the number of connections to use in a bean that manages a connection pool.

This metadata translates to a set of properties that make up each bean definition. The following table describes these properties:

1. Class - Instantiating Beans
2. Name - Naming Beans
3. Scope - Bean Scopes
4. Constructor arguments - Dependency Injection
5. Properties - Dependency Injection
6. Autowiring mode - Autowiring Collaborators
7. Lazy initialization mode - Lazy initialized Beans
8. Initialization method - Initialization Callbacks
9. Destruction method - Destruction Callbacks

### Beans Scope

It is lifecycle of a bean in container.i.e when bean is created till it is destroyed.

- singleton - (Default) Scopes a single bean definition to a single object instance for each Spring IoC container.ONE OBJECT per CONTAINER definition.Created during container startup and stay in container till it is destroyed(container life =singleton). Singleton scope is not same as Java singleton pattern(In java singleton is one object for all application).DEFAULT.

NEVER inject protoype into singleton.

```java
@Component
@Scope("singleton")// @scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MySingletonBean {
    // Bean definition
}
```

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="mySingletonBean" class="com.kipcollo.beans.MySingletonBean" scope="singleton"/>
</beans>
```

- prototype - Scopes a single bean definition to any number of object instances.For every request new bean is created.Once object is completed it gets destroyed.Container doesn't hold  bean reference.Useful when bean is holding instance variable since it varies from each other.

- request - Scopes a single bean definition to the lifecycle of a single HTTP request. That is, each HTTP request has its own instance of a bean created off the back of a single bean definition. Only valid in the context of a web-aware Spring ApplicationContext.
- session - Scopes a single bean definition to the lifecycle of an HTTP Session. Only valid in the context of a web-aware Spring ApplicationContext.
- application - Scopes a single bean definition to the lifecycle of a ServletContext. Only valid in the context of a web-aware Spring ApplicationContext.

```java
@Component
@Scope("application")
public class MyApplicationBean {
    // Bean definition
}
```

- websocket - Scopes a single bean definition to the lifecycle of a WebSocket. Only valid in the context of a web-aware Spring ApplicationContext.
When you create a bean definition, you create a recipe for creating actual instances of the class defined by that bean definition. The idea that a bean definition is a recipe is important, because it means that, as with a class, you can create many object instances from a single recipe.

### Stereotype Annotations

Are used to tag classes for which spring beans needs to be automatically created in application context(Spring IoC container).Define in the packge **org.springframework.stereotype**.

It includes:

- @Component :Any annotation meta-annotated with @Component is considered a stereotype annotation which makes the annotated class eligible for classpath scanning.If you don't give a name, then default will be the class name.

```java
@Component("component")
public class MyComponent {
    public String hello(){
        return "Hello Component";
    }
}
```

- @Controller: Indicates that an annotated class is a "Controller" (e.g. a web controller).Serves as a specialization of @Component, allowing for implementation classes to be autodetected through classpath scanning

```java
@Controller
public class MyService {

    public String hello(){
        return "Hello controller";
    }
}
```

- @Service: This annotation is a general-purpose stereotype.Serves as a specialization of @Component, allowing for implementation classes to be autodetected through classpath scanning.May also indicate that a class is a "Business Service Facade"

```java
@Service
public class MyService {

    public String hello(){
        return "Hello Service";
    }
}
```

- @Repository:  "a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects".This annotation is a general-purpose stereotype.A class thus annotated is eligible for Spring DataAccessException translation when used in conjunction with a PersistenceExceptionTranslationPostProcessor.serves as a specialization of @Component, allowing for implementation classes to be autodetected through classpath scanning.

```java
@Repository
public class MyRepo {

    public String hello(){
        return "Hello Repo";
    }
}
```

- @Indexed: Indicate that the annotated element represents a stereotype for the index. The index allows retrieving the candidate components (i.e. fully qualified name) based on a stereotype. This annotation instructs the generator to index the element on which the annotated element is present or if it implements or extends from the annotated element. The stereotype is the fully qualified name of the annotated element.

```java
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
     SpringApplication.run(DemoApplication.class, args);
     MyService cust=context.getBean(MyService.class);
    System.out.println(cust.hello());

    Customer custController = context.getBean(Customer.class);
    System.out.println(custController.hello());

    MyRepo custRepo = context.getBean(MyRepo.class);
     System.out.println(custRepo.hello());

     MyComponent comp = (MyComponent) context.getBean("component");
     System.out.println(comp.hello());
 }

}
```
