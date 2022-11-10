package com.sopt31th.server.common.dto;

import com.sopt31th.server.common.exception.ErrorCode;
import com.sopt31th.server.common.exception.StatusCode;
import com.sopt31th.server.common.exception.SuccessCode;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    public static final ApiResponse<String> SUCCESS = success("OK");

    private int statusCode;
    private boolean success;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(StatusCode.SUCCESS.getStatus(), true,  "", data);
    }

    public static <T> ApiResponse<T> success(SuccessCode successCode) {
        return new ApiResponse<>(StatusCode.SUCCESS.getStatus(), true, successCode.getMessage(), null);
    }

    public static <T> ApiResponse<T> success(SuccessCode successCode, T data) {
        return new ApiResponse<>(StatusCode.SUCCESS.getStatus(), true, successCode.getMessage(), data);
    }

    public static <T> ApiResponse<T> error(ErrorCode errorCode) {
        return new ApiResponse<>(errorCode.getStatusCode().getStatus(), false, errorCode.getMessage(), null);
    }

    public static <T> ApiResponse<T> error(ErrorCode errorCode, String message) {
        return new ApiResponse<>(errorCode.getStatusCode().getStatus(), false, message, null);
    }
}
