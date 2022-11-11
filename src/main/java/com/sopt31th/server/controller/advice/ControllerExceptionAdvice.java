package com.sopt31th.server.controller.advice;

import com.sopt31th.server.common.dto.ApiResponse;
import com.sopt31th.server.common.exception.model.SoptException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * Sopt Custom Exception
     */
    @ExceptionHandler(SoptException.class)
    protected ResponseEntity<ApiResponse<Object>> handleBaseException(SoptException exception) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity.status(exception.getStatus())
                .body(ApiResponse.error(exception.getErrorCode()));
    }
}
