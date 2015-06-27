package net.upliftinglemma.blog.controllers;

import java.util.Arrays;
import java.util.List;

import net.upliftinglemma.blog.assemblers.ArticleResourceAssembler;
import net.upliftinglemma.blog.assemblers.CommentResourceAssembler;
import net.upliftinglemma.blog.model.Article;
import net.upliftinglemma.blog.model.ArticleResource;
import net.upliftinglemma.blog.model.Comment;
import net.upliftinglemma.blog.model.CommentResource;

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

    @Autowired private ArticleResourceAssembler articleResourceAssembler;
    @Autowired private CommentResourceAssembler commentResourceAssembler;
    
    @RequestMapping(method=RequestMethod.GET)
    public List<ArticleResource> showAll() {
        final List<Article> articles = Arrays.asList(
                Article.createWithId(1L),
                Article.createWithId(2L),
                Article.createWithId(3L)
                );
        
        return articleResourceAssembler.toResources(articles);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ArticleResource show(@PathVariable Long id) {
        final Article article = Article.createWithId(id);
        return articleResourceAssembler.toResource(article);
    }
    
    @RequestMapping(value="/{id}/comments", method=RequestMethod.GET)
    public List<CommentResource> showComments() {
        final List<Comment> comments = Arrays.asList(
                Comment.createWithId(1L),
                Comment.createWithId(2L),
                Comment.createWithId(3L)
                );
        
        return commentResourceAssembler.toResources(comments);
    }

}
