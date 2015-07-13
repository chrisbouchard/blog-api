package net.upliftinglemma.blog.resources;

import net.upliftinglemma.blog.controllers.ArticleController;
import net.upliftinglemma.blog.model.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ArticleResourceAssembler extends ResourceAssemblerSupport<Article, ArticleResource> {
    
    @Autowired private EntityLinks entityLinks;

    public ArticleResourceAssembler() {
        super(ArticleController.class, ArticleResource.class);
    }

    @Override
    public ArticleResource toResource(final Article entity) {
        final ArticleResource resource = createResourceWithId(entity.getId(), entity);

        resource.setBody(entity.getBody());
        resource.setTitle(entity.getTitle());
        
        resource.add(
                entityLinks.linkForSingleResource(entity.getAuthor()).withRel("author"),
                entityLinks.linkForSingleResource(entity).slash("comments").withRel("comments")
                );

        return resource;
    }

}
