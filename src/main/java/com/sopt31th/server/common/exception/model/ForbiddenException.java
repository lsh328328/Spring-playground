package com.sopt31th.server.common.exception.model;

import com.sopt31th.server.common.exception.ErrorCode;

public class ForbiddenException extends SoptException {
    public ForbiddenException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public ForbiddenException(String message) {
        super(message, ErrorCode.FORBIDDEN_EXCEPTION);
    }
}
