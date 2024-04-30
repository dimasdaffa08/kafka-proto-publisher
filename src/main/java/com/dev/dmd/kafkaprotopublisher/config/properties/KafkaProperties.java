package com.dev.dmd.kafkaprotopublisher.config.properties;

import io.soabase.recordbuilder.core.RecordBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@RecordBuilder
@ConfigurationProperties(prefix = "kafka.config")
public record KafkaProperties(
        @DefaultValue("127.0.0.1:9092")
        String bootStrapServer,
        @DefaultValue("io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer")
        String valueSerializer,
        @DefaultValue("1")
        String schemaRegistryUrl,
        Topic topicUser
) {
    @RecordBuilder
    public record Topic(
            String topic,
            String groupId
    ) {}
}
