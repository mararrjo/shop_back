package com.example.myshop.exception;

import com.example.myshop.dto.ResponseErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ArticleNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ArticleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseErrorDTO articleNotFoundAdvice(ArticleNotFoundException ex) {
        return new ResponseErrorDTO(ex.getMessage(), 404, "NotFound");
    }
}
