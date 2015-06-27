package net.upliftinglemma.blog.model;

import org.springframework.hateoas.Identifiable;

public class Comment implements Identifiable<Long> {
    
    private Long id;
    private Person author;
    private String body;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    
    public static Comment createWithId(final Long id) {
        final Comment comment = new Comment();
        final Person author = Person.createWithId(1L);
        
        comment.setId(id);
        comment.setAuthor(author);
        comment.setBody("Lorem ipsum dolor sit amen.");
        
        return comment;
    }

}
