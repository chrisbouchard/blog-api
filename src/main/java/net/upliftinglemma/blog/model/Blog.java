package net.upliftinglemma.blog.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.hateoas.Identifiable;

@Entity
public class Blog implements Identifiable<Long> {

    private Long id;
    private String name;
    private String tagline;
    
    private String description;

    private List<Article> articles;

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

    @Column(unique=true)
    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String subtitle) {
        this.tagline = subtitle;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @OneToMany(mappedBy="parent")
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
