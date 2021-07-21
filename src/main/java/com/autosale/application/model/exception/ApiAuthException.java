package com.autosale.application.model.exception;

import org.springframework.security.core.AuthenticationException;

public class ApiAuthException extends AuthenticationException {

    public ApiAuthException(String msg, Throwable t) {
        super(msg, t);
    }

    public ApiAuthException(String msg) {
        super(msg);
    }
}
