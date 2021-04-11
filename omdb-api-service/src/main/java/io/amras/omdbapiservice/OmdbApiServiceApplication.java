package io.amras.omdbapiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OmdbApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmdbApiServiceApplication.class, args);
	}

}
