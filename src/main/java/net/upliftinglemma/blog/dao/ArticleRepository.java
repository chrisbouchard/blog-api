package net.upliftinglemma.blog.dao;

import net.upliftinglemma.blog.model.Article;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> { }
