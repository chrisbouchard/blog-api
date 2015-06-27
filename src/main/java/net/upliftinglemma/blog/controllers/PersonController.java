package net.upliftinglemma.blog.controllers;

import java.util.Arrays;
import java.util.List;

import net.upliftinglemma.blog.assemblers.PersonResourceAssembler;
import net.upliftinglemma.blog.model.Person;
import net.upliftinglemma.blog.model.PersonResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Person.class)
@RequestMapping("/person")
public class PersonController {
    
    @Autowired private PersonResourceAssembler personResourceAssembler;
    
    @RequestMapping(method=RequestMethod.GET)
    public List<PersonResource> showAll() {
        final List<Person> persons = Arrays.asList(
                Person.createWithId(1L),
                Person.createWithId(2L),
                Person.createWithId(3L)
                );
        
        return personResourceAssembler.toResources(persons);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public PersonResource show(@PathVariable Long id) {
        final Person person = Person.createWithId(id);
        return personResourceAssembler.toResource(person);
    }

}
