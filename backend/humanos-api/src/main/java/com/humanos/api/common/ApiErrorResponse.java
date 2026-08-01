package com.humanos.api.common;

import java.util.Map;

public record ApiErrorResponse(
        int status,
        String message,
        Map<String, String> errors
) {
}