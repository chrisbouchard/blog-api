package net.upliftinglemma.blog.dao;

import net.upliftinglemma.blog.model.Comment;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> { }
