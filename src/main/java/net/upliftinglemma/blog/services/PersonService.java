package net.upliftinglemma.blog.services;

import javax.transaction.Transactional;

import net.upliftinglemma.blog.dao.PersonRepository;
import net.upliftinglemma.blog.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    @Autowired private PersonRepository personRepository;
    
    @Transactional
    public Person findOne(final Long id) {
        return personRepository.findOne(id);
    }
    
    @Transactional
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

}
