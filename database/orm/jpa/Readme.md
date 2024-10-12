## Java Persistence API vs. Jakarta Persistence Layer

Java Persistence API (JPA) and Jakarta Persistence Layer (JPL) are both popular frameworks for managing relational data in Java applications. While JPA has been around for a longer time, JPL was introduced as part of the Jakarta EE specifications after Java EE was transferred to the Eclipse Foundation. 

## Java Persistence API (JPA)

Java Persistence API (JPA) is a Java specification for managing relational data in Java applications. It is part of the Java EE and Jakarta EE specifications and provides an Object-Relational Mapping (ORM) framework to map Java objects to relational database tables. JPA allows developers to interact with relational databases in an object-oriented way, abstracting the underlying SQL.

## Jakarta Persistence Layer (JPL)

Jakarta Persistence Layer (JPL) is the successor to JPA and is part of the Jakarta EE specifications. It is built upon JPA and provides similar functionality for managing relational data in Java applications. The primary difference is the change of package names, from javax.persistence to jakarta.persistence.

Both Java Persistence API (JPA) and Jakarta Persistence Layer (JPL) provide robust frameworks for managing relational data in Java applications. They both offer similar functionality, and the primary difference is the change of package names.

Jakarta Persistence is the API for the management for persistence and object/relational mapping.

## Annotation Types 
Access 	
Used to specify an access type to be applied to an entity class, mapped superclass, or embeddable class, or to a specific attribute of such a class.
AssociationOverride 	
Used to override a mapping for an entity relationship.
AssociationOverrides 	
Used to override mappings of multiple relationship properties or fields.
AttributeOverride 	
Used to override the mapping of a Basic (whether explicit or default) property or field or Id property or field.
AttributeOverrides 	
Used to override mappings of multiple properties or fields.
Basic 	
The simplest type of mapping to a database column.
Cacheable 	
Specifies whether an entity should be cached if caching is enabled when the value of the persistence.xml caching element is ENABLE_SELECTIVE or DISABLE_SELECTIVE.
CollectionTable 	
Specifies the table that is used for the mapping of collections of basic or embeddable types.
Column 	
Specifies the mapped column for a persistent property or field.
ColumnResult 	
Used in conjunction with the SqlResultSetMapping annotation or ConstructorResult annotation to map a column of the SELECT list of a SQL query.
ConstructorResult 	
Used in conjunction with the SqlResultSetMapping annotation to map the SELECT clause of a SQL query to a constructor.
Convert 	
Specifies the conversion of a Basic field or property.
Converter 	
Specifies that the annotated class is a converter and defines its scope.
Converts 	
Used to group Convert annotations.
DiscriminatorColumn 	
Specifies the discriminator column for the SINGLE_TABLE and JOINED Inheritance mapping strategies.
DiscriminatorValue 	
Specifies the value of the discriminator column for entities of the given type.
ElementCollection 	
Specifies a collection of instances of a basic type or embeddable class.
Embeddable 	
Specifies a class whose instances are stored as an intrinsic part of an owning entity and share the identity of the entity.
Embedded 	
Specifies a persistent field or property of an entity whose value is an instance of an embeddable class.
EmbeddedId 	
Applied to a persistent field or property of an entity class or mapped superclass to denote a composite primary key that is an embeddable class.
Entity 	
Specifies that the class is an entity.
EntityListeners 	
Specifies the callback listener classes to be used for an entity or mapped superclass.
EntityResult 	
Used in conjunction with the SqlResultSetMapping annotation to map the SELECT clause of a SQL query to an entity result.
Enumerated 	
Specifies that a persistent property or field should be persisted as a enumerated type.
ExcludeDefaultListeners 	
Specifies that the invocation of default listeners is to be excluded for the entity class (or mapped superclass) and its subclasses.
ExcludeSuperclassListeners 	
Specifies that the invocation of superclass listeners is to be excluded for the entity class (or mapped superclass) and its subclasses.
FieldResult 	
Used in conjunction with the EntityResult annotation to map columns specified in the SELECT list of a SQL query to the properties or fields of an entity class.
ForeignKey 	
Used to specify the handling of foreign key constraints when schema generation is in effect.
GeneratedValue 	
Provides for the specification of generation strategies for the values of primary keys.
Id 	
Specifies the primary key of an entity.
IdClass 	
Specifies a composite primary key class that is mapped to multiple fields or properties of the entity.
Index 	
Used in schema generation to specify creation of an index.
Inheritance 	
Specifies the inheritance strategy to be used for an entity class hierarchy.
JoinColumn 	
Specifies a column for joining an entity association or element collection.
JoinColumns 	
Specifies the mapping for composite foreign keys.
JoinTable 	
Specifies the mapping of associations.
Lob 	
Specifies that a persistent property or field should be persisted as a large object to a database-supported large object type.
ManyToMany 	
Specifies a many-valued association with many-to-many multiplicity.
ManyToOne 	
Specifies a single-valued association to another entity class that has many-to-one multiplicity.
MapKey 	
Specifies the map key for associations of type java.util.Map when the map key is itself the primary key or a persistent field or property of the entity that is the value of the map.
MapKeyClass 	
Specifies the type of the map key for associations of type java.util.Map.
MapKeyColumn 	
Specifies the mapping for the key column of a map whose map key is a basic type.
MapKeyEnumerated 	
Specifies the enum type for a map key whose basic type is an enumerated type.
MapKeyJoinColumn 	
Specifies a mapping to an entity that is a map key.
MapKeyJoinColumns 	
Supports composite map keys that reference entities.
MapKeyTemporal 	
This annotation must be specified for persistent map keys of type Date and Calendar.
MappedSuperclass 	
Designates a class whose mapping information is applied to the entities that inherit from it.
MapsId 	
Designates a ManyToOne or OneToOne relationship attribute that provides the mapping for an EmbeddedId primary key, an attribute within an EmbeddedId primary key, or a simple primary key of the parent entity.
NamedAttributeNode 	
A NamedAttributeNode is a member element of a NamedEntityGraph.
NamedEntityGraph 	
Used to specify the path and boundaries for a find operation or query.
NamedEntityGraphs 	
Used to group NamedEntityGraph annotations.
NamedNativeQueries 	
Specifies multiple native SQL named queries.
NamedNativeQuery 	
Specifies a named native SQL query.
NamedQueries 	
Specifies multiple named Jakarta Persistence query language queries.
NamedQuery 	
Specifies a static, named query in the Jakarta Persistence query language.
NamedStoredProcedureQueries 	
Specifies multiple named stored procedure queries.
NamedStoredProcedureQuery 	
Specifies and names a stored procedure, its parameters, and its result type.
NamedSubgraph 	
A NamedSubgraph is a member element of a NamedEntityGraph.
OneToMany 	
Specifies a many-valued association with one-to-many multiplicity.
OneToOne 	
Specifies a single-valued association to another entity that has one-to-one multiplicity.
OrderBy 	
Specifies the ordering of the elements of a collection valued association or element collection at the point when the association or collection is retrieved.
OrderColumn 	
Specifies a column that is used to maintain the persistent order of a list.
PersistenceContext 	
Expresses a dependency on a container-managed EntityManager and its associated persistence context.
PersistenceContexts 	
Declares one or more PersistenceContext annotations.
PersistenceProperty 	
Describes a single container or persistence provider property.
PersistenceUnit 	
Expresses a dependency on an EntityManagerFactory and its associated persistence unit.
PersistenceUnits 	
Declares one or more PersistenceUnit annotations.
PostLoad 	
Specifies a callback method for the corresponding lifecycle event.
PostPersist 	
Specifies a callback method for the corresponding lifecycle event.
PostRemove 	
Specifies a callback method for the corresponding lifecycle event.
PostUpdate 	
Specifies a callback method for the corresponding lifecycle event.
PrePersist 	
Specifies a callback method for the corresponding lifecycle event.
PreRemove 	
Specifies a callback method for the corresponding lifecycle event.
PreUpdate 	
Specifies a callback method for the corresponding lifecycle event.
PrimaryKeyJoinColumn 	
Specifies a primary key column that is used as a foreign key to join to another table.
PrimaryKeyJoinColumns 	
Groups PrimaryKeyJoinColumn annotations.
QueryHint 	
Used to supply a query property or hint to the NamedQuery or NamedNativeQuery annotation.
SecondaryTable 	
Specifies a secondary table for the annotated entity class.
SecondaryTables 	
Specifies multiple secondary tables for an entity.
SequenceGenerator 	
Defines a primary key generator that may be referenced by name when a generator element is specified for the GeneratedValue annotation.
SequenceGenerators 	
Used to group SequenceGenerator annotations.
SqlResultSetMapping 	
Specifies the mapping of the result of a native SQL query or stored procedure.
SqlResultSetMappings 	
Is used to define one or more SqlResultSetMapping annotations.
StoredProcedureParameter 	
Specifies a parameter of a named stored procedure query.
Table 	
Specifies the primary table for the annotated entity.
TableGenerator 	
Defines a primary key generator that may be referenced by name when a generator element is specified for the GeneratedValue annotation.
TableGenerators 	
Used to group TableGenerator annotations.
Temporal 	
This annotation must be specified for persistent fields or properties of type java.util.Date and java.util.Calendar.
Transient 	
Specifies that the property or field is not persistent.
UniqueConstraint 	
Specifies that a unique constraint is to be included in the generated DDL for a primary or secondary table.
Version 	
Specifies the version field or property of an entity class that serves as its optimistic lock value.