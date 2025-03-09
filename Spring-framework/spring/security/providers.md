# Authentication Providers

AuthenticationProvider:- Indicates a class can process a specific Authentication implementation.Implementing class includes DaoAuthenticationProvider, JaasAuthenticationProvider, JwtAuthenticationProvider,LdapAuthenticationProvider, OAuth2AuthorizationCodeAuthenticationProvider, OAuth2LoginAuthenticationProvider, OidcAuthorizationCodeAuthenticationProvider, OneTimeTokenAuthenticationProvider

  1. In-Memory Authentication:- Useful for simple applications or testing
  2. Database Authentication:- Authenticate using relational database
  3. LDAP Authentication:- Authentiate users against LDAP directory.
  4. OAuth2 and JWT:- For token-based authentication,Spring Security integrates with OAuth2 and supports JWTs for stateless application.

## DaoAuthenticationProvider

An AuthenticationProvider implementation that retrieves user details from a UserDetailsService.

Method:-

1. setPasswordEncoder(PasswordEncoder passwordEncoder) - Sets the PasswordEncoder instance to be used to encode and validate passwords. If not set, the password will be compared using PasswordEncoderFactories.createDelegatingPasswordEncoder()
2. setUserDetailsPasswordService(UserDetailsPasswordService userDetailsPasswordService)
3. setUserDetailsService(UserDetailsService userDetailsService)
4. public void setCompromisedPasswordChecker(CompromisedPasswordChecker compromisedPasswordChecker) - Sets the CompromisedPasswordChecker to be used before creating a successful authentication. Defaults to null.

```java
@Bean
public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,PasswordEncoder passwordEncoder) {

   DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
   authenticationProvider.setUserDetailsService(userDetailsService);
   authenticationProvider.setPasswordEncoder(passwordEncoder);

   ProviderManager providerManager = new ProviderManager(authenticationProvider);
   providerManager.setEraseCredentialsAfterAuthentication(false);
   return providerManager;

@Bean
public UserDetailsService userDetailsService() {
   //body
}

@Bean
public PasswordEncoder passwordEncoder() {
   //body
}
```

## JwtAuthenticationProvider

An AuthenticationProvider implementation of the Jwt-encoded Bearer Tokens for protecting OAuth 2.0 Resource Servers.This AuthenticationProvider is responsible for decoding and verifying a Jwt-encoded access token, returning its claims set as part of the Authentication statement.

Scopes are translated into GrantedAuthoritys according to the following algorithm: 1. If there is a "scope" or "scp" attribute, then if a String, then split by spaces and return, or if a Collection, then simply return 2. Take the resulting Collection of Strings and prepend the "SCOPE_" keyword, adding as GrantedAuthoritys.

## JaasAuthenticationProvider

An AuthenticationProvider implementation that retrieves user details from a JAAS login configuration.This AuthenticationProvider is capable of validating UsernamePasswordAuthenticationToken requests contain the correct username and password.

This implementation is backed by a JAAS configuration. The loginConfig property must be set to a given JAAS configuration file. This setter accepts a Spring Resource instance. It should point to a JAAS configuration file containing an index matching the loginContextName property.

1. afterPropertiesSet() - Validates the required properties are set.
2. setLoginConfig(org.springframework.core.io.Resource loginConfig) - Set the JAAS login configuration file.
3. setRefreshConfigurationOnStartup(boolean refresh) - If set, a call to Configuration#refresh() will be made by #configureJaas(Resource) method.
4. configureJaas(org.springframework.core.io.Resource loginConfig) - Hook method for configuring Jaas.

## OAuth2LoginAuthenticationProvider

An implementation of an AuthenticationProvider for OAuth 2.0 Login, which leverages the OAuth 2.0 Authorization Code Grant Flow. This AuthenticationProvider is responsible for authenticating an Authorization Code credential with the Authorization Server's Token Endpoint and if valid, exchanging it for an Access Token credential.

It will also obtain the user attributes of the End-User (Resource Owner) from the UserInfo Endpoint using an OAuth2UserService, which will create a Principal in the form of an OAuth2User. The OAuth2User is then associated to the OAuth2LoginAuthenticationToken to complete the authentication.

1. authenticate(Authentication authentication) - Performs authentication with the same contract as AuthenticationManager.authenticate(Authentication) .
2. setAuthoritiesMapper(GrantedAuthoritiesMapper authoritiesMapper) - Sets the GrantedAuthoritiesMapper used for mapping OAuth2AuthenticatedPrincipal.getAuthorities() to a new set of authorities which will be associated to the OAuth2LoginAuthenticationToken.
3. supports(Class<?> authentication) - Returns true if this AuthenticationProvider supports the indicated Authentication object.

## RememberMeAuthenticationProvider

An AuthenticationProvider implementation that validates RememberMeAuthenticationTokens.To be successfully validated, the RememberMeAuthenticationToken.getKeyHash() must match this class' getKey().

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
