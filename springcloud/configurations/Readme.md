# Spring cloud config

It is a library for managing configuration properties for distributed applications.It allows dev to externalize configurations properties for applications, so that they can easily be changed without modifying applications code.Also provides centralalized server for storing and managing config properties for multiple apps,making it easy to update and rollback config across diff. environments.

Spring Cloud Config provides server and client-side support for externalized configuration in a distributed system. With the Config Server you have a central place to manage external properties for applications across all environments. The concepts on both client and server map identically to the Spring Environment and PropertySource abstractions, so they fit very well with Spring applications, but can be used with any application running in any language. As an application moves through the deployment pipeline from dev to test and into production you can manage the configuration between those environments and be certain that applications have everything they need to run when they migrate.

The default implementation of the server storage backend uses git so it easily supports labelled versions of configuration environments, as well as being accessible to a wide range of tooling for managing the content. It is easy to add alternative implementations and plug them in with Spring configuration.

## client side

To use these features in an application, you can build it as a Spring Boot application that depends on spring-cloud-config-client

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

Spring Cloud Config Server pulls configuration for remote clients from various sources:-

1. Git Backend
2. Local File System Backend
3. Hashicorp Vault Backend
4. JDBC compatible Databases
5. Subversion

Spring Cloud Config Server features:

- HTTP, resource-based API for external configuration (name-value pairs, or equivalent YAML content)
- Encrypt and decrypt property values (symmetric or asymmetric)
- Embeddable easily in a Spring Boot application using @EnableConfigServer

- **GIT Backend Repository(External Config)**

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

- **Fie System Backend** - There is also a “native” profile in the Config Server that does not use Git but loads the config files from the local classpath or file system (any static URL you want to point to with spring.cloud.config.server.native.searchLocations). To use the native profile, launch the Config Server with spring.profiles.active=native.

NOTE:- A filesystem backend is great for getting started quickly and for testing. To use it in production, you need to be sure that the file system is reliable and shared across all instances of the Config Server.

The default value of the searchLocations is identical to a local Spring Boot application (that is, [classpath:/, classpath:/config, file:./, file:./config]).
This does not expose the application.properties from the server to all clients,because any property sources present in the server are removed before being sent to the client.

The search locations can contain placeholders for {application}, {profile}, and {label}. In this way, you can segregate the directories in the path and choose a strategy that makes sense for you (such as subdirectory per application or subdirectory per profile).

```java
server.port=8888
```

- **Vault Backend**:- Spring Cloud Config Server also supports Vault as a backend.

Vault is a tool for securely accessing secrets. A secret is anything that to which you want to tightly control access, such as API keys, passwords, certificates, and other sensitive information. Vault provides a unified interface to any secret while providing tight access control and recording a detailed audit log.

To enable the config server to use a Vault backend, you can run your config server with the vault profile. For example, in your config server’s you application.properties, can add spring.profiles.active=vault.

By default, the config server assumes that your Vault server runs at 127.0.0.1:8200. It also assumes that the name of backend is secret and the key is application. All of these defaults can be configured in your config server’s application.properties.
b<63m>
