package com.example.myshop.mapper;

import com.example.myshop.domain.Article;
import com.example.myshop.dto.ArticleDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleMapper {

    public static ArticleDTO toDTO(Article article) {
        return new ArticleDTO(
                article.getId(),
                article.getName(),
                article.getPrice(),
                article.getStock(),
                article.getCreateAt()
        );
    }

    public static Article toEntity(ResultSet result) throws SQLException {
        return new Article(
                result.getLong("id"),
                result.getString("name"),
                result.getDouble("price"),
                result.getLong("stock"),
                result.getDate("create_at")
        );
    }
}
