package com.dev.dmd.kafkaprotopublisher.service.publisher;

import com.dev.dmd.kafkaprotopublisher.config.properties.KafkaProperties;
import com.dev.dmd.kafkaprotopublisher.model.request.UserRequest;
import example.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserPublisher {

    private final KafkaTemplate<String, User.UserMessage> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    public void publishMessage(UserRequest userRequest)  {
        var userMapping = User.UserMessage.newBuilder()
                .setPhoneNum(userRequest.phoneNum())
                .setEmail(userRequest.email())
                .setFirstName(userRequest.firstName())
                .setLastName(userRequest.lastName())
                .build();

        kafkaTemplate.send(kafkaProperties.topicUser().topic(), userMapping);
        log.info("Message published with topic : " + kafkaProperties.topicUser().topic());
    }
}
