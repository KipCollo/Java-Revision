# Persistence

Persistence simply means that we would like our application’s data to outlive the applications process. In Java terms, we would like the state of (some of) our objects to live beyond the scope of the JVM so that the same state is available later.

## JPA (Java Persistence API)

JPA is a specification for ORM (Object-Relational Mapping), which maps Java objects to database tables and abstracts SQL operations.

Key Features:

- Declarative mapping using annotations (@Entity, @Table, etc.).
- Entity relationships (@OneToOne, @OneToMany, etc.).
- JPQL (Java Persistence Query Language): Object-oriented query language.

Key Classes/Interfaces:

- EntityManager: Manages entities and transactions.
- Persistence: Bootstrap class for initializing JPA.
- Entities: Plain Old Java Objects (POJOs) annotated for persistence.

Limitation:- JPA is a specification, not an implementation. It needs a provider like Hibernate.

## Hibernate (JPA Provider)

Hibernate is a framework that implements the JPA specification and adds additional features for ORM and database interactions.

Key Features:

- Implements all JPA features.
- Provides advanced features like caching, lazy loading, and batch processing.
- Supports native SQL queries alongside JPQL.

Key Components:

- SessionFactory: Factory for managing database sessions.
- Session: Equivalent to EntityManager in JPA.
- Criteria API: For programmatically building queries.

Use Case: Hibernate is one of the most popular JPA providers due to its rich feature set and extensive documentation.

**JPA as a Specification** - JPA (Java Persistence API) is indeed a specification, which means it defines a set of rules and guidelines for object-relational mapping (ORM) and how Java objects are persisted in relational databases. JPA itself does not provide an implementation; it just defines the standards for ORM. Think of it as a contract that an ORM provider (like Hibernate, EclipseLink, or OpenJPA) follows to enable persistence functionality in Java.

JPA provides a set of annotations like @Entity, @Id, @GeneratedValue, @ManyToOne, @OneToMany, etc.
JPA also defines how data is persisted, retrieved, and queried, but it leaves the implementation details to the provider.

**Hibernate as an Implementation of JPA** - Hibernate is a popular JPA implementation. It adheres to the JPA specification, but it also includes additional features beyond JPA. Hibernate implements the rules defined by JPA, but it also adds its own set of advanced ORM capabilities, such as custom caching, automatic dirty checking, and more.

Hibernate can be used as the JPA provider. In fact, when you use JPA annotations in your code (like @Entity, @Id, etc.), Hibernate is the underlying implementation that handles the actual mapping between your Java objects and the database.

## JPA Configuration (Persistence Unit)

Create a persistence.xml file inside src/main/resources/META-INF/ to configure the persistence unit.

```xml
<persistence xmlns="https://jakarta.ee/xml/ns/persistence" version="3.0">
    <persistence-unit name="my-persistence-unit">
        <class>User</class>
        <properties>
            <!-- Database connection properties -->
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/my_database"/>
            <property name="jakarta.persistence.jdbc.user" value="root"/>
            <property name="jakarta.persistence.jdbc.password" value="password"/>
            <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>

            <!-- Hibernate as JPA provider -->
            <property name="jakarta.persistence.provider" value="org.hibernate.jpa.HibernatePersistenceProvider"/>

            <!-- Hibernate properties -->
            <property name="hibernate.hbm2ddl.auto" value="update"/> <!-- Auto-create tables -->
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
            <property name="hibernate.show_sql" value="true"/> <!-- Show SQL in logs -->
        </properties>
    </persistence-unit>
</persistence>
```

JPA Implementation

This code demonstrates fetching data from the users table using JPA.

```java
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class JPAExample {
    public static void main(String[] args) {
        // Create EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        try {
            // Fetch all users from the database
            List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();

            // Print user details
            users.forEach(user -> 
                System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail())
            );

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the EntityManager and EntityManagerFactory
            em.close();
            emf.close();
        }
    }
}
```

How It Works

Entity Class:The User class is annotated with @Entity to map it to the users table in the database.The @Id and @GeneratedValue annotations specify the primary key and its auto-generation strategy.
Persistence Configuration:The persistence.xml file defines the persistence unit, database connection details, and JPA provider (Hibernate in this case).
EntityManager:The EntityManager is used to interact with the database.The createQuery method runs a JPQL query (SELECT u FROM User u) to fetch all users.
Resource Management:The EntityManager and EntityManagerFactory are properly closed to release resources.

Advantages of Using JPA

Abstraction:JPA abstracts SQL queries and low-level JDBC code, making database interactions simpler.
ORM Capabilities:JPA maps Java objects directly to database tables, reducing boilerplate code.
Portability:The same code can work with different databases by simply changing the configuration in persistence.xml.
Transaction Management:Transactions are easier to manage compared to JDBC.

This implementation is clean, scalable, and leverages JPA for efficient database operations.

JPA abstracts SQL queries by allowing developers to interact with the database using Java objects and methods rather than writing raw SQL queries. It uses an Object-Relational Mapping (ORM) approach, where Java classes are mapped to database tables, and their fields correspond to table columns. Here's how JPA achieves query abstraction:

- Using Entity Classes Instead of Tables:- With JPA, you work with Java classes (entities) that represent database tables.Instead of manually constructing SQL statements, you manipulate these entities, and JPA translates the operations into SQL.

Example:

```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}
```

How it is abstracted:- This User class is mapped to the users table in the database.You don’t need to write SQL INSERT INTO, SELECT, or UPDATE statements explicitly.

- Query Abstraction with JPQL:- JPA provides Java Persistence Query Language (JPQL), which is a high-level query language similar to SQL but operates on entity objects rather than table names.

Example:

```java
List<User> users = em.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class)
                     .setParameter("name", "Alice")
                     .getResultList();
```

How it is abstracted:- The SELECT u FROM User u query operates on the User entity, not the users table.JPA automatically translates this JPQL query into the equivalent SQL:

```sql
SELECT * FROM users WHERE name = 'Alice';
```

- CRUD Operations Without SQL:- JPA provides methods for common database operations like Create, Read, Update, and Delete (CRUD). You don’t need to write SQL for these tasks.

Example: Persisting an Object (Insert)

```java
User user = new User();
user.setName("Charlie");
user.setEmail("charlie@example.com");

em.getTransaction().begin();
em.persist(user);
em.getTransaction().commit();
```

How it is abstracted:- The persist method inserts the object into the database.JPA generates the following SQL:

```sql
INSERT INTO users (name, email) VALUES ('Charlie', 'charlie@example.com');
```

Example: Updating an Object

```java
User user = em.find(User.class, 1L);
user.setEmail("newemail@example.com");

em.getTransaction().begin();
em.merge(user);
em.getTransaction().commit();
```

How it is abstracted:- The merge method updates the object in the database.
JPA generates:

```sql
UPDATE users SET email = 'newemail@example.com' WHERE id = 1;
```

- Relationships Abstracted:- JPA handles relationships (e.g., one-to-many, many-to-many) without requiring SQL joins.

Example:

```java
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user; // Maps to the 'user_id' column in the orders table
}
```

How it is abstracted:- The @ManyToOne annotation maps a Java reference to a foreign key column in SQL.Fetching all orders with their users:

```java
List<Order> orders = em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
```

JPA generates:

```sql
SELECT o.id, o.user_id FROM orders o;
```

- Automatic SQL Generation:- JPA automatically generates SQL based on annotations like @Entity, @Table, @Id, etc. For example:

Entity Class:

```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}
```

Generated SQL for Table Creation:

```sql
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255)
);
```

- Criteria API for Dynamic Queries:- For dynamic queries, JPA provides a Criteria API, allowing you to build queries programmatically in Java.

Example:

```java
CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<User> query = cb.createQuery(User.class);
Root<User> root = query.from(User.class);
query.select(root).where(cb.equal(root.get("name"), "Alice"));

List<User> users = em.createQuery(query).getResultList();
```

How it is abstracted:- This builds a SQL query dynamically without directly writing SQL:

```sql
SELECT * FROM users WHERE name = 'Alice';
```

Summary of Abstractions
Task- JDBC (Manual SQL)- JPA (Abstracted)
Entity Mapping- Write SQL for table operations.- Annotate Java classes, and let JPA map them.
Querying- Write SELECT statements manually.- Use JPQL or Criteria API for object-oriented queries.
Inserting Data- Use INSERT INTO queries.- Call persist() on an entity.
Updating Data- Write UPDATE statements.- Call merge() on an entity.
Relationships- Manually manage foreign keys.- Use annotations like @OneToMany, @ManyToOne.
Transactions- Explicitly manage commit/rollback in SQL.- Use EntityTransaction with abstracted methods.

JPA reduces the need for boilerplate SQL, minimizes error-prone code, and provides a cleaner, object-oriented approach to database interactions.

## Java Persistence API vs. Jakarta Persistence Layer

Java Persistence API (JPA) and Jakarta Persistence Layer (JPL) are both popular frameworks for managing relational data in Java applications. While JPA has been around for a longer time, JPL was introduced as part of the Jakarta EE specifications after Java EE was transferred to the Eclipse Foundation.

## Java Persistence API (JPA)

Java Persistence API (JPA) is a Java specification for managing relational data in Java applications. It is part of the Java EE and Jakarta EE specifications and provides an Object-Relational Mapping (ORM) framework to map Java objects to relational database tables. JPA allows developers to interact with relational databases in an object-oriented way, abstracting the underlying SQL.

## Jakarta Persistence Layer (JPL)

Jakarta Persistence Layer (JPL) is the successor to JPA and is part of the Jakarta EE specifications. It is built upon JPA and provides similar functionality for managing relational data in Java applications. The primary difference is the change of package names, from javax.persistence to jakarta.persistence.

Both Java Persistence API (JPA) and Jakarta Persistence Layer (JPL) provide robust frameworks for managing relational data in Java applications. They both offer similar functionality, and the primary difference is the change of package names.

Jakarta Persistence is the API for the management for persistence and object/relational mapping.

## Annotation Types

1. @Access:- Used to specify an access type to be applied to an entity class, mapped superclass, or embeddable class, or to a specific attribute of such a class.
2. @AssociationOverride:- Used to override a mapping for an entity relationship.
3. @AssociationOverrides:- Used to override mappings of multiple relationship properties or fields.
4. @AttributeOverride:- Used to override the mapping of a Basic (whether explicit or default) property or field or Id property or field.
5. @AttributeOverrides:- Used to override mappings of multiple properties or fields.
6. @Basic:- The simplest type of mapping to a database column.
7. @Cacheable:- Specifies whether an entity should be cached if caching is enabled when the value of the persistence.xml caching element is ENABLE_SELECTIVE or DISABLE_SELECTIVE.
8. @CollectionTable:- Specifies the table that is used for the mapping of collections of basic or embeddable types.
9. @Column:- Specifies the mapped column for a persistent property or field.
10. @ColumnResult;- Used in conjunction with the SqlResultSetMapping annotation or ConstructorResult annotation to map a column of the SELECT list of a SQL query.
11. @ConstructorResult:- Used in conjunction with the SqlResultSetMapping annotation to map the SELECT clause of a SQL query to a constructor.
12. @Convert:- Specifies the conversion of a Basic field or property.
13. @Converter:- Specifies that the annotated class is a converter and defines its scope.
14. @Entity:- Specifies that the class is an entity.
15. @Id:- Specifies the primary key of an entity.
16. @Table:- Specifies the primary table for the annotated entity.
17. @UniqueConstraint- Specifies that a unique constraint is to be included in the generated DDL for a primary or secondary table.
18. @GeneratedValue:- Provides for the specification of generation strategies for the values of primary keys.
19. @SequenceGenerators- Used to group SequenceGenerator annotations.

Converts- Used to group Convert annotations.
DiscriminatorColumn- Specifies the discriminator column for the SINGLE_TABLE and JOINED Inheritance mapping strategies.
DiscriminatorValue:- Specifies the value of the discriminator column for entities of the given type.
ElementCollection:- Specifies a collection of instances of a basic type or embeddable class.
Embeddable:- Specifies a class whose instances are stored as an intrinsic part of an owning entity and share the identity of the entity.
Embedded:- Specifies a persistent field or property of an entity whose value is an instance of an embeddable class.
EmbeddedId:- Applied to a persistent field or property of an entity class or mapped superclass to denote a composite primary key that is an embeddable class.
@EntityListeners:- Specifies the callback listener classes to be used for an entity or mapped superclass.
EntityResult:- Used in conjunction with the SqlResultSetMapping annotation to map the SELECT clause of a SQL query to an entity result.
Enumerated:- Specifies that a persistent property or field should be persisted as a enumerated type.
ExcludeDefaultListeners:- Specifies that the invocation of default listeners is to be excluded for the entity class (or mapped superclass) and its subclasses.
ExcludeSuperclassListeners:- Specifies that the invocation of superclass listeners is to be excluded for the entity class (or mapped superclass) and its subclasses.
FieldResult:- Used in conjunction with the EntityResult annotation to map columns specified in the SELECT list of a SQL query to the properties or fields of an entity class.
ForeignKey:- Used to specify the handling of foreign key constraints when schema generation is in effect.
@IdClass:- Specifies a composite primary key class that is mapped to multiple fields or properties of the entity.
@Index:- Used in schema generation to specify creation of an index.
@Inheritance:- Specifies the inheritance strategy to be used for an entity class hierarchy.
@JoinColumn:- Specifies a column for joining an entity association or element collection.
@JoinColumns:- Specifies the mapping for composite foreign keys.
@JoinTable:- Specifies the mapping of associations.
@Lob :- Specifies that a persistent property or field should be persisted as a large object to a database-supported large object type.
@ManyToMany:- Specifies a many-valued association with many-to-many multiplicity.
@ManyToOne:- Specifies a single-valued association to another entity class that has many-to-one multiplicity.
MapKey:- Specifies the map key for associations of type java.util.Map when the map key is itself the primary key or a persistent field or property of the entity that is the value of the map.
MapKeyClass:- Specifies the type of the map key for associations of type java.util.Map.
MapKeyColumn:- Specifies the mapping for the key column of a map whose map key is a basic type.
MapKeyEnumerated:- Specifies the enum type for a map key whose basic type is an enumerated type.
MapKeyJoinColumn:- Specifies a mapping to an entity that is a map key.
MapKeyJoinColumns:- Supports composite map keys that reference entities.
MapKeyTemporal:- This annotation must be specified for persistent map keys of type Date and Calendar.
MappedSuperclass:- Designates a class whose mapping information is applied to the entities that inherit from it.
MapsId:- Designates a ManyToOne or OneToOne relationship attribute that provides the mapping for an EmbeddedId primary key, an attribute within an EmbeddedId primary key, or a simple primary key of the parent entity.
NamedAttributeNode:- A NamedAttributeNode is a member element of a NamedEntityGraph.
NamedEntityGraph:- Used to specify the path and boundaries for a find operation or query.
NamedEntityGraphs:- Used to group NamedEntityGraph annotations.
NamedNativeQueries:- Specifies multiple native SQL named queries.
NamedNativeQuery:- Specifies a named native SQL query.
NamedQueries:- Specifies multiple named Jakarta Persistence query language queries.
NamedQuery:- Specifies a static, named query in the Jakarta Persistence query language.
NamedStoredProcedureQueries:- Specifies multiple named stored procedure queries.
NamedStoredProcedureQuery:- Specifies and names a stored procedure, its parameters, and its result type.
NamedSubgraph:- A NamedSubgraph is a member element of a NamedEntityGraph.
@OneToMany:- Specifies a many-valued association with one-to-many multiplicity.
@OneToOne:- Specifies a single-valued association to another entity that has one-to-one multiplicity.
@OrderBy:- Specifies the ordering of the elements of a collection valued association or element collection at the point when the association or collection is retrieved.
@OrderColumn:- Specifies a column that is used to maintain the persistent order of a list.
PersistenceContext:- Expresses a dependency on a container-managed EntityManager and its associated persistence context.
PersistenceContexts:- Declares one or more PersistenceContext annotations.
PersistenceProperty:- Describes a single container or persistence provider property.
PersistenceUnit:- Expresses a dependency on an EntityManagerFactory and its associated persistence unit.
PersistenceUnits:- Declares one or more PersistenceUnit annotations.
PostLoad:- Specifies a callback method for the corresponding lifecycle event.
PostPersist:- Specifies a callback method for the corresponding lifecycle event.
PostRemove:- Specifies a callback method for the corresponding lifecycle event.
PostUpdate:- Specifies a callback method for the corresponding lifecycle event.
PrePersist:- Specifies a callback method for the corresponding lifecycle event.
PreRemove:- Specifies a callback method for the corresponding lifecycle event.
PreUpdate:- Specifies a callback method for the corresponding lifecycle event.
PrimaryKeyJoinColumn:- Specifies a primary key column that is used as a foreign key to join to another table.
PrimaryKeyJoinColumns:- Groups PrimaryKeyJoinColumn annotations.
QueryHint:- Used to supply a query property or hint to the NamedQuery or NamedNativeQuery annotation.
SecondaryTable:- Specifies a secondary table for the annotated entity class.
SecondaryTables:- Specifies multiple secondary tables for an entity.
SequenceGenerator:- Defines a primary key generator that may be referenced by name when a generator element is specified for the GeneratedValue annotation.
SqlResultSetMapping:- Specifies the mapping of the result of a native SQL query or stored procedure.
SqlResultSetMappings:- Is used to define one or more SqlResultSetMapping annotations.
StoredProcedureParameter:- Specifies a parameter of a named stored procedure query.
TableGenerator:- Defines a primary key generator that may be referenced by name when a generator element is specified for the GeneratedValue annotation.
TableGenerators:- Used to group TableGenerator annotations.
Temporal:- This annotation must be specified for persistent fields or properties of type java.util.Date and java.util.Calendar.
Transient:- Specifies that the property or field is not persistent.
Version:- Specifies the version field or property of an entity class that serves as its optimistic lock value.

Generation strategy of key

1. GenerationType.AUTO -  Default generation type and lets the persistence provider choose the generation strategy.If you use Hibernate as persistence provider,it selects a generation strategy based on database-specific dialect.Most popular database uses GenerationType.SEQUENCE
2. GenerationType.IDENTITY - It relies on auto-incremented database column and lets database generate new value with each insert operation.Not good for JDBC batch operations.
3. GenerationType.SEQUENCE - Is used to generate primary key values and uses a database sequence to generate unique values.It requires additional select statements to get next value from a database sequence,but this has no performance impact on most applications.
  The @SequenceGenerator lets you define the name of generator and schema of db sequence and allocation size.
4. GenerationType.TABLE - Rarely used nowadays

```java
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="product_generator")
@SequenceGenerator(name ="product_generator",sequenceName="product_sequence_name",allocationSize=1)
```

Example:-

```java
@Entity
@Table(name= "products", schema = "ecommerce", uniqueConstraints={@UniqueConstraint=(name="cln_unique",columnNames="email"),@UniqueConstraint=(name="cln_unique",columnNames="pass")})
public class Product{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String email
   @Column(name="pass", nullable = false)
   private String password
}
```

## Why Use JPA Annotations and Not Hibernate Annotations?

In modern applications, it's a best practice to use JPA annotations rather than Hibernate-specific annotations because:

Portability: JPA annotations are part of the Java EE specification and are therefore standardized. By using JPA, your code can run with any JPA-compliant provider (e.g., Hibernate, EclipseLink, or OpenJPA). If you use Hibernate-specific annotations, your code becomes tightly coupled to Hibernate, making it harder to switch to another ORM provider if needed.

Abstraction: JPA provides a level of abstraction over the underlying ORM implementation. When you use JPA annotations, your code is less dependent on the specific ORM framework you're using (in this case, Hibernate). The goal is to write portable, standard code that follows JPA rules, while Hibernate simply implements these rules behind the scenes.

Spring's Choice: In a Spring application, especially with Spring Data JPA, you typically don't need to worry about the underlying ORM provider (like Hibernate) because Spring abstracts that away. You only need to use the JPA annotations, and Spring Data will use the configured JPA provider (which can be Hibernate by default) to handle the actual database interactions.
