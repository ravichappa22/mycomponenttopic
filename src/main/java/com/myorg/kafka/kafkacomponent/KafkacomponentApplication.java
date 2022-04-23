package com.myorg.kafka.kafkacomponent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkacomponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkacomponentApplication.class, args);

	}

}
