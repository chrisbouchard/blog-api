package net.upliftinglemma.blog.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.upliftinglemma.blog.model.Article;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {}
