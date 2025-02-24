# Java SE Technologies - Database

## Java DB

Is Oracle's supported distribution of the open source Apache Derby database. Its ease of use, standards compliance, full feature set, and small footprint make it the ideal database for Java developers. Java DB is written in the Java programming language, providing "write once, run anywhere" portability. It can be embedded in Java applications, requiring zero administration by the developer or user. It can also be used in client server mode. Java DB is fully transactional and provides a standard SQL interface as well as a JDBC 4.1 compliant driver.JavaDB is no longer included in recent versions of the JDK.

## Java Data Objects (JDO)

Is a standard interface-based Java model abstraction of persistence. Application programmers can use JDO technology to directly store Java domain model instances into the persistent store (database). Benefits include ease of programming, application portability, database independence, high performance, and optional integration with Enterprise JavaBeans (EJB).

## The Java Database Connectivity (JDBC)

Is the industry standard for database-independent connectivity between the Java programming language and a wide range of databases SQL databases and other tabular data sources, such as spreadsheets or flat files. The JDBC API provides a call-level API for SQL-based database access.JDBC technology allows you to use the Java programming language to exploit "Write Once, Run Anywhere" capabilities for applications that require access to enterprise data. With a JDBC technology-enabled driver, you can connect all corporate data even in a heterogeneous environment.

There are two main ways to access a relational database from Java:

1. Java Database Connectivity (JDBC): Accesses data as rows and columns.
2. Java Persistence API (JPA): Accesses data through Java objects using a concept called object-­relational mapping (ORM). The idea is that you don’t have to write as much code, and you get your data in Java objects.

The relationship among java.sql, javax.sql, JPA, Hibernate, and Spring Data revolves around managing databases in Java applications. Each provides specific capabilities, often working together to simplify database interactions.

**java.sql (Core JDBC API)**:- java.sql provides the foundation for database connectivity in Java using JDBC (Java Database Connectivity). It allows executing SQL statements, managing connections, and handling result sets.

Key Components:

- DriverManager: Manages database connections.
- Connection: Represents a connection to a database.
- Statement/PreparedStatement: Executes SQL queries.
- ResultSet: Retrieves results of queries.

Limitation:

- Low-Level API: Requires writing SQL manually and managing resources (connections, statements) explicitly.
- No object-relational mapping (ORM) capabilities.

**javax.sql (Advanced JDBC)**:- Extends java.sql by adding advanced features for JDBC, focusing on connection pooling and distributed transactions.

Key Components:

- DataSource: A factory for managing connections. More robust than DriverManager.
- ConnectionPoolDataSource: Provides connection pooling support.
- RowSet: Easier handling of tabular data with support for disconnected operation.

Use Case:

- Applications requiring performance optimizations (via connection pooling).
- Foundation for higher-level frameworks like JPA and Spring Data.

**JPA (Java Persistence API)**:-JPA is a specification for ORM (Object-Relational Mapping), which maps Java objects to database tables and abstracts SQL operations.

Key Features:

- Declarative mapping using annotations (@Entity, @Table, etc.).
- Entity relationships (@OneToOne, @OneToMany, etc.).
- JPQL (Java Persistence Query Language): Object-oriented query language.

Key Classes/Interfaces:

- EntityManager: Manages entities and transactions.
- Persistence: Bootstrap class for initializing JPA.
- Entities: Plain Old Java Objects (POJOs) annotated for persistence.

Limitation:

JPA is a specification, not an implementation. It needs a provider like Hibernate.

**Hibernate (JPA Provider)**:- Hibernate is a framework that implements the JPA specification and adds additional features for ORM and database interactions.

Key Features:

- Implements all JPA features.
- Provides advanced features like caching, lazy loading, and batch processing.
- Supports native SQL queries alongside JPQ- K- Components:
- SessionFactory: Factory for managing database sessions.
- Session: Equivalent to EntityManager in JPA.
- Criteria API: For programmatically building queries.

Use Case: Hibernate is one of the most popular JPA providers due to its rich feature set and extensive documentation.

**Spring Data**:- Spring Data is a high-level abstraction layer over JPA (or other persistence technologies) that simplifies database access in Spring applications.

Key Features:

- Repositories: Predefined CRUD operations with minimal boilerplate.Example: JpaRepository, CrudRepository.
- Query Methods: Derive queries from method names (findByName, findByAgeGreaterThan).
- Integration with other persistence APIs like MongoDB, Cassandra, etc.

Key Components:

- JpaRepository: Extends JPA with additional features like pagination and sorting.
- Custom Queries: Supports JPQL, native SQL, and @Query annotations.

Use Case: Spring Data eliminates boilerplate code in Spring applications, making it easier to implement complex persistence logic.

java.sql - Low-level database connectivity using JDBC.Direct database access.
javax.sql- Extends java.sql with advanced JDBC features like connection pooling.Builds on java.sql.
JPA- High-level abstraction for ORM, maps Java objects to database tables.Uses javax.sql for connections.
Hibernate- A JPA provider with additional ORM features.Implements JPA.
Spring Data- Simplifies working with JPA (or other databases) in Spring applications.Leverages JPA/Hibernate.

Spring Data manages repository abstractions.
Hibernate handles ORM and implements JPA.
JPA abstracts SQL using entities.
javax.sql provides the DataSource for connections.
java.sql is used internally for executing SQL queries.
