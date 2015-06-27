package net.upliftinglemma.blog.model;

import org.springframework.hateoas.Identifiable;

public class Person implements Identifiable<Long> {
    
    private Long id;
    private String name;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public static Person createWithId(final Long id) {
        final Person person = new Person();
        person.setId(id);
        person.setName("John Smith");
        return person;
    }

}
