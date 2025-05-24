package com.wanted.cqrs.common.response;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApiResponse<T> {

    private final boolean success;
    private final String message;
    private final T data;
}
