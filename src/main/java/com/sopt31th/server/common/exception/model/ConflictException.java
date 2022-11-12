package com.sopt31th.server.common.exception.model;

import com.sopt31th.server.common.exception.ErrorCode;

public class ConflictException extends SoptException {
    public ConflictException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public ConflictException(String message) {
        super(message, ErrorCode.CONFLICT_EXCEPTION);
    }
}
