# Spring Security

Spring Security provides comprehensive security services for J2EE-based enterprise software applications.

security features of J2EE's Servlet Specification or EJB Specification lack the depth required for typical enterprise application scenarios. Whilst mentioning these standards, it's important to recognise that they are not portable at a WAR or EAR level. Therefore, if you switch server environments, it is typically a lot
of work to reconfigure your application's security in the new target environment. Using Spring Security overcomes these problems, and also brings you dozens of other useful, customisable security features

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

## Components in Spring Security

1. Filter Chain:- Series of filters that process incoming requests.
2. SecurityContext:- Holds authentication information(principal,credentials and roles).Managed via SecurityContextHolder.
3. AuthenticationManager:- Core interface for handling authentication.Works with AuthenticationProvider to validate credentials.
4. GrantedAuthority:- Represents user permissions(e.g roles like ROLE_USER,ROLE_ADMIN)
5. UserDetailsService:- Loads user-specific data from database or other sources.Often used with UserDetails for custom User Management.

## Spring Security Configurations

- Java Config
- XML configuration

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

## Authentication Providers

1. In-Memory Authentication:- Useful for simple applications or testing
2. Database Authentication:- Authenticate using relational database
3. LDAP Authentication:- Authentiate users against LDAP directory.
4. OAuth2 and JWT:- For token-based authentication,Spring Security integrates with OAuth2 and supports JWTs for stateless application.

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

### Username/Password Authentication

- Publish an AuthenticationManager bean: A fairly common requirement is publishing an AuthenticationManager bean to allow for custom authentication, such as in a @Service or Spring MVC @Controller.
For example, you may want to authenticate users via a REST API instead of using Form Login.

You can configure username and password authentication using the following:
Simple Username/Password Example

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
http
 .authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
 .httpBasic(Customizer.withDefaults())
 .formLogin(Customizer.withDefaults());

return http.build();
}

@Bean
public UserDetailsService userDetailsService() {
UserDetails userDetails = User.withDefaultPasswordEncoder()
.username("user")
.password("password")
.roles("USER")
.build();
return new InMemoryUserDetailsManager(userDetails);
}
}
```

The preceding configuration automatically registers an in-memory UserDetailsService with the SecurityFilterChain , registers the DaoAuthenticationProvider with the default AuthenticationManager , and enables Form Login and HTTP Basic authentication.

Publish an AuthenticationManager bean: A fairly common requirement is publishing an AuthenticationManager bean to allow for custom authentication, such as in a @Service or Spring MVC @Controller.

For example, you may want to authenticate users via a REST API instead of using Form Login.
You can publish such an AuthenticationManager for custom authentication scenarios using the following configuration:

Publish AuthenticationManager bean for Custom Authentication

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
http
.authorizeHttpRequests((authorize) -> authorize
.requestMatchers("/login").permitAll()
.anyRequest().authenticated()
);
return http.build();
}

@Bean
public AuthenticationManager authenticationManager(
UserDetailsService userDetailsService,
PasswordEncoder passwordEncoder) {
DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
authenticationProvider.setUserDetailsService(userDetailsService);
authenticationProvider.setPasswordEncoder(passwordEncoder);
return new ProviderManager(authenticationProvider);
}

@Bean
public UserDetailsService userDetailsService() {
UserDetails userDetails = User.withDefaultPasswordEncoder()
.username("user")
.password("password")
.roles("USER")
.build();
return new InMemoryUserDetailsManager(userDetails);
}

@Bean
public PasswordEncoder passwordEncoder() {
return PasswordEncoderFactories.createDelegatingPasswordEncoder();
}
}
```

With the preceding configuration in place, you can create a @RestController that uses the AuthenticationManager as follows:
Create a @RestController for Authentication

```java
@RestController
public class LoginController {
private final AuthenticationManager authenticationManager;

public LoginController(AuthenticationManager authenticationManager) {
this.authenticationManager = authenticationManager;
}
@PostMapping("/login")
public ResponseEntity<Void> login(@RequestBody LoginRequest loginRequest) {
Authentication authenticationRequest =
UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(), loginRequest.password());
Authentication authenticationResponse =
this.authenticationManager.authenticate(authenticationRequest);
// ...
}
public record LoginRequest(String username, String password) {
}
}
```

Customize the AuthenticationManager
Normally, Spring Security builds an AuthenticationManager internally composed of a DaoAuthenticationProvider for username/password authentication. In cer-
tain cases, it may still be desired to customize the instance of AuthenticationManager used by Spring Security. For example, you may need to simply disable creden-
tial erasure for cached users.
The recommended way to do this is to simply publish your own AuthenticationManager bean, and Spring Security will use it. You can publish an
AuthenticationManager using the following configuration:

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
http
.authorizeHttpRequests((authorize) -> authorize
.requestMatchers("/login").permitAll()
.anyRequest().authenticated()
)
.httpBasic(Customizer.withDefaults())
.formLogin(Customizer.withDefaults());
return http.build();
}

@Bean
public AuthenticationManager authenticationManager(
UserDetailsService userDetailsService,
PasswordEncoder passwordEncoder) {
DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
authenticationProvider.setUserDetailsService(userDetailsService);
authenticationProvider.setPasswordEncoder(passwordEncoder);
ProviderManager providerManager = new ProviderManager(authenticationProvider);
providerManager.setEraseCredentialsAfterAuthentication(false);
return providerManager;
}

@Bean
public UserDetailsService userDetailsService() {
UserDetails userDetails = User.withDefaultPasswordEncoder()
.username("user")
.password("password")
.roles("USER")
.build();
return new InMemoryUserDetailsManager(userDetails);
}

@Bean
public PasswordEncoder passwordEncoder() {
return PasswordEncoderFactories.createDelegatingPasswordEncoder();
}
}
```

Alternatively, you can take advantage of the fact that the AuthenticationManagerBuilder used to build Spring Security’s global AuthenticationManager is pub-
lished as a bean. You can configure the builder as follows:
Configure global AuthenticationManagerBuilder

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
// ...
return http.build();
}

@Bean
public UserDetailsService userDetailsService() {
// Return a UserDetailsService that caches users
// ...
}
@Autowired
public void configure(AuthenticationManagerBuilder builder) {
builder.eraseCredentials(false);
}
}
```

## PASSWORD ENCODING

Password encoding ensures that passwords are securely stored and compared, protecting against attacks such as credential theft. The framework provides several built-in encoders and encourages the use of secure algorithms like BCrypt, which includes salting and hashing.

How Password Encoding Works

1. Encoding: Converts a plain-text password into a hashed format before storage.
2. Matching: When a user logs in, the plain-text password they provide is encoded and compared with the stored hashed password.

Common Password Encoders in Spring Security

- BCryptPasswordEncoder:- Implements the BCrypt hashing algorithm with a built-in salt.Resistant to brute force and rainbow table attacks.

```java
@Bean
public PasswordEncoder passwordEncoder() {
   return new BCryptPasswordEncoder();
}
```

- Pbkdf2PasswordEncoder:- Uses the PBKDF2 algorithm for password hashing.Supports configurable hashing strength.

```java
@Bean
public PasswordEncoder passwordEncoder() {
   return new Pbkdf2PasswordEncoder("secret", 185000, 256); // Custom secret, iterations, and hash width
}
```

- Argon2PasswordEncoder:- Implements the Argon2 hashing algorithm, designed for secure password hashing.

```java
@Bean
public PasswordEncoder passwordEncoder() {
   return new Argon2PasswordEncoder();
}
```

- SCryptPasswordEncoder:- Uses the SCrypt algorithm, designed to be memory-intensive.

```java
@Bean
public PasswordEncoder passwordEncoder() {
   return new SCryptPasswordEncoder();
}
```

- NoOpPasswordEncoder (NOT Recommended):- Stores passwords in plain text (use only for testing).

```java
@Bean
public PasswordEncoder passwordEncoder() {
   return NoOpPasswordEncoder.getInstance();
}
```

- DelegatingPasswordEncoder:- Allows using multiple encoders and prefixing encoded passwords with identifiers (e.g., {bcrypt}, {noop}).

```java
@Bean
public PasswordEncoder passwordEncoder() {
Map<String, PasswordEncoder> encoders = new HashMap<>();
   encoders.put("bcrypt", new BCryptPasswordEncoder());
   encoders.put("noop", NoOpPasswordEncoder.getInstance());
    
   return new DelegatingPasswordEncoder("bcrypt", encoders);
}
```
