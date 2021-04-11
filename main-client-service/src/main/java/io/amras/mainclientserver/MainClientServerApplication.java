package io.amras.mainclientserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MainClientServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainClientServerApplication.class, args);
	}

}
