# Networking

The Internet is the global network of millions of computers. Your computer can connect to the Internet through an Internet Service Provider (ISP) using a dialup, DSL, or cable modem, or through a local area network (LAN).

When a computer needs to communicate with another computer, it needs to know the other computer’s address.

An `Internet Protocol (IP)` address uniquely identifies the computer on the Internet. An IP address consists of four dotted decimal numbers between 0 and 255, such as 130.254.204.31. Since it is not easy to remember so many numbers, they are often mapped to meaningful names called domain names, such as liang.armstrong.edu. Special servers called Domain Name Servers (DNS) on the Internet translate host names into IP addresses.

When a computer contacts liang.armstrong.edu, it first asks the DNS to translate this domain name into a numeric IP address and then sends the request using the IP address.
The Internet Protocol is a low-level protocol for delivering data from one computer to another across the Internet in packets. Two higher-level protocols used in conjunction with the IP are the Transmission Control Protocol (TCP) and the User Datagram Protocol (UDP).

TCP enables two hosts to establish a connection and exchange streams of data. TCP guarantees delivery of data and also guarantees that packets will be delivered in the same order in which they were sent.

UDP is a standard, low-overhead, connectionless, host-to-host protocol that is used over the IP. UDP allows an application program on one computer to send a datagram to an application program on another computer.

Java supports both stream-based and packet-based communications. Stream-based communications use TCP for data transmission, whereas packet-based communications use UDP.
Since TCP can detect lost transmissions and resubmit them, transmissions are lossless and reliable. UDP, in contrast, cannot guarantee lossless transmission. Stream-based communications are used in most areas of Java programming.

Java Networking is a concept of connecting two or more computing devices together so that we can share resources.

When computing devices such as laptops, desktops, servers, smartphones, and tablets and an eternally-expanding arrangement of IoT gadgets such as cameras, door locks, doorbells, refrigerators, audio/visual systems, thermostats, and various sensors are sharing information and data with each other is known as networking.

With networks, a single program can regain information stored in millions of computers positioned anywhere in the world. Java Networking is a notion of combining two or more computing devices together to share resources.

Java Socket Programming provides facility to share data between different computing devices.

**Advantage of Java Networking :**

- sharing resources
- centralized software management

All the Java program communications over the network are done at the application layer. The java.net package of the J2SE APIs comprises various classes and interfaces that execute the low-level communication features, enabling the user to formulate programs that focus on resolving the problem.

**The java.net Package Supports 2 Protocols:**

- **TCP:** Transmission Control Protocol provides reliable communication between the sender and receiver. TCP is used along with the Internet Protocol referred as TCP/IP.
- **UDP:** User Datagram Protocol provides a connection-less protocol service by allowing packet of data to be transferred along two or more nodes

## Java Networking Terminology

Some of the widely used java networking terminologies are as follows:

1. IP Address- IP address is a unique number assigned to a node of a network e.g. 192.168.0.1. It is composed of octets that range from 0 to 255. It is a logical address that can be changed.
2. Protocol- A protocol is a set of rules basically that is followed for communication. For example: TCP, FTP, Telnet, SMTP, POP, etc.
3. Port Number- The port number is used to uniquely identify different applications. It acts as a communication endpoint between applications. The port number is associated with the IP address for communication between two applications.
4. MAC Address- MAC (Media Access Control) Address is a unique identifier of NIC (Network Interface Controller). A network node can have multiple NIC but each with unique MAC. The main difference between MAC and IP address is that, MAC Address is used to ensure the physical address of computer. It uniquely identifies the devices on a network. While IP address are used to uniquely identifies the connection of network with that device take part in a network.
5. Socket- A socket is one endpoint of a two-way communication connection between the two applications running on the network. The socket mechanism presents a method of inter-process communication (IPC) by setting named contact points between which the communication occurs. A socket is tied to a port number so that the TCP layer can recognize the application to which the data is intended to be sent.
6. Connection-oriented protocol- In connection-oriented protocol, acknowledgement is sent by the receiver. So, it is reliable but slow. The example of connection-oriented protocol is TCP.
7. Connection-less protocol- In connection-less protocol, acknowledgement is not sent by the receiver. So, it is not reliable but fast. The example of connection-less protocol is UDP.
8. Sockets:-Endpoints for communication between two machines.Types:
    - TCP Sockets: Use Socket and ServerSocket classes.
    - UDP Sockets: Use DatagramSocket and DatagramPacket.

## Java Networking Classes

The java.net package of the Java programming language includes various classes that provide an easy-to-use means to access network resources. The classes covered in the java.net package are given as follows:-

| <!-- -->    | <!-- -->    | <!-- -->    | <!-- -->    | <!-- -->    |
|-------------|-------------|-------------|-------------|-------------|
|Authenticator|CacheRequest|CacheResponse|ContentHandler|CookieHandler|
|CookieManager|DatagramPacket|DatagramSocket|DatagramSocketImpl|InterfaceAddress|
|JarURLConnection|MulticastSocket|InetSocketAddress|InetAddress|Inet4Address|
|Inet6Address|IDN|HttpURLConnection|HttpCookie|NetPermission|
|NetworkInterface|PasswordAuthentication|Proxy|ProxySelector|ResponseCache|
|SecureCacheResponse|ServerSocket|Socket|SocketAddress|SocketImpl|
|SocketPermission|StandardSocketOptions|URI|URL|URLClassLoader|
|URLConnection|URLDecoder|URLEncoder|URLStreamHandler|-|

1. CacheRequest - The CacheRequest class is used in java whenever there is a need to store resources in ResponseCache. The objects of this class provide an edge for the OutputStream object to store resource data into the cache. 
2. CookieHandler- The CookieHandler class is used in Java to implement a callback mechanism for securing up an HTTP state management policy implementation inside the HTTP protocol handler. The HTTP state management mechanism specifies the mechanism of how to make HTTP requests and responses.
3. CookieManager - The CookieManager class is used to provide a precise implementation of CookieHandler. This class separates the storage of cookies from the policy surrounding accepting and rejecting cookies. A CookieManager comprises a CookieStore and a CookiePolicy.
4. DatagramPacket- The DatagramPacket class is used to provide a facility for the connectionless transfer of messages from one system to another. This class provides tools for the production of datagram packets for connectionless transmission applying the datagram socket class.
5. InetAddress- The InetAddress class is used to provide methods to get the IP address of any hostname. An IP address is expressed by a 32-bit or 128-bit unsigned number. InetAddress can handle both IPv4 and IPv6 addresses.
6. Server Socket- The ServerSocket class is used for implementing system-independent implementation of the server-side of a client/server Socket Connection. The constructor for ServerSocket class throws an exception if it can’t listen on the specified port. For example – it will throw an exception if the port is already being used.
7. Socket- The Socket class is used to create socket objects that help the users in implementing all fundamental socket operations. The users can implement various networking actions such as sending, reading data, and closing connections. Each Socket object built using java.net.Socket class has been connected exactly with 1 remote host; for connecting to another host, a user must create a new socket object.
8. DatagramSocket- The DatagramSocket class is a network socket that provides a connection-less point for sending and receiving packets. Every packet sent from a datagram socket is individually routed and delivered. It can further be practiced for transmitting and accepting broadcast information. Datagram Sockets is Java’s mechanism for providing network communication via UDP instead of TCP.
9. Proxy- A proxy is a changeless object and a kind of tool or method or program or system, which serves to preserve the data of its users and computers. It behaves like a wall between computers and internet users. A Proxy Object represents the Proxy settings to be applied with a connection.
10. URL- The URL class in Java is the entry point to any available sources on the internet. A Class URL describes a Uniform Resource Locator, which is a signal to a “resource” on the World Wide Web. A source can denote a simple file or directory, or it can indicate a more difficult object, such as a query to a database or a search engine.
11. URLConnection- The URLConnection class in Java is an abstract class describing a connection of a resource as defined by a similar URL. The URLConnection class is used for assisting two distinct yet interrelated purposes. Firstly it provides control on interaction with a server(especially an HTTP server) than a URL class. Furthermore, with a URLConnection, a user can verify the header transferred by the server and can react consequently. A user can also configure header fields used in client requests using URLConnection.

## Java Networking Interfaces

The java.net package includes various interfaces also that provide an easy-to-use means to access network resources. The interfaces included in the java.net package are as follows:-

1. CookiePolicy- The CookiePolicy interface in the java.net package provides the classes for implementing various networking applications. It decides which cookies should be accepted and which should be rejected. In CookiePolicy, there are three pre-defined policy implementations, namely ACCEPT_ALL, ACCEPT_NONE, and ACCEPT_ORIGINAL_SERVER.
2. CookieStore- A CookieStore is an interface that describes a storage space for cookies. CookieManager combines the cookies to the CookieStore for each HTTP response and recovers cookies from the CookieStore for each HTTP request.
3. FileNameMap- The FileNameMap interface is an uncomplicated interface that implements a tool to outline a file name and a MIME type string. FileNameMap charges a filename map ( known as a mimetable) from a data file.
4. SocketOption- The SocketOption interface helps the users to control the behavior of sockets. Often, it is essential to develop necessary features in Sockets. SocketOptions allows the user to set various standard options.
5. SocketImplFactory- The SocketImplFactory interface defines a factory for SocketImpl instances. It is used by the socket class to create socket implementations that implement various policies.
6. ProtocolFamily- This interface represents a family of communication protocols. The ProtocolFamily interface contains a method known as name(), which returns the name of the protocol family.

### URL Class

The URL class in Java is the entry point to any available sources on the internet. A Class URL describes a Uniform Resource Locator, which is a signal to a “resource” on the World Wide Web. A source can denote a simple file or directory, or it can indicate a more difficult object, such as a query to a database or a search engine. URL is a string of text that recognizes all the sources on the Internet, showing us the address of the source, how to interact with it, and recover something from it.

#### Components of a URL

A URL can have many forms. The most general however follows a three-components system-  
 > Protocol – The protocol in a URL defines how information is transported among the host and a client (or web browser).
 > Hostname – The hostname is the name of the device on which the resource exists.
 > File Name – The filename is the pathname to the file on the device.
 > Port Number – The port number is used to identify different applications uniquely. It is typically optional.

 InetAddress: Used to represent an IP address.

```java
import java.net.*;

public class InetAddressExample {
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName("www.google.com");
        System.out.println("IP Address: " + address.getHostAddress());
        System.out.println("Host Name: " + address.getHostName());
    }
}
```

DatagramSocket (UDP): For sending and receiving datagrams.

Sender:

```java
import java.net.*;

public class UDPSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        String message = "Hello, UDP Receiver!";
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), address, 5000);
        socket.send(packet);
        socket.close();
    }
}
```

Receiver:

```java
import java.net.*;

public class UDPReceiver {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(5000);
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        socket.receive(packet);
        String message = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received: " + message);

        socket.close();
    }
}
```

## Networking Libraries in Java

1. HTTP and REST APIs: Use the java.net.HttpURLConnection class or third-party libraries like Apache HttpClient, OkHttp, or Spring RestTemplate.
2. NIO (Non-blocking I/O): For scalable network applications, use Java NIO with Selector, Channel, and Buffer.
3. WebSockets: Use Java EE's WebSocket API or third-party libraries like Tyrus for real-time communication.

Key Points About Java 21 and OkHttp

Java 21 supports HTTP/2 through the HttpClient API, just like earlier versions, and it also supports HTTP/3 in a limited experimental mode.
OkHttp (version 4.x and newer) has native support for HTTP/2, HTTP/3, and WebSockets, and it offers more flexibility and advanced features like connection pooling, retry logic, and interceptors.

So while Java 21 supports HTTP/2, OkHttp may still be preferred in some situations due to its additional features and broader support for modern protocols.
What Java 21 Offers Natively:

HTTP/2 support through the HttpClient API (fully supported from Java 11).
HTTP/3 support is now in experimental mode (via the java.net.http client).
Enhanced SSL/TLS support, such as the use of the ALPN (Application-Layer Protocol Negotiation) protocol for negotiating HTTP/2 and HTTP/3 connections.
Asynchronous and synchronous support for requests.
Improvements in performance and security.

What OkHttp Offers Beyond Java 21:

Better HTTP/2 support: OkHttp has fine-tuned HTTP/2 support, including connection multiplexing, header compression, and the ability to make use of features like server push.
HTTP/3 support: OkHttp fully supports HTTP/3 (over QUIC protocol), which Java’s native HttpClient does not support out of the box (though Java 21 introduces experimental HTTP/3 support).
    WebSockets: OkHttp has a robust WebSocket implementation, which Java's native HTTP client only partially supports with its WebSocket API in Java 11+.
    Interceptors: OkHttp’s interceptor mechanism allows for request and response modifications, logging, and custom authentication in a cleaner, more flexible way than Java's native HttpClient.
    Connection pooling and retries: OkHttp manages connections more efficiently with connection pooling and automatic retries for failed requests, which isn't as straightforward in Java's HttpClient.

When to Use OkHttp Over Java 21’s HttpClient:

Advanced features like connection pooling, retry strategies, interceptors for logging or adding custom headers, and WebSockets.
If you're targeting HTTP/3 (OkHttp offers full HTTP/3 support, whereas Java's support is still experimental).
    More control over low-level details like connection management or network configurations.

Using OkHttp with Java 21:

You can still use OkHttp in a Java 21 project. OkHttp works alongside the HttpClient API, and you can choose to use OkHttp for its extended features while using Java’s native client for simpler use cases.

Here’s a basic example of how to integrate OkHttp in a Java 21 project:

Add OkHttp dependency (in Gradle or Maven).

Gradle:

```groovy
implementation 'com.squareup.okhttp3:okhttp:4.11.0'  // Or use the latest version
```

Maven:

```xml
    <dependency>
        <groupId>com.squareup.okhttp3</groupId>
        <artifactId>okhttp</artifactId>
        <version>4.11.0</version>  <!-- Or use the latest version -->
    </dependency>
```

Use OkHttp:

```java
    import okhttp3.OkHttpClient;
    import okhttp3.Request;
    import okhttp3.Response;

    public class OkHttpWithJava21 {
        public static void main(String[] args) {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://httpbin.org/get")
                    .build();

            try (Response response = client.newCall(request).execute()) {
                System.out.println(response.body().string());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
```

Conclusion:

Java 21 provides solid support for HTTP/2 and HTTP/3 (experimental), making it a good choice for many networking tasks.
OkHttp, however, is still a better choice for advanced features like connection pooling, HTTP/3 support, WebSockets, interceptors, and more granular control over the networking behavior.
If you're working on complex, performance-sensitive applications or need full HTTP/3 and WebSocket support, OkHttp is likely the better choice, even in Java 21.

## Client/Server Computing

Java provides the ServerSocket class for creating a server socket and the Socket class for creating a client socket. Two programs on the Internet communicate through
a server socket and a client socket using I/O streams.

Networking is tightly integrated in Java. The Java API provides the classes for creating sockets to facilitate program communications over the Internet.

Sockets are the endpoints of logical connections between two hosts and can be used to send and receive data. Java treats socket communications much as it treats I/O operations; thus, programs can read from or write to sockets as easily as they can read from or write to files.

Network programming usually involves a server and one or more clients. The client sends requests to the server, and the server responds. The client begins by attempting to establish a connection to the server. The server can accept or deny the connection. Once a connection is established, the client and the server communicate through sockets.

The server must be running when a client attempts to connect to the server. The server waits for a connection request from the client.

Java Socket programming is used for communication between the applications running on different JRE. Java Socket programming can be connection-oriented or connection-less.

Socket and ServerSocket classes are used for connection-oriented socket programming and DatagramSocket and DatagramPacket classes are used for connection-less socket programming.

**Server Sockets**:-To establish a server, you need to create a server socket and attach it to a port, which is where the server listens for connections. The port identifies the TCP service on the socket. Port numbers range from 0 to 65536, but port numbers 0 to 1024 are reserved for privileged services.

For every client connecting to server a new socket is created.

Step 1: Create a server socket on a port, e.g.,8000, using the following statement:

```java
ServerSocket serverSocket = new ServerSocket(8000);
```

Step 2: Create a socket to connect to a client,using the following statement:

```java
Socket socket =serverSocket.accept();
```

Step 3: A client program uses the following statement to connect to the server:

```java
Socket socket = new Socket(serverHost, 8000);
```

The server creates a server socket and, once a connection to a client is established, connects to the client with a client socket.

For instance, the email server runs on port 25, and the Web server usually runs on port 80.You can choose any port number that is not currently used by other programs. The following statement creates a server socket serverSocket:

```java
ServerSocket serverSocket = new ServerSocket(port);
```

NOTE:- Attempting to create a server socket on a port already in use would cause a java.net.BindException.

**Client Sockets**:-After a server socket is created, the server can use the following statement to listen for connections:

```java
Socket socket = serverSocket.accept();
```

This statement waits until a client connects to the server socket. The client issues the following statement to request a connection to a server:
connect to client

The client in socket programming must know two information:

1. IP Address of Server
2. Port number.

```java
Socket socket = new Socket(serverName, port);
```

This statement opens a socket so that the client program can communicate with the server.serverName is the server’s Internet host name or IP address. The following statement creates a socket on the client machine to connect to the host 130.254.204.33 at port 8000:

```java
Socket socket = new Socket("130.254.204.33", 8000)
```

Alternatively, you can use the domain name to create a socket, as follows:

```java
Socket socket = new Socket("liang.armstrong.edu", 8000);
```

When you create a socket with a host name, the JVM asks the DNS to translate the host name into the IP address.

NOTE:- A program can use the host name localhost or the IP address 127.0.0.1 to refer to the machine on which a client is running.

If the server is not running, the client program terminates with a java.net.ConnectException. After it is connected, the client gets input and output streams—wrapped by data input and output streams—in order to receive and send data to the server.

**Data Transmission through Sockets**:- After the server accepts the connection, communication between the server and the client is conducted in the same way as for I/O streams. The statements needed to create the streams and to exchange data between them.

To get an input stream and an output stream, use the getInputStream() and getOutputStream() methods on a socket object. For example, the following statements
create an InputStream stream called input and an OutputStream stream called output from a socket:

```java
InputStream input = socket.getInputStream();
OutputStream output = socket.getOutputStream();
```

The InputStream and OutputStream streams are used to read or write bytes. You can use DataInputStream, DataOutputStream, BufferedReader, and PrintWriter to
wrap on the InputStream and OutputStream to read or write data, such as int, double, or String. The following statements, for instance, create the DataInputStream stream
input and the DataOutput stream output to read and write primitive data values:

```java
DataInputStream input = new DataInputStream(socket.getInputStream());
DataOutputStream output = new DataOutputStream(socket.getOutputStream());
```

The server can use input.readDouble() to receive a double value from the client and output.writeDouble(d) to send the double value d to the client.

Recall that binary I/O is more efficient than text I/O because text I/O requires encoding and decoding. Therefore, it is better to use binary I/O for transmitting data between a server and a client to improve performance

## The InetAddress Class

The server program can use the InetAddress class to obtain the information about the IP address and host name for the client.
Occasionally, you would like to know who is connecting to the server. You can use the InetAddress class to find the client’s host name and IP address. The InetAddress class
models an IP address. You can use the following statement in the server program to get an instance of InetAddress on a socket that connects to the client.

```java
InetAddress inetAddress = socket.getInetAddress();
System.out.println("Client's IP Address is " + inetAddress.getHostAddress());
```

You can also create an instance of InetAddress from a host name or IP address using the static getByName method. For example, the following statement creates an InetAddress
for the host liang.armstrong.edu.

```java
InetAddress address = InetAddress.getByName("liang.armstrong.edu");
```

**Serving Multiple Clients**:-A server can serve multiple clients. The connection to each client is handled by one thread.
Multiple clients are quite often connected to a single server at the same time. Typically, a server runs continuously on a server computer, and clients from all over the Internet can connect to it. You can use threads to handle the server’s multiple clients simultaneously—simply create a thread for each connection. Here is how the server handles the establishment of a connection:

```java
while (true) {
Socket socket = serverSocket.accept(); // Connect to a client
Thread thread = new ThreadClass(socket);
thread.start();
}
```

The server socket can have many connections. Each iteration of the while loop creates a new connection. Whenever a connection is established, a new thread is created to handle communication between the server and the new client, and this allows multiple connections to run at the same time.

## Socket Class

A socket is simply an endpoint for communications between the machines. The Socket class can be used to create a socket.

**Important methods :**

- void connect(SocketAddress host, int timeout)|connects the socket to the particularized host|
- int getPort()|returns the port to which the socket is pinned on the remote machine|
- InetAddress getInetAddress()|returns the location of the other computer to which the socket is connected|
- int getLocalPort()|returns the port to which the socket is joined on the local machine|
- SocketAddress getRemoteSocketAddress()|returns the location of the remote socket|
- InputStream getInputStream()|returns the input stream of the socket|
- OutputStream getOutputStream()|returns the output stream of the socket|
- synchronized void close()|closes the socket|

### ServerSocket Class

The ServerSocket class can be used to create a server socket. This object is used to establish communication with the clients.

**Important methods :**

- int getLocalPort()|returns the port that the server socket is monitoring on|
- void setSoTimeout(int timeout)|sets the time-out in which the server socket pauses for a client during the accept() method|
- Socket accept()|waits for an incoming client; returns the socket and establish a connection between server and client|
- void bind(SocketAddress host, int backlog)|bind the socket to the particularized server and port in the object of SocketAddress|
- synchronized void close()|closes the server socket|
