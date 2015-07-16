package net.upliftinglemma.blog.resources;

import net.upliftinglemma.blog.controllers.BlogController;
import net.upliftinglemma.blog.model.Blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogResourceAssembler extends ResourceAssemblerSupport<Blog, BlogResource> {

    private final EntityLinks entityLinks;

    @Autowired
    public BlogResourceAssembler(final EntityLinks entityLinks) {
        super(BlogController.class, BlogResource.class);
        this.entityLinks = entityLinks;
    }

    @Override
    public BlogResource toResource(final Blog entity) {
        final BlogResource resource = createResourceWithId(entity.getId(), entity);

        resource.setTitle(entity.getTitle());
        resource.setSubtitle(entity.getSubtitle());
        resource.setDescription(entity.getDescription());
        
        resource.add(
                entityLinks.linkForSingleResource(entity).slash("articles").withRel("articles")
                );

        return resource;
    }

}
