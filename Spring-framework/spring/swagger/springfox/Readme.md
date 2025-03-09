# Springfox

The Springfox suite of java libraries are all about automating the generation of machine and human readable specifications for JSON APIs written using the spring family of projects. Springfox works by examining an application, once, at runtime to infer API semantics based on spring configurations, class structure and various compile time java Annotations

Springfox has evolved from a project originally created by Marty Pitt and was named swagger-springmvc.

- The goals of springfox is:
   1. To extend support for a number of evolving standards targeted at JSON API specification and documentation such as Swagger,RAML and jsonapi.
   2. To extend support for spring technologies.
   3. Discourage using swagger-core annotations that are not material to the service description at runtime. Annotations are to to be used only to supplement documentation or override/tweak the resulting spec in cases where its not possible to infer service/schema characteristics.

The Springfox libraries are hosted on bintray and jcenter.It has multiple modules and dependencies will vary depending on desired API specification standard.
Below outlines how to include the springfox-swagger2 module which produces Swagger 2.0 API documentation.

Gradle:

```groovy
repositories {
  jcenter()
}

dependencies {
//  For Spring boot Projects
    implementation "io.springfox:springfox-boot-starter:3.0.0"
//  Uncomment for regular spring mvc projects and commend above dependency
//    implementation "io.springfox:springfox-oas:3.0.0"
}
```

Maven:

```xml


<pom>

    <repositories>
        <repository>
          <id>jcenter-snapshots</id>
          <name>jcenter</name>
          <url>https://jcenter.bintray.com/</url>
        </repository>
    </repositories>

    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-boot-starter</artifactId>
        <version>3.0.0</version>
    </dependency>
<!--   Uncomment for regular spring mvc projects and commend above dependency
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-oas</artifactId>
        <version>3.0.0</version>
    </dependency>
-->
</pom>
```

## Migrating from existing 2.x version

- `Spring Boot Applications`:-
   1. Remove library inclusions of earlier releases. Specifically remove springfox-swagger2 and springfox-swagger-ui inclusions.
   2. Remove the @EnableSwagger2 annotations
   3. Add the springfox-boot-starter
   4. Springfox 3.x removes dependencies on guava and other 3rd party libraries (not zero dep yet! depends on spring plugin and open api libraries for annotations and models) so if you used guava predicates/functions those will need to transition to java 8 function interfaces

- `Regular spring mvc`:-
   1. Remove library inclusions of earlier releases. Specifically remove springfox-swagger2 and springfox-swagger-ui inclusions.
   2. For OpenAPI add the @EnableOpenApi annotation (and @EnableSwagger2 for swagger 2.0)
   3. For OpenAPI add the springfox-oas library dependency (for swagger 2.0 use springfox-swagger2)
   4. Springfox 3.x removes dependencies on guava and other 3rd party libraries (not zero dep yet! depends on spring plugin and open api libraries for annotations and models) so if you used guava predicates/functions those will need to transition to java 8 function interfaces

- `Changes in swagger-ui`:- For non-boot applications springfox-swagger-ui is no longer automatically enabled by adding the dependency. It needs to be explicitly register using a resource handler configurer (WebFluxConfigurer or WebMvcConfigurer). Here is how it is configured in springfox-boot-starter

## Architecture

- `Component Model`:-The different Springfox modules are split up as shown below.
   1. springfox-core - Contains the internal service and schema description models along with their builders.
   2. springfox-spi - Contains the service provider interfaces that can be used to extend and enrich the service models, e.g. swagger specific annotation processors.
   3. springfox-schema - Schema inference extensions that help build up the schema for the parameters, models and responses
   4. springfox-spring-web - spring web specific extensions that can build the service models based on RequestMapping information.This is the heart library that infers the service model.
   5. springfox-swagger-common - Common swagger specific extensions that are aware of the different swagger annotations.
   6. springfox-swagger1,springfox-swagger2

Swagger:- Springfox supports both version 1.2 and version 2.0 of the Swagger specification. Where possible, the Swagger 2.0 specification is preferable.The `swagger-core` annotations, as provided by swagger-core, are typically used to decorate the java source code of an API which is being 'swaggered'. Springfox is aware of the Swagger-Core Annotations and will favor those annotations over inferred defaults.

## Configuring Springfox

- To enable support for swagger specification 1.2 use the `@EnableSwagger` annotation.To enable support for swagger specification 2.0 use the `@EnableSwagger2` annotation.
- To document the service we use a Docket. This is changed to be more inline with the fact that expressing the contents of the documentation is agnostic of the format the documentation is rendered.
- Docket stands for A summary or other brief statement of the contents of a document; an abstract.
- Docket helps configure a subset of the services to be documented and groups them by name. Significant changes to this is the ability to provide an expressive predicate based for api selection.

```java
import static springfox.documentation.builders.PathSelectors.*;
import static com.google.common.base.Predicates.*;

@Bean
public Docket swaggerSpringMvcPlugin() {
   return new Docket(DocumentationType.SWAGGER_2)
         .groupName("business-api")
         .select()
            //Ignores controllers annotated with @CustomIgnore
            .apis(not(withClassAnnotation(CustomIgnore.class))) //Selection by RequestHandler
            .paths(paths()) // and by paths
            .build()
            .apiInfo(apiInfo())
            .securitySchemes(securitySchemes())
            .securityContext(securityContext());
  }

//Here is an example where we select any api that matches one of these paths
private Predicate<String> paths() {
   return or(
      regex("/business.*"),
      regex("/some.*"),
      regex("/contacts.*"),
      regex("/pet.*"),
      regex("/springsRestController.*"),
      regex("/test.*"));
  }

private ApiInfo apiInfo(){
   return new ApiInfo(
      "Title",
      "Description",
      "Version",
      "TermsOfService",
      new Contact("name","url", "email"),
      "license",
      "LicenseURL",
      //VendorExtensions E.g Collections.emptyList()
   )
}
```

After defining the Docket bean, its select() method returns an instance of ApiSelectorBuilder, which provides a way to control the endpoints exposed by Swagger.
We can configure predicates for selecting RequestHandlers with the help of RequestHandlerSelectors and PathSelectors. Using any() for both will make documentation for our entire API available through Swagger.

- By default the swagger service descriptions are generated at the following urls:-
   1. 1.2 - /api-docs - implicit default group
   2. 1.2 - /api-docs?group=external - external group via docket.groupName()
   3. 2.0 - /v2/api-docs - implicit default group
   4. 2.0 - /api-docs?group=external - external group via docket.groupName()
- To customize these endpoints, loading a property source with the following properties allows the properties to be overridden
   1. 1.2 - springfox.documentation.swagger.v1.path
   2. 2.0 - springfox.documentation.swagger.v2.path

- `Docket XML Configuration`:-To use the plugin you must create a spring java configuration class which uses spring’s @Configuration. This config class must then be defined in your xml application context.
Xml Configuration

```xml
<!-- Required so springfox can access spring's RequestMappingHandlerMapping  -->
<mvc:annotation-driven/>

<!-- Required to enable Spring post processing on @Configuration classes. -->
<context:annotation-config/>

<bean class="com.yourapp.configuration.MySwaggerConfig"/>
```

Configuration bean pulled into xml a configuration as a bean

```java
@Configuration
@EnableSwagger //Loads the spring beans required by the framework
public class MySwaggerConfig {

   /**
    * Every Docket bean is picked up by the swagger-mvc framework - allowing for multiple
    * swagger groups i.e. same code base multiple swagger resource listings.
    */
   @Bean
   public Docket customDocket(){
      return new Docket(); //some customization goes here
   }

}
```

- `Docket Spring Java Configuration`:-  the @EnableSwagger or @EnableSwagger2 annotation.Define one or more Docket instances using springs @Bean annotation.

Java Configuration

```java
@Configuration
@EnableWebMvc //NOTE: Only needed in a non-springboot application
@EnableSwagger2
@ComponentScan("com.myapp.controllers")
public class CustomJavaPluginConfig {


   @Bean //Don't forget the @Bean annotation
   public Docket customImplementation(){
      return new Docket()
            .apiInfo(apiInfo());
            //... more options available

   }

   //...
}
```

Swagger UI adds a set of resources that we must configure as part of a class that extends WebMvcConfigurerAdapter and is annotated with @EnableWebMvc:

```java
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("swagger-ui.html")
      .addResourceLocations("classpath:/META-INF/resources/");

    registry.addResourceHandler("/webjars/**")
      .addResourceLocations("classpath:/META-INF/resources/webjars/");
}
```

- `Support for documentation from property file lookup`:- Starting with 2.7.0 we support looking up description from the following annotations given a property just like property place holders resolve a value annotation @Value(${key}). The following annotations attributes support description resolution.
   1. @ApiParam#value()
   2. @ApiImplicitParam#value()
   3. @ApiModelProperty#value()
   4. @ApiOperation#value()
   5. @ApiOperation#notes()
   6. @RequestParam#defaultValue()
   7. @RequestHeader#defaultValue()

Below are examples of how it would work

Controller Example

```java
SomeController.java

  @ApiOperation(value = "Find pet by Status", notes = "${SomeController.findPetsByStatus.notes}"...) 
  @RequestMapping(value = "/findByStatus", method = RequestMethod.GET, params = {"status"})
  public Pet findPetsByStatus(
      @ApiParam(value = "${SomeController.findPetsByStatus.status}", required = true,...)
      @RequestParam("status",defaultValue="${SomeController.findPetsByStatus.status.default}") String status) { 
      //...
  }

  @ApiOperation(notes = "Operation 2", value = "${SomeController.operation2.value}",response = ResponseEntity.class...) 
  @ApiImplicitParams(
      @ApiImplicitParam(name="header1", value="${SomeController.operation2.header1}", ...) 
  )
  @RequestMapping(value = "operation2", method = RequestMethod.POST)
  public ResponseEntity<String> operation2() {
    return ResponseEntity.ok("");
  }
```

Model Example

```java
SomeModel.java

  public class SomeModel {
    @ApiModelProperty(value = "${SomeModel.someProperty}", ...) 
    private long someProperty;
  }
```

**Swagger UI**:- Swagger UI is a built-in solution that makes user interaction with the Swagger-generated API documentation much easier.
To use Swagger UI, we need to add an additional Maven dependency:

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>3.0.0</version>
</dependency>
```

Now we can test it in our browser by visiting: <http://localhost:8080/swagger-ui/>

**Spring Data REST**:-Springfox provides support for Spring Data REST through its springfox-data-rest library.Spring Boot will take care of the auto-configuration if it discovers the spring-boot-starter-data-rest on the classpath.

we’ll import the SpringDataRestConfiguration class to the SpringFoxConfig class:

```java
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class SpringFoxConfig {
    //...
}
```

**Bean Validations**:- Springfox also supports the bean validation annotations through its springfox-bean-validators library.

First, we’ll add the Maven dependency to our pom.xml:

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-bean-validators</artifactId>
    <version>2.9.2</version>
</dependency>
```

Finally, we’ll import the BeanValidatorPluginsConfiguration class to the SpringFoxConfig class:

```java
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig {
    //...
}
```

**Plugin**:- In order to add specific features to the API specifications, we can create a Springfox plugin. A plugin can offer various features, from enriching the models and properties to the custom API listings and defaults.

Springfox supports the plugin creation through its spi module. The spi module provides a few interfaces like the ModelBuilderPlugin, ModelPropertyBuilderPlugin, and ApiListingBuilderPlugin that act as an extensibility hook to implement a custom plugin.
