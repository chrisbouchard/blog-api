package net.upliftinglemma.blog.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.hateoas.Identifiable;

@Entity
@Table(indexes={@Index(columnList="name")})
public class Person implements Identifiable<Long> {

    private Long id;
    private String name;
    private boolean isAdmin;
    
    private List<Article> articles;
    private List<Comment> comments;


    @Override
    @Id @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Column(unique=true)
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }


    @OneToMany(mappedBy="author")
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(final List<Article> articles) {
        this.articles = articles;
    }

    @OneToMany(mappedBy="author")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(final List<Comment> comments) {
        this.comments = comments;
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
        
        return Objects.equals(this.getName(), other.getName());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }

}
