package com.dev.dmd.kafkaprotopublisher.model.response;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record UserResponse(
        String userId
) { }
