# JDBC (Java Database Connectivity)

## Java.sql Package

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

Here's an example of how to use the java.sql package for basic database operations such as connecting to a database, executing a query, and retrieving results.
Example Code: Basic JDBC Program Using java.sql

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JavaSQLExample {
    public static void main(String[] args) {
        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/my_database";
        String username = "root";
        String password = "password";

        // SQL query
        String query = "SELECT id, name, email FROM users";

        // Try-with-resources to ensure resources are closed automatically
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Check connection
            System.out.println("Connected to the database!");

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

How the Code Works

Database Connection:-The DriverManager.getConnection() method establishes a connection to the database using the provided JDBC URL, username, and password.
SQL Query Execution:-A PreparedStatement is created to execute the query. It is a safer option as it helps prevent SQL injection.
Result Processing:-The ResultSet object retrieves data returned by the SQL query. Methods like getInt(), getString(), etc., are used to extract column values.
Resource Management:-The try-with-resources statement ensures that the Connection, PreparedStatement, and ResultSet objects are closed automatically, avoiding resource leaks.

NOTE:- JDBC Driver: Ensure the MySQL JDBC driver (mysql-connector-java) is added to your project classpath.

The Java Database Connectivity (JDBC) API provides universal data access from the Java programming language. Using the JDBC API, you can access virtually any data source, from relational databases to spreadsheets and flat files.

A relational database is accessed through Structured Query Language (SQL). SQL is a programming language used to interact with database records. JDBC works by sending a
SQL command to the database and then processing the response.
In addition to relational databases, there is another type of database called a NoSQL database. These databases store their data in a format other than tables, such as key/value, document stores, and graph-­based databases. NoSQL is out of scope for the exam as well.

There are five key interfaces of JDBC. The interfaces are declared in the JDK.For example “Collections and Generics,” has interface List and the concrete class ArrayList.
With JDBC, the concrete classes come from the JDBC driver. Each database has a different JAR file with these classes. For example, PostgreSQL’s JAR is called something like postgresql-­9.4–1201.jdbc4.jar. MySQL’s JAR is called something like mysql-­connector-­java-­5.1.36.jar. The exact name depends on the vendor and version of the driver JAR.

This driver JAR contains an implementation of these key interfaces along with a number of other interfaces. The key is that the provided implementations know how to communicate with a database. There are also different types of drivers.

With JDBC, you use only the interfaces in your code and never the implementation classes directly. In fact, they might not even be public classes.

- java.sql package defines collection of interfaces and classes that allows programs to interact with DB:

1. Drivers - Supports creation of data connection.
2. Connection - Rep. connection btwn client & SQL databse server.
3. DatabaseMetaData - Contains info about database server.
4. Statement - Includes methods for xecuting text queries.
5. PreparedStatement - Rep. precompiled & stored query.
6. CallableStatement - Execute SQL stored procedures.
7. ResultSet - Contains results of execution of select query.
8. ResultSetMetadata  - Contains info about ResultSet, including attribute names and types.

To use the JDBC API with a particular database management system, you need a JDBC technology-based driver to mediate between JDBC technology and the database.Before connecting to db, you must make **database driver** available for your app.

- CONNECTIONS

The first step in doing anything with a database is connecting to it. First we show you how to build the JDBC URL. Then we show you how to use it to get a Connection to the database.

- Building a JDBC URL:- To access a website, you need to know its URL. To access your email, you need to know your username and password. JDBC is no different. To access a database, you need to know this information about it.

Unlike web URLs, JDBC URLs have a variety of formats. They have three parts in common. The first piece is always the same. It is the protocol jdbc.The second part is the subprotocol, which is the name of the database, such as hsqldb, mysql, or postgres. The third part is the subname, which is a database-­specific format. Colons (:) separate the three parts.

The subname typically contains information about the database such as its location and/or name. The syntax varies. You need to know about the three main parts. You don’t
need to memorize the subname formats.

Examples:-

```java
jdbc:postgresql://localhost/zoo
jdbc:oracle:thin:@123.123.123.123:1521:zoo
jdbc:mysql://localhost:3306
jdbc:mysql://localhost:3306/zoo?profileSQL=true
```

NOTE:- Port is optional when using the default location.

- Connecting to Database

There are two main ways to get a Connection: DriverManager and DataSource.
The DriverManager class is in the JDK, as it is an API that comes with Java. It uses the factory pattern, which means that you call a static method to get a Connection rather than calling a constructor.The factory pattern means that you can get any implementation of the interface when calling the method. The good news is that the method has an easy-­to-­remember name: getConnection().

To get connection to db, you use the **getConnection()** method of **DriverManager** class to return Connection object.This method requires three arguments: URL for db, usernsme, password.

The getConnection method throws an SQLException, you need to handle the exception whenever you connect to db.

```java
 try{
    String url ="jdbc:postgresql://localhost:5432/dbName";
    String username="USERNAME";
    String password="PASWRD";

    Connection conn = DriverManager.getConnection(url,username, password);

 } catch(SQLException e){
    e.printStackTrace();
 }
```

The nice thing about the factory pattern is that it takes care of the logic of creating a class for you. You don’t need to know the name of the class that implements Connection, and you don’t need to know how it is created. You are probably a bit curious, though.

DriverManager looks through any drivers it can find to see whether they can handle the JDBC URL. If so, it creates a Connection using that Driver. If not, it gives up and throws a SQLException.

The Class.forName() was required with older drivers (that were designed for older versions of JDBC) before getting a Connection.

## STATEMENTS

The object used for executing a static SQL statement to db server for execution and returning the results it produces.By default, only one ResultSet object per Statement object can be open at the same time. Therefore, if the reading of one ResultSet object is interleaved with the reading of another, each must have been generated by different Statement objects. All execution methods in the Statement interface implicitly close a current ResultSet object of the statement if an open one exists.

Statement is an interface that both PreparedStatement and CallableStatement extend. A Statement and a PreparedStatement are similar to each other, except that a PreparedStatement takes parameters, while a Statement does not. A Statement just executes whatever SQL query you give it.

While it is possible to run SQL directly with Statement, you shouldn’t.PreparedStatement is far superior for the following reasons:

1. Performance: In most programs, you run similar queries multiple times. When you use PreparedStatement, the database software often devises a plan to run the query well
and remembers it.
2. Security: You are protected against an attack called SQL injection when using a PreparedStatement correctly
3. Readability: It’s nice not to have to deal with string concatenation in building a query string with lots of parameters.
4. Future use: Even if your query is being run only once or doesn’t have any parameters,you should still use a PreparedStatement. That way, future editors of the code won’t
add a variable and have to remember to change to PreparedStatement then.

- Obtaining a PreparedStatement:- To run SQL, you need to tell a PreparedStatement about it. Getting a PreparedStatement from a Connection is easy.

```java
try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM exhibits")) {
// work with ps
}
```

An instance of a PreparedStatement represents a SQL statement that you want to run using the Connection. It does not execute the query yet! We get to that shortly.
Passing a SQL statement when creating the object is mandatory. You might see a trick on the exam.

```java
try (var ps = conn.prepareStatement()) { // DOES NOT COMPILE
}
```

The previous example does not compile, because SQL is not supplied at the time a PreparedStatement is requested. We also used var in this example. We write JDBC code
both using var and the actual class names to get you used to both approaches.
There are overloaded signatures that allow you to specify a ResultSet type and concurrency mode. On the exam, you only need to know how to use the default options, which
process the results in order.

- Executing a PreparedStatement:- Now that we have a PreparedStatement, we can run the SQL statement. The method for running SQL varies depending on what kind of SQL statement it is. Remember that you aren’t expected to be able to read SQL, but you do need to know what the first keyword means.

Modifying Data with executeUpdate()
Let’s start with statements that change the data in a table. Those are SQL statements that
begin with DELETE, INSERT, or UPDATE. They typically use a method called executeUpdate().
The name is a little tricky because the SQL UPDATE statement is not the only statement that
uses this method.
The method takes the SQL statement to run as a parameter. It returns the number of rows that were inserted, deleted, or changed. Here’s an example of all three update types:

```java
var insertSql = "INSERT INTO exhibits VALUES(10, 'Deer', 3)";
var updateSql = "UPDATE exhibits SET name = '' " + "WHERE name = 'None'";
var deleteSql = "DELETE FROM exhibits WHERE id = 10";

try (var ps = conn.prepareStatement(insertSql)) {
    int result = ps.executeUpdate();
    System.out.println(result); // 1
}

try (var ps = conn.prepareStatement(updateSql)) {
    int result = ps.executeUpdate();
    System.out.println(result); //
}

try (var ps = conn.prepareStatement(deleteSql)) {
    int result = ps.executeUpdate();
    System.out.println(result); // 1
}
```

Each distinct SQL statement needs its own prepareStatement() call.
Line 15 creates the insert statement, and line 16 runs that statement to insert one row.
The result is 1 because one row was affected. Line 20 creates the update statement, and line
21 checks the whole table for matching records to update. Since no records match, the result
is 0. Line 25 creates the delete statement, and line 26 deletes the row created on line 16.
Again, one row is affected, so the result is 1.
Reading Data with executeQuery()
Next, let’s look at a SQL statement that begins with SELECT. This time, we use the executeQuery() method.

```java
var sql = "SELECT * FROM exhibits";
try (var ps = conn.prepareStatement(sql);
ResultSet rs = ps.executeQuery() ) {
// work with rs
}
```

On line 31, we create a PreparedStatement for our SELECT query. On line 32, we run
it. Since we are running a query to get a result, the return type is ResultSet. In the next
section, we show you how to process the ResultSet.
Processing Data with execute()
There’s a third method called execute() that can run either a query or an update. It returns a boolean so that we know whether there is a ResultSet. That way, we can call the proper method to get more detail. The pattern looks like this:

```java
boolean isResultSet = ps.execute();
if (isResultSet) {
    try (ResultSet rs = ps.getResultSet()) {
        System.out.println("ran a query");
    }
} else {
int result = ps.getUpdateCount();
System.out.println("ran an update");
}
```

If the PreparedStatement refers to sql that is a SELECT, the boolean is true, and we can get the ResultSet. If it is not a SELECT, we can get the number of rows updated.
Using the Correct Method What do you think happens if we use the wrong method for a SQL statement? Let’s take a look:

```java
var sql = "SELECT * FROM names";
try (var ps = conn.prepareStatement(sql)) {
}
var result = ps.executeUpdate();
```

This throws a SQLException similar to the following:
Exception in thread "main" java.sql.SQLException:statement does not generate a row count
We can’t get a compiler error since the SQL is a String. We can get an exception,
though, and we do. We also get a SQLException when using executeQuery() with SQL that changes the database.
Exception in thread "main" java.sql.SQLException:
statement does not generate a result set
Again, we get an exception because the driver can’t translate the query into the expected
return type.

## javax.sql (Advanced JDBC)

Provides the API for server side data source access and processing from the JavaTM programming language. This package supplements the java.sql package and, as of the version 1.4 release, is included in the Java Platform, Standard Edition (Java SETM). It remains an essential part of the Java Platform, Enterprise Edition (Java EETM).

It extends java.sql by adding advanced features for JDBC, focusing on connection pooling and distributed transactions.

Use Case:

Applications requiring performance optimizations (via connection pooling).
Foundation for higher-level frameworks like JPA and Spring Data.

The javax.sql package provides for the following:

1. The DataSource interface as an alternative to the DriverManager for establishing a connection with a data source.A factory for managing connections. More robust than DriverManager.
2. Connection pooling and Statement pooling.ConnectionPoolDataSource: Provides connection pooling support.
3. Distributed transactions
4. Rowsets - Easier handling of tabular data with support for disconnected operation.

Applications use the DataSource and RowSet APIs directly, but the connection pooling and distributed transaction APIs are used internally by the middle-tier infrastructure.
Using a DataSource Object to Make a Connection
The javax.sql package provides the preferred way to make a connection with a data source. The DriverManager class, the original mechanism, is still valid, and code using it will continue to run. However, the newer DataSource mechanism is preferred because it offers many advantages over the DriverManager mechanism.

These are the main advantages of using a DataSource object to make a connection:

1. Changes can be made to a data source's properties, which means that it is not necessary to make changes in application code when something about the data source or driver changes.
2. Connection and Statement pooling and distributed transactions are available through a DataSource object that is implemented to work with the middle-tier infrastructure. 3. Connections made through the DriverManager do not have connection and statement pooling or distributed transaction capabilities.

Driver vendors provide DataSource implementations. A particular DataSource object represents a particular physical data source, and each connection the DataSource object creates is a connection to that physical data source.

A logical name for the data source is registered with a naming service that uses the Java Naming and Directory InterfaceTM (JNDI) API, usually by a system administrator or someone performing the duties of a system administrator. An application can retrieve the DataSource object it wants by doing a lookup on the logical name that has been registered for it. The application can then use the DataSource object to create a connection to the physical data source it represents.

A DataSource object can be implemented to work with the middle tier infrastructure so that the connections it produces will be pooled for reuse. An application that uses such a DataSource implementation will automatically get a connection that participates in connection pooling. A DataSource object can also be implemented to work with the middle tier infrastructure so that the connections it produces can be used for distributed transactions without any special coding.
Connection Pooling and Statement Pooling
Connections made via a DataSource object that is implemented to work with a middle tier connection pool manager will participate in connection pooling. This can improve performance dramatically because creating new connections is very expensive. Connection pooling allows a connection to be used and reused, thus cutting down substantially on the number of new connections that need to be created.

Connection pooling is totally transparent. It is done automatically in the middle tier of a Java EE configuration, so from an application's viewpoint, no change in code is required. An application simply uses the DataSource.getConnection method to get the pooled connection and uses it the same way it uses any Connection object.

The classes and interfaces used for connection pooling are:

- ConnectionPoolDataSource
- PooledConnection
- ConnectionEvent
- ConnectionEventListener
- StatementEvent
- StatementEventListener

The connection pool manager, a facility in the middle tier of a three-tier architecture, uses these classes and interfaces behind the scenes. When a ConnectionPoolDataSource object is called on to create a PooledConnection object, the connection pool manager will register as a ConnectionEventListener object with the new PooledConnection object. When the connection is closed or there is an error, the connection pool manager (being a listener) gets a notification that includes a ConnectionEvent object.

If the connection pool manager supports Statement pooling, for PreparedStatements, which can be determined by invoking the method DatabaseMetaData.supportsStatementPooling, the connection pool manager will register as a StatementEventListener object with the new PooledConnection object. When the PreparedStatement is closed or there is an error, the connection pool manager (being a listener) gets a notification that includes a StatementEvent object.

Distributed Transactions
As with pooled connections, connections made via a DataSource object that is implemented to work with the middle tier infrastructure may participate in distributed transactions. This gives an application the ability to involve data sources on multiple servers in a single transaction.

The classes and interfaces used for distributed transactions are:

- XADataSource
- XAConnection

These interfaces are used by the transaction manager; an application does not use them directly.

The XAConnection interface is derived from the PooledConnection interface, so what applies to a pooled connection also applies to a connection that is part of a distributed transaction. A transaction manager in the middle tier handles everything transparently. The only change in application code is that an application cannot do anything that would interfere with the transaction manager's handling of the transaction. Specifically, an application cannot call the methods Connection.commit or Connection.rollback, and it cannot set the connection to be in auto-commit mode (that is, it cannot call Connection.setAutoCommit(true)).

An application does not need to do anything special to participate in a distributed transaction. It simply creates connections to the data sources it wants to use via the DataSource.getConnection method, just as it normally does. The transaction manager manages the transaction behind the scenes. The XADataSource interface creates XAConnection objects, and each XAConnection object creates an XAResource object that the transaction manager uses to manage the connection.
Rowsets
The RowSet interface works with various other classes and interfaces behind the scenes. These can be grouped into three categories.

- Event Notification
RowSetListener
A RowSet object is a JavaBeansTM component because it has properties and participates in the JavaBeans event notification mechanism. The RowSetListener interface is implemented by a component that wants to be notified about events that occur to a particular RowSet object. Such a component registers itself as a listener with a rowset via the RowSet.addRowSetListener method.

When the RowSet object changes one of its rows, changes all of it rows, or moves its cursor, it also notifies each listener that is registered with it. The listener reacts by carrying out its implementation of the notification method called on it.

- RowSetEvent
As part of its internal notification process, a RowSet object creates an instance of RowSetEvent and passes it to the listener. The listener can use this RowSetEvent object to find out which rowset had the event.

- Metadata
RowSetMetaData
This interface, derived from the ResultSetMetaData interface, provides information about the columns in a RowSet object. An application can use RowSetMetaData methods to find out how many columns the rowset contains and what kind of data each column can contain.

The RowSetMetaData interface provides methods for setting the information about columns, but an application would not normally use these methods. When an application calls the RowSet method execute, the RowSet object will contain a new set of rows, and its RowSetMetaData object will have been internally updated to contain information about the new columns.

- The Reader/Writer Facility
A RowSet object that implements the RowSetInternal interface can call on the RowSetReader object associated with it to populate itself with data. It can also call on the RowSetWriter object associated with it to write any changes to its rows back to the data source from which it originally got the rows. A rowset that remains connected to its data source does not need to use a reader and writer because it can simply operate on the data source directly.

- RowSetInternal
By implementing the RowSetInternal interface, a RowSet object gets access to its internal state and is able to call on its reader and writer. A rowset keeps track of the values in its current rows and of the values that immediately preceded the current ones, referred to as the original values. A rowset also keeps track of (1) the parameters that have been set for its command and (2) the connection that was passed to it, if any. A rowset uses the RowSetInternal methods behind the scenes to get access to this information. An application does not normally invoke these methods directly.

- RowSetReader
A disconnected RowSet object that has implemented the RowSetInternal interface can call on its reader (the RowSetReader object associated with it) to populate it with data. When an application calls the RowSet.execute method, that method calls on the rowset's reader to do much of the work. Implementations can vary widely, but generally a reader makes a connection to the data source, reads data from the data source and populates the rowset with it, and closes the connection. A reader may also update the RowSetMetaData object for its rowset. The rowset's internal state is also updated, either by the reader or directly by the method RowSet.execute.

- RowSetWriter
A disconnected RowSet object that has implemented the RowSetInternal interface can call on its writer (the RowSetWriter object associated with it) to write changes back to the underlying data source. Implementations may vary widely, but generally, a writer will do the following:

Make a connection to the data source
Check to see whether there is a conflict, that is, whether a value that has been changed in the rowset has also been changed in the data source
Write the new values to the data source if there is no conflict
Close the connection

The RowSet interface may be implemented in any number of ways, and anyone may write an implementation. Developers are encouraged to use their imaginations in coming up with new ways to use rowsets.

Using the javax.sql package improves the handling of database connections by leveraging connection pooling via a DataSource. Below is the restructured version of the code to use javax.sql.

```java
import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource; // MySQL DataSource class
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JavaxSQLExample {

    // Method to create a DataSource
    private static DataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/my_database");
        dataSource.setUser("root");
        dataSource.setPassword("password");
        return dataSource;
    }

    public static void main(String[] args) {
        // SQL query
        String query = "SELECT id, name, email FROM users";

        // Get the DataSource
        DataSource dataSource = getDataSource();

        // Try-with-resources to ensure resources are closed automatically
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Check connection
            System.out.println("Connected to the database using DataSource!");

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

Key Differences in this Implementation

1. DataSource Usage:- A DataSource is used instead of directly managing connections with DriverManager.MysqlDataSource from com.mysql.cj.jdbc is configured with the database URL, username, and password.
2. Connection Pooling:- Most DataSource implementations (e.g., HikariCP, Apache DBCP) support connection pooling by default, improving performance by reusing connections.
3. Simpler Connection Handling:- The application code doesn't need to manage low-level connection details, making it easier to switch between databases or pooling implementations.

You can replace MysqlDataSource with a third-party library like HikariCP or Apache DBCP for better connection pooling support in production environments. This will make the javax.sql implementation even more efficient.

## Connection Pooling

Connection pooling is a technique used to enhance the performance and scalability of applications that interact with a database. It involves creating and maintaining a pool (a cache) of pre-established database connections that can be reused by the application, instead of creating and closing a new connection each time a database operation is performed.

How Connection Pooling Works

1. Pool Initialization:- At application startup, a pool of database connections is created and managed by a connection pooling library or framework.
2. Connection Reuse:- When an application needs to interact with the database, it requests a connection from the pool.The application uses the connection to execute queries or updates.
3. Connection Return:- After completing its task, the application returns the connection to the pool instead of closing it.The connection is now available for reuse by other parts of the application.
4. Dynamic Management:- The pool dynamically manages the number of connections based on demand, creating new connections or closing unused ones when necessary.

Benefits of Connection Pooling

- Improved Performance:-Avoids the overhead of repeatedly creating and closing database connections, which can be resource-intensive.
- Reduced Latency:- Connections are readily available in the pool, leading to faster database access.
- Better Resource Utilization:- Limits the number of open connections to the database, preventing overloading.
- Scalability:- Supports high-concurrency environments by efficiently managing database connections.
- Configurable:- Parameters like the maximum number of connections, idle timeout, and connection validation can be tuned based on application requirements.

Key Parameters in Connection Pooling

1. Maximum Connections (maxPoolSize):-The maximum number of connections the pool can hold at a time.
2. Minimum Idle Connections (minIdle):-The minimum number of idle connections that should always be available in the pool.
3. Connection Timeout:-The time an application waits for a connection from the pool before throwing an exception if no connection is available.
4. Idle Timeout:-The time a connection can remain idle in the pool before being closed.
5. Validation Query:-A simple SQL query executed to check if a connection is still valid before it’s handed over to an application.

Key Takeaways

1. Connection pooling is critical for high-performance database-driven applications.
2. It reduces the cost of database connection management by reusing existing connections.
3. Libraries like HikariCP make it easy to implement efficient connection pooling in Java applications.

## Common Connection Pooling Libraries

- HikariCP:-A lightweight and fast connection pooling library.Highly efficient and widely used in modern applications.
- Apache DBCP (Database Connection Pooling):-Part of Apache Commons, offering a robust pooling mechanism.
- C3P0:-A reliable connection pooling library with extensive configuration options.
- Tomcat JDBC Connection Pool:-A connection pooling implementation provided by the Apache Tomcat project.

```java
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionPoolingExample {
    public static void main(String[] args) {
        // Configure HikariCP
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/my_database");
        config.setUsername("root");
        config.setPassword("password");
        config.setMaximumPoolSize(10); // Max connections
        config.setMinimumIdle(2);     // Min idle connections

        // Create DataSource
        DataSource dataSource = new HikariDataSource(config);

        // SQL query
        String query = "SELECT id, name, email FROM users";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Close DataSource (optional, typically managed by the application lifecycle)
        ((HikariDataSource) dataSource).close();
    }
}
```

Key Takeaways

Connection pooling is critical for high-performance database-driven applications.
It reduces the cost of database connection management by reusing existing connections.
Libraries like HikariCP make it easy to implement efficient connection pooling in Java applications.
