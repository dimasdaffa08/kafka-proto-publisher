package com.dev.dmd.kafkaprotopublisher.service;

import com.dev.dmd.kafkaprotopublisher.model.request.UserRequest;
import com.dev.dmd.kafkaprotopublisher.model.response.UserResponse;
import com.dev.dmd.kafkaprotopublisher.model.response.UserResponseBuilder;
import com.dev.dmd.kafkaprotopublisher.service.publisher.UserPublisher;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserPublisher userPublisher;

    public ResponseEntity<UserResponse> execute(@Valid UserRequest userRequest) {
        var userId = UUID.randomUUID().toString();

        try {
            userPublisher.publishMessage(userRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(UserResponseBuilder.builder()
                .userId(userId)
                .build());
    }
}
