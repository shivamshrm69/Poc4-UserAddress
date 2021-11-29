package com.poc4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class Poc4UserAddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(Poc4UserAddressApplication.class, args);
	}
@Bean
@LoadBalanced
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
}
