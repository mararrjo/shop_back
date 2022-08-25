package com.example.myshop.exception;

public class ArticleNotFoundException extends RuntimeException {

    public ArticleNotFoundException(String id) {
        super("Not found article with id: " + id);
    }

}
