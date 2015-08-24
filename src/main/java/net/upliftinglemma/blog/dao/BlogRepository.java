package net.upliftinglemma.blog.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.upliftinglemma.blog.model.Blog;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {

    public Blog findByName(String name);

}
