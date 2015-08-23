package net.upliftinglemma.blog.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import net.upliftinglemma.blog.controllers.ArticleController;
import net.upliftinglemma.blog.model.Article;

@Component
public class ArticleResourceAssembler extends ResourceAssemblerSupport<Article, ArticleResource> {

    private final EntityLinks entityLinks;

    @Autowired
    public ArticleResourceAssembler(final EntityLinks entityLinks) {
        super(ArticleController.class, ArticleResource.class);
        this.entityLinks = entityLinks;
    }

    @Override
    public ArticleResource toResource(final Article entity) {
        final ArticleResource resource = createResourceWithId(entity.getId(), entity);

        resource.setBody(entity.getBody());
        resource.setTitle(entity.getTitle());
        resource.setCommentCount(entity.getComments().size());

        resource.add(entityLinks.linkForSingleResource(entity.getAuthor()).withRel("author"));
        resource.add(entityLinks.linkForSingleResource(entity).slash("comments").withRel("comments"));

        return resource;
    }

}
