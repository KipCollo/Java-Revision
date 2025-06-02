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
