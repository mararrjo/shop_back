package com.example.myshop.controller;

import com.example.myshop.dto.ArticleDTO;
import com.example.myshop.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("article")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ArticleController {

    @Autowired
    private ArticleService service;

    @GetMapping
    public List<ArticleDTO> getArticles() {
        return service.getList();
    }

    @GetMapping("{id}")
    public ArticleDTO getArticle(@PathVariable String id) {
        return service.getArticle(id);
    }

}
