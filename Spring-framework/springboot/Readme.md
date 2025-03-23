# Spring boot

Spring Boot makes it easy to create stand-alone, production-grade Spring-based Applications that you can run. We take an
opinionated view of the Spring platform and third-party libraries, so that you can get started with minimum fuss. Most Spring
Boot applications need very little Spring configuration.

Spring boot came to make Spring dev easier:

To make Spring web app:

1. Create a maven project
2. Add dependencies to pom.xml(spring core,MVC,jackson,validator)
3. Configure required beans in configuration using xml or java-config(DispatcherServlet,Viewresolver,Controller)
4. Write web.xml
5. Write controller class
6. configure annotations e,g(@requestBody)

Spring Drawbacks:

* Step 1-4 is boilerplate code(i.e common code for all project)
* Dependency management was too hard 
* Manual configurations(complex,time consuming)
* Many configurations-More configurations less code.
* Doesn't support non-functional requirements by default(i.e Healthy checks,metrics,logs,monitoring)

To overcome this drawbacks,spring boot was developed.It is a module in spring framework.we can develop any type of apps in spring boot(Standalone,web..etc)>It is on top of other spring modules.

SPRING     ------->     SPRING MVC,JDBC,SECURITY  -------------->   SPRING   -----------> APPS
CORE                     AOP,BATCH                                   BOOT

## Features of Spring boot

1. Removes boilerplate code
2. Makes dependency management easier(Dev doesn't need to remember required dependencies)Uses spring boot starter dependencies.
3. Auto Configurations- Developer doesn't need to configure the beans(No XML or Java-config)
4. (Actuator)Provide a range of non-functional features that are common to large classes of projects (such as embedded servers,
security, metrics, health checks, and externalized configuration).
5. Spring boot CLI: For quick prototype apps
6. DevTools; improve developer productivity

* Embedded Servers: Server inside the application

  1. Traditional: Develop------>Deploy----------->External Tomcat server(Configuration(server.xml,catalina.properties))
  2. Modern: Develop------>Deploy-----------Tomcat server within App(embedded server(source code + server config)): Used mostly in cloud

* Dependency Management:
Spring-boot introduced 2 types of dependencies:

1. spring-boot-starter-parent- For supporting open-source third party libraries.ie.(Jackson,validator,RedisCache,MongoDB..etc,spring core,spring mvc)
Spring boot parent pom is used to declare and configure spring f/w and their 3rd party related version info.

It provides info for all libraries.

2. spring-boot-starter-xxxx(Where xxxx can be web,jdbc,security,data..)i.e Spring web requires (spring core,MVc,web MVC,jdbv,jackson).The spring-boot-starter-web combines all the modules and their dependencies.

* Spring Version:

1. Spring Boot 1.x--------->(Spring core,spring mvc,spring JDBC: 3.x)
                  ---------->jackson-1.x,validator-2.x,hibernate-3.x
2. Spring boot 2.3.5--------->spring core,spring-mvcjdbc: 4.x
                    --------->jackson: 2.x,validator 3.x,hibernate 4.x
3. spring Boot 2.6.6-------->(Spring core,spring mvc,spring JDBC: 5.x)
                    --------->jackson: 2.5,validator 4.x,hibernate 5.x

## Creating Spring Boot application

There are 3 ways:

1. Manually - using IDEs(Eclipse,STS,IntelliJ):

  * Create maven project
  * Add spring boot parent and required dependencies to pom.xml

 ```xml
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.3.5</version>
    <relativePath/> <!-- lookup parent from repository -->
  </parent>

      <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
 ```

  * Write Spring boot entry class manually

 ```java

  @SpringBootApplication
   public class Application{

    public static main void(String[] args){
      
    SpringApplication.run(Application.class,args);
   }
  }
  ```

2. Using start.spring.io: No need to write manual code.
3. Using spring starter project using IDEs.
