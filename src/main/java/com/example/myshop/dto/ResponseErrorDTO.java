package com.example.myshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseErrorDTO {

    private String message;
    private int code;
    private String codeDesc;

}
