package net.upliftinglemma.blog.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.upliftinglemma.blog.model.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Person findByName(String name);

}
