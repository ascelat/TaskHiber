package com.example.HibernateApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseSuccessResponse {
    private Integer statusCode;

    private Boolean success;

    public BaseSuccessResponse(Boolean success) {
        this(0, success);
    }
}
