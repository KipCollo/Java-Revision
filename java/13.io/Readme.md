# I/O

We using I/O (input/output) and NIO.2 (non-­blocking I/O) APIs to interact with files and I/O streams. The preferred approach for working with files and directories with newer software applications is to use NIO.2 rather than I/O where possible.

Java IO is an API that comes with java which is targeted at reading and writing data(input and output).The java.io package contains all classes required for input and output opertations.Most apps need to process some input and produce some output based on input.Eg read data from file or internet,and write to a file or write response back over the internet.

Java performs I/O through streams.A stream is linked to a physical layer by java I/O system to make input and output operation in java.A stream is a sequence of data.In java stream is composed of bytes.Streams support of diff kinds of data including simple bytes,primitive data types,localized characters and objects.

## Conceptualizing the File System

Data is stored on persistent storage devices, such as hard disk drives and memory cards. A file within the storage device holds data. Files are organized into hierarchies using directories. A directory is a location that can contain files as well as other directories.

When working with directories in Java, we often treat them like files. In fact, we use many of the same classes and interfaces to operate on files and directories.For example, a file and directory both can be renamed with the same Java method.

To interact with files, we need to connect to the file system. The file system is in charge of reading and writing data within a computer. Different operating systems use different file systems to manage their data. For example, Windows-­based systems use a different file system than Unix-­based ones.

The JVM will automatically connect to the local file system, allowing you to perform the same operations across multiple platforms.

The root directory is the topmost directory in the file system, from which all files and directories inherit. In Windows, it is denoted with a drive letter such as C:\, while on Linux, it is denoted with a single forward slash, /.

A path is a representation of a file or directory within a file system. Each file system defines its own path separator character that is used between directory entries. The value to the left of a separator is the parent of the value to the right of the separator. For example, the path value /user/home/zoo.txt means that the file zoo.txt is inside the home directory, with the home directory inside the user directory.

NOTE:- Different operating systems vary in their format of pathnames. For example, Unix-­based systems use the forward slash, /, for paths, whereas Windows-­based systems use the backslash, \, character. That said, many programming languages and file systems support both types of slashes when writing path statements. Java offers a system property to retrieve the local separator character for the current environment:

```java
System.out.print(System.getProperty("file.separator"));
```

- The absolute path of a file or directory is the full path from the root directory to the file or directory, including all subdirectories that contain the file or directory.
- The relative path of a file or directory is the path from the current working directory to the file or directory.

Absolute and relative paths can contain path symbols. A path symbol is one of a reserved series of characters with special meaning in some file systems.

- . A reference to the current directory
- .. A reference to the parent of the current directory

A symbolic link is a special file within a file system that serves as a reference or pointer to another file or directory.In general, symbolic links are transparent to the user, as the operating system takes care of resolving the reference to the actual file. While the I/O APIs do not support symbolic links, NIO.2 includes full support for creating, detecting, and navigating symbolic links within the file system.

## Creating a File or Path

In order to do anything useful, you first need an object that represents the path to a particular file or directory on the file system. Using legacy I/O, this is the java.io.File class, whereas with NIO.2, it is the java.nio.file.Path interface.

The File class and Path interface cannot read or write data within a file, although they are passed as a reference to other classes.

- Creating a File:- The File class is created by calling its constructor. This code shows three different constructors:

```java
File zooFile1 = new File("/home/tiger/data/stripes.txt");
File zooFile2 = new File("/home/tiger", "data/stripes.txt");
File parent = new File("/home/tiger");
File zooFile3 = new File(parent, "data/stripes.txt");
```

All three create a File object that points to the same location on disk. If we passed null as the parent to the final constructor, it would be ignored, and the method would behave the same way as the single String constructor

- Creating a Path:- Since Path is an interface, we can’t create an instance directly. After all, interfaces don’t have constructors! Java provides a number of classes and methods that you can use to obtain Path objects.

The simplest and most straightforward way to obtain a Path object is to use a static factory method defined on Path or Paths. All four of these examples point to the same reference on disk:

```java
Path zooPath1 = Path.of("/home/tiger/data/stripes.txt");
Path zooPath2 = Path.of("/home", "tiger", "data", "stripes.txt");
Path zooPath3 = Paths.get("/home/tiger/data/stripes.txt");
Path zooPath4 = Paths.get("/home", "tiger", "data", "stripes.txt");
System.out.println(Files.exists(zooPath1));
```

The Path.of() method was introduced in Java 11 as a static method on the interface. The Paths factory class also provides a get() method to do the same thing. Note the s at the end of the Paths class to distinguish it from the Path interface.

NOTE:- You might notice that both the I/O and NIO.2 classes can interact with a URI. A uniform resource identifier (URI) is a string of characters that identifies a resource. It begins with a schema that indicates the resource type, followed by a path value such as file:// for local file systems and http://, https://, and ftp:// for remote file systems.

Since File and Path both reference locations on disk, it is helpful to be able to convert between them. Luckily, Java makes this easy by providing methods to do just that:

```java
File file = new File("rabbit");
Path nowPath = file.toPath();
File backToFile = nowPath.toFile();
```

Many older libraries use File, making it convenient to be able to get a File from a Path and vice versa. When working with newer applications, you should rely on NIO.2’s
Path interface, as it contains a lot more features. For example, only NIO.2 provides FileSystem support.

NIO.2 makes extensive use of creating objects with factory classes. The FileSystems class creates instances of the abstract FileSystem class. The latter includes methods for working with the file system directly. Both Paths.get() and Path.of() are shortcuts for this FileSystem method. Let’s rewrite our earlier examples one more time to see how to obtain a Path instance the long way:

```java
Path zooPath1 = FileSystems.getDefault().getPath("/home/tiger/data/stripes.txt");
Path zooPath2 = FileSystems.getDefault().getPath("/home", "tiger", "data", "stripes.txt");
```

The model for I/O is smaller, and you only need to understand the File class. In contrast,NIO.2 has more features and makes extensive use of the factory pattern. You should become comfortable with this approach. Many of your interactions with NIO.2 will require two types: an abstract class or interface and a factory or helper class.

NOTE:- The java.io.File is the I/O class, while Files is an NIO.2 helper class.Files operates on Path instances, not java.io.File instances. We know this is confusing, but they are from completely different APIs!

## Operating on File and Path

## Creating, Moving, and Deleting Files and Directories

Creating, moving, and deleting have some nuance.

- Making Directories:- To create a directory, we use these Files methods:

```java
public static Path createDirectory(Path dir,FileAttribute<?>... attrs) throws IOException
public static Path createDirectories(Path dir,FileAttribute<?>... attrs) throws IOException
```

The createDirectory() method will create a directory and throw an exception if it already exists or if the paths leading up to the directory do not exist.
The createDirectories() method creates the target directory along with any nonexistent parent directories leading up to the path. If all of the directories already exist,
createDirectories() will simply complete without doing anything. This is useful in situations where you want to ensure a directory exists and create it if it does not.

Both of these methods also accept an optional list of FileAttribute<?> values to apply to the newly created directory or directories.

The following shows how to create directories:

```java
Files.createDirectory(Path.of("/bison/field"));
Files.createDirectories(Path.of("/bison/field/pasture/green"));
```

The first example creates a new directory, field, in the directory /bison, assuming /bison exists; otherwise, an exception is thrown. Contrast this with the second example,
which creates the directory green along with any of the following parent directories if they do not already exist, including bison, field, and pasture.

- Copying Files:- The Files class provides a method for copying files and directories within the file system.

```java
public static Path copy(Path source, Path target,CopyOption... options) throws IOException
```

The method copies a file or directory from one location to another using Path objects.
The following shows an example of copying a file and a directory:

```java
Files.copy(Paths.get("/panda/bamboo.txt"),Paths.get("/pandasave/bamboo.txt"));
Files.copy(Paths.get("/turtle"), Paths.get("/turtleCopy"));
```

When directories are copied, the copy is shallow. A shallow copy means that the files and subdirectories within the directory are not copied. A deep copy means that the entire tree is copied, including all of its content and subdirectories. A deep copy typically requires recursion, where a method calls itself.

```java
public void copyPath(Path source, Path target) {
   try {
      Files.copy(source, target);
         if(Files.isDirectory(source))
            try (Stream<Path> s = Files.list(source)) {
               s.forEach(p -­> copyPath(p,target.resolve(p.getFileName())));
               }
            } catch(IOException e) {
         // Handle exception
            }
   } catch(IOException e) {
// Handle exception
}
```

The method first copies the path, whether a file or a directory. If it is a directory, only a shallow copy is performed. Next, it checks whether the path is a directory and, if it is, performs a recursive copy of each of its elements. What if the method comes across a symbolic
link? Don’t worry: the JVM will not follow symbolic links when using the list() method.

The method first copies the path, whether a file or a directory. If it is a directory, only a
shallow copy is performed. Next, it checks whether the path is a directory and, if it is, per-
forms a recursive copy of each of its elements. What if the method comes across a symbolic
link? Don’t worry: the JVM will not follow symbolic links when using the list() method.
Copying and Replacing Files
By default, if the target already exists, the copy() method will throw an exception.
You can change this behavior by providing the StandardCopyOption enum value
REPLACE_EXISTING to the method. The following method call will overwrite the
movie.txt file if it already exists:
Files.copy(Paths.get("book.txt"), Paths.get("movie.txt"),
StandardCopyOption.REPLACE_EXISTING);
For the exam, you need to know that without the REPLACE_EXISTING option, this
method will throw an exception if the file already exists.
Copying Files with I/O Streams
The Files class includes two copy() methods that operate with I/O streams.
public static long copy(InputStream in, Path target,
CopyOption... options) throws IOException
public static long copy(Path source, OutputStream out)
throws IOException
The first method reads the contents of an I/O stream and writes the output to a file. The
second method reads the contents of a file and writes the output to an I/O stream. These
methods are quite convenient if you need to quickly read/write data from/to disk.
The following are examples of each copy() method:
try (var is = new FileInputStream("source-­
data.txt")) {
// Write I/O stream data to a file
Files.copy(is, Paths.get("/mammals/wolf.txt"));
}
Files.copy(Paths.get("/fish/clown.xsl"), System.out);
While we used FileInputStream in the first example, the I/O stream could have been
any valid I/O stream including website connections, in-­memory stream resources, and so
forth. The second example prints the contents of a file directly to the System.out stream.

## java.io

package java.io: Provides for system input and output through data streams, serialization and the file system. Unless otherwise noted, passing a null argument to a constructor or method in any class or interface in this package will cause a NullPointerException to be thrown. A pathname string passed as a String argument to a constructor or method in any class or interface in this package will be interpreted as described in the class specification of File.

Java IO is an API that comes with Java which is targeted at reading and writing data(input & output).The java.io package contains all classes required for input and output operations.Most app need to process some input and produce some output based on that input.e.g read data from a file or over network.

Provides for system input and output through data streams, serialization and the file system. Unless otherwise noted, passing a null argument to a constructor or method in any class or interface in this package will cause a NullPointerException to be thrown.

Java uses the concept of a stream to make I/O operation fast.The stream in the java.io package supports many data such as primitives, Object, localized characters, etc.A stream can be defined as a sequence of data. The InputStream is used to read data from a source and the OutputStream is used for writing data to a destination.

## Stream

A stream is a sequence of data. In Java, a stream is composed of bytes. It's called a stream because it is like a stream of water that continues to flow.Stream supports diff types of data including primitive data types,localized characters and objects.

In Java, 3 streams are created for us automatically. All these streams are attached with the console.

1) System.out: standard output stream
2) System.in: standard input stream  
3) System.err: standard error stream

Java application uses an input stream to read data from source ,it may be a file,memory arrays,peripheral device or socket.

Java application uses an output stream to read data to destination,it may be a file,memory arrays,peripheral device or socket.

### Java InputStream class

Java uses byte streams to perform input and output of 8-bit bytes.All input byte stream classes are descended from **IputStream**.InputStream class is an abstract class.Is superclass of all class rep input stream of bytes.

1. AudioInputStream
2. ByteArrayInputStream
3. FileInputStream
4. FilterInputStream
5. ObjectInputStream
6. PipedinputStream
7. SequenceInputStream
8. StringBufferinputStream

### Java OutputStream class

Java uses byte streams to perform input and output of 8-bit bytes.All input byte stream classes are descended from **OutputStream**.OutputStream class is an abstract class.Is superclass of all class rep output stream of bytes.

1. ByteArrayoutputStream
2. FileOutputStream
3. FilterOutputStream
4. ObjectOutputStream
5. PipedOutputStream

#### Class FileOutputStream

A file output stream is an output stream for writing data to a File or to a FileDescriptor. Whether or not a file is available or may be created depends upon the underlying platform. Some platforms, in particular, allow a file to be opened for writing by only one FileOutputStream (or other file-writing object) at a time. In such situations the constructors in this class will fail if the file involved is already open.

FileOutputStream is meant for writing streams of raw bytes such as image data. For writing streams of characters, consider using FileWriter.

Note:

The close() method should be called to release resources used by this stream, either directly, or with the try-with-resources statement.

##### Constructors

1. FileOutputStream(File file) - Creates a file output stream to write to the file represented by the specified File object.
2. FileOutputStream(FileDescriptor fdObj) - Creates a file output stream to write to the specified file descriptor, which represents an existing connection to an actual file in the file system.
3. FileOutputStream(File file, boolean append) - Creates a file output stream to write to the file represented by the specified File object.
4. FileOutputStream(String name) - Creates a file output stream to write to the file with the specified name.
5. FileOutputStream(String name, boolean append) - Creates a file output stream to write to the file with the specified name.

##### Methods

1. void close() - Closes this file output stream and releases any system resources associated with this stream.
2. FileChannel getChannel() - Returns the unique FileChannel object associated with this file output stream.
3. final FileDescriptor getFD() - Returns the file descriptor associated with this stream.
4. void write(byte[] b) - Writes b.length bytes from the specified byte array to this file output stream.
5. void write(byte[] b, int off, int len) - Writes len bytes from the specified byte array starting at offset off to this file output stream.
6. void write(int b) - Writes the specified byte to this file output stream.

## File Navigation and I/O

There are several other classes that we would be going through to get to know the basics of File Navigation and I/O .

1. File Class
2. FileReader Class
3. FileWriter Class

- **File Class** :An abstract representation of file and directory pathnames. Java File class represents the files and directory pathnames in an abstract manner. This class is used for creation of files and directories, file searching, file deletion etc.

```java
public class File extends Object implements Serializable, Comparable<File>
```

User interfaces and operating systems use system-dependent pathname strings to name files and directories. This class presents an abstract, system-independent view of hierarchical pathnames. An abstract pathname has two components:

An optional system-dependent prefix string, such as a disk-drive specifier, "/" for the UNIX root directory, or "\\\\" for a Microsoft Windows UNC pathname, and
A sequence of zero or more string names.
The first name in an abstract pathname may be a directory name or, in the case of Microsoft Windows UNC pathnames, a hostname. Each subsequent name in an abstract pathname denotes a directory; the last name may denote either a directory or a file. The empty abstract pathname has no prefix and an empty name sequence.

The first name in an abstract pathname may be a directory name or, in the case of Microsoft Windows UNC pathnames, a hostname. Each subsequent name in an abstract pathname denotes a directory; the last name may denote either a directory or a file. The empty abstract pathname has no prefix and an empty name sequence.
The conversion of a pathname string to or from an abstract pathname is inherently system-dependent. When an abstract pathname is converted into a pathname string, each name is separated from the next by a single copy of the default separator character. The default name-separator character is defined by the system property file.separator, and is made available in the public static fields separator and separatorChar of this class. When a pathname string is converted into an abstract pathname, the names within it may be separated by the default name-separator character or by any other name-separator character that is supported by the underlying system.

A pathname, whether abstract or in string form, may be either absolute or relative. An absolute pathname is complete in that no other information is required in order to locate the file that it denotes. A relative pathname, in contrast, must be interpreted in terms of information taken from some other pathname. By default the classes in the java.io package always resolve relative pathnames against the current user directory. This directory is named by the system property user.dir, and is typically the directory in which the Java virtual machine was invoked.

The parent of an abstract pathname may be obtained by invoking the getParent() method of this class and consists of the pathname's prefix and each name in the pathname's name sequence except for the last. Each directory's absolute pathname is an ancestor of any File object with an absolute abstract pathname which begins with the directory's absolute pathname. For example, the directory denoted by the abstract pathname "/usr" is an ancestor of the directory denoted by the pathname "/usr/local/bin".

The prefix concept is used to handle root directories on UNIX platforms, and drive specifiers, root directories and UNC pathnames on Microsoft Windows platforms, as follows:

For UNIX platforms, the prefix of an absolute pathname is always "/". Relative pathnames have no prefix. The abstract pathname denoting the root directory has the prefix "/" and an empty name sequence.
For Microsoft Windows platforms, the prefix of a pathname that contains a drive specifier consists of the drive letter followed by ":" and possibly followed by "\\" if the pathname is absolute. The prefix of a UNC pathname is "\\\\"; the hostname and the share name are the first two names in the name sequence. A relative pathname that does not specify a drive has no prefix.
Instances of this class may or may not denote an actual file-system object such as a file or a directory. If it does denote such an object then that object resides in a partition. A partition is an operating system-specific portion of storage for a file system. A single storage device (e.g. a physical disk-drive, flash memory, CD-ROM) may contain multiple partitions. The object, if any, will reside on the partition named by some ancestor of the absolute form of this pathname.

A file system may implement restrictions to certain operations on the actual file-system object, such as reading, writing, and executing. These restrictions are collectively known as access permissions. The file system may have multiple sets of access permissions on a single object. For example, one set may apply to the object's owner, and another may apply to all other users. The access permissions on an object may cause some methods in this class to fail.

Instances of the File class are immutable; that is, once created, the abstract pathname represented by a File object will never change.

Interoperability with java.nio.file package: The java.nio.file package defines interfaces and classes for the Java virtual machine to access files, file attributes, and file systems. This API may be used to overcome many of the limitations of the java.io.File class. The toPath method may be used to obtain a Path that uses the abstract path represented by a File object to locate a file. The resulting Path may be used with the Files class to provide more efficient and extensive access to additional file operations, file attributes, and I/O exceptions to help diagnose errors when an operation on a file fails.

The File object represents the actual file/directory on the disk. There are following constructors to create a File object:

File(File parent, String child);- Following syntax creates a new File instance by converting the given pathname string into an abstract pathname.Creates a new File instance from a parent abstract pathname and a child pathname string.

If parent is null then the new File instance is created as if by invoking the single-argument File constructor on the given child pathname string.
Otherwise the parent abstract pathname is taken to denote a directory, and the child pathname string is taken to denote either a directory or a file. If the child pathname string is absolute then it is converted into a relative pathname in a system-dependent way. If parent is the empty abstract pathname then the new File instance is created by converting child into an abstract pathname and resolving the result against a system-dependent default directory. Otherwise each pathname string is converted into an abstract pathname and the child abstract pathname is resolved against the parent.

File(String pathname) - Following syntax creates a new File instance from a parent pathname string and a child pathname string.Creates a new File instance by converting the given pathname string into an abstract pathname. If the given string is the empty string, then the result is the empty abstract pathname.

File(String parent, String child)- Following syntax creates a new File instance by converting the given file: URI into an abstract pathname.Creates a new File instance from a parent pathname string and a child pathname string.

If parent is null then the new File instance is created as if by invoking the single-argument File constructor on the given child pathname string.
Otherwise the parent pathname string is taken to denote a directory, and the child pathname string is taken to denote either a directory or a file. If the child pathname string is absolute then it is converted into a relative pathname in a system-dependent way. If parent is the empty string then the new File instance is created by converting child into an abstract pathname and resolving the result against a system-dependent default directory. Otherwise each pathname string is converted into an abstract pathname and the child abstract pathname is resolved against the parent.

File(URI uri)- Once you have File object in hand then there is a list of helper methods which can be used manipulate the files.
Creates a new File instance by converting the given file: URI into an abstract pathname.
The exact form of a file: URI is system-dependent, hence the transformation performed by this constructor is also system-dependent.

For a given abstract pathname f it is guaranteed that

new File( f.toURI()).equals( f.getAbsoluteFile())
so long as the original abstract pathname, the URI, and the new abstract pathname are all created in (possibly different invocations of) the same Java virtual machine. This relationship typically does not hold, however, when a file: URI that is created in a virtual machine on one operating system is converted into an abstract pathname in a virtual machine on a different operating system.

- **FileWriter**: This class inherits from the OutputStreamWriter class. The class is used for writing streams of characters.
This class has several constructors to create required objects.

- **FileReader**: This class inherits from the InputStreamReader class. FileReader is used for reading streams of characters.

Reads text from character files using a default buffer size. Decoding from bytes to characters uses either a specified charset or the default charset.
The FileReader is meant for reading streams of characters. For reading streams of raw bytes, consider using a FileInputStream.
This class has several constructors to create required objects.

1. FileReader(File file): Creates a new FileReader, given the File to read, using the default charset.
2. FileReader(FileDescriptor fd): Creates a new FileReader, given the FileDescriptor to read, using the default charset.
3. FileReader(File file, Charset charset): Creates a new FileReader, given the File to read and the charset.
4. FileReader(String fileName): Creates a new FileReader, given the name of the file to read, using the default charset.
5. FileReader(String fileName, Charset charset): Creates a new FileReader, given the name of the file to read and the charset.

Once you have FileReader object in hand then there is a list of helper methods which can be used manipulate the files:

1. public int read() throws IOException- Reads a single character. Returns an int, which represents the character read.
2. public int read(char [] c, int offset, int len)- Reads characters into an array. Returns the number of characters read.
Example:

```java
import java.io.*;
public class FileRead{
public static void main(String args[])throws IOException{
File file = new File("Hello1.txt");
// creates the file
file.createNewFile();
// creates a FileWriter Object
FileWriter writer = new FileWriter(file);
// Writes the content to the file
writer.write("This\n is\n an\n example\n");
writer.flush();
writer.close();
//Creates a FileReader Object
FileReader fr = new FileReader(file);
char [] a = new char[50];
fr.read(a); // reads the content to the array
for(char c : a)
System.out.print(c); //prints the characters one by one
fr.close();
}
}
```

## I/O Streams

The “I/O” refers to the nature of how data is accessed, either by reading the data from a resource (input) or by writing the data to a resource (output).

The contents of a file may be accessed or written via an I/O stream, which is a list of data elements presented sequentially. An I/O stream can be conceptually thought of as a long,nearly never-­ending stream of water with data presented one wave at a time.

The I/O stream is so large that once we start reading it, we have no idea where the beginning or the end is. We just have a pointer to our current position in the I/O stream and read data one block at a time.

Each type of I/O stream segments data into a wave or block in a particular way. For example, some I/O stream classes read or write data as individual bytes. Other I/O stream
classes read or write individual characters or strings of characters. On top of that, some I/O stream classes read or write larger groups of bytes or characters at a time, specifically those with the word Buffered in their name.

NOTE:- Although the java.io API is full of I/O streams that handle characters, strings, groups of bytes, and so on, nearly all are built on top of reading or writing an individual byte or an array of bytes at a time. Higher-­level I/O streams exist for convenience as well as performance.

Although I/O streams are commonly used with file I/O, they are more generally used to handle the reading/writing of any sequential data source. For example, you might construct a Java application that submits data to a website using an output stream and reads the result via an input stream.

The java.io API provides numerous classes for creating, accessing, and manipulating I/O streams

- Storing Data as Bytes:- Data is stored in a file system (and memory) as a 0 or 1, called a bit. Since it’s really hard for humans to read/write data that is just 0s and 1s, they are grouped into a set of 8 bits, called a byte.When we use I/O streams, values are often read or written using byte values and arrays.

The java.io API defines two sets of I/O stream classes for reading and writing I/O streams: byte I/O streams and character I/O streams.

1. Byte I/O streams read/write binary data (0s and 1s) and have class names that end in InputStream or OutputStream.
2. Character I/O streams read/write text data and have class names that end in Reader or Writer.

The API frequently includes similar classes for both byte and character I/O streams, such as FileInputStream and FileReader. The difference between the two classes is based on how the bytes are read or written.

NOTE:- It is important to remember that even though character I/O streams do not contain the word Stream in their class name, they are still I/O streams. The use of Reader/Writer in the name is just to distinguish them from byte streams.

The byte I/O streams are primarily used to work with binary data, such as an image or executable file, while character I/O streams are used to work with text files. For example, you can use a Writer class to output a String value to a file without necessarily having to worry about the underlying character encoding of the file.

The character encoding determines how characters are encoded and stored in bytes in an I/O stream and later read back or decoded as characters. Although this may sound simple,Java supports a wide variety of character encodings, ranging from ones that may use one byte for Latin characters, UTF-­8 and ASCII for example, to using two or more bytes per character, such as UTF-­16.

In Java, the character encoding can be specified using the Charset class by passing a name value to the static Charset.forName() method, such as in the following examples:

```java
Charset usAsciiCharset = Charset.forName("US-­ASCII");
Charset utf8Charset = Charset.forName("UTF-­8");
Charset utf16Charset = Charset.forName("UTF-­16");
```

Java supports numerous character encodings, each specified by a different standard name value.

- Input vs. Output Streams

Most InputStream classes have a corresponding OutputStream class, and vice versa. For example, the FileOutputStream class writes data that can be read by a FileInputStream. If you understand the features of a particular Input or Output stream class, you should naturally know what its complementary class does.

It follows, then, that most Reader classes have a corresponding Writer class. For example, the FileWriter class writes data that can be read by a FileReader.
There are exceptions to this rule. For the exam, you should know that PrintWriter has no accompanying PrintReader class. Likewise, the PrintStream is an OutputStream that has no corresponding InputStream class. It also does not have Output in its name.

- Low-­Level vs. High-­Level Streams

Another way that you can familiarize yourself with the java.io API is by segmenting I/O streams into low-­level and high-­level streams.

1. A low-­level stream connects directly with the source of the data, such as a file, an array, or a String. Low-­level I/O streams process the raw data or resource and are accessed in a direct and unfiltered manner. For example, a FileInputStream is a class that reads file data one byte at a time.
2. A high-­level stream is built on top of another I/O stream using wrapping.Wrapping is the process by which an instance is passed to the constructor of another class,
and operations on the resulting instance are filtered and applied to the original instance.For example, take a look at the FileReader and BufferedReader objects in the following sample code:

```java
try (var br = new BufferedReader(new FileReader("zoo-­data.txt"))) {
 System.out.println(br.readLine());
}
```

In this example, FileReader is the low-­level I/O stream, whereas BufferedReader is the high-­level I/O stream that takes a FileReader as input. Many operations on the high-­level I/O stream pass through as operations to the underlying low-­level I/O stream, such as read() or close(). Other operations override or add new functionality to the low-­level I/O stream methods. The high-­level I/O stream may add new methods, such as readLine(),as well as performance enhancements for reading and filtering the low-­level data.

High-­level I/O streams can also take other high-­level I/O streams as input. For example, although the following code might seem a little odd at first, the style of wrapping an I/O stream is quite common in practice:

```java
try (var ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("zoo-­data.txt")))) {
 System.out.print(ois.readObject());
}
```

In this example, the low-­level FileInputStream interacts directly with the file, which is wrapped by a high-­level BufferedInputStream to improve performance. Finally, the entire object is wrapped by another high-­level ObjectInputStream, which allows us to interpret the data as a Java object.

The java.io library defines four abstract classes that are the parents of all I/O stream classes defined within the API: InputStream, OutputStream, Reader, and Writer.
The constructors of high-­level I/O streams often take a reference to the abstract class. For example, BufferedWriter takes a Writer object as input, which allows it to take any subclass of Writer.

The java.io abstract stream base classes:-

1. InputStream - Abstract class for all input byte streams
2. OutputStream - Abstract class for all output byte streams
3. Reader - Abstract class for all input character streams
4. Writer - Abstract class for all output character streams

The java.io concrete I/O stream classes:-

1. FileInputStream - Low - Reads file data as bytes
2. FileOutputStream - Low - Writes file data as bytes
3. FileReader - Low - Reads file data as characters
4. FileWriter - Low - Writes file data as characters
5. BufferedInputStream - High - Reads byte data from existing InputStream in buffered manner, which improves efficiency and performance
6. BufferedOutputStream - High - Writes byte data to existing OutputStream in buffered manner, which improves efficiency and performance
7. BufferedReader - High - Reads character data from existing Reader in buffered manner, which improves efficiency and performance
8. BufferedWriter - High - Writes character data to existing Writer in buffered manner, which improves efficiency and performance
9. ObjectInputStream - High - Deserializes primitive Java data types and graphs of Java objects from existing Description InputStream
10. ObjectOutputStream - High - Serializes primitive Java data types and graphs of Java objects to existingOutputStream
11. PrintStream - High - Writes formatted representations of Java objects to binary stream
12. PrintWriter- High - Writes formatted representations of Java objects to character stream

## Reading and Writing Files

There are a number of ways to read and write from a file:-

- Using I/O Streams:- I/O streams are all about reading/writing data, so it shouldn’t be a surprise that the most important methods are read() and write(). Both InputStream and Reader declare a read() method to read byte data from an I/O stream. Likewise, OutputStream and Writer both define a write() method to write a byte to the stream:

The following copyStream() methods show an example of reading all of the values of an InputStream and Reader and writing them to an OutputStream and Writer, respectively. In both examples, -­1 is used to indicate the end of the stream.

```java
void copyStream(InputStream in, OutputStream out) throws IOException {
   int b;
   while ((b = in.read()) != -­1) {
      out.write(b);
   }
}
void copyStream(Reader in, Writer out) throws IOException {
   int b;
   while ((b = in.read()) != -­1) {
      out.write(b);
   }  
}
```

## Serializing and Deserializing Data

Serialization is the process of converting an in-­memory object to a byte stream. Likewise, deserialization is the process of converting from a byte stream into an object. Serialization often involves writing an object to a stored or transmittable format,while deserialization is the reciprocal process.
E.g serializing and deserializing a Giraffe object to and from a giraffe.txt file.

- Applying the Serializable Interface:- To serialize an object using the I/O API, the object must implement the java.io.Serializable interface. The Serializable interface is a marker interface, which means it does not have any methods. Any class can implement the Serializable interface since there are no required methods to implement.

NOTE:- You should only mark data-­oriented classes serializable. Process-­oriented classes, such as the I/O streams or the Thread instances  are often poor candidates for serialization,as the internal state of those classes tends to be ephemeral or short-­lived.

The purpose of using the Serializable interface is to inform any process attempting to serialize the object that you have taken the proper steps to make the object serializable. All Java primitives and many of the built-­in Java classes that you have worked with throughout this book are Serializable. For example, this class can be serialized:

```java
import java.io.Serializable;
public class Gorilla implements Serializable {
   private static final long serialVersionUID = 1L;
   private String name;
   private int age;
   private Boolean friendly;
   private transient String favoriteFood;

   // Constructors/Getters/Setters/toString() omitted

}
```

- Maintaining a serialVersionUID:- It’s a good practice to declare a static serialVersionUID variable in every class that implements Serializable. The version is stored with each object as part of serialization.Then, every time the class structure changes, this value is updated or incremented.
Perhaps our Gorilla class receives a new instance member Double banana, or maybe the age field is renamed. The idea is a class could have been serialized with an older version of the class and deserialized with a newer version of the class.
The serialVersionUID helps inform the JVM that the stored data may not match the new class definition. If an older version of the class is encountered during deserialization,a java.io.InvalidClassException may be thrown. Alternatively, some APIs support converting data between versions.

- Marking Data transient:- The transient modifier can be used for sensitive data of the class, like a password. There are other objects it does not make sense to serialize, like the state of an in-­memory Thread.If the object is part of a serializable object, we just mark it transient to ignore these select instance members.

It reverts to its default Java values, such as 0.0 for double, or null for an object.

NOTE:- Marking static fields transient has little effect on serialization. Other than the serialVersionUID, only the instance members of a class are serialized.

## Interacting with Users

Java includes numerous classes for interacting with the user. For example, you might want to write an application that asks a user to log in and then prints a success message.

- Printing Data to the User:- Java includes two PrintStream instances for providing information to the user: System.out and System.err.The syntax for calling and using System.err is the same as System.out but is used to report errors to the user in a separate I/O stream from the regular output information.

```java
try (var in = new FileInputStream("zoo.txt")) {
   System.out.println("Found file!");
} catch (FileNotFoundException e) {
   System.err.println("File not found!");
}
```

They differs depending on what is executing the program.For example, if you are running from a command prompt, they will likely print text in the same format. On the other hand, if you are working in an integrated development environment (IDE), they might print the System.err text in a different color. Finally, if the code is being run on a server, the System.err stream might write to a different log file.

NOTE:- Using Logging APIs:- While System.out and System.err are incredibly useful for debugging stand-­alone or simple applications, they are rarely used in professional software development. Most applications rely on a logging service or API.While many logging APIs are available, they tend to share a number of similar attributes.
First you create a static logging object in each class. Then you log a message with an appropriate logging level: debug(), info(), warn(), or error(). The debug() and
info() methods are useful as they allow developers to log things that aren’t errors but may be useful

## Review of Key APIs

1. File - I/O representation of location in file system
2. Files - Helper methods for working with Path
3. Path - NIO.2 representation of location in file system
4. Paths - Contains factory methods to get Path
5. URI - Uniform resource identifier for files, URLs, etc.
6. FileSystem - NIO.2 representation of file system
7. FileSystems - Contains factory methods to get FileSystem
8. InputStream - Superclass for reading files based on bytes
9. OuputStream - Superclass for writing files based on bytes
10. Reader - Superclass for reading files based on characters
11. Writer - Superclass for writing files based on characters
