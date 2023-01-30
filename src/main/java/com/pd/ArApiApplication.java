package com.pd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ArApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArApiApplication.class, args);
	}

	@Bean
	public WebClient getWebClient() {
		return WebClient.builder().build();
	}

	@Bean
	public RestTemplate restTemplate() {

		return new RestTemplate();
	}
}
