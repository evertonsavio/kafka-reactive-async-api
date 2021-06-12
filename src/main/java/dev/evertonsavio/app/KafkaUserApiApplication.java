package dev.evertonsavio.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration
public class KafkaUserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaUserApiApplication.class, args);
	}

}
