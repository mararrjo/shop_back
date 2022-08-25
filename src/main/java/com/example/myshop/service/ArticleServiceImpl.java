package com.example.myshop.service;

import com.example.myshop.domain.Article;
import com.example.myshop.dto.ArticleDTO;
import com.example.myshop.exception.ArticleNotFoundException;
import com.example.myshop.mapper.ArticleMapper;
import com.example.myshop.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    public ArticleRepository repository;

    @Override
    public List<ArticleDTO> getList() {
        List<Article> list = repository.findAll();
        List<ArticleDTO> listDTO = list.stream()
                .map(article ->
                        ArticleMapper.toDTO(article))
                .collect(Collectors.toList());
        return listDTO;
    }

    @Override
    public ArticleDTO getArticle(String id) {
        Article article = repository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ArticleNotFoundException(id));
        return ArticleMapper.toDTO(article);
    }
}
