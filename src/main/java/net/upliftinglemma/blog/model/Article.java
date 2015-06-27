package net.upliftinglemma.blog.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.hateoas.Identifiable;

@Entity
public class Article implements Identifiable<Long> {

    private Long id;
    private Person author;
    private String title;
    private String body;

    @Override
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(final Person author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(final String body) {
        this.body = body;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null)
            return false;
        
        if (obj == this)
            return true;

        if (!(obj instanceof Article))
            return false;
        
        final Article other = (Article) obj;

        return Objects.equals(this.getId(), other.getId())
                && Objects.equals(this.getAuthor(), other.getAuthor())
                && Objects.equals(this.getTitle(), other.getTitle())
                && Objects.equals(this.getBody(), other.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getAuthor(), this.getTitle(),
                this.getBody());
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
