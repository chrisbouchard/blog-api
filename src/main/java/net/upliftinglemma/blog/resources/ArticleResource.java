package net.upliftinglemma.blog.resources;

import org.springframework.hateoas.ResourceSupport;

public class ArticleResource extends ResourceSupport {

    public String title;
    public String body;

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

}
