# springdoc-openapi

springdoc-openapi java library helps to automate the generation of API documentation using spring boot projects. springdoc-openapi works by examining an application at runtime to infer API semantics based on spring configurations, class structure and various annotations.

Automatically generates documentation in JSON/YAML and HTML format APIs. This documentation can be completed by comments using swagger-api annotations.

- This library supports:
   1. OpenAPI 3
   2. Spring-boot v3 (Java 17 & Jakarta EE 9)
   3. JSR-303, specifically for @NotNull, @Min, @Max, and @Size.
   4. Swagger-ui
   5. OAuth 2
   6. GraalVM native images

For the integration between spring-boot and swagger-ui, add the library to the list of your project dependencies (No additional configuration is needed)

```xml
<dependency>
   <groupId>org.springdoc</groupId>
   <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
   <version>2.8.5</version>
</dependency>
```

- This will automatically deploy swagger-ui to a spring-boot application:
   1. Documentation will be available in HTML format, using the official swagger-ui jars
   2. The Swagger UI page will then be available at <http://server:port/context-path/swagger-ui.html> and the OpenAPI description will be available at the following url for json format: <http://server:port/context-path/v3/api-docs>
      - server: The server name or IP
      - port: The server port
      - context-path: The context path of the application
   3. Documentation can be available in yaml format as well, on the following path : /v3/api-docs.yaml

## Springdoc-openapi Features

- `Adding API Information and Security documentation`:-The library uses spring-boot application auto-configured packages to scan for the following annotations in spring beans: OpenAPIDefinition and Info. These annotations declare, API Information: Title, version, licence, security, servers, tags, security and externalDocs. For better performance of documentation generation, declare @OpenAPIDefinition and @SecurityScheme annotations within a spring managed bean.

- `Error Handling for REST using @ControllerAdvice`:-To generate documentation automatically, make sure all the methods declare the HTTP Code responses using the annotation: @ResponseStatus

## Migrating from SpringFox

- Remove springfox and swagger 2 dependencies. Add springdoc-openapi-starter-webmvc-ui dependency instead.

```xml
<dependency>
   <groupId>org.springdoc</groupId>
   <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
   <version>2.8.5</version>
</dependency>
```

```properties
# Disabling the /v3/api-docs endpoint
springdoc.api-docs.enabled=false

# Disabling the swagger-ui
springdoc.swagger-ui.enabled=false
```

- Replace swagger 2 annotations with swagger 3 annotations (it is already included with springdoc-openapi-starter-webmvc-ui dependency). Package for swagger 3 annotations is io.swagger.v3.oas.annotations.

    @Api → @Tag

    @ApiIgnore → @Parameter(hidden = true) or @Operation(hidden = true) or @Hidden

    @ApiImplicitParam → @Parameter

    @ApiImplicitParams → @Parameters

    @ApiModel → @Schema

    @ApiModelProperty(allowEmptyValue = true) → @Schema(nullable = true)

    @ApiModelProperty → @Schema

    @ApiOperation(value = "foo", notes = "bar") → @Operation(summary = "foo", description = "bar")

    @ApiParam → @Parameter

    @ApiResponse(code = 404, message = "foo") → @ApiResponse(responseCode = "404", description = "foo")

For custom path of the OpenAPI documentation in Json format, add a custom springdoc property, in your spring-boot configuration file:

```java
# /api-docs endpoint custom path
springdoc.api-docs.path=/api-docs
```

## Annotations

Spring OpenAPI (via SpringDoc) provides several annotations to document your REST API. Here is a categorized list of the most commonly used ones:

- `API Documentation-Level Annotations`:- These are used to describe the overall API.
   1. @OpenAPIDefinition - Defines metadata for the entire API.
   2. @Info - Used inside @OpenAPIDefinition to provide general information.
   3. @Server - Defines server information.

```java
@OpenAPIDefinition(
    info = @Info(title = "My API", version = "1.0", description = "API documentation"),
    servers = {@Server(url = "http://localhost:8080", description = "Local Server")}
)
@Configuration
public class OpenAPIConfig {}
```

- `Controller-Level Annotations`:- These help organize API endpoints.
   1. @Tag - Groups related API endpoints.
   2. @Operation - Describes a single API operation.
   3. @ApiResponse - Defines possible responses for an endpoint.
   4. @ApiResponses - Groups multiple @ApiResponse annotations.

```java
@Tag(name = "User Management", description = "Operations related to users")
@Operation(summary = "Get user details", description = "Fetch details of a specific user")
@ApiResponse(responseCode = "200", description = "Successfully retrieved user")
@ApiResponse(responseCode = "404", description = "User not found")
@ApiResponses({
    @ApiResponse(responseCode = "200", description = "Success"),
    @ApiResponse(responseCode = "400", description = "Invalid Request")
})
```

- `Parameter and Request Body Annotations`:- Used for documenting request parameters and request bodies.
   1. @Parameter - Describes a request parameter.
   2. @RequestBody- Marks the request body, often used with @io.swagger.v3.oas.annotations.parameters.RequestBody.

```java
@GetMapping("/users/{id}")
public User getUser(
    @Parameter(description = "User ID", required = true) @PathVariable Long id
) {
    return userService.getUserById(id);
}

@PostMapping("/users")
public User createUser(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User data") 
    @RequestBody User user
) {
    return userService.createUser(user);
}
```

- `Security Annotations`:- Used for authentication and authorization.
   1. @SecurityRequirement- Defines security requirements for an operation.
   2. @SecurityScheme - Configures security schemes.

```Java
@SecurityRequirement(name = "bearerAuth")

@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT"
)
@Configuration
public class SecurityConfig {}
```

- `Schema and Model Annotations`:- Used for defining data models.
   1. @Schema - Describes model properties.
   2. @ArraySchema - Describes an array-type field.

```java
public class User {
    @Schema(description = "Unique identifier of the user", example = "1")
    private Long id;

    @Schema(description = "User's name", example = "John Doe")
    private String name;
}

@ArraySchema(schema = @Schema(description = "List of user roles", example = "[\"admin\", \"user\"]"))
private List<String> roles;
```
