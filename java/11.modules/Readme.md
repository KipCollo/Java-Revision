# Modules

Packages can be grouped into modules.
A real project will consist of hundreds or thousands of classes grouped into packages. These packages are grouped into Java archive (JAR) files. A JAR is a ZIP file with some extra information, and the extension is .jar.

In addition to code written by your team, most applications also use code written by others. `Open source `is software with the code supplied and is often free to use. Java has a vibrant `open source software (OSS)` community, and those libraries are also supplied as JAR files. For example, there are libraries to read files, connect to a database, and much more.

Some open source projects even depend on functionality in other open source projects.For example, Spring is a commonly used framework, and JUnit is a commonly used testing library. To use either, you need to make sure you have compatible versions of all the relevant JARs available at runtime. This complex chain of dependencies and minimum versions is often referred to by the community as `JAR hell`.

The `Java Platform Module System (JPMS)` groups code at a higher level. The main purpose of a module is to provide groups of related packages that offer developers a particular set of functionality. It’s like a JAR file, except a developer chooses which packages are accessible outside the module.

The Java Platform Module System includes the following:

1. A format for module JAR files
2. Partitioning of the JDK into modules
3. Additional command-­line options for Java tools

A `module` is a group of one or more packages plus a special file called `module-­info.java`. The contents of this file are the module declaration.

## Benefits of Modules

Modules look like another layer of things you need to know in order to program.While using modules is optional, it is important to understand the problems they are designed to solve:

1. Better access control: In addition to the levels of access control you can have packages that are only accessible to other packages in
the module.
2. Clearer dependency management: Since modules specify what they rely on, Java can complain about a missing JAR when starting up the program rather than when it is first accessed at runtime.
3. Custom Java builds: You can create a Java runtime that has only the parts of the JDK that your program needs rather than the full one at over 150 MB.
4. Improved security: Since you can omit parts of the JDK from your custom build, you don’t have to worry about vulnerabilities discovered in a part you don’t use.
5. Improved performance: Another benefit of a smaller Java package is improved startup time and a lower memory requirement.
6. Unique package enforcement: Since modules specify exposed packages, Java can ensure that each package comes from only one module and avoid confusion about what is being run.

- **module-­info.java file**:- There are a few key differences between a module declaration and a regular Java class declaration:

1. The module-­info.java file must be in the root directory of your module. Regular Java classes should be in packages.
2. The module declaration must use the keyword `module` instead of class, interface, or enum.
3. The module name follows the naming rules for package names. It often includes periods(.) in its name. Regular class and package names are not allowed to have dashes (-­).Module names follow the same rule
