package com.example.myshop;

import com.example.myshop.domain.Article;
import com.example.myshop.mapper.ArticleMapper;
import com.example.myshop.repository.ArticleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Profile("test")
public class MyShopTest {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ArticleRepository repository;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Test
    public void loadArticles() {
        List<Article> list = jdbcTemplate.query("select * from Article", (result, rowNumber) -> ArticleMapper.toEntity(result));
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void getArticleById1() {
        Optional<Article> article = repository.findById(1L);
        Assert.assertEquals(true, article.isPresent());
    }

    @Test
    public void notFoundArticle() {
        Optional<Article> article = repository.findById(3L);
        Assert.assertEquals(false, article.isPresent());
    }

}
