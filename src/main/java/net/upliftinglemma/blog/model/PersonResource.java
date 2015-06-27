package net.upliftinglemma.blog.model;

import org.springframework.hateoas.ResourceSupport;

public class PersonResource extends ResourceSupport {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
