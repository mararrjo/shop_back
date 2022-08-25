package com.example.myshop.service;

import com.example.myshop.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {

    public List<ArticleDTO> getList();
    public ArticleDTO getArticle(String id);

}
