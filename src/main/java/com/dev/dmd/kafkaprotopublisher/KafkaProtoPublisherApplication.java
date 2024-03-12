package com.dev.dmd.kafkaprotopublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
@ConfigurationPropertiesScan
public class KafkaProtoPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProtoPublisherApplication.class, args);
	}

}
