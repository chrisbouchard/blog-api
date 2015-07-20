package net.upliftinglemma.blog.resources;

import org.springframework.hateoas.ResourceSupport;

public class PersonResource extends ResourceSupport {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
