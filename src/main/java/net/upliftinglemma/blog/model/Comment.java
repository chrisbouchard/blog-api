package net.upliftinglemma.blog.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.hateoas.Identifiable;

@Entity
public class Comment implements Identifiable<Long> {
    
    private Long id;
    private Person author;
    private String body;
    
    private Article parent;

    private Date createdAt;
    private Date updatedAt;


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

    public String getBody() {
        return body;
    }

    public void setBody(final String body) {
        this.body = body;
    }


    @ManyToOne
    public Article getParent() {
        return parent;
    }

    public void setParent(Article parent) {
        this.parent = parent;
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

        if (!(obj instanceof Comment))
            return false;
        
        final Comment other = (Comment) obj;
        
        return Objects.equals(this.getAuthor(), other.getAuthor()) &&
                Objects.equals(this.getBody(), other.getBody()) &&
                Objects.equals(this.getParent(), other.getParent());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.getAuthor(), this.getBody(), this.getParent());
    }

}
