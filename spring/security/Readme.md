# Spring Security

Spring Security provides comprehensive security services for J2EE-based enterprise software applications. 

security features of J2EE's Servlet Specification or EJB Specification lack the depth required for typical
enterprise application scenarios. Whilst mentioning these standards, it's important to recognise that they
are not portable at a WAR or EAR level. Therefore, if you switch server environments, it is typically a lot
of work to reconfigure your application's security in the new target environment. Using Spring Security
overcomes these problems, and also brings you dozens of other useful, customisable security features

Two main areas that Spring Security targets. “Authentication” is
the process of establishing a principal is who they claim to be (a “principal” generally means a user,
device or some other system which can perform an action in your application). “Authorization” refers
to the process of deciding whether a principal is allowed to perform an action within your application.
To arrive at the point where an authorization decision is needed, the identity of the principal has already
been established by the authentication process

Spring Security
3.0.8.RELEASE 2
1.1 What is Spring Security?
Spring Security provides comprehensive security services for J2EE-based enterprise software
applications. There is a particular emphasis on supporting projects built using The Spring Framework,
which is the leading J2EE solution for enterprise software development. If you're not using Spring for
developing enterprise applications, we warmly encourage you to take a closer look at it. Some familiarity
with Spring - and in particular dependency injection principles - will help you get up to speed with
Spring Security more easily.
People use Spring Security for many reasons, but most are drawn to the project after finding the
security features of J2EE's Servlet Specification or EJB Specification lack the depth required for typical
enterprise application scenarios. Whilst mentioning these standards, it's important to recognise that they
are not portable at a WAR or EAR level. Therefore, if you switch server environments, it is typically a lot
of work to reconfigure your application's security in the new target environment. Using Spring Security
overcomes these problems, and also brings you dozens of other useful, customisable security features.
As you probably know two major areas of application security are “authentication” and “authorization”
(or “access-control”). These are the two main areas that Spring Security targets. “Authentication” is
the process of establishing a principal is who they claim to be (a “principal” generally means a user,
device or some other system which can perform an action in your application). “Authorization” refers
to the process of deciding whether a principal is allowed to perform an action within your application.
To arrive at the point where an authorization decision is needed, the identity of the principal has already
been established by the authentication process. These concepts are common, and not at all specific to
Spring Security.
At an authentication level, Spring Security supports a wide range of authentication models. Most of
these authentication models are either provided by third parties, or are developed by relevant standards
bodies such as the Internet Engineering Task Force. In addition, Spring Security provides its own set of
authentication features. Specifically, Spring Security currently supports authentication integration with
all of these technologies:
• HTTP BASIC authentication headers (an IEFT RFC-based standard)
• HTTP Digest authentication headers (an IEFT RFC-based standard)
• HTTP X.509 client certificate exchange (an IEFT RFC-based standard)
• LDAP (a very common approach to cross-platform authentication needs, especially in large
environments)
• Form-based authentication (for simple user interface needs)
• OpenID authentication
• Authentication based on pre-established request headers (such as Computer Associates Siteminder)
• JA-SIG Central Authentication Service (otherwise known as CAS, which is a popular open source
single sign on system)
• Transparent authentication context propagation for Remote Method Invocation (RMI) and
HttpInvoker (a Spring remoting protocol)
• Automatic "remember-me" authentication (so you can tick a box to avoid re-authentication for a
predetermined period of time)
• Anonymous authentication (allowing every call to automatically assume a particular security identity)
Spring Security
3.0.8.RELEASE 3
• Run-as authentication (which is useful if one call should proceed with a different security identity)
• Java Authentication and Authorization Service (JAAS)
• JEE container autentication (so you can still use Container Managed Authentication if desired)
• Kerberos
• Java Open Source Single Sign On (JOSSO) *
• OpenNMS Network Management Platform *
• AppFuse *
• AndroMDA *
• Mule ESB *
• Direct Web Request (DWR) *
• Grails *
• Tapestry *
• JTrac *
• Jasypt *
• Roller *
• Elastic Path *
• Atlassian Crowd *
• Your own authentication systems (see below)

Spring Security began in late 2003 as “The Acegi Security System for Spring”. A question was posed on
the Spring Developers' mailing list asking whether there had been any consideration given to a Spring-
based security implementation

## Project Modules
In Spring Security 3.0, the codebase has been sub-divided into separate jars which more clearly separate
different functionaltiy areas and third-party dependencies

1. Core - spring-security-core.jar
Contains core authentication and access-contol classes and interfaces, remoting support and basic
provisioning APIs. Required by any application which uses Spring Security. Supports standalone
applications, remote clients, method (service layer) security and JDBC user provisioning. Contains the
top-level packages:
• org.springframework.security.core
• org.springframework.security.access
• org.springframework.security.authentication
• org.springframework.security.provisioning
• org.springframework.security.remoting

2. Web - spring-security-web.jar
Contains filters and related web-security infrastructure code. Anything with a servlet API dependency.
You'll need it if you require Spring Security web authentication services and URL-based access-control.
The main package is org.springframework.security.web

3. Config - spring-security-config.jar
Contains the security namespace parsing code (and hence nothing that you are likely yo use directly in
your application). You need it if you are using the Spring Security XML namespace for configuration.
The main package is org.springframework.security.config

4. LDAP - spring-security-ldap.jar
LDAP authentication and provisioning code. Required if you need to use LDAP authentication or
manage LDAP user entries. The top-level package is org.springframework.security.ldap.

5. ACL - spring-security-acl.jar
Specialized domain object ACL implementation. Used to apply security to
specific domain object instances within your application. The top-level package is
org.springframework.security.acls.

6. CAS - spring-security-cas-client.jar
Spring Security's CAS client integration. If you want to use Spring Security web authentication with a
CAS single sign-on server. The top-level package is org.springframework.security.cas.

7. OpenID - spring-security-openid.jar
OpenID web authentication support. Used to authenticate users against an external OpenID server.
org.springframework.security.openid. Requires OpenID4Java.