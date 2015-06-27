package net.upliftinglemma.blog.assemblers;

import net.upliftinglemma.blog.model.Comment;
import net.upliftinglemma.blog.model.CommentResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class CommentResourceAssembler extends ResourceAssemblerSupport<Comment, CommentResource> {
    
    @Autowired private EntityLinks entityLinks;

    public CommentResourceAssembler() {
        super(Comment.class, CommentResource.class);
    }

    @Override
    public CommentResource toResource(final Comment entity) {
        final CommentResource resource = createResourceWithId(entity.getId(), entity);
        resource.setBody(entity.getBody());
        resource.add(entityLinks.linkForSingleResource(entity.getAuthor()).withRel("author"));
        return resource;
    }

}