package net.upliftinglemma.blog.controllers;

import java.util.List;

import net.upliftinglemma.blog.assemblers.PersonResourceAssembler;
import net.upliftinglemma.blog.model.Person;
import net.upliftinglemma.blog.model.PersonResource;
import net.upliftinglemma.blog.services.PersonService;

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
    
    @Autowired private PersonService personService;
    @Autowired private PersonResourceAssembler personResourceAssembler;
    
    @RequestMapping(method=RequestMethod.GET)
    public List<PersonResource> showAll() {
        return personResourceAssembler.toResources(personService.findAll());
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public PersonResource show(@PathVariable final Long id) {
        return personResourceAssembler.toResource(personService.findOne(id));
    }

}
