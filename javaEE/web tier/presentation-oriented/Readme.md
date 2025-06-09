# WebApps


## Standalone Servlet Containers

A `standalone servlet container` is a server that includes built-in support for servlets. Such a container has the advantage that everything works right out of the box. One disadvantage, however, is that you have to wait for a new release of the web server to get the latest servlet support. Another disadvantage is that server vendors generally support only the vendor-provided JVM. Web servers that provide standalone support include those in the following list.

1. Apache's Tomcat Server, the official reference implementation for how a servlet container should support servlets. Written entirely in Java, and freely available under an open source license. All the source code is available and anyone can help with its development. This server can operate standalone or as an add-on providing Apache or other servers with servlet support. It can even be used as an embedded container. Along with Tomcat, Apache develops the standard implementation of the javax.servlet and javax.servlet.http package
2. iPlanet (Netscape) Web Server Enterprise Edition (Version 4.0 and later), perhaps the most popular web server to provide built-in servlet support. Some benchmarks show this server to have the fastest servlet implementation. Beware that, while Versions 3.51 and 3.6 of this server had built-in servlet support, those servers supported only the early Servlet API 1.0 and suffered from a number of bugs so significant the servlet support was practically unusable. To use servlets with Netscape 3.x servers, use an add-on servlet container.
3. Zeus Web Server, a web server some consider the fastest available. Its feature list is quite long and includes servlet support.
4. Caucho's Resin, an open source container that prides itself on performance. It can run in standalone mode or as an add-on to many servers
5. Gefion Software's LiteWebServer, a small (just over 100K) servlet container intended for uses, such as bundling with demos, where small size matters.
6. World Wide Web Consortium's Jigsaw Server, open source and written entirely in Java
7. Sun's Java Web Server, the server that started it all. This server was the first server to implement servlets and acted as the effective reference implementation for Servlet API 2.0. It's written entirely in Java (except for two native code libraries that enhance its functionality but are not needed). Sun has discontinued development on the server, concentrating now on iPlanet/Netscape products as part of the Sun-Netscape Alliance.

`Application servers` are a growing area of development. An application server offers server-side support for developing enterprise-
based applications. Most Java-based application support servlets and the rest of the Java 2, Enterprise Edition, (J2EE)
specification. These servers include:

1. BEA System's WebLogic Application Server, one of the first and most famous Java-based application servers.
2. Orion Application Server, a high-end but relatively low-priced server, written entirely in Java.
3. Enhydra Application Server, an open source server from Lutris.
4. Oracle's Application Server, a server designed for integration with an Oracle database.
5. Silverstream Application Server, a fully compliant J2EE server that also started with a servlet focus.
6. Allaire's JRun Server (formerly from Live Software), a simple servlet container that grew to an advanced container providing
many J2EE technologies including EJB, JTA, and JMS.

`Add-on Servlet Containers`:- An add-on servlet container functions as a plug-in to an existing server—it adds servlet support to a server that was not originally designed with servlets in mind or to a server with a poor or outdated servlet implementation. Add-on servlet containers have been written for many servers including Apache, iPlanet's FastTrack Server and Enterprise Server, Microsoft's Internet Information Server and Personal Web Server, O'Reilly's WebSite, Lotus Domino's Go Webserver, StarNine's WebSTAR, and Apple's
AppleShare IP. Add-on servlet containers include the following:

1. New Atlanta's ServletExec, a plug-in designed to support servlets on all the popular web servers on all the popular operating
systems. Includes a free debugger.
2. The Java-Apache project's JServ module, a freely available open source servlet container that adds servlet support to the
extremely popular Apache server. Development has completed on JServ, and the Tomcat Server (acting as a plug-in) is the replacement for JServ.
3. Apache's Tomcat Server, as discussed previously, Tomcat may be plugged into other servers including Apache,
iPlanet/Netscape, and IIS.

`Embeddable Servlet Containers`:-An embeddable container is generally a lightweight servlet deployment platform that can be embedded in another application. That application becomes the true server. Embeddable servlet containers include the following:

1. Apache's Tomcat Server, while generally used standalone or as an add-on, this server also can be embedded into another application when necessary. Because this server is open source, development on most other embeddable containers has stopped.
2. Anders Kristensen's Nexus Web Server, a freely available servlet runner that implements most of the Servlet API and can be easily embedded in Java applications.

