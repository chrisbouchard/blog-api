package net.upliftinglemma.blog.controllers;

import java.util.List;

import net.upliftinglemma.blog.model.Person;
import net.upliftinglemma.blog.resources.PersonResource;
import net.upliftinglemma.blog.resources.PersonResourceAssembler;
import net.upliftinglemma.blog.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Person.class)
@RequestMapping(value="/person", produces="application/json")
public class PersonController {
    
    private final PersonService personService;
    private final PersonResourceAssembler personResourceAssembler;
    
    @Autowired
    public PersonController(final PersonService personService, final PersonResourceAssembler personResourceAssembler) {
        this.personService = personService;
        this.personResourceAssembler = personResourceAssembler;
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<PersonResource> showAll() {
        return personResourceAssembler.toResources(personService.findAll());
    }
    
    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public PersonResource show(@PathVariable final Long id) {
        return personResourceAssembler.toResource(personService.findOne(id));
    }

}
