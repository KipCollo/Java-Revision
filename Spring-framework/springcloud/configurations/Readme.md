# Spring cloud config

It is a library for managing configuration properties for distributed applications.It allows dev to externalize configurations properties for applications, so that they can easily be changed without modifying applications code.Also provides centralized server for storing and managing config properties for multiple apps,making it easy to update and rollback config across diff. environments.

Spring Cloud Config provides server-side and client-side support for externalized configuration in a distributed system. With the Config Server you have a central place to manage external properties for applications across all environments. The concepts on both client and server map identically to the Spring Environment and PropertySource abstractions, so they fit very well with Spring applications, but can be used with any application running in any language. As an application moves through the deployment pipeline from dev to test and into production you can manage the configuration between those environments and be certain that applications have everything they need to run when they migrate.

The concepts on both client and server map identically to the Spring Environment and PropertySource abstractions, so they fit very well with Spring applications but can be used with any application running in any language. As an application moves through the deployment pipeline from dev to test and into production, you can manage the configuration between those environments and be certain that applications have everything they need to run when they migrate. 

The default implementation of the server storage backend uses git, so it easily supports labelled versions of configuration environments as well as being accessible to a wide range of tooling for managing the content. It is easy to add alternative implementations and plug them in with Spring configuration.

A Spring Cloud Config Server is a centralized configuration management service that provides configuration settings to multiple microservices in a distributed system. Instead of hardcoding configurations in each microservice, you store them in a central location (such as a Git repository or a database), and the Config Server makes these settings available dynamically.

Why use it:-

1. Centralized configurations - Manages all services configurations in one place.
2. Dynamic updates -  Change configurations without restarting services.
3. Environment-Specific Configs – Supports dev, prod, staging, etc.
4. Security & Versioning – Configurations are stored in a secure and version-controlled repository.
5. Decoupling – Microservices focus on business logic instead of managing configurations.

## CLIENT SIDE

To use these features in an application, you can build it as a Spring Boot application that depends on spring-cloud-config-client
`Spring Boot Config Data Import`:- Spring Boot 2.4 introduced a new way to import configuration data via the spring.config.import property. This is now the default way to bind to Config Server.

To optionally connect to config server set the following in application.properties:

```java
spring.config.import=optional:configserver:
```

This will connect to the Config Server at the default location of `"http://localhost:8888"`. Removing the `optional:` prefix will cause the Config Client to fail if it is unable to connect to Config Server. To change the location of Config Server either set `spring.cloud.config.uri` or add the url to the `spring.config.import` statement such as, `spring.config.import=optional:configserver:http://myhost:8888`. The location in the import property has precedence over the uri property.

Spring Boot Config Data resolves configuration in a two step process. First it loads all configuration using the default profile. This allows Spring Boot to gather all configuration which may activate any additional profiles. After it has gathered all activated profiles it will load any additional configuration for the active profiles. Due to this you may see multiple requests being made to the Spring Cloud Config Server to fetch configuration. This is normal and is a side effect of how Spring Boot loads configuration when using spring.config.import. In previous versions of Spring Cloud Config there was only a single request made but this meant you could not activate profiles from configuration coming from the Config Server. The additional request with just the default profile now makes this possible.

NOTE:-  A bootstrap file (properties or yaml) is not needed for the Spring Boot Config Data method of import via spring.config.import.

`Config First Bootstrap`:- To use the legacy bootstrap way of connecting to Config Server, bootstrap must be enabled via a property or the spring-cloud-starter-bootstrap starter. The property is spring.cloud.bootstrap.enabled=true. It must be set as a System Property or environment variable. Once bootstrap has been enabled any application with Spring Cloud Config Client on the classpath will connect to Config Server as follows: When a config client starts, it binds to the Config Server (through the spring.cloud.config.uri bootstrap configuration property) and initializes Spring Environment with remote property sources.

The net result of this behavior is that all client applications that want to consume the Config Server need a bootstrap.yml (or an environment variable) with the server address set in spring.cloud.config.uri (it defaults to "http://localhost:8888").

If you use a DiscoveryClient implementation, such as Spring Cloud Netflix and Eureka Service Discovery or Spring Cloud Consul, you can have the Config Server register with the Discovery Service.If you prefer to use DiscoveryClient to locate the Config Server, you can do so by setting `spring.cloud.config.discovery.enabled=true` (the default is false).

The price for using this option is an extra network round trip on startup, to locate the service registration. The benefit is that, as long as the Discovery Service is a fixed point, the Config Server can change its coordinates. The default service ID is configserver, but you can change that on the client by setting spring.cloud.config.discovery.serviceId (and on the server, in the usual way for a service, such as by setting spring.application.name).

`Security` - If you use HTTP Basic security on the server, clients need to know the password (and username if it is not the default). You can specify the username and password through the config server URI or via separate username and password properties, as shown in the following example:

```java
spring.cloud.config.uri = https://user:secret@myconfig.mycompany.com

```

```java
spring.cloud.config.uri = https://myconfig.mycompany.com
spring.cloud.config.username =
spring.cloud.config.password=
```

The spring.cloud.config.password and spring.cloud.config.username values override anything that is provided in the URI.


## SERVER SIDE

`Spring cloud config server`:- Helps in externalizing configurations.It is a rest api,it exposes the endpoints to retrieve config for microservice.
Spring Cloud Config Server provides an HTTP resource-based API for external configuration (name-value pairs or equivalent YAML content). The server is embeddable in a Spring Boot application, by using the @EnableConfigServer annotation. Consequently, the following application is a config server:

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


Spring Cloud Config Server pulls configuration for remote clients from various sources:-

1. Git Backend
2. Local File System Backend
3. Hashicorp Vault Backend
4. JDBC compatible Databases
5. Subversion

- The strategy that governs the behaviour of storing the configuration datais the EnvironmentRepository, serving Environment objects. This Environment is a shallow copy of the domain from the Spring Environment (including propertySources as the main feature). The Environment resources are parametrized by three variables:
     1. {application}, which maps to spring.application.name on the client side.
     2. {profile}, which maps to spring.profiles.active on the client (comma-separated list).
     3. {label}, which is a server side feature labelling a "versioned" set of config files.

Repository implementations generally behave like a Spring Boot application, loading configuration files from a spring.config.name equal to the {application} parameter, and spring.profiles.active equal to the {profiles} parameter. Precedence rules for profiles are also the same as in a regular Spring Boot application: Active profiles take precedence over defaults, and, if there are multiple profiles, the last one wins (similar to adding entries to a Map).Active profiles take precedence over defaults, and, if there are multiple profiles, the last one wins (similar to adding entries to a Map).

```java
spring.application.name = app-name>
spring.profiles.active = dev,mysql
```

You can set spring.cloud.config.server.accept-empty to false so that Server would return a HTTP 404 status, if the application is not found. By default, this flag is set to true.
NOTE:-  You cannot place spring.main.* properties in a remote EnvironmentRepository. These properties are used as part of the application initialization. 

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

- **Fie System Backend** - It is a “native” profile in the Config Server that does not use Git but loads the config files from the local classpath or file system (any static URL you want to point to with `spring.cloud.config.server.native.searchLocations`).

To use the native profile, launch the Config Server with `spring.profiles.active=native`.

NOTE:- A filesystem backend is great for getting started quickly and for testing. To use it in production, you need to be sure that the file system is reliable and shared across all instances of the Config Server.

Remember to use the file: prefix for file resources (the default without a prefix is usually the classpath). As with any Spring Boot configuration, you can embed ${}-style environment placeholders, but remember that absolute paths in Windows require an extra / (for example, /${user.home}/config-repo).

The default value of the searchLocations is identical to a local Spring Boot application (that is, [classpath:/, classpath:/config, file:./, file:./config]).
This does not expose the application.properties from the server to all clients,because any property sources present in the server are removed before being sent to the client.

The search locations can contain placeholders for {application}, {profile}, and {label}. In this way, you can segregate the directories in the path and choose a strategy that makes sense for you (such as subdirectory per application or subdirectory per profile).

```java
server.port=8888
```

This behavior can be disabled by setting spring.cloud.config.server.native.addLabelLocations=false.

- **Vault Backend**:- Spring Cloud Config Server also supports Vault as a backend.

Vault is a tool for securely accessing secrets. A secret is anything that to which you want to tightly control access, such as API keys, passwords, certificates, and other sensitive information. Vault provides a unified interface to any secret while providing tight access control and recording a detailed audit log.

To enable the config server to use a Vault backend, you can run your config server with the vault profile. For example, in your config server’s you application.properties, can add spring.profiles.active=vault.

By default, the config server assumes that your Vault server runs at 127.0.0.1:8200. It also assumes that the name of backend is secret and the key is application. All of these defaults can be configured in your config server’s application.properties.
b<63m>

## Sharing Configuration With All Applications

`File Based Repositories`:- With file-based (git, svn, and native) repositories, resources with file names in application* (application.properties, application.yml, application-*.properties, and so on) are shared between all client applications. You can use resources with these file names to configure global defaults and have them be overridden by application-specific files as necessary.

The property overrides feature can also be used for setting global defaults, with placeholders applications allowed to override them locally.

NOTE:- With the “native” profile (a local file system backend) , you should use an explicit search location that is not part of the server’s own configuration. Otherwise, the application* resources in the default search locations get removed because they are part of the server. 

`Vault Server` - When using Vault as a backend, you can share configuration with all applications by placing configuration in secret/application. For example, if you run the following Vault command, all applications using the config server will have the properties foo and baz available to them:

```sh
vault write secret/application foo=bar baz=bam
```

`JDBC Environment Repository`:- To share configurations using the JDBC backend, insert records into your database with 'application' as the value in the application column for entries intended to be shared across all clients. Application-specific properties can then override these shared configurations, providing flexibility and control over your application environments.

```SQL
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('application', 'default', 'master', 'a.b.c', 'shared-value');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('myapp', 'prod', 'master', 'd.e.f', 'specific-value');
```
