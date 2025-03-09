# Autoconfiguration

@SpringBootApplication annotation is responsible for enabling spring boot auto configurations.Consists of @ComponentScan,@EnableAutoConfiguration and @springBootConfiguration

1. @SpringBootConfiguration - Its like spring configuration.Its just renamed from @Configuration to @springBootConfiguration
2. @ComponentScan - Scans the Component classes at packages and class levels.Default packagename is current package.
3. @EnableAutoConfiguration - Provides framework related autoconfiguration.i.e enables autoconfiguration.Used to create framework\predefined classes with help of spring.factories file.

We configure beans using xml or java-config or @Autowire with components.Even though we use @Autowire,we still depend on manual configuration i.e we can't use @Component for all classes(We apply only to classes with source code)but can't apply for framework classes like DataSource,JDBCTemplate,RestTamplate,MongoTemplate..

If we want to use framework classes,we should either use @Bean or <bean> element.
i.e

```java

@configuration
public class Config{

    @bean
    public DataSource datasource(){

        return new DriverManagerDataSource();
    }

     @bean
    public JdbcTemplate jdbcTemplate(){

        return new JdbcTemplate();
    }
}
```

In spring boot apps, you'll write minimal configurations.Others are taken care off by Spring Boot autoconfigurations with help of @SpringBootApplication.

using Spring Boot we can develop apps using configurations:

1. standalone-
      ApplicationContext context = new AnnotationconfigApplicationContext(JavaConfig);
2. Web apps-
    new AnnotationconfigServletWebServerApplicationContext()
3. Reactivee apps-
    new AnnotationconfigReactiveWebServerApplicationContext()

* When SpringApplication.run is executed:

1. SpringApplication constructor will identify which container is required.The **deduceFromClassPath()** method will check in classpath,based on classes found in classpath then corresponding spring container is created.
2. An empty environment object will be created.
3. Detected configs of our apps will be loaded into environment object.(application.properties or application.yaml)
4. Prints the boot banner
5. Identifies WebApplicationtype:
   1. If spring mvc jars is found on path,then WebapplicationType=WEB and creates AnnotationConfigServletWebServerApplicationContext
   2. If spring webflux jars is found on path,then WebapplicationType=Reactive and creates AnnotationConfigReactiveWebServerApplicationContext
   3. If none of above is found; then Webapplicationtype=NONE,then it creates AnnotationApplicationContext. 
6. Instantiates spring factories and registers IoC container
7. Execute ApplicationContextInializer(will detect all autoconfiguration)
8. Then it executes prepareContext
9. Refreshcontext.

* During above stages,it will publish various diff type of events and invokes listeners to perform operation.

## Loading Properties File
