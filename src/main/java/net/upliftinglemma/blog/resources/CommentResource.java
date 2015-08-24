package net.upliftinglemma.blog.resources;

import org.springframework.hateoas.ResourceSupport;

public class CommentResource extends ResourceSupport {

    public String body;

    public String getBody() {
        return body;
    }

    public void setBody(final String body) {
        this.body = body;
    }

}
