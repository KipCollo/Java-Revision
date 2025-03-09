# Spring Security Web

The Spring Security Web module provides the integration of Spring Security with the web application layer. It includes components and features specifically designed for securing web-based applications by handling HTTP requests and responses. It builds upon the core Spring Security module to deliver web-specific functionality like filters, sessions, and URL-based security.

## Key Components of Spring Security Web

- **Security Filter Chain**:- The security filter chain is central to Spring Security Web. It processes incoming HTTP requests and applies security logic before passing the request to the application.

Defines a filter chain which is capable of being matched against an HttpServletRequest.

It consists of multiple filters, including:

- Authentication Filters: Handle login processes and validate credentials.
- Authorization Filters: Check whether the user has permission to access the requested resource.
- CSRF Filters: Protect against Cross-Site Request Forgery attacks.
- Session Management Filters: Handle session fixation and other session-related security concerns.

Example configuration of the filter chain:

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/public/**").permitAll()  // Public URLs
            .antMatchers("/admin/**").hasRole("ADMIN")  // Admin-only URLs
            .anyRequest().authenticated()  // All other URLs require authentication
            .and()
        .formLogin()
            .loginPage("/login")  // Custom login page
            .permitAll()
            .and()
        .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")
            .permitAll();
    return http.build();
}
```

- **HttpSecurity**:- HttpSecurity is a fluent API for configuring web-based security. It allows you to define:

- URL access rules (e.g., public vs. protected URLs).
- Authentication mechanisms (e.g., form-based login, HTTP Basic authentication).
- CSRF protection.
- Session management policies.

Example:

```java
http.authorizeRequests()
    .antMatchers("/admin/**").hasRole("ADMIN")
    .antMatchers("/user/**").hasRole("USER")
    .antMatchers("/public/**").permitAll()
    .anyRequest().authenticated()
    .and()
    .formLogin();
```

- **Default Security Behavior**:- If no custom configuration is provided, Spring Security Web:

- Protects all URLs by requiring authentication.
- Provides a default login page.
- Enables CSRF protection.
- Includes basic security headers.

- **WebSecurityConfigurerAdapter (Deprecated)**:- Before Spring Security 5.7.0, developers extended WebSecurityConfigurerAdapter to customize web security. This approach has been deprecated and replaced with a more modular bean-based configuration using SecurityFilterChain.

Old style (deprecated):

```java
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin();
    }
}
```

New style:

```java
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin();
        return http.build();
    }
}
```

- **Session Management**:- Spring Security Web allows you to manage session behavior:

- Session Fixation Protection: Replaces the session ID after successful login.
- Concurrent Session Control: Restricts the number of active sessions per user.
- Stateless Sessions: Ideal for REST APIs.

Example:

```java
http.sessionManagement()
    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);  // For REST APIs
```

- **CSRF Protection**:-Cross-Site Request Forgery (CSRF) protection is enabled by default in Spring Security Web. It prevents malicious websites from performing actions on behalf of authenticated users.

To disable CSRF (not recommended for production):

```java
http.csrf().disable();
```

For stateless REST APIs, CSRF is typically disabled as it's unnecessary in stateless contexts.

- **Security Context**

The SecurityContext holds the authentication details for the currently authenticated user.
The SecurityContext is stored in a ThreadLocal and managed by the SecurityContextPersistenceFilter.

Example of accessing the SecurityContext:

```java
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
System.out.println("Authenticated user: " + auth.getName());
```

- **Authentication Entry Point**

The authentication entry point is triggered when a user attempts to access a secured resource without being authenticated.

For form-based login:

```java
http.formLogin()
    .loginPage("/custom-login");
```

For stateless APIs (returning 401 Unauthorized):

```java
    http.exceptionHandling()
        .authenticationEntryPoint((request, response, authException) -> {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        });
```

- **Custom Filters**

You can add custom filters to the filter chain to extend Spring Security Web's functionality.

Example:

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .addFilterBefore(new CustomFilter(), UsernamePasswordAuthenticationFilter.class)
        .authorizeRequests()
        .anyRequest().authenticated();
    return http.build();
}
```

- **Cross-Origin Resource Sharing (CORS)**

Spring Security Web integrates with CORS to allow or restrict cross-origin requests.

Example:
  
```java
http.cors().configurationSource(request -> {
    CorsConfiguration config = new CorsConfiguration();
    config.addAllowedOrigin("http://example.com");
    config.addAllowedMethod("*");
    config.addAllowedHeader("*");
    return config;
});
```

## Features of Spring Security Web

- Secures HTTP Endpoints: Protects web resources using URL patterns and request types.
- Authentication and Authorization: Handles login, logout, and permission checks.
- CSRF Protection: Guards against CSRF attacks.
- Session Management: Supports session creation, fixation protection, and concurrency control.
- Security Headers: Automatically includes headers like X-Frame-Options, X-Content-Type-Options, etc.
- Customizable: Allows for custom login pages, filters, and access rules.
- CORS Integration: Configurable cross-origin resource sharing for web applications.
- OAuth2 Support: Integrates with third-party OAuth2 providers like Google and GitHub.

Spring Security Web is a powerful and flexible module for securing web applications. It builds on Spring Security Core to provide comprehensive security features, such as filter chains, session management, CSRF protection, and CORS support. Its modular design allows developers to easily customize and extend security configurations for any type of web application.

## SERVER

1. SecurityWebFilterChain - Defines a filter chain which is capable of being matched against a ServerWebExchange in order to decide whether it applies to that request.
2. ServerAuthenticationEntryPoint - Used to request authentication
3. ServerRedirectStrategy - A strategy for performing redirects.
4. WebFilterChainProxy - Used to delegate to a List of SecurityWebFilterChain instances.
5. WebFilterChainProxy.DefaultWebFilterChainDecorator - A WebFilterChainProxy.WebFilterChainDecorator that uses the DefaultWebFilterChain
6. WebFilterChainProxy.WebFilterChainDecorator - A strategy for decorating the provided filter chain with one that accounts for the SecurityFilterChain for a given request.
7. WebFilterExchange - A composite of the ServerWebExchange and the WebFilterChain.
