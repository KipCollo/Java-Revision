# Spring Boot CLI

Spring Boot CLI is a command-line abstraction that allows us to easily run Spring micro-services expressed as Groovy scripts. It also provides simplified and enhanced dependency management for those services.

- Installing the CLI

The Spring Boot CLI (Command-Line Interface) can be installed manually by using SDKMAN! (the SDK Manager) or by using Homebrew or MacPorts if you are an OSX user.

```bash
sdk install springboot
```

To verify the install, run the command:

```bash
spring --version
```

Spring Boot CLI provides several useful commands and features out-of-the-box. One of the most helpful features is Spring Shell, which wraps commands with the necessary spring prefix.
To start the embedded shell, we run:

```bash
spring shell
```
