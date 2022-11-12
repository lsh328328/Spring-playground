package com.sopt31th.server.common.exception.model;

import com.sopt31th.server.common.exception.ErrorCode;

public class NotFoundException extends SoptException{
    public NotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public NotFoundException(String message) {
        super(message, ErrorCode.CONFLICT_EXCEPTION);
    }
}
