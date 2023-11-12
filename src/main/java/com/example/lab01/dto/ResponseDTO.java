package com.example.lab01.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String errorCode;
    private String message;

}
