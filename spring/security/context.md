# Context

 A security context is usually associated with the current execution thread for the duration of the request, making the authentication information it contains available throughout all the layers of an application.

The SecurityContext can be accessed at any point by calling the SecurityContextHolder.

- SecurityContext:- Interface defining the minimum security information associated with the current thread of execution.The security context is stored in a SecurityContextHolder.
  1. Authentication getAuthentication() - Obtains the currently authenticated principal, or an authentication request token.
  2. void setAuthentication(Authentication authentication) - Changes the currently authenticated principal, or removes the authentication information.

- SecurityContextHolder:- Associates a given SecurityContext with the current execution thread.This class provides a series of static methods that delegate to an instance of SecurityContextHolderStrategy. The purpose of the class is to provide a convenient way to specify the strategy that should be used for a given JVM. This is a JVM-wide setting, since everything in this class is static to facilitate ease of use in calling code.
- To specify which strategy should be used, you must provide a mode setting. A mode setting is one of the three valid MODE_ settings defined as static final fields, or a fully qualified classname to a concrete implementation of SecurityContextHolderStrategy that provides a public no-argument constructor.
- There are two ways to specify the desired strategy mode String. The first is to specify it via the system property keyed on SYSTEM_PROPERTY. The second is to call setStrategyName(String) before using the class. If neither approach is used, the class will default to using MODE_THREADLOCAL, which is backwards compatible, has fewer JVM incompatibilities and is appropriate on servers (whereas MODE_GLOBAL is definitely inappropriate for server use).
