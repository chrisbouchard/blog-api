package net.upliftinglemma.blog;

public class Article {
    
    private final long id;
    private final Person author;
    private final String title;
    private final String body;

    public Article(final long id, final Person author, final String title, final String body) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public Person getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

}
