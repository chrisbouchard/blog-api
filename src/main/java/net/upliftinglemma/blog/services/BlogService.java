package net.upliftinglemma.blog.services;

import net.upliftinglemma.blog.dao.BlogRepository;
import net.upliftinglemma.blog.model.Blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogService {
    
    private final BlogRepository blogRepository;
    
    @Autowired
    public BlogService(final BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Transactional
    public Blog findOne(final Long id) {
        return blogRepository.findOne(id);
    }
    
    @Transactional
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

}
