package com.autosale.application.model.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiException {
    private Integer status;
    private String message;
    private String stacktrace;
    private List<Field> fields;

    public ApiException(Integer status, String message) {
        this(status, message, null, null);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Field {
        private String name;
        private String message;
    }
}
