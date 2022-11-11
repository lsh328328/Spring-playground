package com.sopt31th.server.common.exception.model;

import com.sopt31th.server.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class SoptException extends  RuntimeException {
    private final ErrorCode errorCode;

    public SoptException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getStatus() {
        return errorCode.getStatus();
    }
}
