package net.upliftinglemma.blog.dao;

import net.upliftinglemma.blog.model.Blog;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    
    public Blog findByName(String name);
    
}
