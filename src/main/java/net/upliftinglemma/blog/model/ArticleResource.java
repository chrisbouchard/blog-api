package net.upliftinglemma.blog.model;

import org.springframework.hateoas.ResourceSupport;

public class ArticleResource extends ResourceSupport {

    public String title;
    public String body;

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

}
