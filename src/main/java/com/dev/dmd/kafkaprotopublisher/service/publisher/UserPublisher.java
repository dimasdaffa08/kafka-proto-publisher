package com.dev.dmd.kafkaprotopublisher.service.publisher;

import com.dev.dmd.kafkaprotopublisher.model.request.UserRequest;
import example.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserPublisher {

    private final KafkaTemplate<String, User.UserMessage> kafkaTemplate;

    @Value("user.kafka.topic")
    private String topic;

    public void publishMessage(UserRequest userRequest)  {
        var userMapping = User.UserMessage.newBuilder()
                .setPhoneNum(userRequest.phoneNum())
                .setEmail(userRequest.email())
                .setFirstName(userRequest.firstName())
                .setLastName(userRequest.lastName())
                .build();

        kafkaTemplate.send(topic, userMapping);
        log.info("Message published with topic : " + topic);
    }
}
