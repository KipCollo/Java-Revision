# Spring web annotations

Annotations for binding requests to controllers and handler methods as well as for binding request parameters to method arguments.Defined in the package **org.springframework.web.bind.**

It includes:

* @BindParam - Annotation to bind values from a web request such as request parameters or path variables to fields of a Java object.
* @ControllerAdvice - Specialization of @Component for classes that declare @ExceptionHandler, @InitBinder, or @ModelAttribute methods to be shared across multiple @Controller classes.
* @CookieValue - Annotation to indicate that a method parameter is bound to an HTTP cookie.
* @CrossOrigin - Annotation for permitting cross-origin requests on specific handler classes and/or handler methods.
* @DeleteMapping - Annotation for mapping HTTP DELETE requests onto specific handler methods.
* @ExceptionHandler - Annotation for handling exceptions in specific handler classes and/or handler methods.
* @GetMapping - Annotation for mapping HTTP GET requests onto specific handler methods.is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).

```java
  @GetMapping("/home")
   public String hello(){
        return "Hello Controller";
   }
```

* @InitBinder - Annotation that identifies methods that initialize the WebDataBinder which will be used for populating command and form object arguments of annotated handler methods.
* @Mapping - Meta annotation that indicates a web mapping annotation.
* @MatrixVariable - Annotation which indicates that a method parameter should be bound to a name-value pair within a path segment.
* @ModelAttribute - Annotation that binds a method parameter or method return value to a named model attribute, exposed to a web view.
* @PatchMapping - Annotation for mapping HTTP PATCH requests onto specific handler methods.
* @PathVariable - Annotation which indicates that a method parameter should be bound to a URI template variable.
* @PostMapping - Annotation for mapping HTTP POST requests onto specific handler methods.
* @PutMapping - Annotation for mapping HTTP PUT requests onto specific handler methods.
* @RequestAttribute - Annotation to bind a method parameter to a request attribute.
* @RequestBody - Annotation indicating a method parameter should be bound to the body of the web request.Spring treats result of method as response.Converts response to JSON.
* @RequestHeader - Annotation which indicates that a method parameter should be bound to a web request header.
* @RequestMapping - Annotation for mapping web requests onto methods in request-handling classes with flexible method signatures.Both Spring MVC and Spring WebFlux support this annotation.Can be used both at the class and at the method level.Cannot be used in conjunction with other @RequestMapping annotations that are declared on the same element (class, interface, or method)

Methods:

* String[] consumes- Narrows the primary mapping by media types that can be consumed by the mapped handler.
* String[] headers - The headers of the mapped request, narrowing the primary mapping.
* RequestMethod[] method - The HTTP request methods to map to, narrowing the primary mapping: GET, POST, HEAD, OPTIONS, PUT, PATCH, DELETE, TRACE.
* String name - Assign a name to this mapping.
* String[] params - The parameters of the mapped request, narrowing the primary mapping.
* String[] path - The path mapping URIs — for example, "/profile".
* String[] produces - Narrows the primary mapping by media types that can be produced by the mapped handler.
* String[] value - The path mapping URIs — for example, "/profile".

```java
@RestController
@RequestMapping("/api")//class level
public class Customer {

    @RequestMapping("/home")// Method level
    public String hello(){
        return "Hello Controller";
    }

    @RequestMapping(value={"/student","/teacher"},//Multiple URI
         method=RequestMethod.GET//HTTP Methods
         produces={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
         consumes=MediaType.APPLICATION_XML_VALUE)
    public Student getStudent(){
        Student student = new Student(1, "Collins", "Finalist");
        return student;
    }
}
```

* @RequestParam - Annotation which indicates that a method parameter should be bound to a web request parameter.
* @RequestPart - Annotation that can be used to associate the part of a "multipart/form-data" request with a method argument.
* @ResponseBody - Annotation that indicates a method return value should be bound to the web response body.
* @ResponseStatus - Marks a method or exception class with the status ResponseStatus.code() and ResponseStatus.reason() that should be returned.
* @RestController - A convenience annotation that is itself annotated with @Controller and @ResponseBody.Used to develop RESTful web apps.
* @RestControllerAdvice - A convenience annotation that is itself annotated with @ControllerAdvice and @ResponseBody.
* @SessionAttribute - Annotation to bind a method parameter to a session attribute.
* @SessionAttributes - Annotation that indicates the session attributes that a specific handler uses.
ValueConstants
Common value constants shared between bind annotations.
