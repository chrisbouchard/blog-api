package net.upliftinglemma.blog.dao;

import net.upliftinglemma.blog.model.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> { }
