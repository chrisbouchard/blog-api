package net.upliftinglemma.blog.services;

import javax.transaction.Transactional;

import net.upliftinglemma.blog.dao.CommentRepository;
import net.upliftinglemma.blog.model.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    
    @Autowired private CommentRepository commentRepository;
    
    @Transactional
    public Comment findOne(final Long id) {
        return commentRepository.findOne(id);
    }
    
    @Transactional
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

}
