# Developer Tools

Spring Boot includes an additional set of tools that can make the application development experience a little more pleasant. The spring-boot-devtools module can be included in any project to provide additional development-time features. To include devtools support, simply add the module dependency to your build:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

```groovy
dependencies {
    compileOnly("org.springframework.boot:spring-boot-devtools")
}
```

Developer tools are automatically disabled when running a fully packaged application. If your application is launched using java -jar or if it’s started using a special classloader, then it is considered a “production application”. Flagging the dependency as optional in Maven or using compileOnly in Gradle is a best practice that prevents devtools from being transitively applied to other modules using your project.

repackaged archives do not contain devtools by default. If you want to use certain remote devtools feature, you’ll need to disable the excludeDevtools build property to include it. The property is supported with both the Maven and Gradle plugins.

`Automatic restart`:- Applications that use *spring-boot-devtools* will automatically restart whenever files on the classpath change. This can be a useful feature when working in an IDE as it gives a very fast feedback loop for code changes. By default, any entry on the classpath that points to a folder will be monitored for changes. Note that certain resources such as static assets and view templates do not need to restart the application.
