package com.dev.dmd.kafkaprotopublisher.config;

import com.dev.dmd.kafkaprotopublisher.config.properties.KafkaProperties;
import com.dev.dmd.kafkaprotopublisher.constant.Constants;
import example.user.User;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaPublisherConfig {

    private final KafkaProperties kafkaProperties;

    @Bean
    public ProducerFactory<String, User.UserMessage> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.bootStrapServer());
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, kafkaProperties.valueSerializer());
        configProps.put(Constants.SCHEMA_REGISTRY_URL, kafkaProperties.schemaRegistryUrl());

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, User.UserMessage> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
