package net.upliftinglemma.blog.resources;

import net.upliftinglemma.blog.controllers.ArticleController;
import net.upliftinglemma.blog.model.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ArticleSummaryResourceAssembler extends ResourceAssemblerSupport<Article, ArticleSummaryResource> {
    
    private final EntityLinks entityLinks;

    @Autowired
    public ArticleSummaryResourceAssembler(final EntityLinks entityLinks) {
        super(ArticleController.class, ArticleSummaryResource.class);
        this.entityLinks = entityLinks;
    }

    @Override
    public ArticleSummaryResource toResource(final Article entity) {
        final ArticleSummaryResource resource = createResourceWithId(entity.getId(), entity);

        resource.setTitle(entity.getTitle());
        resource.setCommentCount(entity.getComments().size());
        
        resource.add(entityLinks.linkForSingleResource(entity.getAuthor()).withRel("author"));

        return resource;
    }

}
