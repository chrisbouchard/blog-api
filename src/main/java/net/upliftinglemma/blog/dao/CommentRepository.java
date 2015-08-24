package net.upliftinglemma.blog.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.upliftinglemma.blog.model.Comment;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {}
