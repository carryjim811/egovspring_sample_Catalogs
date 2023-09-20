package com.dkpia.catalogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * @ComponentScan("com.dkpia.*") : @controller, @repository 등을 찾아서 ioc container에 올림 
 * 스프링부트는 여기 main 메소드로 시작(mvc랑 다름)
 * @author anarc
 *
 */
@ComponentScan("com.dkpia.*")
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class CatalogsApplication {

	@Bean
//	@LoadBalanced
	public RestTemplate restTemplate() { 
		return new RestTemplate(); 
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CatalogsApplication.class, args);
	}

}
