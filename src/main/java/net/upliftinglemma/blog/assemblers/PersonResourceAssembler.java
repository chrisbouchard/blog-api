package net.upliftinglemma.blog.assemblers;

import net.upliftinglemma.blog.model.Person;
import net.upliftinglemma.blog.model.PersonResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class PersonResourceAssembler extends ResourceAssemblerSupport<Person, PersonResource> {
    
    public PersonResourceAssembler() {
        super(Person.class, PersonResource.class);
    }

    @Override
    public PersonResource toResource(final Person entity) {
        final PersonResource resource = createResourceWithId(entity.getId(), entity);
        resource.setName(entity.getName());
        return resource;
    }

}
