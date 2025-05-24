package com.wanted.cqrs.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiErrorResponse {

    private boolean success;
    private Error error;

    @AllArgsConstructor
    @Getter
    public static class Error {
        private ErrorCode code;
        private String message;
    }
}
