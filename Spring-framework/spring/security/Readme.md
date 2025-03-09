# Spring Security

Spring Security provides comprehensive security services for J2EE-based enterprise software applications.

security features of J2EE's Servlet Specification or EJB Specification lack the depth required for typical enterprise application scenarios. Whilst mentioning these standards, it's important to recognise that they are not portable at a WAR or EAR level. Therefore, if you switch server environments, it is typically a lot
of work to reconfigure your application's security in the new target environment. Using Spring Security overcomes these problems, and also brings you dozens of other useful, customisable security features

The Spring Security framework provides the WebSecurity and HttpSecurity classes to provide both global and resource-specific mechanisms to restrict access to APIs and assets. The WebSecurity class helps to configure security at a global level, while HttpSecurity provides methods to configure security for a specific resource.

**HttpSecurity**:- The HttpSecurity class helps to configure security for specific HTTP requests.Also, it permits using the requestMatcher() method to restrict security configuration to a specific HTTP endpoint.

To enable HTTP Security in Spring, we need to create a SecurityFilterChain bean.

Furthermore, it provides flexibility to configure authorization for a specific HTTP request. We can create a role-based authentication with the hasRole() method.

```java
@Bean
SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/admin/**")
      .authenticated()
      .anyRequest()
      .permitAll())
      .formLogin(withDefaults());
    return http.build();
}
```

In the code above, we use the HttpSecurity class to restrict access to the “/admin/**” endpoint. Any request made to the endpoint will require authentication before access is granted.

Furthermore, HttpSecurity provides a method to configure authorization for a restricted endpoint. Let’s modify our example code to permit only a user with an admin role to access the “/admin/**” endpoint:

```java
// ...
http.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/admin/**").hasRole("ADMIN"))
// ...
```

```java
@Bean 
 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .anyRequest().authenticated()
      .and().httpBasic();
    return http.build();
}
```

The above configuration makes sure any request to the application is authenticated with form based login or HTTP basic authentication.

Also, it is exactly similar to the following XML configuration:

```xml
<http>
    <intercept-url pattern="/**" access="isAuthenticated()"/>
    <form-login />
    <http-basic />
</http>
```

Form Login - Interestingly, Spring Security generates a login page automatically, based on the features that are enabled and using standard values for the URL which processes the submitted login:

```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .anyRequest().authenticated()
      .and().formLogin()
      .loginPage("/login").permitAll();
    return http.build();
}
```

Here the automatically generated login page is convenient to get up and running quickly.

**WebSecurity**:- The WebSecurity class helps to configure security at a global level in a Spring application. We can customize WebSecurity by exposing the WebSecurityCustomizer bean.Unlike the HttpSecurity class, which helps configure security rules for specific URL patterns or individual resources, WebSecurity configuration applies globally to all requests and resources.

Furthermore, it provides methods to debug logging for Spring Security filters, ignore security checks for certain requests and resources, or configure a firewall for a Spring application.

Additionally, the WebSecurity class provides a method named ignoring(). The ignoring() method helps Spring Security to ignore an instance of a RequestMatcher. It’s recommended that register requests are of only static resources.

Here’s an example that uses the ignoring() method to ignore static resources in a Spring application:

```java
@Bean
WebSecurityCustomizer ignoringCustomizer() {
    return (web) -> web.ignoring().requestMatchers("/resources/**", "/static/**");
}
```

Here, we use the ignoring() method to bypass static resources from a security check.

Notably, Spring advises that the ignoring() method shouldn’t be used for dynamic requests but only for static resources because it bypasses the Spring Security filter chain. This is recommended for static assets like CSS, images, etc.

However, dynamic requests need to pass through authentication and authorization to provide different access rules because they carry sensitive data. Also, if we ignore dynamic endpoints completely, we lose total security control. This could open an application for different attacks like CSRF attacks or SQL injection.

The debug() Method

Additionally, the debug() method enables logging of Spring Security internals to assist with debugging configuration or request failures. This could be helpful in diagnosing security rules without the need for a debugger.

Let’s see an example code that uses the debug() method to debug security:

```java
@Bean
WebSecurityCustomizer debugSecurity() {
    return (web) -> web.debug(true);
}
```

Here, we invoke debug() on the WebSecurity instance and set it to true. This globally enables debug logging across all security filters.

The httpFirewall() Method

Also, the WebSecurity class provides the httpFirewall() method to configure a firewall for a Spring application. It helps to set rules to permit certain actions at the global level.

Let’s use the httpFirewall() method to determine which HTTP methods should be allowed in our application:

```java
@Bean
HttpFirewall allowHttpMethod() {
    List<String> allowedMethods = new ArrayList<String>();
    allowedMethods.add("GET");
    allowedMethods.add("POST");
    StrictHttpFirewall firewall = new StrictHttpFirewall();
    firewall.setAllowedHttpMethods(allowedMethods);
    return firewall;
}

@Bean
WebSecurityCustomizer fireWall() {
    return (web) -> web.httpFirewall(allowHttpMethod());
}
```

In this tutorial, we’ll look in detail at the key usage of HttpSecurity and WebSecurity. Also, we’ll see the differences between the two classes.

HttpSecurity and WebSecurity configurations can work together to provide global and resource-specific security rules.

However, if similar security rules are configured in both, the WebSecurity configuration takes the highest precedence:

```java
@Bean
WebSecurityCustomizer ignoringCustomizer() {
    return (web) -> web.ignoring().antMatchers("/admin/**");
}

// ...
 http.authorizeHttpRequests((authorize) -> authorize.antMatchers("/admin/**").hasRole("ADMIN"))
// ...
```

Two main areas that Spring Security targets:

1. “Authentication” is the process of establishing a principal is who they claim to be (a “principal” generally means a user,device or some other system which can perform an action in your application).
2. “Authorization” refers to the process of deciding whether a principal is allowed to perform an action within your application.To arrive at the point where an authorization decision is needed, the identity of the principal has already been established by the authentication process

Spring security is a framework for in Spring ecosystem for securing Java applications.It is highly customizable and can be integreted in web applications and RESful web services.It provides features i.e authentication,authorization,protection against common vulnerabilities and intergration with various security standards and protocols.

Spring Security provides comprehensive security services for J2EE-based enterprise software applications. There is a particular emphasis on supporting projects built using The Spring Framework,which is the leading J2EE solution for enterprise software development. If you're not using Spring for developing enterprise applications, we warmly encourage you to take a closer look at it. Some familiarity with Spring - and in particular dependency injection principles - will help you get up to speed with Spring Security more easily.

- Auhentication

At an authentication level, Spring Security supports a wide range of authentication models. Most of these authentication models are either provided by third parties, or are developed by relevant standards bodies such as the Internet Engineering Task Force. In addition, Spring Security provides its own set of authentication features. Specifically, Spring Security currently supports authentication integration with all of these technologies:

1. HTTP BASIC authentication headers (an IEFT RFC-based standard)
2. HTTP Digest authentication headers (an IEFT RFC-based standard)
3. HTTP X.509 client certificate exchange (an IEFT RFC-based standard)
4. LDAP (a very common approach to cross-platform authentication needs, especially in large environments)
5. Form-based authentication (for simple user interface needs)
6. OpenID authentication
7. Authentication based on pre-established request headers (such as Computer Associates Siteminder)
8. JA-SIG Central Authentication Service (otherwise known as CAS, which is a popular open source single sign on system)
9. Transparent authentication context propagation for Remote Method Invocation (RMI) and HttpInvoker (a Spring remoting protocol)
10. Automatic "remember-me" authentication (so you can tick a box to avoid re-authentication for a predetermined period of time)
11. Anonymous authentication (allowing every call to automatically assume a particular security identity)Spring Security

- Authorization: -Supports role-based access control(RBAC) and permission-based access control.Provides fine-grained control over URLs,methods and resources.

- Protection Against Attacks:-
   1. Cross-Site Scripting(XSS):- Escapes malicious input in web responses.
   2. Cross-Site Request Forgery(CSRF):- Protects against unauthorized actions from authenticated users.
   3. Session Fixation:- Prevents session hijacking
   4. Clickjacking:- Defends against UI redness attacks.

- Intergration:- Works seamlessly with other Spring projects i.e Spring MVC,Spring Boot.It also supports OAuth2,OpenID Connect,SAML and JWT for modern authentication.

## Project Modules

In Spring Security 3.0, the codebase has been sub-divided into separate jars which more clearly separate different functionaltiy areas and third-party dependencies

1. Core - spring-security-core.jar:- Contains core authentication and access-contol classes and interfaces, remoting support and basic provisioning APIs. Required by any application which uses Spring Security. Supports standalone applications, remote clients, method (service layer) security and JDBC user provisioning. Contains the top-level packages:
• org.springframework.security.core
• org.springframework.security.access
• org.springframework.security.authentication
• org.springframework.security.provisioning
• org.springframework.security.remoting

2. Web - spring-security-web.jar:- Contains filters and related web-security infrastructure code. Anything with a servlet API dependency.You'll need it if you require Spring Security web authentication services and URL-based access-control.The main package is org.springframework.security.web

3. Config - spring-security-config.jar:- Contains the security namespace parsing code (and hence nothing that you are likely yo use directly in your application). You need it if you are using the Spring Security XML namespace for configuration.The main package is org.springframework.security.config

4. LDAP - spring-security-ldap.jar:- LDAP authentication and provisioning code. Required if you need to use LDAP authentication or manage LDAP user entries. The top-level package is org.springframework.security.ldap.

5. ACL - spring-security-acl.jar:- Specialized domain object ACL implementation. Used to apply security to specific domain object instances within your application. The top-level package is org.springframework.security.acls.

6. CAS - spring-security-cas-client.jar:- Spring Security's CAS client integration. If you want to use Spring Security web authentication with a CAS single sign-on server. The top-level package is org.springframework.security.cas.

7. OpenID - spring-security-openid.jar:- OpenID web authentication support. Used to authenticate users against an external OpenID server. org.springframework.security.openid. Requires OpenID4Java.

## Spring Security Features

1. Authorization:This functionality is provided by Spring Security and allows the user to be authorized before accessing resources. It enables developers to set access controls for resources.
2. Single sign-on:  This feature allows a user to utilize a single account to access different apps (user name and password).
3. Software Localization: This capability enables us to create user interfaces for applications in any language.
4. Remember-me: With the help of HTTP Cookies, Spring Security provides this capability. It remembers the user and prevents them from logging in from the same workstation until they log out.
5. LDAP (Lightweight Directory Access Protocol): That is an open application protocol for managing and interacting with dispersed directory information services over the Internet Protocol.
6. JAAS (Java Authentication and Authorization Service) LoginModule: This is a Java-based Pluggable Authentication Module. It is supported by Spring Security’s authentication procedure.
7. Web Form Authentication: Web forms capture and authenticate user credentials from the web browser during this procedure. While we wish to build web form authentication, Spring Security supports it.
8. Digest Access Authentication: We can make the authentication procedure more secure with this functionality than with Basic Access Authentication. Before delivering sensitive data over the network, it requests that the browser verify the user’s identity.
9. HTTP Authorization:Using Apache Ant paths or regular expressions, Spring provides this functionality for HTTP authorization of web request URLs.
10. Basic Access Authentication: Spring Security has support for Basic Access Authentication, which is used to give a user name and password when performing network requests.

## Features Added in Spring Security 6.0

1. OAuth 2.0 Login: This feature allows users to connect to the app using their current GitHub or Google accounts. The Authorization Code Grant defined in the OAuth 2.0 Authorization Framework is used to implement this functionality.
2. Reactive Support: Spring Security 6.0 adds support for reactive programming and reactive web runtimes, as well as the ability to interact with Spring WebFlux.
3. Modernized Password Encoding: Spring Security 6.0 introduces the DelegatingPasswordEncoder, a new way to store passwords. The format for storing passwords is: {id} encodedPassword. List of ids for various password encoders are:

    - {bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG
    - {noop}password
    - {pbkdf2}5d923b44a6d129f3ddf3e3c8d29412723dcbde72445e8ef6bf3b508fbf17fa4ed4d6b99ca763d8dc
    - {scrypt}$e0801$8bWJaSu2IKSn9Z9kM+TPXfOc/9bdYSrN1oD9qfVThWEwdRTnO7re7Ei+fUZRJ68k9lTyuTeUp4of4g24hHnazw==$OAOec05+bXxvuu/1qZ6NUR+xQYvYv7BeL1QxwRpY5Pc=
    - {sha256}97cde38028ad898ebc02e690819fa220e88c62e0699403e94fff291cfffaf8410849f27605abcbc0

requestMatchers() configures if an URL will be processed by that SecurityFilterChain. So if an URL does not match it , the whole SecurityFilterChain will be skipped which means Spring Security will not handle this URL after that. If you do not configure it , the default is to match all URLs.

The authorizeRequests() configures the authorisation stuff for an URL such as things like if it requires to be authenticated or if only certain roles can access it etc. It only has effect for those URLs that are processed by that SecurityFilterChain (i.e. Those URLs that are matched by requestMatchers())

## Core

Core classes and interfaces related to user authentication and authorization, as well as the maintenance of a security context.

AuthenticatedPrincipal- Representation of an authenticated Principal once an Authentication request has been successfully authenticated by the AuthenticationManager.authenticate(Authentication) method.
Authentication - Represents the token for an authentication request or for an authenticated principal once the request has been processed by the AuthenticationManager.authenticate(Authentication) method.
AuthenticationException- Abstract superclass for all exceptions related to an Authentication object being invalid for whatever reason.
CredentialsContainer- Indicates that the implementing object contains sensitive data, which can be erased using the eraseCredentials method.
GrantedAuthority - Represents an authority granted to an Authentication object.
SpringSecurityCoreVersion- Internal class used for checking version compatibility in a deployed application.
SpringSecurityMessageSource- The default MessageSource used by Spring Security.
Transient - A marker for Authentications that should never be stored across requests, for example a bearer token authentication

Authentication:- Represents the token for an authentication request or for an authenticated principal once the request has been processed by the AuthenticationManager.authenticate(Authentication) method.

Once the request has been authenticated, the Authentication will usually be stored in a thread-local SecurityContext managed by the SecurityContextHolder by the authentication mechanism which is being used. An explicit authentication can be achieved, without using one of Spring Security's authentication mechanisms, by creating an Authentication instance and using the code:

```java
 SecurityContext context = SecurityContextHolder.createEmptyContext();
 context.setAuthentication(anAuthentication);
 SecurityContextHolder.setContext(context);
```

Note that unless the Authentication has the authenticated property set to true, it will still be authenticated by any security interceptor (for method or web invocations) which encounters it.

In most cases, the framework transparently takes care of managing the security context and authentication objects for you.

### USERDETAILS

The standard interfaces for implementing user data DAOs.Can be the traditional UserDetailsService which uses a unique username to identify the user or, for more complex requirements, the AuthenticationUserDetailsService.

1. memory- Exposes an in-memory authentication repository.
2. jdbc - Exposes a JDBC-based authentication repository, implementing org.springframework.security.core.userdetails.UserDetailsService UserDetailsService.
3. cache- Implementations of UserCache.

- UserDetails:- Provides core user information.Implementations are not used directly by Spring Security for security purposes. They simply store user information which is later encapsulated into Authentication objects. This allows non-security related user information (such as email addresses, telephone numbers etc) to be stored in a convenient location.
Concrete implementations must take particular care to ensure the non-null contract detailed for each method is enforced. See User for a reference implementation (which you might like to extend or use in your code):-
  1. Collection<? extends GrantedAuthority> getAuthorities():- Returns the authorities granted to the user.
  2. String getPassword():- Returns the password used to authenticate the user.
  3. String getUsername():- Returns the username used to authenticate the user.
  4. default boolean isAccountNonExpired():- Indicates whether the user's account has expired.
  5. default boolean isAccountNonLocked():- Indicates whether the user is locked or unlocked.
  6. default boolean isCredentialsNonExpired():- Indicates whether the user's credentials (password) has expired.
  7. default boolean isEnabled():- Indicates whether the user is enabled or disabled.

- UserDetailsService:- Core interface which loads user-specific data.It is used throughout the framework as a user DAO and is the strategy used by the DaoAuthenticationProvider.The interface requires only one read-only method, which simplifies support for new data-access strategies.
  - UserDetails loadUserByUsername(String username) throws UsernameNotFoundException- Locates the user based on the username. In the actual implementation, the search may possibly be case sensitive, or case insensitive depending on how the implementation instance is configured. In this case, the UserDetails object that comes back may have a username that is of a different case than what was actually requested..

- UsernameNotFoundException:- Thrown if an UserDetailsService implementation cannot locate a User by its username.
  1. UsernameNotFoundException(String msg) - Constructs a UsernameNotFoundException with the specified message.
  2. UsernameNotFoundException(String msg, Throwable cause)- Constructs a UsernameNotFoundException with the specified message and root cause

- User:- Models core user information retrieved by a UserDetailsService.Developers may use this class directly, subclass it, or write their own UserDetails implementation from scratch.
equals and hashcode implementations are based on the username property only, as the intention is that lookups of the same user principal object (in a user registry, for example) will match where the objects represent the same user, not just when all the properties (authorities, password for example) are the same.
- Note that this implementation is not immutable. It implements the CredentialsContainer interface, in order to allow the password to be erased after authentication. This may cause side-effects if you are storing instances in-memory and reusing them. If so, make sure you return a copy from your UserDetailsService each time it is invoked.

- UserCache:- Provides a cache of UserDetails objects.Implementations should provide appropriate methods to set their cache parameters (e.g. time-to-live) and/or force removal of entities before their normal expiration. These are not part of the UserCache interface contract because they vary depending on the type of caching system used (in-memory, disk, cluster, hybrid etc.).
- Caching is generally only required in applications which do not maintain server-side state, such as remote clients or web services. The authentication credentials are then presented on each invocation and the overhead of accessing a database or other persistent storage mechanism to validate would be excessive. In this case, you would configure a cache to store the UserDetails information rather than loading it each time.

## authentication

Core classes and interfaces related to user authentication, which are used throughout Spring Security.
Of key importance is the AuthenticationManager and its default implementation ProviderManager, which maintains a list AuthenticationProviders to which it delegates authentication requests.

- AuthenticationManager - This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.Processes an Authentication request.
  - Authentication authenticate(Authentication authentication) - Attempts to authenticate the passed Authentication object, returning a fully populated Authentication object (including granted authorities) if successful.
An AuthenticationManager must honour the following contract concerning exceptions:
  1. A DisabledException must be thrown if an account is disabled and the AuthenticationManager can test for this state.
  2. A LockedException must be thrown if an account is locked and the AuthenticationManager can test for account locking.
  3. A BadCredentialsException must be thrown if incorrect credentials are presented. Whilst the above exceptions are optional, an AuthenticationManager must always test credentials.

Exceptions should be tested for and if applicable thrown in the order expressed above (i.e. if an account is disabled or locked, the authentication request is immediately rejected and the credentials testing process is not performed). This prevents credentials being tested against disabled or locked accounts.
Implementing class include ObservationAuthenticationManager, ProviderManager.

- AuthenticationProvider:- Indicates a class can process a specific Authentication implementation.Implementing class includes DaoAuthenticationProvider, JaasAuthenticationProvider, JwtAuthenticationProvider,LdapAuthenticationProvider, OAuth2AuthorizationCodeAuthenticationProvider, OAuth2LoginAuthenticationProvider, OidcAuthorizationCodeAuthenticationProvider, OneTimeTokenAuthenticationProvider
  1. In-Memory Authentication:- Useful for simple applications or testing
  2. Database Authentication:- Authenticate using relational database
  3. LDAP Authentication:- Authentiate users against LDAP directory.
  4. OAuth2 and JWT:- For token-based authentication,Spring Security integrates with OAuth2 and supports JWTs for stateless application.

- ProviderManager:- Iterates an Authentication request through a list of AuthenticationProviders.AuthenticationProviders are usually tried in order until one provides a non-null response. A non-null response indicates the provider had authority to decide on the authentication request and no further providers are tried. If a subsequent provider successfully authenticates the request, the earlier authentication exception is disregarded and the successful authentication will be used. If no subsequent provider provides a non-null response, or a new AuthenticationException, the last AuthenticationException received will be used. If no provider returns a non-null response, or indicates it can even process an Authentication, the ProviderManager will throw a ProviderNotFoundException. A parent AuthenticationManager can also be set, and this will also be tried if none of the configured providers can perform the authentication. This is intended to support namespace configuration options though and is not a feature that should normally be required.
- The exception to this process is when a provider throws an AccountStatusException, in which case no further providers in the list will be queried. Post-authentication, the credentials will be cleared from the returned Authentication object, if it implements the CredentialsContainer interface. This behaviour can be controlled by modifying the eraseCredentialsAfterAuthentication property.

### OAuth2

Spring Security’s OAuth 2.0 support consists of two primary feature sets:

   1. OAuth2 Resource Server
   2. OAuth2 Clien

- OAuth2 Resource Server

Protect Access with an OAuth2 Access Token
It is very common to protect access to an API using OAuth2 access tokens. In most cases, Spring Security requires only minimal configuration to secure an application
with OAuth2

There are two types of Bearer tokens supported by Spring Security which each use a different component for validation:
• JWT support uses a JwtDecoder bean to validate signatures and decode tokens
• Opaque token support uses an OpaqueTokenIntrospector bean to introspect tokens

JWT Support
The following example configures a JwtDecoder bean using Spring Boot configuration properties:

```yaml
spring:
 security:
  oauth2:
  resourceserver:
   jwt:
    issuer-uri: https://my-auth-server.com
```

Opaque Token Support
The following example configures an OpaqueTokenIntrospector bean using Spring Boot configuration properties:

```yaml
spring:
 security:
  oauth2:
  resourceserver:
   opaquetoken:
    introspection-uri: https://my-auth-server.com/oauth2/introspect
    client-id: my-client-id
    client-secret: my-client-secret
```

You can add trace leve of logging to check the logs
