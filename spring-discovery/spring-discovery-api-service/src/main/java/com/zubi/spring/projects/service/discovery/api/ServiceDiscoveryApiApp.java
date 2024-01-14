package com.zubi.spring.projects.service.discovery.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceDiscoveryApiApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscoveryApiApp.class, args);
    }
}