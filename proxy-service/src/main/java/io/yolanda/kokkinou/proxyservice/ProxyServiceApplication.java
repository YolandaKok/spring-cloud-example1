package io.yolanda.kokkinou.proxyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("io.yolanda.kokkinou.*")
public class ProxyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyServiceApplication.class, args);
	}

}
