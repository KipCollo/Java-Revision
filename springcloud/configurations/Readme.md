# Spring cloud config

Spring Cloud Config provides server and client-side support for externalized configuration in a distributed system. With the Config Server you have a central place to manage external properties for applications across all environments. The concepts on both client and server map identically to the Spring Environment and PropertySource abstractions, so they fit very well with Spring applications, but can be used with any application running in any language. As an application moves through the deployment pipeline from dev to test and into production you can manage the configuration between those environments and be certain that applications have everything they need to run when they migrate. The default implementation of the server storage backend uses git so it easily supports labelled versions of configuration environments, as well as being accessible to a wide range of tooling for managing the content. It is easy to add alternative implementations and plug them in with Spring configuration.

We consolidate all of our configurations into a single GIT repository and a connect to that one application that manages all configurations for all our application.

## Spring cloud config server

Helps in externalizing configurations.It is a rest api,it exposes the endpoints to retrieve config for microservice.

To turn application into configuration server, we use @EnableConfigServer annotation

```java

@SpringBootApplication
@EnableConfigserver
public class ConfigApplication{
     ....
}
```

Spring Cloud Config Server features:

- HTTP, resource-based API for external configuration (name-value pairs, or equivalent YAML content)
- Encrypt and decrypt property values (symmetric or asymmetric)
- Embeddable easily in a Spring Boot application using @EnableConfigServer

1. GIT Repository(External Config)

```java
app.properties
app<profile>.properties

service-one.properties
service-one-dev.properties

service-two.properties
service-two-dev.properties
```

The config server takes the configurations from git.In config server you provide:

- git url
- username
- password

The Config Server will get properties file from git repo using its application name.All properties will be loaded.i.e

I/O: application-name = service-one

O/P: service-one.properties
     service-one-dev.properties

Every microservice calls the config server.You pass the application name and profile on each services.i.e

```java

spring.cloud.config.server.git.uri=
spring.cloud.config.server.git.username=
spring.cloud.config.server.git.password=
spring.cloud.config.git.default-label=//This is branchs name
```
