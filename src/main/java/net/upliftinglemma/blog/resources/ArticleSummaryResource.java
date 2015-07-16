package net.upliftinglemma.blog.resources;

import org.springframework.hateoas.ResourceSupport;

public class ArticleSummaryResource extends ResourceSupport {

    public String title;
    public int commentCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

}
