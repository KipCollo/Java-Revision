# Spring Security Filters

Spring Security provides a powerful and flexible filter chain to control access to application resources. Here's an overview of how the Spring Security filter chain works:

- **FilterChainProxy**:- FilterChainProxy is the central component in the Spring Security filter chain. It delegates the actual filtering to one or more security filters, which can be configured for different URLs.

Several filters can be applied, each performing a specific security-related task. Some of the commonly used filters are:

 1. WebAsyncManagerIntegrationFilter: Integrates the SecurityContext with the WebAsyncManager.
 2. SecurityContextPersistenceFilter: Manages the SecurityContext persistence between requests.
 3. HeaderWriterFilter: Adds security headers to the response.
 4. CsrfFilter: Protects against Cross-Site Request Forgery attacks.
 5. LogoutFilter: Handles logout requests.
 6. UsernamePasswordAuthenticationFilter: Processes authentication requests for username and password.
 7. DefaultLoginPageGeneratingFilter: Generates a default login page.
 8. BasicAuthenticationFilter: Processes HTTP basic authentication.
 9. RequestCacheAwareFilter: Caches and retrieves previously requested URLs.
 10. SecurityContextHolderAwareRequestFilter: Makes the SecurityContext accessible through the HttpServletRequest.
 11. AnonymousAuthenticationFilter: Provides anonymous authentication support.
 12. SessionManagementFilter: Manages the security of HTTP sessions.
 13. ExceptionTranslationFilter: Translates authentication exceptions to HTTP responses.
 14. FilterSecurityInterceptor: Protects web resources by enforcing the configured access control rules.

## HttpSecurity

HttpSecurity object in Spring Security is specifically designed to allow you to configure and add security filters to your web application, enabling you to define how different parts of your application should be secured by applying various filter types for authentication, authorization, and other security checks.
Key points about HttpSecurity and filters:

1. Adding filters:- You use methods on the HttpSecurity object like addFilter() or dedicated methods for specific filter types (e.g., formLogin() which internally adds a form login filter) to add filters to the security chain.
2. Filter chain:- When a request comes in, it will pass through the configured filters in the order they were added to the HttpSecurity object.
3. Custom filters:- You can also create your own custom filters and add them to the HttpSecurity to implement specific security logic.

It allows configuring web based security for specific http requests. By default it will be applied to all requests, but can be restricted using #requestMatcher(RequestMatcher) or other similar methods.

Methods:-

- headers:- Adds the Security headers to the response. This is activated by default when using EnableWebSecurity.

Accepting the default provided by EnableWebSecurity or only invoking headers() without invoking additional methods on it, is the equivalent of:

```java
@Configuration
@EnableWebSecurity
public class CsrfSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .headers((headers) ->
                                headers
                                        .contentTypeOptions(withDefaults())
                                        .xssProtection(withDefaults())
                                        .cacheControl(withDefaults())
                                        .httpStrictTransportSecurity(withDefaults())
                                        .frameOptions(withDefaults())
                        );
                return http.build();
        }
 }
 ```

You can disable the headers using the following:

```java
 @Configuration
 @EnableWebSecurity
 public class CsrfSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .headers((headers) -> headers.disable());
                return http.build();
        }
 }
 ```

Returns the CorsConfigurer for customizations

- cors:- Adds a CorsFilter to be used. If a bean by the name of corsFilter is provided, that CorsFilter is used. Else if corsConfigurationSource is defined, then that CorsConfiguration is used. Otherwise, if Spring MVC is on the classpath a HandlerMappingIntrospector is used. You can enable CORS using:

```java
 @Configuration
 @EnableWebSecurity
 public class CorsSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .cors(withDefaults());
                return http.build();
        }
 }
```

It returns HttpSecurity for further customizations

- authorizeHttpRequests:- Allows restricting access based upon the HttpServletRequest using RequestMatcher implementations (i.e. via URL patterns).

```java
 @Configuration
 @EnableWebSecurity
 public class AuthorizeUrlsSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .authorizeHttpRequests((authorizeHttpRequests) ->
                                authorizeHttpRequests
                                        .requestMatchers("/**").hasRole("USER")
                        )
                        .formLogin(withDefaults());
                return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService() {
                UserDetails user = User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();
                UserDetails admin = User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("password")
                        .roles("ADMIN", "USER")
                        .build();
                return new InMemoryUserDetailsManager(user, admin);
        }
 }
```

We can also configure multiple URLs. The configuration below requires authentication to every URL and will grant access to URLs starting with /admin/ to only the "admin" user. All other URLs either user can access.

```java
 @Configuration
 @EnableWebSecurity
 public class AuthorizeUrlsSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .authorizeHttpRequests((authorizeHttpRequests) ->
                                authorizeHttpRequests
                                        .requestMatchers("/admin/**").hasRole("ADMIN")
                                        .requestMatchers("/**").hasRole("USER")
                        )
                        .formLogin(withDefaults());
                return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService() {
                UserDetails user = User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();
                UserDetails admin = User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("password")
                        .roles("ADMIN", "USER")
                        .build();
                return new InMemoryUserDetailsManager(user, admin);
        }
 }
```

Note that the matchers are considered in order. Therefore, the following is invalid because the first matcher matches every request and will never get to the second mapping:

```java
 @Configuration
 @EnableWebSecurity
 public class AuthorizeUrlsSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .authorizeHttpRequests((authorizeHttpRequests) ->
                                authorizeHttpRequests
                                        .requestMatchers("/**").hasRole("USER")
                                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        );
                return http.build();
        }
 }
 ```

Parameters:authorizeHttpRequestsCustomizer - the Customizer to provide more options for the AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry
Returns the HttpSecurity for further customizations

- exceptionHandling:- Allows configuring exception handling. This is automatically applied when using EnableWebSecurity.

```java
@Configuration
 @EnableWebSecurity
 public class ExceptionHandlingSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .authorizeRequests((authorizeRequests) ->
                                authorizeRequests
                                        .requestMatchers("/**").hasRole("USER")
                        )
                        // sample exception handling customization
                        .exceptionHandling((exceptionHandling) ->
                                exceptionHandling
                                        .accessDeniedPage("/errors/access-denied")
                        );
                return http.build();
        }
 }
```

Returns the HttpSecurity for further customizations

- csrf:- Enables CSRF protection. This is activated by default when using EnableWebSecurity. You can disable it using:

```java
 @Configuration
 @EnableWebSecurity
 public class CsrfSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .csrf((csrf) -> csrf.disable());
                return http.build();
        }
 }
```

Returns the HttpSecurity for further customizations

- logout:- Provides logout support. This is automatically applied when using EnableWebSecurity. The default is that accessing the URL "/logout" will log the user out by invalidating the HTTP Session, cleaning up any rememberMe() authentication that was configured, clearing the SecurityContextHolder, and then redirect to "/login?success".

```java
@Configuration
 @EnableWebSecurity
 public class LogoutSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .authorizeRequests((authorizeRequests) ->
                                authorizeRequests
                                        .requestMatchers("/**").hasRole("USER")
                        )
                        .formLogin(withDefaults())
                        // sample logout customization
                        .logout((logout) ->
                                logout.deleteCookies("remove")
                                        .invalidateHttpSession(false)
                                        .logoutUrl("/custom-logout")
                                        .logoutSuccessUrl("/logout-success")
                        );
                return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService() {
                UserDetails user = User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();
                return new InMemoryUserDetailsManager(user);
        }
 }
```

- formLogin:- Specifies to support form based authentication. If FormLoginConfigurer.loginPage(String) is not specified a default login page will be generated.

```java
 @Configuration
 @EnableWebSecurity
 public class FormLoginSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .authorizeRequests((authorizeRequests) ->
                                authorizeRequests
                                        .requestMatchers("/**").hasRole("USER")
                        )
                        .formLogin(withDefaults());
                return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService() {
                UserDetails user = User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();
                return new InMemoryUserDetailsManager(user);
        }
 }
```

The configuration below demonstrates customizing the defaults.

```java
 @Configuration
 @EnableWebSecurity
 public class FormLoginSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .authorizeRequests((authorizeRequests) ->
                                authorizeRequests
                                        .requestMatchers("/**").hasRole("USER")
                        )
                        .formLogin((formLogin) ->
                                formLogin
                                        .usernameParameter("username")
                                        .passwordParameter("password")
                                        .loginPage("/authentication/login")
                                        .failureUrl("/authentication/login?failed")
                                        .loginProcessingUrl("/authentication/login/process")
                        );
                return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService() {
                UserDetails user = User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();
                return new InMemoryUserDetailsManager(user);
        }
 }
```

- httpBasic:- Configures HTTP Basic authentication.

```java
@Configuration
 @EnableWebSecurity
 public class HttpBasicSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .authorizeRequests((authorizeRequests) ->
                                authorizeRequests
                                        .requestMatchers("/**").hasRole("USER")
                        )
                        .httpBasic(withDefaults());
                return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService() {
                UserDetails user = User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();
                return new InMemoryUserDetailsManager(user);
        }
 }
```

- authenticationManager:- Configure the default AuthenticationManager.
- userDetailsService:- Allows adding an additional UserDetailsService to be used

## Spring Security Configurations

- Java Config
- XML configuration

@EnableWebSecurity:- Add this annotation to an @Configuration class to have the Spring Security configuration defined in any WebSecurityConfigurer or more likely by exposing a SecurityFilterChain bean

SecurityFilterChain:- Defines a filter chain which is capable of being matched against an HttpServletRequest. in order to decide whether it applies to that request.Used to configure a FilterChainProxy.

WebSecurityConfigurer:- Allows customization to the WebSecurity. In most instances users will use EnableWebSecurity and create a Configuration that exposes a SecurityFilterChain bean. This will automatically be applied to the WebSecurity by the EnableWebSecurity annotation.

- **Configuring the Filter Chain**:- The filter chain can be configured using Java-based configuration (@Configuration) or XML-based configuration. Here's an example using Java-based configuration:

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Bean
    public CustomFilter customFilter() {
        return new CustomFilter();
    }
}
```

- **Custom Filters** -You can also create and add custom filters to the filter chain. For example:

```java
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

public class CustomFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // Custom filter logic here
        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic here
    }

    @Override
    public void destroy() {
        // Cleanup logic here
    }
}
```

To add the custom filter to the filter chain:

```java
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .addFilterBefore(customFilter(), UsernamePasswordAuthenticationFilter.class)
        .csrf().disable()
        .authorizeRequests()
            .antMatchers("/public/**").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()
            .permitAll();
}
```

- **Understanding the Order**:The order in which filters are applied is crucial. Misordering can lead to unexpected behavior. Spring Security ensures the correct order by default, but custom filters need to be added in the right place.

By understanding and configuring the Spring Security filter chain correctly, you can effectively manage authentication, authorization, and other security concerns in your application.
