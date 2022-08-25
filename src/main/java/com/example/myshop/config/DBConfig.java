package com.example.myshop.config;

import com.example.myshop.domain.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.myshop.repository.ArticleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DBConfig {

    private static final Logger log = LoggerFactory.getLogger(DBConfig.class);

    @Bean
    CommandLineRunner initDatabase(ArticleRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Article(1L, "Television", Double.valueOf(1000), 1L, new Date())));
            log.info("Preloading " + repository.save(new Article(2L, "Sound System", Double.valueOf(500), 2L, new Date())));
        };
    }
}
