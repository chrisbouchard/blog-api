package net.upliftinglemma.blog.controllers;

import java.util.List;

import net.upliftinglemma.blog.model.Comment;
import net.upliftinglemma.blog.resources.CommentResource;
import net.upliftinglemma.blog.resources.CommentResourceAssembler;
import net.upliftinglemma.blog.services.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Comment.class)
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private final CommentResourceAssembler commentResourceAssembler;
    
    @Autowired
    public CommentController(final CommentService commentService, final CommentResourceAssembler commentResourceAssembler) {
        this.commentService = commentService;
        this.commentResourceAssembler = commentResourceAssembler;
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<CommentResource> showAll() {
        return commentResourceAssembler.toResources(commentService.findAll());
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public CommentResource show(@PathVariable final Long id) {
        return commentResourceAssembler.toResource(commentService.findOne(id));
    }

}
