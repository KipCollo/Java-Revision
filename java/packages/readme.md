# packages

A package is a namespace that organizes a set of related classes and interfaces. Conceptually you can think of packages as being similar to different folders on your computer. You might keep HTML pages in one folder, images in another, and scripts or applications in yet another. Because software written in the Java programming language can be composed of hundreds or thousands of individual classes, it makes sense to keep things organized by placing related classes and interfaces into packages.

- *Java package is used to categorize the classes and interfaces, provides access protection and removes naming collision.*
- *The package keyword is used to create a package. Package inside the package is called the subpackage.*
- *If you import a package (package.* ), subpackages will not be imported.*
- *To import subpackage, use import package.classname.*
- *Use fully qualified name to access only the declared class of a package.*
- *Sequence of the program must be package then import then class.*
- *The standard of defining package is domain.company.package. eg - com.oracle.database*
- *There can be only one public class in a java source file and it must be saved by the public class name.*

Packages may include:   
  - java.lang :Provides classes that are fundamental to the design of the Java programming language.
  - java. util: Contains the collections framework, legacy collection classes, event model, date and time facilities, internationalization, and miscellaneous utility classes (a string tokenizer, a random-number generator, and a bit array).
  - java.awt: Contains all of the classes for creating user interfaces and for painting graphics and images.
  - java.sql: Provides the API for server side data source access and processing from the JavaTM programming language.
  - java.net: Provides classes for networking applications
  - java.io: Provides for system input and output through data streams, serialization and the file system.