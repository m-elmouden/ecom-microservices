package com.microservice.productcomposite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer

public class ProductCompositeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCompositeApplication.class, args);
    }

}
