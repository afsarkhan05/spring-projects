# spring-projects

#Spring Cloud Example

Full example with Spring Cloud:

* Eureka Discovery Server
* Microservice Registration to eureka server


***

See [Spring Cloud](http://projects.spring.io/spring-cloud/) for official reference

for the example we use this Spring Cloud version:
```xml
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-dependencies</artifactId>
    <version>2023.0.0</version>
```

Spring boot parent latest version:
```xml
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.2.1</version>
```

This example will create a simple service to run eureka server and register one or many microservices

## Discovery Server (Eureka)

Spring uses Netflix eureka technology as implementation for service discovery, called Eureka Server.
This server run under Spring boot, and its include in Spring Cloud Packages.

***

### Try it out

#### Eureka Server

Start the server

```
cd spring-discovery/spring-discovery-service
mvn spring-boot:run
```

Visit the Eureka dashboard via any browser at http://localhost:8761

As you can note there is currently no services registered


#### Eureka Client

Start up a eureka client

Visit the client directly at http://localhost:8081/first-service/hello

also if you access http://localhost:8761 it will give you detail about client registered.

You can get more detail about the same at http://localhost:8761/eureka/apps

You can run one more client (microservice) and register to eureka server


```
cd spring-discovery/spring-discovery-service
mvn spring-boot:run -Dspring.application.name=second-service -Dserver.port=8082 -Dspring.application.name=secondApp
```



Following simple changes required 

At Eureka server

In this simple example only include the annotations
```java
@EnableEurekaServer
@SpringBootApplication
```

We need to include following dependency to make microservice as eureka server
```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
```

```properties

server:
  port: 8761
eureka:
  instance:
    hostname: localhost
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```

Following changes at microservice (Client service)

```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
```

```java
@EnableDiscoveryClient
```

We have to configure it in src/main/resources/application.properties file, by default eureka try to autoregister himself,and we dont want to do that.We configure the port too:

```yaml
spring:
  application:
    name: myClientApp

eureka:
  instance:
    name: localhost
  client:
    registerWithEureka: true
    fetchRegistry: true
    service-url:
      defaultZone: http://127.0.0.1:8761/eureka
```

