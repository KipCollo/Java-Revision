# JDBC

Spring Data JDBC, part of the larger Spring Data family, makes it easy to implement JDBC based repositories. This module deals with enhanced support for JDBC based data access layers. It makes it easier to build Spring powered applications that use data access technologies.

## Spring Data JDBC and R2DBC

Spring Data JDBC and R2DBC provide repository support for the Java Database Connectivity (JDBC) rand Reactive Relational Database Connectivity (R2DBC) APIs. It eases development of applications with a consistent programming model that need to access SQL data sources.

Spring Data JDBC aims to be much simpler conceptually, by embracing the following design decisions:

1. If you load an entity, SQL statements get run. Once this is done, you have a completely loaded entity. No lazy loading or caching is done.
2. If you save an entity, it gets saved. If you do not, it does not. There is no dirty tracking and no session.

In terms of databases, Spring Data JDBC requires a dialect to abstract common SQL functionality over vendor-specific flavours. Spring Data JDBC includes direct support for the following databases:

1. DB2
2. H2
3. HSQLDB
4. MariaDB
5. Microsoft SQL Server
6. MySQL
7. Oracle
8. Postgres

## Logging

Spring Data JDBC does little to no logging on its own. Instead, the mechanics of JdbcTemplate to issue SQL statements provide logging. Thus, if you want to inspect what SQL statements are run, activate logging for Spring’s NamedParameterJdbcTemplate or MyBatis.

You may also want to set the logging level to DEBUG to see some additional information. To do so, edit the application.properties file to have the following content:

```java
logging.level.org.springframework.jdbc=DEBUG
```

## Database Connection

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
spring.datasource.url=jdbc:mysql:localhost:3306/database-name?createDatabaseIfNotExist=true//mysql can create database automatically if it doesn't exist
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name= com.mysql.cj.jdbc.Driver
```
