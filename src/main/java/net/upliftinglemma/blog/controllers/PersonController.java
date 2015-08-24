package net.upliftinglemma.blog.controllers;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.upliftinglemma.blog.dao.PersonRepository;
import net.upliftinglemma.blog.model.Person;
import net.upliftinglemma.blog.resources.PersonResource;
import net.upliftinglemma.blog.resources.PersonResourceAssembler;

@RestController
@ExposesResourceFor(Person.class)
@RequestMapping(value = "/person", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonResourceAssembler personResourceAssembler;

    @Autowired
    public PersonController(final PersonRepository personRepository,
            final PersonResourceAssembler personResourceAssembler) {
        this.personRepository = personRepository;
        this.personResourceAssembler = personResourceAssembler;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<PersonResource> showAll() {
        return personResourceAssembler.toResources(personRepository.findAll());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public PersonResource show(@PathVariable final Long id) {
        return personResourceAssembler.toResource(personRepository.findOne(id));
    }

}
