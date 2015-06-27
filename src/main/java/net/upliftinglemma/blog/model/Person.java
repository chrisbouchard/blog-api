package net.upliftinglemma.blog.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.hateoas.Identifiable;

@Entity
public class Person implements Identifiable<Long> {
    
    private Long id;
    private String name;


    @Override
    @Id @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    
    @Override
    public boolean equals(final Object obj) {
        if (obj == null)
            return false;
        
        if (obj == this)
            return true;

        if (!(obj instanceof Person))
            return false;
        
        final Person other = (Person) obj;
        
        return Objects.equals(this.getId(), other.getId()) &&
                Objects.equals(this.getName(), other.getName());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getName());
    }
    
    
    public static Person createWithId(final Long id) {
        final Person person = new Person();
        person.setId(id);
        person.setName("John Smith");
        return person;
    }

}
