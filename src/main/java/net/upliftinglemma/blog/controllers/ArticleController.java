package net.upliftinglemma.blog.controllers;

import java.util.List;

import net.upliftinglemma.blog.model.Article;
import net.upliftinglemma.blog.resources.ArticleResource;
import net.upliftinglemma.blog.resources.ArticleResourceAssembler;
import net.upliftinglemma.blog.resources.CommentResource;
import net.upliftinglemma.blog.resources.CommentResourceAssembler;
import net.upliftinglemma.blog.services.ArticleService;
import net.upliftinglemma.blog.services.CommentService;

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

    @Autowired private ArticleService articleService;
    @Autowired private ArticleResourceAssembler articleResourceAssembler;

    @Autowired private CommentService commentService;
    @Autowired private CommentResourceAssembler commentResourceAssembler;
    
    @RequestMapping(method=RequestMethod.GET)
    public List<ArticleResource> showAll() {
        return articleResourceAssembler.toResources(articleService.findAll());
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ArticleResource show(@PathVariable Long id) {
        return articleResourceAssembler.toResource(articleService.findOne(id));
    }
    
    @RequestMapping(value="/{id}/comments", method=RequestMethod.GET)
    public List<CommentResource> showComments() {
        // TODO: Only get comments for this article.
        return commentResourceAssembler.toResources(commentService.findAll());
    }

}
