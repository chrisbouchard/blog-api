package net.upliftinglemma.blog.dao;

import java.util.List;

import net.upliftinglemma.blog.model.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
    
    List<Person> findByName(String name);
    
}
