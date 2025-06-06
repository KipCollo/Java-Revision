# Java Security

Java EE, web, and web services applications are made up of components that can be deployed into different containers. These components are used to build a multitier enterprise application. Security for components is provided by their containers. A container provides two kinds of security: declarative and programmatic security.

* Declarative security expresses an application component’s security requirements using deployment descriptors. Deployment descriptors are external to an application, and include information that specifies how security roles and access requirements are mapped into environment-specific security roles, users, and policies.

Annotations (also called metadata) are used to specify information about security within a class file. When the application is deployed, this information can either be used by or overridden by the application deployment descriptor. Annotations save your from having to write declarative information inside XML descriptors. Instead, you just put annotations on the code and the required information gets generated.

* Programmatic security is embedded in an application and is used to make security decisions. Programmatic security is useful when declarative security alone is not sufficient to express the security model of an application.

## Security Functions

A properly implemented security mechanism will provide the following functionality:

- Prevent unauthorized access to application functions and business or personal data
- Hold system users accountable for operations they perform (non-repudiation)
- Protect a system from service interruptions and other breaches that affect quality of service

Ideally, properly implemented security mechanisms will also provide the following functionality:

- Easy to administer
- Transparent to system users
- Interoperable across application and enterprise boundaries

## Characteristics of Application Security

Java EE applications consist of components that can contain both protected and unprotected resources. Often, you need to protect resources to ensure that only authorized users have access. Authorization provides controlled access to protected resources. Authorization is based on identification and authentication. Identification is a process that enables recognition of an entity by a system, and authentication is a process that verifies the identity of a user, device, or other entity in a computer system, usually as a prerequisite to allowing access to resources in a system.

Authorization and authentication are not required for an entity to access unprotected resources. Accessing a resource without authentication is referred to as unauthenticated or anonymous access.

These and several other well-defined characteristics of application security that, when properly addressed, help to minimize the security threats faced by an enterprise, include the following:

1. Authentication: The means by which communicating entities (for example, client and server) prove to one another that they are acting on behalf of specific identities that are authorized for access. This ensures that users are who they say they are.
2. Authorization, or Access Control: The means by which interactions with resources are limited to collections of users or programs for the purpose of enforcing integrity, confidentiality, or availability constraints. This ensures that users have permission to perform operations or access data.
3. Data integrity: The means used to prove that information has not been modified by a third party (some entity other than the source of the information). For example, a recipient of data sent over an open network must be able to detect and discard messages that were modified after they were sent. This ensures that only authorized users can modify data.
4. Confidentiality or Data Privacy: The means used to ensure that information is made available only to users who are authorized to access it. This ensures that only authorized users can view sensitive data.
5. Non-repudiation: The means used to prove that a user performed some action such that the user cannot reasonably deny having done so. This ensures that transactions can be proven to have happened.
6. Quality of Service (QoS): The means used to provide better service to selected network traffic over various technologies.
7. Auditing: The means used to capture a tamper-resistant record of security-related events for the purpose of being able to evaluate the effectiveness of security policies and mechanisms. To enable this, the system maintains a record of transactions and security information.

## Java SE Security Implementation Mechanisms

Java SE provides support for a variety of security features and mechanisms, including:

1. Java Authentication and Authorization Service (JAAS): JAAS is a set of APIs that enable services to authenticate and enforce access controls upon users. JAAS provides a pluggable and extensible framework for programmatic user authentication and authorization. JAAS is a core Java SE API and is an underlying technology for Java EE security mechanisms.
2. Java Generic Security Services (Java GSS-API): Java GSS-API is a token-based API used to securely exchange messages between communicating applications. The GSS-API offers application programmers uniform access to security services atop a variety of underlying security mechanisms, including Kerberos.
3. Java Cryptography Extension (JCE): JCE provides a framework and implementations for encryption, key generation and key agreement, and Message Authentication Code (MAC) algorithms. Support for encryption includes symmetric, asymmetric, block, and stream ciphers. Block ciphers operate on groups of bytes while stream ciphers operate on one byte at a time. The software also supports secure streams and sealed objects.
4. Java Secure Sockets Extension (JSSE): JSSE provides a framework and an implementation for a Java version of the SSL and TLS protocols and includes functionality for data encryption, server authentication, message integrity, and optional client authentication to enable secure Internet communications.
5. Simple Authentication and Security Layer (SASL): SASL is an Internet standard (RFC 2222) that specifies a protocol for authentication and optional establishment of a security layer between client and server applications. SASL defines how authentication data is to be exchanged but does not itself specify the contents of that data. It is a framework into which specific authentication mechanisms that specify the contents and semantics of the authentication data can fit.

## Java EE Security Implementation Mechanisms

Java EE security services are provided by the component container and can be implemented using declarative or programmatic techniques (container security is discussed more in Securing Containers). Java EE security services provide a robust and easily configured security mechanism for authenticating users and authorizing access to application functions and associated data at many different layers. Java EE security services are separate from the security mechanisms of the operating system.
Application-Layer Security

In Java EE, component containers are responsible for providing application-layer security. Application-layer security provides security services for a specific application type tailored to the needs of the application. At the application layer, application firewalls can be employed to enhance application protection by protecting the communication stream and all associated application resources from attacks.

Java EE security is easy to implement and configure, and can offer fine-grained access control to application functions and data. However, as is inherent to security applied at the application layer, security properties are not transferable to applications running in other environments and only protect data while it is residing in the application environment. In the context of a traditional application, this is not necessarily a problem, but when applied to a web services application, where data often travels across several intermediaries, you would need to use the Java EE security mechanisms along with transport-layer security and message-layer security for a complete security solution.

The advantages of using application-layer security include the following:

1. Security is uniquely suited to the needs of the application.
2. Security is fine-grained, with application-specific settings.

The disadvantages of using application-layer security include the following:

1. The application is dependent on security attributes that are not transferable between application types.
2. Support for multiple protocols makes this type of security vulnerable.
3. Data is close to or contained within the point of vulnerability.

For more information on providing security at the application layer, read Securing Containers.

1. Transport-Layer Security

Transport-layer security is provided by the transport mechanisms used to transmit information over the wire between clients and providers, thus transport-layer security relies on secure HTTP transport (HTTPS) using Secure Sockets Layer (SSL). Transport security is a point-to-point security mechanism that can be used for authentication, message integrity, and confidentiality. When running over an SSL-protected session, the server and client can authenticate one another and negotiate an encryption algorithm and cryptographic keys before the application protocol transmits or receives its first byte of data. Security is “live” from the time it leaves the consumer until it arrives at the provider, or vice versa, even across intermediaries. The problem is that it is not protected once it gets to its destination. One solution is to encrypt the message before sending.

2. Transport-layer security is performed in a series of phases, which are listed here:

    The client and server agree on an appropriate algorithm.

    A key is exchanged using public-key encryption and certificate-based authentication.

    A symmetric cipher is used during the information exchange.

Digital certificates are necessary when running secure HTTP transport (HTTPS) using Secure Sockets Layer (SSL). The HTTPS service of most web servers will not run unless a digital certificate has been installed. Digital certificates have already been created for the Application Server. If you are using a different server, use the procedure outlined in Working with Digital Certificates to set up a digital certificate that can be used by your web or application server to enable SSL.

The advantages of using transport-layer security include the following:

    Relatively simple, well understood, standard technology.

    Applies to message body and attachments.

The disadvantages of using transport-layer security include the following:

    Tightly-coupled with transport-layer protocol.

    All or nothing approach to security. This implies that the security mechanism is unaware of message contents, and as such, you cannot selectively apply security to portions of the message as you can with message-layer security.

    Protection is transient. The message is only protected while in transit. Protection is removed automatically by the endpoint when it receives the message.

    Not an end-to-end solution, simply point-to-point.

For more information on transport-layer security, read Establishing a Secure Connection Using SSL.
3. Message-Layer Security

In message-layer security, security information is contained within the SOAP message and/or SOAP message attachment, which allows security information to travel along with the message or attachment. For example, a portion of the message may be signed by a sender and encrypted for a particular receiver. When the message is sent from the initial sender, it may pass through intermediate nodes before reaching its intended receiver. In this scenario, the encrypted portions continue to be opaque to any intermediate nodes and can only be decrypted by the intended receiver. For this reason, message-layer security is also sometimes referred to as end-to-end security.

The advantages of message-layer security include the following:

    Security stays with the message over all hops and after the message arrives at its destination.

    Security can be selectively applied to different portions of a message (and to attachments if using XWSS).

    Message security can be used with intermediaries over multiple hops.

    Message security is independent of the application environment or transport protocol.

The disadvantage of using message-layer security is that it is relatively complex and adds some overhead to processing.

The Application Server supports message security. It uses Web Services Security (WSS) to secure messages. Because this message security is specific to the Application Server and not a part of the Java EE platform, this tutorial does not discuss using WSS to secure messages.

Securing Containers

In Java EE, the component containers are responsible for providing application security. A container provides two types of security: declarative and programmatic. The following sections discuss these concepts in more detail.
Using Deployment Descriptors for Declarative Security

Declarative security expresses an application component’s security requirements using deployment descriptors. A deployment descriptor is an XML document with an .xml extension that describes the deployment settings of an application, a module, or a component. Because deployment descriptor information is declarative, it can be changed without the need to modify the source code. At runtime, the Java EE server reads the deployment descriptor and acts upon the application, module, or component accordingly.

This tutorial does not document how to write the deployment descriptors from scratch, only what configurations each example requires its deployment descriptors to define. For help with writing deployment descriptors, you can view the provided deployment descriptors in a text editor. Each example’s deployment descriptors are stored at the top layer of each example’s directory. Another way to learn how to write deployment descriptors is to read the specification in which the deployment descriptor elements are defined.

Deployment descriptors must provide certain structural information for each component if this information has not been provided in annotations or is not to be defaulted.

Different types of components use different formats, or schema, for their deployment descriptors. The security elements of deployment descriptors which are discussed in this tutorial include the following:

    Enterprise JavaBeans components use an EJB deployment descriptor that must be named META-INF/ejb-jar.xml and must be contained in the EJB JAR file.

    The schema for enterprise bean deployment descriptors is provided in the EJB 3.0 Specification (JSR-220), Chapter 18.5, Deployment Descriptor XML Schema, which can be downloaded from http://jcp.org/en/jsr/detail?id=220.

    Security elements for EJB deployment descriptors are discussed in this tutorial in the section Using Enterprise Bean Security Deployment Descriptor Elements.

    Web Services components use a jaxrpc-mapping-info deployment descriptor defined in JSR 109. This deployment descriptor provides deployment-time mapping functionality between Java and WSDL. In conjunction with JSR 181, JAX-WS 2.0 complements this mapping functionality with development-time Java annotations that control mapping between Java and WSDL.

    The schema for web services deployment descriptors is provided in Web Services for Java EE (JSR-109), section 7.1, Web Services Deployment Descriptor XML Schema, which can be downloaded from http://jcp.org/en/jsr/detail?id=109.

    Schema elements for web application deployment descriptors are discussed in this tutorial in the section Declaring Security Requirements in a Deployment Descriptor.

    Web components use a web application deployment descriptor named web.xml.

    The schema for web component deployment descriptors is provided in the Java Servlet 2.5 Specification (JSR-154), section SRV.13, Deployment Descriptor, which can be downloaded from http://jcp.org/en/jsr/detail?id=154.

    Security elements for web application deployment descriptors are discussed in this tutorial in the section Declaring Security Requirements in a Deployment Descriptor.

Using Annotations

Annotations enable a declarative style of programming, and so encompass both the declarative and programmatic security concepts. Users can specify information about security within a class file using annotations. When the application is deployed, this information is used by the Application Server. Not all security information can be specified using annotations, however. Some information must be specified in the application deployment descriptors.

Annotations let you avoid writing boilerplate code under many circumstances by enabling tools to generate it from annotations in the source code. This leads to a declarative programming style, where the programmer says what should be done and tools emit the code to do it. It also eliminates the need for maintaining side files that must be kept up to date with changes in source files. Instead the information can be maintained in the source file.

In this tutorial, specific annotations that can be used to specify security information within a class file are described in the following sections:

    Declaring Security Requirements Using Annotations

    Using Enterprise Bean Security Annotations

The following are sources for more information on annotations:

    JSR 175: A Metadata Facility for the Java Programming Language

    JSR 181: Web Services Metadata for the Java Platform

    JSR 250: Common Annotations for the Java Platform

    The Java SE discussion of annotations

Links to this information are provided in Further Information about Security.
Using Programmatic Security

Programmatic security is embedded in an application and is used to make security decisions. Programmatic security is useful when declarative security alone is not sufficient to express the security model of an application. The API for programmatic security consists of two methods of the EJBContext interface and two methods of the servlet HttpServletRequest interface. These methods allow components to make business logic decisions based on the security role of the caller or remote user.

Programmatic security is discussed in more detail in the following sections:

    Accessing an Enterprise Bean Caller's Security Context

    Working with Security Roles

## Securing Java EE Applications

Java EE applications are made up of components that can be deployed into different containers. These components are used to build multitier enterprise applications. Security services are provided by the component container and can be implemented using declarative or programmatic techniques. Java EE security services provide a robust and easily configured security mechanism for authenticating users and authorizing access to application functions and associated data. Java EE security services are separate from the security mechanisms of the operating system.

The ways to implement Java EE security services are discussed in a general way in Securing Containers. This chapter provides more detail and a few examples that explore these security services as they relate to Java EE components. Java EE security services can be implemented in the following ways:

    Metadata annotations (or simply, annotations) enable a declarative style of programming. Users can specify information about security within a class file using annotations. When the application is deployed, this information can either be used by or overridden by the application deployment descriptor.

    Declarative security expresses an application’s security structure, including security roles, access control, and authentication requirements in a deployment descriptor, which is external to the application.

    Any values explicitly specified in the deployment descriptor override any values specified in annotations.

    Programmatic security is embedded in an application and is used to make security decisions. Programmatic security is useful when declarative security alone is not sufficient to express the security model of an application.

## Securing Web Applications

Web applications contain resources that can be accessed by many users. These resources often traverse unprotected, open networks, such as the Internet. In such an environment, a substantial number of web applications will require some type of security.

The ways to implement security for Java EE applications are discussed in a general way in Securing Containers. This chapter provides more detail and a few examples that explore these security services as they relate to web components.

Java EE security services can be implemented for web applications in the following ways:

    Metadata annotations (or simply, annotations) are used to specify information about security within a class file. When the application is deployed, this information can either be used by or overridden by the application deployment descriptor.

    Declarative security expresses an application’s security structure, including security roles, access control, and authentication requirements in a deployment descriptor, which is external to the application.

    Any values explicitly specified in the deployment descriptor override any values specified in annotations.

    Programmatic security is embedded in an application and is used to make security decisions. Programmatic security is useful when declarative security alone is not sufficient to express the security model of an application.

### Overview of Web Application Security

In the Java EE platform, web components provide the dynamic extension capabilities for a web server. Web components are either Java servlets, JSP pages, JSF pages, or web service endpoints.

Web components are supported by the services of a runtime platform called a web container. A web container provides services such as request dispatching, security, concurrency, and life-cycle management.

Certain aspects of web application security can be configured when the application is installed, or deployed, to the web container. Annotations and/or deployment descriptors are used to relay information to the deployer about security and other aspects of the application. Specifying this information in annotations or in the deployment descriptor helps the deployer set up the appropriate security policy for the web application. Any values explicitly specified in the deployment descriptor override any values specified in annotations. This chapter provides more information on configuring security for web applications.

For secure transport, most web applications use the HTTPS protocol.

Working with Security Roles

If you read Working with Realms, Users, Groups, and Roles, you will remember the following definitions:

    In applications, roles are defined using annotations or in application deployment descriptors such as web.xml, ejb-jar.xml, and application.xml.

    A role is an abstract name for the permission to access a particular set of resources in an application. For more information, read What Is a Role?.

    For more information on defining roles, see Declaring Security Roles.

    On the Application Server, the following options are configured using the Admin Console:

        A realm is a complete database of users and groups that identify valid users of a web application (or a set of web applications) and are controlled by the same authentication policy. For more information, read What Is a Realm?.

        A user is an individual (or application program) identity that has been defined in the Application Server. On the Application Server, a user generally has a user name, a password, and, optionally, a list of groups to which this user has been assigned. For more information, read What Is a User?.

        A group is a set of authenticated users, classified by common traits, defined in the Application Server. For more information, read What Is a Group?.

        A principal is an entity that can be authenticated by an authentication protocol in a security service that is deployed in an enterprise.

        For more information on configuring users on the Application Server, read Managing Users and Groups on the Application Server.

    During deployment, the deployer takes the information provided in the application deployment descriptor and maps the roles specified for the application to users and groups defined on the server using the Application Server deployment descriptors sun-web.xml, sun-ejb-jar.xml, or sun-application.xml.

    For more information, read Mapping Security Roles to Application Server Groups.

Declaring Security Roles

You can declare security role names used in web applications using either the @DeclareRoles annotation (preferred) or the security-role-ref elements of the deployment descriptor. Declaring security role names in this way enables you to link the security role names used in the code to the security roles defined for an assembled application. In the absence of this linking step, any security role name used in the code will be assumed to correspond to a security role of the same name in the assembled application.

A security role reference, including the name defined by the reference, is scoped to the component whose class contains the @DeclareRoles annotation or whose deployment descriptor element contains the security-role-ref deployment descriptor element.

You can also use the security-role-ref elements for those references that were declared in annotations and you want to have linked to a security-role whose name differs from the reference value. If a security role reference is not linked to a security role in this way, the container must map the reference name to the security role of the same name. See Declaring and Linking Role References for a description of how security role references are linked to security roles.

For an example using each of these methods, read the following sections:

    Specifying Security Roles Using Annotations

    Specifying Security Roles Using Deployment Descriptor Elements

Specifying Security Roles Using Annotations

Annotations are the best way to define security roles on a class or a method. The @DeclareRoles annotation is used to define the security roles that comprise the security model of the application. This annotation is specified on a class, and it typically would be used to define roles that could be tested (for example, by calling isUserInRole) from within the methods of the annotated class.

Following is an example of how this annotation would be used. In this example, employee is the only security role specified, but the value of this parameter can include a list of security roles specified by the application.

@DeclareRoles("employee")
public class CalculatorServlet {
    //...
}

Specifying @DeclareRoles("employee") is equivalent to defining the following in the web.xml:

<security-role>
    <role-name>employee</role-name>
</security-role>

This annotation is not used to link application roles to other roles. When such linking is necessary, it is accomplished by defining an appropriate security-role-ref in the associated deployment descriptor, as described in Declaring and Linking Role References.

When a call is made to isUserInRole from the annotated class, the caller identity associated with the invocation of the class is tested for membership in the role with the same name as the argument to isUserInRole. If a security-role-ref has been defined for the argument role-name, the caller is tested for membership in the role mapped to the role-name.
Specifying Security Roles Using Deployment Descriptor Elements

The following snippet of a deployment descriptor is taken from the simple sample application. This snippet includes all of the elements needed to specify security roles using deployment descriptors:

<servlet>
     ...
    <security-role-ref>
        <role-name>MGR</role-name>
        <!-- role name used in code -->
        <role-link>employee</role-link>
    </security-role-ref>
</servlet>

<security-constraint>
    <web-resource-collection>
        <web-resource-name>Protected Area</web-resource-name>
        <url-pattern>/jsp/security/protected/*</url-pattern>
        <http-method>PUT</http-method>
        <http-method>DELETE</http-method>
        <http-method>GET</http-method>
        <http-method>POST</http-method>
    </web-resource-collection>
    <auth-constraint>
        <role-name>role1</role-name>
        <role-name>employee</role-name>
    </auth-constraint>
</security-constraint>

 <!-- Security roles referenced by this web application -->
<security-role>
    <role-name>role1</role-name>
</security-role>
<security-role>
    <role-name>employee</role-name>
</security-role>

In this example, the security-role element lists all of the security roles used in the application: role1 and employee. This enables the deployer to map all of the roles defined in the application to users and groups defined on the Application Server.

The auth-constraint element specifies the roles (role1, employee) that can access HTTP methods (PUT, DELETE, GET, POST) located in the directory specified by the url-pattern element (/jsp/security/protected/*). You could also have used the @DeclareRoles annotation in the source code to accomplish this task.

The security-role-ref element is used when an application uses the HttpServletRequest.isUserInRole(String role) method. The value of the role-name element must be the String used as the parameter to the HttpServletRequest.isUserInRole(String role) method. The role-link must contain the name of one of the security roles defined in the security-role elements. The container uses the mapping of security-role-ref to security-role when determining the return value of the call.
Mapping Security Roles to Application Server Groups

To map security roles to Application Server principals and groups, use the security-role-mapping element in the runtime deployment descriptor (DD). The runtime deployment descriptor is an XML file that contains information such as the context root of the web application and the mapping of the portable names of an application’s resources to the Application Server’s resources. The Application Server web application runtime DD is located in /WEB-INF/ along with the web application DD. Runtime deployment descriptors are named sun-web.xml, sun-application.xml, or sun-ejb-jar.xml.

The following example demonstrates how to do this mapping:

<sun-web-app>

      <security-role-mapping>
        <role-name>CEO</role-name>
        <principal-name>smcneely</principal-name>
    </security-role-mapping>

    <security-role-mapping>
        <role-name>Admin</role-name>
        <group-name>director</group-name>
    </security-role-mapping>

    ...

</sun-web-app>

A role can be mapped to specific principals, specific groups, or both. The principal or group names must be valid principals or groups in the current default realm. The role-name element must match the role-name in the security-role element of the corresponding application deployment descriptor (web.xml, ejb-jar.xml) or the role name defined in the @DeclareRoles annotation.

Sometimes the role names used in the application are the same as the group names defined on the Application Server. Under these circumstances, you can use the Admin Console to define a default principal to role mapping that apply to the entire Application Server instance. From the Admin Console, select Configuration, then Security, then check the enable box beside Default Principal to Role Mapping.

Security is the science of keeping sensitive information in the hands of authorized users. On the Web, this boils down to four
important issues:

1. Authentication-Being able to verify the identities of the parties involved
2. Authorization-Limiting access to resources to a select set of users or programs
3. Confidentiality-Ensuring that only the parties involved can understand the communication
4. Integrity-Being able to verify that the content of the communication is not changed during transmission

Authentication, authorization, confidentiality, and integrity are all linked by digital certificate technology. Digital certificates allow web
servers and clients to use advanced cryptographic techniques to handle identification and encryption in a secure manner. Thanks to
Java's built-in support for digital certificates, servlets are an excellent platform for deploying secure web applications that use digital
certificate technology.

Security is also about making sure that crackers can't gain access to the sensitive data on your web server. Because Java was
designed from the ground up as a secure, network-oriented language, it is possible to leverage the built-in security features and
make sure that server add-ons from third parties are almost as safe as the ones you write yourself.

## HTTP Authentication

HTTP protocol provides built-in authentication support—called basic authentication—
based on a simple challenge/response, username/password model. With this technique, the web server maintains a database of
usernames and passwords and identifies certain resources (files, directories, servlets, etc.) as protected. When a user requests
access to a protected resource, the server responds with a request for the client's username and password. At this point, the
browser usually pops up a dialog box where the user enters the information, and that input is sent back to the server as part of a
second authorized request. If the submitted username and password match the information in the server's database, access is
granted. The whole authentication process is handled by the server itself.

Basic authentication alone is very weak. It provides no confidentiality, no integrity, and only the most basic authentication. The
problem is that passwords are transmitted over the network, thinly disguised by a well-known and easily reversed Base64
encoding. Anyone monitoring the TCP/IP data stream has full and immediate access to all the information being exchanged,
including the username and password, unless there is additional SSL encryption employed (as discussed later in the chapter). Plus,
passwords are often stored on the server in clear text, making them vulnerable to anyone cracking into the server's filesystem. While
it's certainly better than nothing, sites that rely exclusively on basic authentication cannot be considered really secure.

Digest authentication is a variation on the basic authentication scheme. Instead of transmitting a password over the network
directly, a digest of the password is used instead. The digest is produced by taking a hash (using the very secure MD5 encryption
algorithm) of the username, password, URI, HTTP request method, and a randomly generated nonce value provided by the server.
Both sides of the transaction know the password and use it to compute digests. If the digests match, access is granted. Transactions
are thus somewhat more secure than they would be otherwise because digests are valid for only a single URI request and nonce
value. The server, however, must still maintain a database of the original passwords. And, as of this writing, digest authentication is
not supported by very many browsers.

### Configuring HTTP Authentication

In versions of the Servlet API before 2.2, the technique for configuring authentication varied depending on the server. Beginning
with API 2.2, the technique has been standardized and now configuration of security policies can be accomplished in a portable
manner using the web.xml deployment descriptor.

there are two caveats to this portability. First, a web server is not required to implement the Servlet API 2.2
security mechanism to be considered Servlet API 2.2 compliant. Implementing the full security portion of the specification is quite
involved, and a servlet container is allowed to implement only a portion of the security mechanism, or even none at all. The only
servers required to implement the full security mechanism are those wishing to be compliant with the more advanced Java 2,
Enterprise Edition (J2EE) specification, of which the Servlet API is but one part. Second, security is one of the newest and least
understood aspects of Servlet API 2.2, and web servers have varied somewhat on their implementations of these mechanisms.
Over time that will settle down, but in the meanwhile, to ensure your site remains secure, make sure you test everything at least once
when migrating between servers.

#### Role-based authentication

Using tags in the web application deployment descriptor, security constraints can be set up to indicate that certain pages in the web
application are to be accessed only by users with certain credentials. Servlets use role-based authorization to manage access. With
this model, access permissions are granted to an abstract entity called a security role , and access is allowed only to users or
groups of users who are part of that given role. For example, you might want to set up your site so that pages that display salary
information are restricted to only those users who are in a "manager" role.
The deployment descriptor specifies the type of access granted to each role, but does not specify that role to user or group
mapping. That's done during deployment of the application, using server-specific tools. The ultimate mapping may come from many
locations—text files, database tables, the operating system, and so on.

conf/tomcat-users.xml

```xml
<tomcat-users>
<user name="Dilbert"
password="dnrc"
roles="engineer" />
<user name="Wally"
password="iluvalice"
roles="engineer,slacker" />
<user name="MrPointyHair" password="MrPointyHair" roles="manager,slacker" />
</tomcat-users>
```

## Form-Based Authentication

Servlets can also perform authentication without relying on HTTP authentication, by using HTML forms instead. Using this
technique allows users to enter your site through a well-designed, descriptive and friendly login page.Many banks and other online services have chosen to use form-based authentication. Implementing such a system is relatively
straightforward with servlets because form-based authentication is built into Servlet API 2.2.

```xml

<login-config>
<auth-method>
FORM
<!-- BASIC, DIGEST, FORM, CLIENT-CERT -->
</auth-method>
<form-login-config> <!-- only useful for FORM -->
<form-login-page>
/loginpage.html
</form-login-page>
<form-error-page>
/errorpage.html
</form-error-page>
</form-login-config>
</login-config>
```

## Custom Authentication

Normally, client authentication is handled by the web server. The deployment descriptor tells the server which resources are to be
restricted to which roles, and the server somehow manages the user/group to role mapping.
This is often good enough. Sometimes, however, the desired security policy cannot be implemented by the server. Maybe the user
list needs to be stored in a format that is not readable by the server. Or maybe you want any username to be allowed, as long as it
is given with the appropriate "skeleton key" password. To handle these situations, we can use servlets. A servlet can be
implemented so that it learns about users from a specially formatted file or a relational database; it can also be written to enforce any
security policy you like. Such a servlet can even add, remove, or manipulate user entries—something that isn't supported directly in
the Servlet API, except through proprietary server extensions.

A servlet uses status codes and HTTP headers to manage its own basic authentication security policy. The servlet receives encoded
user credentials in the Authorization header. If it chooses to deny those credentials, it does so by sending the
SC_UNAUTHORIZED status code and a WWW-Authenticate header that describes the desired credentials. A web server normally
handles these details without involving its servlets, but for a servlet to do its own authorization, it must handle these details itself,
while the server is told not to restrict access to the servlet.
