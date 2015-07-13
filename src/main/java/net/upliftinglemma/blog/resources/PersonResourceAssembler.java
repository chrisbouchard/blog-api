package net.upliftinglemma.blog.resources;

import net.upliftinglemma.blog.controllers.PersonController;
import net.upliftinglemma.blog.model.Person;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class PersonResourceAssembler extends ResourceAssemblerSupport<Person, PersonResource> {
    
    public PersonResourceAssembler() {
        super(PersonController.class, PersonResource.class);
    }

    @Override
    public PersonResource toResource(final Person entity) {
        final PersonResource resource = createResourceWithId(entity.getId(), entity);
        resource.setName(entity.getName());
        return resource;
    }

}
