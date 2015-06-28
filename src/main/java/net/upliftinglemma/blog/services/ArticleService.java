package net.upliftinglemma.blog.services;

import javax.transaction.Transactional;

import net.upliftinglemma.blog.dao.ArticleRepository;
import net.upliftinglemma.blog.model.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    
    private final ArticleRepository articleRepository;
    
    @Autowired
    public ArticleService(final ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Transactional
    public Article findOne(final Long id) {
        return articleRepository.findOne(id);
    }
    
    @Transactional
    public Iterable<Article> findAll() {
        return articleRepository.findAll();
    }

}
