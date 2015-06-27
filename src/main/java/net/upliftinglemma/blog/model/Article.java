package net.upliftinglemma.blog.model;

import org.springframework.hateoas.Identifiable;

public class Article implements Identifiable<Long> {
    
    private Long id;
    private Person author;
    private String title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }
    
    public void setBody(String body) {
        this.body = body;
    }

    
    public static Article createWithId(final Long id) {
        final Article article = new Article();
        final Person author = Person.createWithId(1L);
        
        article.setId(id);
        article.setAuthor(author);
        article.setTitle("Hello World");
        article.setBody("Lorem ipsum dolor sit amen.");
        
        return article;
    }

}
