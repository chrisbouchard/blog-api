package net.upliftinglemma.blog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.hateoas.Identifiable;

@Entity
public class Article implements Identifiable<Long> {

    private Long id;
    private Person author;
    private String title;
    private String body;

    private List<Comment> comments;

    private Date createdAt;
    private Date updatedAt;
    
    public Article() {
        this.comments = new ArrayList<>();
    }

    @Override
    @Id @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @ManyToOne
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


    @OneToMany
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(final List<Comment> comments) {
        this.comments = comments;
    }


    @CreationTimestamp
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Date publishedAt) {
        this.createdAt = publishedAt;
    }

    @UpdateTimestamp
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final Date updatedAt) {
        this.updatedAt = updatedAt;
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
                && Objects.equals(this.getBody(), other.getBody())
                && Objects.equals(this.getComments(), other.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getAuthor(), this.getTitle(), this.getBody(), this.getComments());
    }

}
