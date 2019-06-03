package com.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description 发现注册
 */
//@EnableEurekaClient
@EnableEurekaServer
@SpringBootApplication
public class DiscoveryApplicaion {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplicaion.class, args);
    }
}
