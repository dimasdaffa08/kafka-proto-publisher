package com.dev.dmd.kafkaprotopublisher.controller;

import com.dev.dmd.kafkaprotopublisher.model.request.UserRequest;
import com.dev.dmd.kafkaprotopublisher.model.response.UserResponse;
import com.dev.dmd.kafkaprotopublisher.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/v1/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/generate-user-id")
    public ResponseEntity<UserResponse> generateUserId(@Valid @RequestBody UserRequest userRequest) {
        return userService.execute(userRequest);
    }
}
