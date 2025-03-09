# Core

Core support package for annotations, meta-annotations, and merged annotations with attribute overrides.Found in package **org.springframework.core.annotation**.

It includes the Core Container.

The Core Container consists of the Core, Beans, Context, and Expression Language modules.

The Core and Beans modules provide the fundamental parts of the framework, including the IoC and Dependency Injection features. The BeanFactory is a sophisticated implementation of the factory pattern. It removes the need for programmatic singletons and allows you to decouple the configuration and specification of dependencies from your actual program logic.

The Context module builds on the solid base provided by the Core and Beans modules: it is a means to access objects in a framework-style manner that is similar to a JNDI registry. The Context module inherits its features from the Beans module and adds support for internationalization (using, for example, resource bundles), event-propagation, resource-loading, and the transparent creation of contexts by, for example, a servlet container. The Context module also supports Java EE features such as EJB, JMX ,and basic remoting. The ApplicationContext interface is the focal point of the Context module.

The Expression Language module provides a powerful expression language for querying and manipulating an object graph at runtime. It is an extension of the unified expression language (unified EL) as specified in the JSP 2.1 specification. The language supports setting and getting property values, property assignment, method invocation, accessing the context of arrays, collections and indexers, logical and arithmetic operators, named variables, and retrieval of objects by name from Spring’s IoC container. It also supports list projection and selection as well as common list aggregations.

@Order defines the sort order for an annotated component.
@AliasFor is an annotation that is used to declare aliases for annotation attributes.

## Validation, Data Binding, and Type Conversion

There are pros and cons for considering validation as business logic, and Spring offers a design for validation and data binding that does not exclude either one of them. Specifically, validation should not be tied to the web tier and should be easy to localize, and it should be possible to plug in any available validator. Considering these concerns, Spring provides a Validator contract that is both basic and eminently usable in every layer of an application.

Data binding is useful for letting user input be dynamically bound to the domain model of an application (or whatever objects you use to process user input). Spring provides the aptly named DataBinder to do exactly that. The Validator and the DataBinder make up the validation package, which is primarily used in but not limited to the web layer.

The BeanWrapper is a fundamental concept in the Spring Framework and is used in a lot of places. However, you probably do not need to use the BeanWrapper directly. Because this is reference documentation, however, we feel that some explanation might be in order. We explain the BeanWrapper in this chapter, since, if you are going to use it at all, you are most likely do so when trying to bind data to objects.

Spring’s DataBinder and the lower-level BeanWrapper both use PropertyEditorSupport implementations to parse and format property values. The PropertyEditor and PropertyEditorSupport types are part of the JavaBeans specification and are also explained in this chapter. Spring’s core.convert package provides a general type conversion facility, as well as a higher-level format package for formatting UI field values. You can use these packages as simpler alternatives to PropertyEditorSupport implementations. They are also discussed in this chapter.

Spring supports Java Bean Validation through setup infrastructure and an adaptor to Spring’s own Validator contract. Applications can enable Bean Validation once globally, as described in Java Bean Validation, and use it exclusively for all validation needs. In the web layer, applications can further register controller-local Spring Validator instances per DataBinder, as described in Configuring a DataBinder, which can be useful for plugging in custom validation logic.
Resources

## Validations

Validation ensures:

1. Data integrity in your APIs.
2. Better user experience with meaningful error messages.
3. Reduced bugs in the business logic.

- Use @Valid to validate incoming request data automatically.

```java
@RestController
@RequestMapping("/user")
public class UserController{
   @PostMapping
   public ResponseEntity<String> createUser(@Valid @RequestBody UserRequest request){
      return ResponseEntity.ok("user created");
   }
}
```

@Valid: Automatically triggers validation based on annotations in the UserRequest class.

- Use built-in annotations to validate fields in your DTOs

```java
public class UserRequest{

   @NotNull(message ="Name cannot be null")
   private String name;

   @Email(message ="Invalid Email")
   private String email;

   @Size(min =10, max =10, message ="Phone must be 10 digits")
   private String email;
}
```

1. @NotNull: Ensures the field is not null.
2. @Email: Validates email format.
3. @Size: Ensures the phone number has exactly 10 digits.

Handle Errors with @ExceptionHandler:- Customize error responses for invalid data.

```java
@ControllerAdvice
public class GlobalExceptionHandler{
   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<Map<String,String>> handleValidationExceptions(@MethodArgumentNotValidException ex){
      Map<String,String> errors = new HashMap<>();
      ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(
         error.getField(), error.getDefaultMessage()
      ));
      return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
   }
}
```

Extracts validation errors and returns them as a structured JSON response.

- Best Practices for Validation
   1. Validate at the DTO level using annotations.
   2. Use custom constraints for specific requirements.
   3. Handle exceptions globally with @ControllerAdvice.
   4. Avoid mixing validation logic with business logic.

Bean Validation:-  Bean Validation provides a common way of validation through constraint declaration and metadata for Java applications. To use it, you annotate domain model properties with declarative validation constraints which are then enforced by the runtime. There are built-in constraints, and you can also define your own custom constraints.
