# Hibernate ORM

Object/Relational Mapping refers to the technique of mapping data from an object model representation to a relational data model representation (and vice versa).

Hibernate is an Object/Relational Mapping solution for Java environments.It maps Java classes to database tables (and from Java data types to SQL data types), but also provides data query and retrieval facilities.It reduces development time otherwise spent with manual data handling in SQL and JDBC.

Hibernate may not be the best solution for data-centric applications that only use stored-procedures to implement the business logic in the database, it is most useful with object-oriented domain models and business logic in the Java-based middle-tier.

Hibernate ORM enables developers to more easily write applications whose data outlives the application process. As an Object/Relational Mapping (ORM) framework, Hibernate is concerned with data persistence as it applies to relational databases (via JDBC).Hibernate 6 and Hibernate Reactive are now core components of Quarkus 3.

You need to add a dependency for the JDBC driver for your database.

## JDBC driver dependencies and Database  Driver dependency

1. PostgreSQL or CockroachDB -org.postgresql:postgresql:{version}
2. MySQL or TiDB-com.mysql:mysql-connector-j:{version}
3. MariaDB-org.mariadb.jdbc:mariadb-java-client:{version}
4. DB2-com.ibm.db2:jcc:{version}
5. SQL Server-com.microsoft.sqlserver:mssql-jdbc:${version}
6. Oracle-com.oracle.database.jdbc:ojdbc11:${version}
7. H2-com.h2database:h2:{version}
8. HSQLDB-org.hsqldb:hsqldb:{version}

* Where {version} is the latest version of the JDBC driver for your databse.

Hibernate makes relational data visible to a program written in Java, in a natural and typesafe form,making it easy to write complex queries and work with their results,letting the program easily synchronize changes made in memory with the database, respecting the ACID properties of transactions, and allowing performance optimizations to be made after the basic persistence logic has already been written.

In the broadest sense, Hibernate categorizes types into two groups:

1. Value types
2. Entity types

### Value types

A value type is a piece of data that does not define its own lifecycle. It is, in effect, owned by an entity, which defines its lifecycle.
Value types are further classified into three sub-categories:

* Basic types -in mapping the Contact table, all attributes except for name would be basic types. Basic types are discussed in detail in Basic types
* Embeddable types-the name attribute is an example of an embeddable type, which is discussed in details in Embeddable types
* Collection types-collection types are also a distinct category among value types.

### Entity types

Entities, by nature of their unique identifier, exist independently of other objects whereas values do not. Entities are domain model classes which correlate to rows in a database table, using a unique identifier. Because of the requirement for a unique identifier, entities exist independently and define their own lifecycle. The Contact class itself would be an example of an entity.

3.2.7. Byte

By default, Hibernate maps values of Byte / byte to the TINYINT JDBC type.
Example 17. Mapping Byte

// these will both be mapped using TINYINT
Byte wrapper;
byte primitive;

See Byte array for mapping arrays of bytes.
3.2.8. Short

By default, Hibernate maps values of Short / short to the SMALLINT JDBC type.
Example 18. Mapping Short

// these will both be mapped using SMALLINT
Short wrapper;
short primitive;

3.2.9. Integer

By default, Hibernate maps values of Integer / int to the INTEGER JDBC type.
Example 19. Mapping Integer

// these will both be mapped using INTEGER
Integer wrapper;
int primitive;

3.2.10. Long

By default, Hibernate maps values of Long / long to the BIGINT JDBC type.
Example 20. Mapping Long

// these will both be mapped using BIGINT
Long wrapper;
long primitive;

3.2.11. BigInteger

By default, Hibernate maps values of BigInteger to the NUMERIC JDBC type.
Example 21. Mapping BigInteger

// will be mapped using NUMERIC
BigInteger wrapper;

3.2.12. Double

By default, Hibernate maps values of Double to the DOUBLE, FLOAT, REAL or NUMERIC JDBC type depending on the capabilities of the database
Example 22. Mapping Double

// these will be mapped using DOUBLE, FLOAT, REAL or NUMERIC
// depending on the capabilities of the database
Double wrapper;
double primitive;

A specific type can be influenced using any of the JDBC type influencers covered in JdbcType section.

If @JdbcTypeCode is used, the Dialect is still consulted to make sure the database supports the requested type. If not, an appropriate type is selected
3.2.13. Float

By default, Hibernate maps values of Float to the FLOAT, REAL or NUMERIC JDBC type depending on the capabilities of the database.
Example 23. Mapping Float

// these will be mapped using FLOAT, REAL or NUMERIC
// depending on the capabilities of the database
Float wrapper;
float primitive;

A specific type can be influenced using any of the JDBC type influencers covered in Mapping basic values section.

If @JdbcTypeCode is used, the Dialect is still consulted to make sure the database supports the requested type. If not, an appropriate type is selected
3.2.14. BigDecimal

By default, Hibernate maps values of BigDecimal to the NUMERIC JDBC type.
Example 24. Mapping BigDecimal

// will be mapped using NUMERIC
BigDecimal wrapper;

3.2.15. Character

By default, Hibernate maps Character to the CHAR JDBC type.
Example 25. Mapping Character

// these will be mapped using CHAR
Character wrapper;
char primitive;

3.2.16. String

By default, Hibernate maps String to the VARCHAR JDBC type.
Example 26. Mapping String

// will be mapped using VARCHAR
String string;

// will be mapped using CLOB
@Lob
String clobString;

Optionally, you may specify the maximum length of the string using @Column(length=…​), or using the @Size annotation from Hibernate Validator. For very large strings, you can use one of the constant values defined by the class org.hibernate.Length, for example:

@Column(length=Length.LONG)
private String text;

Alternatively, you may explicitly specify the JDBC type LONGVARCHAR, which is treated as a VARCHAR mapping with default length=Length.LONG when no length is explicitly specified:

@JdbcTypeCode(Types.LONGVARCHAR)
private String text;

If you use Hibernate for schema generation, Hibernate will generate DDL with a column type that is large enough to accommodate the maximum length you’ve specified.

Embeddable objects

An embeddable object is a Java class whose state maps to multiple columns of a table, but which doesn’t have its own persistent identity. That is, it’s a class with mapped attributes, but no @Id attribute.

An embeddable object can only be made persistent by assigning it to the attribute of an entity. Since the embeddable object does not have its own persistent identity, its lifecycle with respect to persistence is completely determined by the lifecycle of the entity to which it belongs.

An embeddable class must be annotated @Embeddable instead of @Entity.

@Embeddable
class Name {

    @Basic(optional=false)
    String firstName;

    @Basic(optional=false)
    String lastName;

    String middleName;

    Name() {}

    Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    ...
}

An embeddable class must satisfy the same requirements that entity classes satisfy, with the exception that an embeddable class has no @Id attribute. In particular, it must have a constructor with no parameters.

Alternatively, an embeddable type may be defined as a Java record type:

@Embeddable
record Name(String firstName, String middleName, String lastName) {}

In this case, the requirement for a constructor with no parameters is relaxed.

We may now use our Name class (or record) as the type of an entity attribute:

@Entity
class Author {
    @Id @GeneratedValue
    Long id;

    Name name;

    ...
}

Embeddable types can be nested. That is, an @Embeddable class may have an attribute whose type is itself a different @Embeddable class.

We can think of the API of Hibernate in terms of three basic elements:

    an implementation of the JPA-defined APIs, most importantly, of the interfaces EntityManagerFactory and EntityManager, and of the JPA-defined O/R mapping annotations,

    a native API exposing the full set of available functionality, centered around the interfaces SessionFactory, which extends EntityManagerFactory, and Session, which extends EntityManager, and

    a set of mapping annotations which augment the O/R mapping annotations defined by JPA, and which may be used with the JPA-defined interfaces, or with the native API.

persistence-related code comes in two layers:

    a representation of our data model in Java, which takes the form of a set of annotated entity classes, and

    a larger number of functions which interact with Hibernate’s APIs to perform the persistence operations associated with your various transactions.

Most people implement the domain model as a set of what we used to call "Plain Old Java Objects", that is, as simple Java classes with no direct dependencies on technical infrastructure, nor on application logic which deals with request processing, transaction management, communications, or interaction with the database.

The second part of the code is much trickier to get right. This code must:

    manage transactions and sessions,

    interact with the database via the Hibernate session,

    fetch and prepare data needed by the UI, and

    handle failures.

## Testing persistence logic

When we write tests for our persistence logic, we’re going to need:

    a database, with

    an instance of the schema mapped by our persistent entities, and

    a set of test data, in a well-defined state at the beginning of each test.

## Entities

An entity is a Java class which represents data in a relational database table. We say that the entity maps or maps to the table. Much less commonly, an entity might aggregate data from multiple tables.By providing its id to Hibernate, we may re-materialize the instance in a new persistence context, as long as the associated row is present in the database.Id represents the persistent identity of an entity, an identity that outlives a particular instantiation in memory. And this is an important difference between entity class itself and the values of its attributes—the entity has a persistent identity, and a well-defined lifecycle with respect to persistence, whereas a String or List representing one of its attribute values doesn’t.

An instance of a Java class cannot outlive the virtual machine to which it belongs. But we may think of an entity instance having a lifecycle which transcends a particular instantiation in memory.An entity usually has associations to other entities. Typically, an association between two entities maps to a foreign key in one of the database tables. A group of mutually associated entities is often called a domain model.

### Entity classes

An entity must:

1. Be a non-final class,
2. With a non-private constructor with no parameters.

On the other hand, the entity class may be either concrete or abstract, and it may have any number of additional constructors.
Every entity class must be annotated @Entity.

```java
@Entity
class Book {
    Book() {}
    ...
}
```

Alternatively, the class may be identified as an entity type by providing an XML-based mapping for the class.
Mapping entities using XML

When XML-based mappings are used, the <entity> element is used to declare an entity class:

```xml
<entity-mappings>
    <package>org.hibernate.example</package>

    <entity class="Book">
        <attributes> ... </attributes>
    </entity>

    ...
</entity-mappings>
```

Since the orm.xml mapping file format defined by the JPA specification was modelled closely on the annotation-based mappings, it’s usually easy to go back and forth between the two options.

#### "Dynamic" models

We love representing entities as classes because the classes give us a type-safe model of our data. But Hibernate also has the ability to represent entities as detyped instances of java.util.Map

#### Access types

Each entity class has a default access type, either:

1. direct field access, or
2. property access.

Hibernate automatically determines the access type from the location of attribute-level annotations. Concretely:

- if a field is annotated @Id, field access is used, or
- if a getter method is annotated @Id, property access is used.

Mapping annotations should be placed consistently:

- if @Id annotates a field, the other mapping annotations should also be applied to fields, or,
- if @Id annotates a getter, the other mapping annotations should be applied to getters.

An entity class like Book, which does not extend any other entity class, is called a root entity. Every root entity must declare an identifier attribute.

#### Entity class inheritance

An entity class may extend another entity class.

```java
@Entity
class AudioBook extends Book {
    AudioBook() {}
    ...
}
```

A root entity may also extend another class and inherit mapped attributes from the other class. But in this case, the class which declares the mapped attributes must be annotated **@MappedSuperclass**.

```java
@MappedSuperclass
class Versioned {
    ...
}

@Entity
class Book extends Versioned {
    ...
}
```

A root entity class must declare an attribute annotated @Id, or inherit one from a @MappedSuperclass. A subclass entity always inherits the identifier attribute of the root entity. It may not declare its own @Id attribute.

## Identifier attributes

An identifier attribute is usually a field:

```java
@Entity
class Book {
    Book() {}

    @Id
    Long id;

    ...
}
```

But it may be a property:

```java
@Entity
class Book {
    Book() {}

    private Long id;

    @Id
    Long getId() { return id; }
    void setId(Long id) { this.id = id; }

    ...
}
```

An identifier attribute must be annotated @Id or @EmbeddedId.
Identifier values may be:

- assigned by the application, that is, by your Java code, or
- generated and assigned by Hibernate.

### Generated identifiers

An identifier is often system-generated, in which case it should be annotated @GeneratedValue:

```java
@Id 
@GeneratedValue
Long id;
```

System-generated identifiers, or surrogate keys make it easier to evolve or refactor the relational data model. If you have the freedom to define the relational schema, we recommend the use of surrogate keys.

JPA defines the following strategies for generating ids, which are enumerated by GenerationType:

- GenerationType.UUID - UUID or String - A Java UUID
- GenerationType.IDENTITY - Long or Integer - An identity or autoincrement column
- GenerationType.SEQUENCE - Long or Integer - A database sequence
- GenerationType.TABLE - Long or Integer - A database table
- GenerationType.AUTO - Long or Integer - Selects SEQUENCE, TABLE, or UUID based on the identifier type and capabilities of the database

For example, this UUID is generated in Java code:

```java
 @Id
 @GeneratedValue 
 UUID id;  // AUTO strategy selects UUID based on the field type
```

This id maps to a SQL identity, auto_increment, or bigserial column:

```java
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY) 
Long id;
```

The @SequenceGenerator and @TableGenerator annotations allow further control over SEQUENCE and TABLE generation respectively.

Consider this sequence generator:

```java
@SequenceGenerator(name="bookSeq", sequenceName="seq_book", initialValue = 5, allocationSize=10)
```

Values are generated using a database sequence defined as follows:

```sql
create sequence seq_book start with 5 increment by 10
```

Notice that Hibernate doesn’t have to go to the database every time a new identifier is needed. Instead, a given process obtains a block of ids, of size allocationSize, and only needs to hit the database each time the block is exhausted

### Natural keys as identifiers

Not every identifier attribute maps to a (system-generated) surrogate key. Primary keys which are meaningful to the user of the system are called natural keys.

When the primary key of a table is a natural key, we don’t annotate the identifier attribute @GeneratedValue, and it’s the responsibility of the application code to assign a value to the identifier attribute.

```java
@Entity
class Book {
    @Id
    String isbn;

    ...
}
```

Of particular interest are natural keys which comprise more than one database column, and such natural keys are called composite keys.

### Composite identifiers

If your database uses composite keys, you’ll need more than one identifier attribute. There are two ways to map composite keys in JPA:

- using an @IdClass, or
- using an @EmbeddedId.

Perhaps the most immediately-natural way to represent this in an entity class is with multiple fields annotated @Id, for example:

```java
@Entity
@IdClass(BookId.class)
class Book {
    Book() {}

    @Id
    String isbn;

    @Id
    int printing;

    ...
}
```

## Version attributes

An entity may have an attribute which is used by Hibernate for optimistic lock checking. A version attribute is usually of type Integer, Short, Long, LocalDateTime, OffsetDateTime, ZonedDateTime, or Instant.

```java
@Version
LocalDateTime lastUpdated;
```

Version attributes are automatically assigned by Hibernate when an entity is made persistent, and automatically incremented or updated each time the entity is updated.

The @Id and @Version attributes we’ve already seen are just specialized examples of basic attributes

## Enumerated types

An enumerated type is considered a sort of basic type, but since most databases don’t have a native ENUM type, JPA provides a special @Enumerated annotation to specify how the enumerated values should be represented in the database:by default, an enum is stored as an integer, the value of its ordinal() member, but if the attribute is annotated @Enumerated(STRING), it will be stored as a string, the value of its name() member.

//here, an ORDINAL encoding makes sense

```java
@Enumerated
@Basic(optional=false)
DayOfWeek dayOfWeek;

//but usually, a STRING encoding is better
@Enumerated(EnumType.STRING)
@Basic(optional=false)
Status status;
```

In Hibernate 6, an enum annotated @Enumerated(STRING) is mapped to:

- a VARCHAR column type with a CHECK constraint on most databases, or
- an ENUM column type on MySQL.

## Associations

An association is a relationship between entities. We usually classify associations based on their multiplicity. If E and F are both entity classes, then:

- a one-to-one association relates at most one unique instance E with at most one unique instance of F,
- a many-to-one association relates zero or more instances of E with a unique instance of F, and
- a many-to-many association relates zero or more instances of E with zero or more instance of F.

An association between entity classes may be either:

1. unidirectional, navigable from E to F but not from F to E, or
2. bidirectional, and navigable in either direction.

There are three annotations for mapping associations: @ManyToOne, @OneToMany, and @ManyToMany. They share some common annotation members:
Table 15. Association-defining annotation members Member  Interpretation  Default value

- cascade - Persistence operations which should cascade to the associated entity; a list of CascadeTypes - {}
- fetch - Whether the association is eagerly fetched or may be proxied -LAZY for @OneToMany and @ManyToMany, EAGER for @ManyToOne 💀💀💀
- targetEntity - The associated entity class - Determined from the attribute type declaration
- optional - For a @ManyToOne or @OneToOne association, whether the association can be null - true
- mappedBy - For a bidirectional association, an attribute of the associated entity which maps the association - By default, the association is assumed unidirectional

### Many-to-one

A many-to-one association is the most basic sort of association we can imagine. It maps completely naturally to a foreign key in the database.
The @ManyToOne annotation marks the "to one" side of the association, so a unidirectional many-to-one association looks like this:

```java
class Book {
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne(fetch=LAZY)
    Publisher publisher;

    ...
}
```

A very unfortunate misfeature of JPA is that @ManyToOne associations are fetched eagerly by default. This is almost never what we want. Almost all associations should be lazy.
The only scenario in which fetch=EAGER makes sense is if we think there’s always a very high probability that the associated object will be found in the second-level cache.
Whenever this isn’t the case, remember to explicitly specify fetch=LAZY.
Most of the time, we would like to be able to easily navigate our associations in both directions. We do need a way to get the Publisher of a given Book, but we would also like to be able to obtain all the Books belonging to a given publisher.

To make this association bidirectional, we need to add a collection-valued attribute to the Publisher class, and annotate it @OneToMany.

Hibernate needs to proxy unfetched associations at runtime. Therefore, the many-valued side must be declared using an interface type like Set or List, and never using a concrete type like HashSet or ArrayList.

To indicate clearly that this is a bidirectional association, and to reuse any mapping information already specified in the Book entity, we must use the mappedBy annotation member to refer back to Book.publisher.

```java
@Entity
class Publisher {
    @Id @GeneratedValue
    Long id;

    @OneToMany(mappedBy="publisher")
    Set<Book> books;

    ...
}
```

### One-to-one (first way)

The simplest sort of one-to-one association is almost exactly like a @ManyToOne association, except that it maps to a foreign key column with a UNIQUE constraint.
A one-to-one association must be annotated @OneToOne:

```java
@Entity
class Author {
    @Id @GeneratedValue
    Long id;

    @OneToOne(optional=false, fetch=LAZY)
    Person author;

    ...
}
```

We can make this association bidirectional by adding a reference back to the Author in the Person entity:

```java
@Entity
class Person {
    @Id @GeneratedValue
    Long id;

    @OneToOne(mappedBy = Author_.PERSON)
    Author author;

    ...
}
```

### One-to-one (second way)

An arguably more elegant way to represent such a relationship is to share a primary key between the two tables.

To use this approach, the Author class must be annotated like this:

```java
@Entity
class Author {
    @Id
    Long id;

    @OneToOne(optional=false, fetch=LAZY)
    @MapsId
    Person author;

    ...
}
```

Notice that, compared with the previous mapping:

- the @Id attribute is no longer a @GeneratedValue and, instead, the author association is annotated @MapsId.

This lets Hibernate know that the association to Person is the source of primary key values for Author.

Here, there’s no extra foreign key column in the Author table, since the id column holds the identifier of Person. That is, the primary key of the Author table does double duty as the foreign key referring to the Person table.

### Many-to-many

A unidirectional many-to-many association is represented as a collection-valued attribute. It always maps to a separate association table in the database.
A many-to-many association must be annotated @ManyToMany:

```java
@Entity
class Book {
    @Id @GeneratedValue
    Long id;

    @ManyToMany
    Set<Author> authors;

    ...
}
```

If the association is bidirectional, we add a very similar-looking attribute to Book, but this time we must specify mappedBy to indicate that this is the unowned side of the association:

```java
@Entity
class Book {
    @Id
    @GeneratedValue
    Long id;

    @ManyToMany(mappedBy=Author_.BOOKS)
    Set<Author> authors;
    ...
}
```

## Mapping to tables

The following annotations specify exactly how elements of the domain model map to tables of the relational model:

1. @Table - Map an entity class to its primary table
2. @SecondaryTable - Define a secondary table for an entity class
3. @JoinTable - Map a many-to-many or many-to-one association to its association table
4. @CollectionTable - Map an @ElementCollection to its table

The first two annotations are used to map an entity to its primary table and, optionally, one or more secondary tables.

### Mapping entities to tables

By default, an entity maps to a single table, which may be specified using @Table:

```java
@Entity
@Table(name="People")
class Person { ... }
```

However, the @SecondaryTable annotation allows us to spread its attributes across multiple secondary tables.

```java
@Entity
@Table(name="Books")
@SecondaryTable(name="Editions")
class Book { ... }
```

The @Table annotation can do more than just specify a name:

- name - The name of the mapped table
- schema 💀- The schema to which the table belongs
- catalog 💀 - The catalog to which the table belongs
- uniqueConstraints - One or more @UniqueConstraint annotations declaring multi-column unique constraints
- indexes - One or more @Index annotations each declaring an index

The @SecondaryTable annotation is even more interesting:

- name - The name of the mapped table
- schema 💀 - The schema to which the table belongs
- catalog 💀 - The catalog to which the table belongs
- uniqueConstraints - One or more @UniqueConstraint annotations declaring multi-column unique constraints
- indexes - One or more @Index annotations each declaring an index
- pkJoinColumns - One or more @PrimaryKeyJoinColumn annotations, specifying primary key column mappings
- foreignKey - An @ForeignKey annotation specifying the name of the FOREIGN KEY constraint on the @PrimaryKeyJoinColumns

### Mapping associations to tables

The @JoinTable annotation specifies an association table, that is, a table holding foreign keys of both associated entities. This annotation is usually used with @ManyToMany associations:

```java
@Entity
class Book {
    ...
    @ManyToMany
    @JoinTable(name="BooksAuthors")
    Set<Author> authors;

    ...
}
```

But it’s even possible to use it to map a @ManyToOne or @OneToOne association to an association table.

```java
@Entity
class Book {
    ...

    @ManyToOne(fetch=LAZY)
    @JoinTable(name="BookPublisher")
    Publisher publisher;

    ...
}
```

Here, there should be a UNIQUE constraint on one of the columns of the association table.

```java
@Entity
class Author {
    ...

    @OneToOne(optional=false, fetch=LAZY)
    @JoinTable(name="AuthorPerson")
    Person author;

    ...
}
```

Here, there should be a UNIQUE constraint on both columns of the association table.
Table 25. @JoinTable annotation members Annotation member  Purpose

name

The name of the mapped association table

schema 💀

The schema to which the table belongs

catalog 💀

The catalog to which the table belongs

uniqueConstraints

One or more @UniqueConstraint annotations declaring multi-column unique constraints

indexes

One or more @Index annotations each declaring an index

joinColumns

One or more @JoinColumn annotations, specifying foreign key column mappings to the table of the owning side

inverseJoinColumns

One or more @JoinColumn annotations, specifying foreign key column mappings to the table of the unowned side

foreignKey

An @ForeignKey annotation specifying the name of the FOREIGN KEY constraint on the joinColumnss

inverseForeignKey

An @ForeignKey annotation specifying the name of the FOREIGN KEY constraint on the inverseJoinColumnss

To better understand these annotations, we must first discuss column mappings in general.

### Mapping to columns

These annotations specify how elements of the domain model map to columns of tables in the relational model:
Table 26. Annotations for mapping columns Annotation  Purpose

@Column

Map an attribute to a column

@JoinColumn

Map an association to a foreign key column

@PrimaryKeyJoinColumn

Map the primary key used to join a secondary table with its primary, or a subclass table in JOINED inheritance with its root class table

@OrderColumn

Specifies a column that should be used to maintain the order of a List.

@MapKeyColumn

Specified a column that should be used to persist the keys of a Map.

We use the @Column annotation to map basic attributes.
