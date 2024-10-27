# java.io


Java IO is an API that comes with Java which is targeted at reading and writing data(input & output).The java.io package contains all classes required for input and output operations.Most app need to process some input and produce some output based on that input.e.g read data from a file or over network.

Provides for system input and output through data streams, serialization and the file system. Unless otherwise noted, passing a null argument to a constructor or method in any class or interface in this package will cause a NullPointerException to be thrown. 

Java uses the concept of a stream to make I/O operation fast. 

## Stream

A stream is a sequence of data. In Java, a stream is composed of bytes. It's called a stream because it is like a stream of water that continues to flow.Strem supports diff types of data including primitive data types,localized characters and objects.

In Java, 3 streams are created for us automatically. All these streams are attached with the console.

1) System.out: standard output stream
2) System.in: standard input stream  
3) System.err: standard error stream

Java application uses an input stream to read data from source ,it may be a file,memory arrays,peripheral device or socket.

Java application uses an output stream to read data to destination,it may be a file,memory arrays,peripheral device or socket.

### Java InputStream class

Java uses byte streams to perform input and output of 8-bit bytes.All input byte stream classes are descended from **IputStream**.InputStream class is an abstract class.Is superclass of all class rep input stream of bytes.

>AudioInputStream
>ByteArrayInputStream
>FileInputStream
>FilterInputStream
>ObjectInputStream
>PipedinputStream
>SequenceInputStream
>StringBufferinputStream 

### Java OutputStream class

Java uses byte streams to perform input and output of 8-bit bytes.All input byte stream classes are descended from **OutputStream**.OutputStream class is an abstract class.Is superclass of all class rep output stream of bytes.

>ByteArrayoutputStream
>FileOutputStream
>FilterOutputStream
>ObjectOutputStream
>PipedOutputStream

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
