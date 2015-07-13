package net.upliftinglemma.blog.controllers;

import java.util.List;

import net.upliftinglemma.blog.model.Article;
import net.upliftinglemma.blog.resources.ArticleResource;
import net.upliftinglemma.blog.resources.ArticleResourceAssembler;
import net.upliftinglemma.blog.resources.ArticleSummaryResource;
import net.upliftinglemma.blog.resources.ArticleSummaryResourceAssembler;
import net.upliftinglemma.blog.resources.CommentResource;
import net.upliftinglemma.blog.resources.CommentResourceAssembler;
import net.upliftinglemma.blog.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Article.class)
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    private final ArticleResourceAssembler articleResourceAssembler;
    private final ArticleSummaryResourceAssembler articleSummaryResourceAssembler;
    private final CommentResourceAssembler commentResourceAssembler;
    
    @Autowired
    public ArticleController(final ArticleService articleService, final ArticleResourceAssembler articleResourceAssembler,
            final ArticleSummaryResourceAssembler articleSummaryResourceAssembler,
            final CommentResourceAssembler commentResourceAssembler) {
        this.articleService = articleService;
        this.articleResourceAssembler = articleResourceAssembler;
        this.articleSummaryResourceAssembler = articleSummaryResourceAssembler;
        this.commentResourceAssembler = commentResourceAssembler;
    }

    // TODO: Consider paging
    @RequestMapping(method=RequestMethod.GET)
    public List<ArticleSummaryResource> showAll() {
        return articleSummaryResourceAssembler.toResources(articleService.findAll());
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ArticleResource show(@PathVariable final Long id) {
        return articleResourceAssembler.toResource(articleService.findOne(id));
    }
    
    @RequestMapping(value="/{id}/comments", method=RequestMethod.GET)
    public List<CommentResource> showComments(@PathVariable final Long id) {
        final Article article = articleService.findOne(id);
        return commentResourceAssembler.toResources(article.getComments());
    }

}
