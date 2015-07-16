package net.upliftinglemma.blog.resources;

import org.springframework.hateoas.ResourceSupport;

public class BlogResource extends ResourceSupport {

    private String name;
    private String tagline;
    private String description;

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

}
