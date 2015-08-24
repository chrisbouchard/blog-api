package net.upliftinglemma.blog.controllers;

import java.util.List;

import net.upliftinglemma.blog.dao.ArticleRepository;
import net.upliftinglemma.blog.model.Article;
import net.upliftinglemma.blog.resources.ArticleResource;
import net.upliftinglemma.blog.resources.ArticleResourceAssembler;
import net.upliftinglemma.blog.resources.ArticleSummaryResource;
import net.upliftinglemma.blog.resources.ArticleSummaryResourceAssembler;
import net.upliftinglemma.blog.resources.CommentResource;
import net.upliftinglemma.blog.resources.CommentResourceAssembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Article.class)
@RequestMapping(value = "/article", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ArticleController {

    private final ArticleRepository articleRepository;

    private final ArticleResourceAssembler articleResourceAssembler;
    private final ArticleSummaryResourceAssembler articleSummaryResourceAssembler;
    private final CommentResourceAssembler commentResourceAssembler;

    @Autowired
    public ArticleController(final ArticleRepository articleRepository,
            final ArticleResourceAssembler articleResourceAssembler,
            final ArticleSummaryResourceAssembler articleSummaryResourceAssembler,
            final CommentResourceAssembler commentResourceAssembler) {
        this.articleRepository = articleRepository;
        this.articleResourceAssembler = articleResourceAssembler;
        this.articleSummaryResourceAssembler = articleSummaryResourceAssembler;
        this.commentResourceAssembler = commentResourceAssembler;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ArticleResource show(@PathVariable final Long id) {
        return articleResourceAssembler.toResource(articleRepository.findOne(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ArticleSummaryResource> showAll(final Integer page) {
        final Pageable pageable = new PageRequest(page, 10);
        return articleSummaryResourceAssembler.toResources(articleRepository.findAll(pageable));
    }

    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
    public List<CommentResource> showComments(@PathVariable final Long id) {
        final Article article = articleRepository.findOne(id);
        return commentResourceAssembler.toResources(article.getComments());
    }

}
