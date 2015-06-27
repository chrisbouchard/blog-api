package net.upliftinglemma.blog.dao;

import net.upliftinglemma.blog.model.Article;

import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> { }
