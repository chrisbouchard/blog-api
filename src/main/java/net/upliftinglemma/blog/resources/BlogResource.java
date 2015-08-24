package net.upliftinglemma.blog.resources;

import org.springframework.hateoas.ResourceSupport;

public class BlogResource extends ResourceSupport {

    private String name;
    private String tagline;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(final String title) {
        name = title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(final String subtitle) {
        tagline = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
