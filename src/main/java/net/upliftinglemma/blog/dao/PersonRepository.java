package net.upliftinglemma.blog.dao;

import net.upliftinglemma.blog.model.Person;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    
    Person findByName(String name);
    
}
