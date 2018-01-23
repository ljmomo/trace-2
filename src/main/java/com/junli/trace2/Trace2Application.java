package com.junli.trace2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class Trace2Application {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/trace-2")
    public String trace() {
        logger.info("==========call trace-2===");
        return "Trace";
    }

	public static void main(String[] args) {
		SpringApplication.run(Trace2Application.class, args);
	}
}
