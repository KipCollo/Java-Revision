# Overview of Spring Boot JPA

Spring Boot JPA is essentially a configuration and setup framework that integrates JPA with Spring Boot in a seamless way. It simplifies the process of connecting your application to a database and allows you to focus on the business logic instead of tedious configuration.

Key features of Spring Boot JPA:

1. Auto-configuration: Automatically configures JPA-related beans, including EntityManagerFactory, DataSource, and TransactionManager.
2. Repository Support: Spring Data JPA provides easy-to-use repository interfaces, and Spring Boot auto-configures them for you.
3. Integration with Hibernate: By default, Spring Boot uses Hibernate as the JPA implementation (though you can swap it out for other providers if needed).
4. DataSource Configuration: Spring Boot uses application.properties or application.yml to configure the database connection, reducing the need for XML configuration.

It has dependencies from:-

- JPA dependencies
- Hibernate dependencies
- Spring Data JPA dependencies
- AOP
- JDBC
- Transaction

To work with database,you need to configure JDBC URL,Database username,database password and hibernate properties.

You can configure your database connection and JPA properties in src/main/resources/application.properties. Spring Boot automatically picks up this configuration to set up the DataSource, EntityManagerFactory, and transaction management.

```java
spring.datasource.url=jdbc:{database-provider}://{hostname}:{port}/database-name
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=//org.postgresql.Driver, com.mysql.cj.jdbc.Driver, com.mysql.jdbc.Driver

//postgres
spring.datasource.url=jdbc:postgresql:localhost:5432/database-name
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver

//mysql
# Database Configuration
spring.datasource.url=jdbc:mysql:localhost:3306/database-name?createDatabaseIfNotExist=true//mysql can create database automatically if it doesn't exist
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name= com.mysql.cj.jdbc.Driver

# JPA/Hibernate Configuration
spring.jpa.database-platform=//database platform postgresql,mysql
spring.jpa.show-sql=//true or false
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=//create-drop,create,none,update,validate
spring.jpa.properties.hibernate.dialect=//org.hibernate.dialect.MySQL8Dialect
```

- spring.datasource.url: The URL for the database connection.
- spring.datasource.username: Database username.
- spring.datasource.password: Database password.
- spring.jpa.hibernate.ddl-auto: Specifies the DDL mode. It can be none, update, create, or create-drop.
    1. update: Keeps the schema in sync with your entities.Update the schema if necessary
    2. create: Creates the schema from scratch on every application startup.Create the schema and destroy previous data.
    3. create-drop: Creates and drops the schema on startup and shutdown.
    4. none- Disable DDL handling
    5. validate- Validate the schema, make no changes to the database
- spring.jpa.show-sql: When set to true, Hibernate will log all SQL queries.
- spring.jpa.properties.hibernate.format_sql: Makes SQL output easier to read in logs.

## Working with NoSQL Technologies

Spring Data provides additional projects that help you access a variety of NoSQL technologies, including:

1. MongoDB
2. Neo4J
3. Elasticsearch
4. Solr
5. Redis
6. Gemfire or Geode
7. Cassandra
8. Couchbase
9. LDAP

Spring Boot provides auto-configuration for Redis, MongoDB, Neo4j, Elasticsearch, Solr Cassandra, Couchbase, and LDAP.You can make use of the other projects, but you must configure them yourself.

## Redis

Redis is a cache, message broker, and richly-featured key-value store. Spring Boot offers basic auto-configuration for the Lettuce and Jedis client libraries and the abstractions on top of them provided by Spring Data Redis.There is a spring-boot-starter-data-redis “Starter” for collecting the dependencies in a convenient way. By default, it uses Lettuce. That starter handles both traditional and reactive applications.

Note: we also provide a spring-boot-starter-data-redis-reactive “Starter” for consistency with the other stores with reactive support

- Connecting to Redis: You can inject an auto-configured RedisConnectionFactory , StringRedisTemplate , or vanilla RedisTemplate instance as you would any other Spring Bean. By default, the instance tries to connect to a Redis server at localhost:6379 . The following listing shows an example of such a bean:

```java
@Component
public class MyBean {
private StringRedisTemplate template;
@Autowired
public MyBean(StringRedisTemplate template) {
this.template = template;
}
// ...
}
```

You can also register an arbitrary number of beans that implementLettuceClientConfigurationBuilderCustomizer for more advanced customizations. If you use Jedis,
JedisClientConfigurationBuilderCustomizer is also available.

If you add your own @Bean of any of the auto-configured types, it replaces the default (except in the case of RedisTemplate , when the exclusion is based on the bean name, redisTemplate , not its type). By default, if commons-pool2 is on the classpath, you get a pooled connection factory.

## MongoDB

MongoDB is an open-source NoSQL document database that uses a JSON-like schema instead of traditional table-based relational data. Spring Boot offers several conveniences for working with MongoDB, including the spring-boot-starter-data-mongodb and spring-boot-starter-data-mongodb-reactive “Starters”.

- Connecting to a MongoDB Database: To access Mongo databases, you can inject an auto-configured org.springframework.data.mongodb.MongoDbFactory . By default, the instance tries to connect to a MongoDB server at mongodb://localhost/test . The following example shows how to connect to a MongoDB database:

```java
import org.springframework.data.mongodb.MongoDbFactory;
import com.mongodb.DB;
@Component
public class MyBean {
private final MongoDbFactory mongo;
@Autowired
public MyBean(MongoDbFactory mongo) {
this.mongo = mongo;
}
// ...
public void example() {
DB db = mongo.getDb();
// ...
}
}
```

You can set the spring.data.mongodb.uri property to change the URL and configure additional settings such as the replica set, as shown in the following example:

```java
spring.data.mongodb.uri=mongodb://user:secret@mongo1.example.com:12345,mongo2.example.com:23456/test
```

Alternatively, as long as you use Mongo 2.x, you can specify a host / port . For example, you might declare the following settings in your application.properties:

```java
spring.data.mongodb.host=mongoserver
spring.data.mongodb.port=27017
```

If you have defined your own MongoClient , it will be used to auto-configure a suitable MongoDbFactory . Both com.mongodb.MongoClient and com.mongodb.client.MongoClient are supported.

If you use the Mongo 3.0 Java driver, spring.data.mongodb.host and spring.data.mongodb.port are not supported. In such cases, spring.data.mongodb.uri should be used to provide all of the configuration.

If spring.data.mongodb.port is not specified, the default of 27017 is used. You could delete this line from the example shown earlier.

If you do not use Spring Data Mongo, you can inject com.mongodb.MongoClient beans instead of using MongoDbFactory . If you want to take complete control of establishing the MongoDB connection, you can also declare your own MongoDbFactory or MongoClient bean.

If you are using the reactive driver, Netty is required for SSL. The auto-configuration configures this factory automatically if Netty is available and the factory to use hasn’t been customized already.

- MongoTemplate: Spring Data MongoDB provides a MongoTemplate class that is very similar in its design to Spring’s JdbcTemplate . Aswith JdbcTemplate , Spring Boot auto-configures a bean for you to inject the template, as follows:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
@Component
public class MyBean {
private final MongoTemplate mongoTemplate;
@Autowired
public MyBean(MongoTemplate mongoTemplate) {
this.mongoTemplate = mongoTemplate;
}
// ...
}
```

- Spring Data MongoDB Repositories: Spring Data includes repository support for MongoDB. As with the JPA repositories discussed earlier, the basic principle is that
queries are constructed automatically, based on method names.

In fact, both Spring Data JPA and Spring Data MongoDB share the same common infrastructure. You could take the JPA example from earlier and, assuming that City is now a Mongo data class rather than a JPA @Entity , it works in the same way, as shown in the following example:

```java
package com.example.myapp.domain;
import org.springframework.data.domain.*;
import org.springframework.data.repository.*;
public interface CityRepository extends Repository<City, Long> {
Page<City> findAll(Pageable pageable);
City findByNameAndStateAllIgnoringCase(String name, String state);
}
```

You can customize document scanning locations by using the @EntityScan annotation.

- Embedded Mongo: Spring Boot offers auto-configuration for Embedded Mongo. To use it in your Spring Boot application, add a dependency on
de.flapdoodle.embed:de.flapdoodle.embed.mongo.

The port that Mongo listens on can be configured by setting the spring.data.mongodb.port property. To use a randomly allocated free port, use a value of 0. The MongoClient created by MongoAutoConfiguration is automatically configured to use the randomly allocated port.
If you do not configure a custom port, the embedded support uses a random port (rather than 27017) by default.
If you have SLF4J on the classpath, the output produced by Mongo is automatically routed to a logger named org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongo .
You can declare your own IMongodConfig and IRuntimeConfig beans to take control of the Mongo instance’s configuration and logging routing.

## Neo4j

Neo4j is an open-source NoSQL graph database that uses a rich data model of nodes connected by first class relationships,which is better suited for connected big data than traditional RDBMS approaches. Spring Boot offers several conveniences for working with Neo4j, including the spring-boot-starter-data-neo4j “Starter”.

- Connecting to a Neo4j Database: To access a Neo4j server, you can inject an auto-configured org.neo4j.ogm.session.Session . By default, the instance
tries to connect to a Neo4j server at localhost:7687 using the Bolt protocol. The following example shows how to inject a Neo4j Session :

```java
@Component
public class MyBean {
private final Session session;
@Autowired
public MyBean(Session session) {
this.session = session;
}
// ...
}
```

You can configure the uri and credentials to use by setting the spring.data.neo4j.* properties, as shown in the following example:

```java
spring.data.neo4j.uri=bolt://my-server:7687
spring.data.neo4j.username=neo4j
spring.data.neo4j.password=secret
```

You can take full control over the session creation by either adding a org.neo4j.ogm.config.Configuration bean or a org.neo4j.ogm.session.SessionFactory bean.

- Using the Embedded Mode: If you add org.neo4j:neo4j-ogm-embedded-driver to the dependencies of your application, Spring Boot automatically configures an in-process embedded instance of Neo4j that does not persist any data when your application shuts down.
As the embedded Neo4j OGM driver does not provide the Neo4j kernel itself, you have to declare org.neo4j:neo4j as dependency yourself. Refer to the Neo4j OGM documentation for a list of compatible versions.
The embedded driver takes precedence over the other drivers when there are multiple drivers on the classpath. You can
explicitly disable the embedded mode by setting spring.data.neo4j.embedded.enabled=false .
Data Neo4j Tests automatically make use of an embedded Neo4j instance if the embedded driver and Neo4j kernel are on the
classpath as described above.
You can enable persistence for the embedded mode by providing a path to a database file in your configuration,
e.g. spring.data.neo4j.uri=file://var/tmp/graph.db .

- Neo4jSession: By default, if you are running a web application, the session is bound to the thread for the entire processing of the request (that
is, it uses the "Open Session in View" pattern). If you do not want this behavior, add the following line to your application.properties file:

```java
spring.data.neo4j.open-in-view=false
```

- Spring Data Neo4j Repositories: Spring Data includes repository support for Neo4j.
Spring Data Neo4j shares the common infrastructure with Spring Data JPA as many other Spring Data modules do. You could take the JPA example from earlier and define City as Neo4j OGM @NodeEntity rather than JPA @Entity and the repository abstraction works in the same way, as shown in the following example:

```java
package com.example.myapp.domain;
import java.util.Optional;
import org.springframework.data.neo4j.repository.*;
public interface CityRepository extends Neo4jRepository<City, Long> {
Optional<City> findOneByNameAndState(String name, String state);
}
```

The spring-boot-starter-data-neo4j “Starter” enables the repository support as well as transaction management. You can customize the locations to look for repositories and entities by using @EnableNeo4jRepositories and @EntityScan respectively on a @Configuration-bean.

## Solr

Apache Solr is a search engine. Spring Boot offers basic auto-configuration for the Solr 5 client library and the abstractions on top of it provided by Spring Data Solr. There is a spring-boot-starter-data-solr “Starter” for collecting the dependencies in a convenient way.

- Connecting to Solr: You can inject an auto-configured SolrClient instance as you would any other Spring bean. By default, the instance tries to connect to a server at localhost:8983/solr . The following example shows how to inject a Solr bean:

```java
@Component
public class MyBean {
private SolrClient solr;
@Autowired
public MyBean(SolrClient solr) {
this.solr = solr;
}
// ...
}
```

If you add your own @Bean of type SolrClient , it replaces the default. 32.4.2 Spring Data Solr Repositories

- Spring Data Solr Repositories: Spring Data includes repository support for Apache Solr. As with the JPA repositories discussed earlier, the basic principle is
that queries are automatically constructed for you based on method names. In fact, both Spring Data JPA and Spring Data Solr share the same common infrastructure. You could take the JPA example from earlier and, assuming that City is now a @SolrDocument class rather than a JPA @Entity , it works in the same
way

## Elasticsearch

Elasticsearch is an open source, distributed, RESTful search and analytics engine. Spring Boot offers basic auto-configuration for Elasticsearch.

Spring Boot supports several HTTP clients:

1. The official Java "Low Level" and "High Level" REST clients
2. Jest
The transport client is still being used by Spring Data Elasticsearch, which you can start using with the spring-boot-starter-data-elasticsearch “Starter”.

- Connecting to Elasticsearch by REST clients: Elasticsearch ships two different REST clients that you can use to query a cluster: the "Low Level" client and the "High Level" client.
If you have the org.elasticsearch.client:elasticsearch-rest-client dependency on the classpath, Spring Boot will auto-configure and register a RestClient bean that by default targets localhost:9200 . You can further tune how RestClient is configured, as shown in the following example:

```java
spring.elasticsearch.rest.uris=https://search.example.com:9200
spring.elasticsearch.rest.username=user
spring.elasticsearch.rest.password=secret
```

You can also register an arbitrary number of beans that implement RestClientBuilderCustomizer for more advanced customizations. To take full control over the registration, define a RestClient bean.

If you have the org.elasticsearch.client:elasticsearch-rest-high-level-client dependency on the classpath, Spring Boot will auto-configure a RestHighLevelClient , which wraps any existing RestClient bean, reusing its HTTP configuration.

- Connecting to Elasticsearch by Using Jest: If you have Jest on the classpath, you can inject an auto-configured JestClient that by default targets localhost:9200 . You can further tune how the client is configured, as shown in the following example:

```java
spring.elasticsearch.jest.uris=https://search.example.com:9200
spring.elasticsearch.jest.read-timeout=10000
spring.elasticsearch.jest.username=user
spring.elasticsearch.jest.password=secret
```

You can also register an arbitrary number of beans that implement HttpClientConfigBuilderCustomizer for more advanced customizations. The following example tunes additional HTTP settings:

```java
static class HttpSettingsCustomizer implements HttpClientConfigBuilderCustomizer {
@Override
public void customize(HttpClientConfig.Builder builder) {
builder.maxTotalConnection(100).defaultMaxTotalConnectionPerRoute(5);
}
}
```

To take full control over the registration, define a JestClient bean.

- Connecting to Elasticsearch by Using Spring Data: To connect to Elasticsearch, you must provide the address of one or more cluster nodes. The address can be specified by setting the spring.data.elasticsearch.cluster-nodes property to a comma-separated host:port list. With this configuration in place, an ElasticsearchTemplate or TransportClient can be injected like any other Spring bean, as shown in the following example:

```java
spring.data.elasticsearch.cluster-nodes=localhost:9300
```

```java
@Component
public class MyBean {
private final ElasticsearchTemplate template;
public MyBean(ElasticsearchTemplate template) {
this.template = template;
}
// ...
}
```

If you add your own ElasticsearchTemplate or TransportClient @Bean , it replaces the default.

- Spring Data Elasticsearch Repositories: Spring Data includes repository support for Elasticsearch. As with the JPA repositories discussed earlier, the basic principle is that queries are constructed for you automatically based on method names.

In fact, both Spring Data JPA and Spring Data Elasticsearch share the same common infrastructure. You could take the JPA example from earlier and, assuming that City is now an Elasticsearch @Document class rather than a JPA @Entity , it works in the same way.

## Cassandra

Cassandra is an open source, distributed database management system designed to handle large amounts of data across many commodity servers. Spring Boot offers auto-configuration for Cassandra and the abstractions on top of it provided by Spring Data Cassandra. There is a spring-boot-starter-data-cassandra “Starter” for collecting the dependencies in a convenient way.

- Connecting to Cassandra: You can inject an auto-configured CassandraTemplate or a Cassandra Session instance as you would with any other Spring Bean. The spring.data.cassandra.* properties can be used to customize the connection. Generally, you provide keyspace-name and contact-points properties, as shown in the following example:

```java
spring.data.cassandra.keyspace-name=mykeyspace
spring.data.cassandra.contact-points=cassandrahost1,cassandrahost2
```

You can also register an arbitrary number of beans that implement ClusterBuilderCustomizer for more advanced customizations.
The following code listing shows how to inject a Cassandra bean:

```java
@Component
public class MyBean {
private CassandraTemplate template;
@Autowired
public MyBean(CassandraTemplate template) {
this.template = template;
}
// ...
}
```

If you add your own @Bean of type CassandraTemplate , it replaces the default.

- Spring Data Cassandra Repositories: Spring Data includes basic repository support for Cassandra. Currently, this is more limited than the JPA repositories
discussed earlier and needs to annotate finder methods with @Query .

## Couchbase

Couchbase is an open-source, distributed, multi-model NoSQL document-oriented database that is optimized for interactive applications. Spring Boot offers auto-configuration for Couchbase and the abstractions on top of it provided by Spring Data Couchbase. There are spring-boot-starter-data-couchbase and
spring-boot-starter-data-couchbase-reactive “Starters” for collecting the dependencies in a convenient way.

- Connecting to Couchbase: You can get a Bucket and Cluster by adding the Couchbase SDK and some configuration. The spring.couchbase.* properties can be used to customize the connection. Generally, you provide the bootstrap hosts, bucket name, and password, as shown in the following example:

```java
spring.couchbase.bootstrap-hosts=my-host-1,192.168.1.123
spring.couchbase.bucket.name=my-bucket
spring.couchbase.bucket.password=secret
```

YNote: ou need to provide at least the bootstrap host(s), in which case the bucket name is default and the password is an empty String. Alternatively, you can define your own org.springframework.data.couchbase.config.CouchbaseConfigurer @Bean to take control over the whole configuration.

It is also possible to customize some of the CouchbaseEnvironment settings. For instance, the following configuration changes the timeout to use to open a new Bucket and enables SSL support:

```java
spring.couchbase.env.timeouts.connect=3000
spring.couchbase.env.ssl.key-store=/location/of/keystore.jks
spring.couchbase.env.ssl.key-store-password=secret
```

- Spring Data Couchbase Repositories: Spring Data includes repository support for Couchbase.

You can inject an auto-configured CouchbaseTemplate instance as you would with any other Spring Bean, provided a default CouchbaseConfigurer is available (which happens when you enable Couchbase support, as explained earlier).

The following examples shows how to inject a Couchbase bean:

```java
@Component
public class MyBean {
private final CouchbaseTemplate template;
@Autowired
public MyBean(CouchbaseTemplate template) {
this.template = template;
}
// ...
}
```

There are a few beans that you can define in your own configuration to override those provided by the auto-configuration:

1. A CouchbaseTemplate @Bean with a name of couchbaseTemplate .
2. An IndexManager @Bean with a name of couchbaseIndexManager .
3. A CustomConversions @Bean with a name of couchbaseCustomConversions .

To avoid hard-coding those names in your own config, you can reuse BeanNames provided by Spring Data Couchbase. For
instance, you can customize the converters to use, as follows:

```java
@Configuration
public class SomeConfiguration {
@Bean(BeanNames.COUCHBASE_CUSTOM_CONVERSIONS)
public CustomConversions myCustomConversions() {
return new CustomConversions(...);
}
// ...
}
```

If you want to fully bypass the auto-configuration for Spring Data Couchbase, provide your own implementation of org.springframework.data.couchbase.config.AbstractCouchbaseDataConfiguration.

## LDAP

LDAP (Lightweight Directory Access Protocol) is an open, vendor-neutral, industry standard application protocol for accessing and maintaining distributed directory information services over an IP network. Spring Boot offers auto-configuration for any compliant LDAP server as well as support for the embedded in-memory LDAP server from UnboundID.

LDAP abstractions are provided by Spring Data LDAP. There is a spring-boot-starter-data-ldap “Starter” for collecting the dependencies in a convenient way.

- Connecting to an LDAP Server: To connect to an LDAP server, make sure you declare a dependency on the spring-boot-starter-data-ldap “Starter” or spring-ldap-core and then declare the URLs of your server in your application.properties, as shown in the following example:

```java
spring.ldap.urls=ldap://myserver:1235
spring.ldap.username=admin
spring.ldap.password=secret
```

If you need to customize connection settings, you can use the spring.ldap.base and spring.ldap.base-environment properties.

An LdapContextSource is auto-configured based on these settings. If you need to customize it, for instance to use a PooledContextSource , you can still inject the auto-configured LdapContextSource . Make sure to flag your customized ContextSource as @Primary so that the auto-configured LdapTemplate uses it.

- Spring Data LDAP Repositories: Spring Data includes repository support for LDAP.
You can also inject an auto-configured LdapTemplate instance as you would with any other Spring Bean, as shown in the following example:

```java
@Component
public class MyBean {
private final LdapTemplate template;
@Autowired
public MyBean(LdapTemplate template) {
this.template = template;
}
// ...
}
```

- Embedded In-memory LDAP Server: For testing purposes, Spring Boot supports auto-configuration of an in-memory LDAP server from UnboundID. To configure the
server, add a dependency to com.unboundid:unboundid-ldapsdk and declare a base-dn property, as follows:

```java
spring.ldap.embedded.base-dn=dc=spring,dc=io
```

It is possible to define multiple base-dn values, however, since distinguished names usually contain commas, they must be defined using the correct notation.
In yaml files, you can use the yaml list notation:
spring.ldap.embedded.base-dn:

- dc=spring,dc=io
- dc=pivotal,dc=io

In properties files, you must include the index as part of the property name:

```java
spring.ldap.embedded.base-dn[0]=dc=spring,dc=io
spring.ldap.embedded.base-dn[1]=dc=pivotal,dc=io
```

By default, the server starts on a random port and triggers the regular LDAP support. There is no need to specify a spring.ldap.urls property.
If there is a schema.ldif file on your classpath, it is used to initialize the server. If you want to load the initialization script from a different resource, you can also use the spring.ldap.embedded.ldif property.
By default, a standard schema is used to validate LDIF files. You can turn off validation altogether by setting the spring.ldap.embedded.validation.enabled property. If you have custom attributes, you can use spring.ldap.embedded.validation.schema to define your custom attribute types or object classes.

## InfluxDB

InfluxDB is an open-source time series database optimized for fast, high-availability storage and retrieval of time series data in fields such as operations monitoring, application metrics, Internet-of-Things sensor data, and real-time analytics.

- Connecting to InfluxDB: Spring Boot auto-configures an InfluxDB instance, provided the influxdb-java client is on the classpath and the URL of the database is set, as shown in the following example:

```java
spring.influx.url=https://172.0.0.1:8086
```

If the connection to InfluxDB requires a user and password, you can set the spring.influx.user and spring.influx.password properties accordingly.
InfluxDB relies on OkHttp. If you need to tune the http client InfluxDB uses behind the scenes, you can register an InfluxDbOkHttpClientBuilderProvider bean.
