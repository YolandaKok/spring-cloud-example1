package io.yolanda.kokkinou.proxyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import io.yolanda.kokkinou.endpoints.UserServiceEndpoint;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("io.yolanda")
@ComponentScan(basePackages = "io.yolanda.kokkinou.*")
@EnableHystrix
public class ProxyServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProxyServiceApplication.class, args);
	}
}
