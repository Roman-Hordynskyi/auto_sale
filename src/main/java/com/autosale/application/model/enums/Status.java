package com.autosale.application.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    ACTIVE("active"),
    NOT_ACTIVE("not_active"),
    DELETED("deleted");

    @JsonValue
    private final String status;
}
