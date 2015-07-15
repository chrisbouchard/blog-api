package net.upliftinglemma.blog.dao;

import net.upliftinglemma.blog.model.Comment;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> { }
