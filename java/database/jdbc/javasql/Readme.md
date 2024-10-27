# Java.sql Package

Provides the API for accessing and processing data stored in a data source (usually a relational database) using the JavaTM programming language.

The java.sql package contains API for the following:

1. Making a connection with a database via the DriverManager facility
    - DriverManager class -- makes a connection with a driver
    - SQLPermission class -- provides permission when code running within a Security Manager, such as an applet, attempts to set up a logging stream through the DriverManager
    - Driver interface -- provides the API for registering and connecting drivers based on JDBC technology ("JDBC drivers"); generally used only by the DriverManager class
    - DriverPropertyInfo class -- provides properties for a JDBC driver; not used by the general user 

2. Sending SQL statements to a database
    - Statement -- used to send basic SQL statements
    - PreparedStatement -- used to send prepared statements or basic SQL statements (derived from Statement)
    - CallableStatement -- used to call database stored procedures (derived from PreparedStatement)
    - Connection interface -- provides methods for creating statements and managing connections and their properties
    - Savepoint -- provides savepoints in a transaction 

3. Retrieving and updating the results of a query
    - ResultSet interface 
    
4. Standard mappings for SQL types to classes and interfaces in the Java programming language
    - Array interface -- mapping for SQL ARRAY
    - Blob interface -- mapping for SQL BLOB
    - Clob interface -- mapping for SQL CLOB
    - Date class -- mapping for SQL DATE
    - NClob interface -- mapping for SQL NCLOB
    - Ref interface -- mapping for SQL REF
    - RowId interface -- mapping for SQL ROWID
    - Struct interface -- mapping for SQL STRUCT
    - SQLXML interface -- mapping for SQL XML
    - Time class -- mapping for SQL TIME
    - Timestamp class -- mapping for SQL TIMESTAMP
    - Types class -- provides constants for SQL types 

5. Custom mapping an SQL user-defined type (UDT) to a class in the Java programming language
    - SQLData interface -- specifies the mapping of a UDT to an instance of this class
    - SQLInput interface -- provides methods for reading UDT attributes from a stream
    - SQLOutput interface -- provides methods for writing UDT attributes back to a stream 

6. Metadata
    - DatabaseMetaData interface -- provides information about the database
    - ResultSetMetaData interface -- provides information about the columns of a ResultSet object
    - ParameterMetaData interface -- provides information about the parameters to PreparedStatement commands 

7. Exceptions
    - SQLException -- thrown by most methods when there is a problem accessing data and by some methods for other reasons
    - SQLWarning -- thrown to indicate a warning
    - DataTruncation -- thrown to indicate that data may have been truncated
    - BatchUpdateException -- thrown to indicate that not all commands in a batch update executed successfully 

