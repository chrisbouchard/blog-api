package net.upliftinglemma.blog.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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

    private Blog parent;
    private List<Comment> comments;

    private Date createdAt;
    private Date updatedAt;

    @Override
    @Id
    @GeneratedValue
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

    @ManyToOne
    public Blog getParent() {
        return parent;
    }

    public void setParent(final Blog parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
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
        createdAt = publishedAt;
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
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Article)) {
            return false;
        }

        final Article other = (Article) obj;

        return Objects.equals(getAuthor(), other.getAuthor()) && Objects.equals(getTitle(), other.getTitle())
                && Objects.equals(getBody(), other.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getTitle(), getBody());
    }

}
