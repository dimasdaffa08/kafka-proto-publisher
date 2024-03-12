package com.dev.dmd.kafkaprotopublisher.model.request;

import io.soabase.recordbuilder.core.RecordBuilder;
import jakarta.validation.constraints.NotBlank;

@RecordBuilder
public record UserRequest(
        @NotBlank
        String phoneNum,
        @NotBlank
        String email,
        @NotBlank
        String firstName,
        String lastName
) { }
