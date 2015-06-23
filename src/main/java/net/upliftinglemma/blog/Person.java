package net.upliftinglemma.blog;

public class Person {
    
    private final long id;
    private final String name;

    public Person(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
