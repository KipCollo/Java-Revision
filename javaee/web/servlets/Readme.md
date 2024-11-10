# Servlet

A servlet is a small Java program that runs within a Web server. Servlets receive and respond to requests from Web clients, usually across HTTP, the HyperText Transfer Protocol.

A servlet is a Java class that runs in a Java-enabled server. An HTTP servlet is a special type of servlet that handles an HTTP request and provides an HTTP response, usually in the form of an HTML page. The most common use of WebLogic HTTP servlets is to create interactive applications using standard Web browsers for the client-side
presentation while WebLogic Server handles the business logic as a server-side process. WebLogic HTTP servlets can access databases, Enterprise JavaBeans,messaging APIs, HTTP sessions, and other facilities of WebLogic Server

## Jakarta Servlet

Jakarta Servlet is a corner stone web framework that can act as a presentation-oriented as well as a service-oriented web application. Jakarta Servlet intends to reduce the boilerplate code needed to convert the HTTP request into a Java object and to offer a Java object as an HTTP response, and to manage all the lifecycle around them.

To implement this interface, you can write a generic servlet that extends javax.servlet.GenericServlet or an HTTP servlet that extends javax.servlet.http.HttpServlet.

This interface defines methods to initialize a servlet, to service requests, and to remove a servlet from the server. These are known as life-cycle methods and are called in the following sequence:

    The servlet is constructed, then initialized with the init method.
    Any calls from clients to the service method are handled.
    The servlet is taken out of service, then destroyed with the destroy method, then garbage collected and finalized. 

A servlet is a java class that xtends HttpServlet class and runs on server within a servlet container.

A servlet is a Java programming language class that directly or indirectly implements the jakarta.servlet.Servlet interface. The jakarta.servlet and jakarta.servlet.http packages provide interfaces and classes for writing servlets. All servlets must implement the jakarta.servlet.Servlet interface, which defines lifecycle methods such as init, service, and destroy

```java
public class StudentServleet extends HttpServlet{

}
```

In a typical Jakarta Servlet based web application, the class must extend jakarta.servlet.http.HttpServlet and override one of the doXxx methods where Xxx represents the HTTP method of interest.

## Loading Servlets, Context Listeners, and Filters

Servlets, Context Listeners, and Filters are loaded and destroyed in the following
order:
Order of loading:

1. Context Listeners
2. Filters
3. Servlets
Order of destruction:

1. Servlets
2. Filters
3. Context Listeners

Servlets and filters are loaded in the same order they are defined in the web.xml file
and unloaded in reverse order. Context listeners are loaded in the following order:

1. All context listeners in the web.xml file in the order as specified in the file
2. Packaged JAR files containing tag library descriptors
3. Tag library descriptors in the WEB-INF directory

### HttpServlet

Provides an abstract class to be subclassed to create an HTTP servlet suitable for a Web site. A subclass of HttpServlet must override at least one method, usually one of these:

 1. doGet, if the servlet supports HTTP GET requests
 2. doPost, for HTTP POST requests
 3. doPut, for HTTP PUT requests
 4. doDelete, for HTTP DELETE requests
 5. init and destroy, to manage resources that are held for the life of the servlet
 6. getServletInfo, which the servlet uses to provide information about itself

There's almost no reason to override the service method. service handles standard HTTP requests by dispatching them to the handler methods for each HTTP request type (the doXXX methods listed above).
Servlets typically run on multithreaded servers, so be aware that a servlet must handle concurrent requests and be careful to synchronize access to shared resources. Shared resources include in-memory data such as instance or class variables and external objects such as files, database connections, and network connections.

```java
public class StudentServleet extends HttpServlet{

    @Override
    public void doPost(HttpRequesst request, HttpResponse response)throws ServletException,IOException
    {
        ...
    }
}
```

### Standalone Servlet Containers

A standalone servlet container is a server that includes built-in support for servlets. Such a container has the advantage that everything works right out of the box. One disadvantage, however, is that you have to wait for a new release of the web server to get the latest servlet support. Another disadvantage is that server vendors generally support only the vendor-provided JVM. Web servers that provide standalone support include those in the following list.

1. Apache's Tomcat Server, the official reference implementation for how a servlet container should support servlets. Written entirely in Java, and freely available under an open source license. All the source code is available and anyone can help with its development. This server can operate standalone or as an add-on providing Apache or other servers with servlet support. It can even be used as an embedded container. Along with Tomcat, Apache develops the standard implementation of the javax.servlet and javax.servlet.http package
2. iPlanet (Netscape) Web Server Enterprise Edition (Version 4.0 and later), perhaps the most popular web server to provide
built-in servlet support. Some benchmarks show this server to have the fastest servlet implementation. Beware that, while
Versions 3.51 and 3.6 of this server had built-in servlet support, those servers supported only the early Servlet API 1.0 and
suffered from a number of bugs so significant the servlet support was practically unusable. To use servlets with Netscape 3.x
servers, use an add-on servlet container.
3. Zeus Web Server, a web server some consider the fastest available. Its feature list is quite long and includes servlet support.
4. Caucho's Resin, an open source container that prides itself on performance. It can run in standalone mode or as an add-on to
many servers
5. Gefion Software's LiteWebServer, a small (just over 100K) servlet container intended for uses, such as bundling with demos, where small size matters.
6. World Wide Web Consortium's Jigsaw Server, open source and written entirely in Java
7. Sun's Java Web Server, the server that started it all. This server was the first server to implement servlets and acted as the
effective reference implementation for Servlet API 2.0. It's written entirely in Java (except for two native code libraries that
enhance its functionality but are not needed). Sun has discontinued development on the server, concentrating now on
iPlanet/Netscape products as part of the Sun-Netscape Alliance.

Application servers are a growing area of development. An application server offers server-side support for developing enterprise-
based applications. Most Java-based application support servlets and the rest of the Java 2, Enterprise Edition, (J2EE)
specification. These servers include:

1. BEA System's WebLogic Application Server, one of the first and most famous Java-based application servers.
2. Orion Application Server, a high-end but relatively low-priced server, written entirely in Java.
3. Enhydra Application Server, an open source server from Lutris.
4. Oracle's Application Server, a server designed for integration with an Oracle database.
5. Silverstream Application Server, a fully compliant J2EE server that also started with a servlet focus.
6. Allaire's JRun Server (formerly from Live Software), a simple servlet container that grew to an advanced container providing
many J2EE technologies including EJB, JTA, and JMS.

### Add-on Servlet Containers

An add-on servlet container functions as a plug-in to an existing server—it adds servlet support to a server that was not originally designed with servlets in mind or to a server with a poor or outdated servlet implementation. Add-on servlet containers have been written for many servers including Apache, iPlanet's FastTrack Server and Enterprise Server, Microsoft's Internet Information Server and Personal Web Server, O'Reilly's WebSite, Lotus Domino's Go Webserver, StarNine's WebSTAR, and Apple's
AppleShare IP. Add-on servlet containers include the following:

1. New Atlanta's ServletExec, a plug-in designed to support servlets on all the popular web servers on all the popular operating
systems. Includes a free debugger.
2. The Java-Apache project's JServ module, a freely available open source servlet container that adds servlet support to the
extremely popular Apache server. Development has completed on JServ, and the Tomcat Server (acting as a plug-in) is the replacement for JServ.
3. Apache's Tomcat Server, as discussed previously, Tomcat may be plugged into other servers including Apache,
iPlanet/Netscape, and IIS.

### Embeddable Servlet Containers

An embeddable container is generally a lightweight servlet deployment platform that can be embedded in another application. That application becomes the true server. Embeddable servlet containers include the following:

1. Apache's Tomcat Server, while generally used standalone or as an add-on, this server also can be embedded into another application when necessary. Because this server is open source, development on most other embeddable containers has stopped.
2. Anders Kristensen's Nexus Web Server, a freely available servlet runner that implements most of the Servlet API and can be easily embedded in Java applications.

## HTTP Basics

Requests, Responses, and Headers
HTTP is a simple, stateless protocol. A client, such as a web browser, makes a request, the web server responds, and the
transaction is done. When the client sends a request, the first thing it specifies is an HTTP command, called a method, that tells the
server the type of action it wants performed. This first line of the request also specifies the address of a document (a URL) and the
version of the HTTP protocol it is using. For example:
GET /intro.html HTTP/1.0
This request uses the GET method to ask for the document named intro.html, using HTTP Version 1.0. After sending the request,
the client can send optional header information to tell the server extra information about the request, such as what software the client
is running and what content types it understands. This information doesn't directly pertain to what was requested, but it could be
used by the server in generating its response. Here are some sample request headers:
User-Agent: Mozilla/4.0 (compatible; MSIE 4.0; Windows 95)
Accept: image/gif, image/jpeg, text/*, */*
The User-Agent header provides information about the client software, while the Accept header specifies the media (MIME)
types that the client prefers to accept. (We'll talk more about request headers in the context of servlets in Chapter 4.) After the
headers, the client sends a blank line, to indicate the end of the header section. The client can also send additional data, if
appropriate for the method being used, as it is with the POST method that we'll discuss shortly. If the request doesn't send any
data, it ends with an empty line.
After the client sends the request, the server processes it and sends a response. The first line of the response is a status line specifing
the version of the HTTP protocol the server is using, a status code, and a description of the status code. For example:
HTTP/1.0 200 OK
This status line includes a status code of 200, which indicates that the request was successful, hence the description OK. Another
common status code is 404, with the description Not Found—as you can guess, this means that the requested document was not
found. Chapter 5 discusses common status codes and how you can use them in servlets, while Appendix D, provides a complete
list of HTTP status codes.
After the status line, the server sends response headers that tell the client things like what software the server is running and the
content type of the server's response. For example:
Date: Saturday, 23-May-00 03:25:12 GMT
Server: Tomcat Web Server/3.2
MIME-version: 1.0
Content-type: text/html
Content-length: 1029
Last-modified: Thursday, 7-May-00 12:15:35 GMT
The Server header provides information about the server software, while the Content-type header specifies the MIME type of
the data included with the response. (We'll also talk more about response headers in Chapter 5.) The server sends a blank line after
the headers, to conclude the header section.
If the request was successful, the requested data is then sent as part of the response. Otherwise, the response may contain human-This document is created with trial version of CHM2PDF Pilot 2.15.72.
readable data that explains why the server couldn't fulfill the request.
2.1.2 GET and POST
When a client connects to a server and makes an HTTP request, the request can be of several different types, called methods. The
most frequently used methods are GET and POST. Put simply, the GET method is designed for getting information (a document, a
chart, or the results from a database query), while the POST method is designed for posting information (a credit card number,
some new chart data, or information that is to be stored in a database). To use a bulletin board analogy, GET is for reading and
POST is for tacking up new material. GET is the method used when you type a URL directly into your browser or click on a
hyperlink; either GET or POST can be used when submitting an HTML form.
The GET method, although it's designed for reading information, can include as part of the request some of its own information that
better describes what to get—such as an x, y scale for a dynamically created chart. This information is passed as a sequence of
characters appended to the request URL in what's called a query string . Placing the extra information in the URL in this way
allows the page to be bookmarked or emailed like any other. Because GET requests theoretically shouldn't need to send large
amounts of information, some servers limit the length of URLs and query strings to about 240 characters.
The POST method uses a different technique to send information to the server because in some cases it may need to send
megabytes of information. A POST request passes all its data, of unlimited length, directly over the socket connection as part of its
HTTP request body. The exchange is invisible to the client. The URL doesn't change at all. Consequently, POST requests cannot
be bookmarked or emailed or, in some cases, even reloaded. That's by design—information sent to the server, such as your credit
card number, should be sent only once. POST also provides a bit of extra security when sending sensitive information because the
server's access log that records all URL accesses won't record the submitted POST data.
In practice, the use of GET and POST has strayed from the original intent. It's common for long parameterized requests for
information to use POST instead of GET to work around problems with overly long URLs. It's also common for simple forms that
upload information to use GET because, well—why not, it works! Generally, this isn't much of a problem. Just remember that GET
requests, because they can be bookmarked so easily, should not be allowed to cause a change on the server for which the client
could be held responsible. In other words, GET requests should not be used to place an order, update a database, or take an
explicit client action in any way.
2.1.3 Other Methods
In addition to GET and POST, there are several other lesser-used HTTP methods. There's the HEAD method, which is sent by a
client when it wants to see only the headers of the response, to determine the document's size, modification time, or general
availability. There's also PUT, to place documents directly on the server, and DELETE, to do just the opposite. These last two
aren't widely supported due to complicated policy issues. The TRACE method is used as a debugging aid—it returns to the client
the exact contents of its request. Finally, the OPTIONS method can be used to ask the server which methods it supports or what
options are available for a particular resource on the server.

## The Servlet API

Servlets use classes and interfaces from two packages: javax.servlet
and javax.servlet.http. The javax.servlet package contains classes and interfaces to support generic, protocol-
independent servlets. These classes are extended by the classes in the javax.servlet.http package to add HTTP-specific
functionality. The top-level package name is javax instead of the familiar java, to indicate that the Servlet API is an Optional
Package (formerly called a Standard Extension).
Every servlet must implement the javax.servlet.Servlet interface. Most servlets implement this interface by extending one of
two special classes: javax.servlet.GenericServlet or javax.servlet.http.HttpServlet. A protocol-independent
servlet should subclass GenericServlet, while an HTTP servlet should subclass HttpServlet, which is itself a subclass of
GenericServlet with added HTTP-specific functionality.

Unlike a regular Java program, and just like an applet, a servlet does not have a main( ) method. Instead, certain methods of a
servlet are invoked by the server in the process of handling requests. Each time the server dispatches a request to a servlet, it
invokes the servlet's service( ) method.

A generic servlet should override its service( ) method to handle requests as appropriate for the servlet. The service( )
method accepts two parameters: a request object and a response object. The request object tells the servlet about the request,
while the response object is used to return a response.

In contrast, an HTTP servlet usually does not override the service( ) method. Instead, it overrides doGet( ) to handle GET
requests and doPost( ) to handle POST requests. An HTTP servlet can override either or both of these methods, depending on
the type of requests it needs to handle. The service( ) method of HttpServlet handles the setup and dispatching to all the
doXXX( ) methods, which is why it usually should not be overridden

An HTTP servlet can override the doPut( ) and doDelete( ) methods to handle PUT and DELETE requests, respectively.
However, HTTP servlets generally don't touch doTrace( ) or doOptions( ). For these, the default implementations are almost
always sufficient.
The remainder in the javax.servlet and javax.servlet.http packages are largely support classes. For example, the
ServletRequest and ServletResponse classes in javax.servlet provide access to generic server requests and responses,while HttpServletRequest and HttpServletResponse in javax.servlet.http provide access to HTTP requests and
responses. The javax.servlet.http package also contains an HttpSession interface that provides built-in session tracking
functionality and a Cookie class that allows you to quickly set up and process HTTP cookies.

## Page Generation

The most basic type of HTTP servlet generates a full HTML page. Such a servlet has access to the same information usually sent to
a CGI script, plus a bit more. A servlet that generates an HTML page can be used for all the tasks for which CGI is used currently,
such as for processing HTML forms, producing reports from a database, taking orders, checking identities, and so forth.

```java

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class HelloWorld extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {
res.setContentType("text/html");
PrintWriter out = res.getWriter();
out.println("<HTML>");
out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
out.println("<BODY>");
out.println("<BIG>Hello World</BIG>");
out.println("</BODY></HTML>");
}
}
```

This servlet extends the HttpServlet class and overrides the doGet( ) method inherited from it. Each time the web server
receives a GET request for this servlet, the server invokes this doGet( ) method, passing it an HttpServletRequest object and
an HttpServletResponse object.
The HttpServletRequest represents the client's request. This object gives a servlet access to information about the client, the
parameters for this request, the HTTP headers passed along with the request

The HttpServletResponse represents the servlet's response. A servlet can use this object to return data to the client. This data
can be of any content type, though the type should be specified as part of the response. A servlet can also use this object to set
HTTP response headers.

