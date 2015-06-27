package net.upliftinglemma.blog.controllers;

import java.util.Arrays;
import java.util.List;

import net.upliftinglemma.blog.assemblers.CommentResourceAssembler;
import net.upliftinglemma.blog.model.Comment;
import net.upliftinglemma.blog.model.CommentResource;

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

    @Autowired private CommentResourceAssembler commentResourceAssembler;
    
    @RequestMapping(method=RequestMethod.GET)
    public List<CommentResource> showAll() {
        final List<Comment> comments = Arrays.asList(
                Comment.createWithId(1L),
                Comment.createWithId(2L),
                Comment.createWithId(3L)
                );
        
        return commentResourceAssembler.toResources(comments);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public CommentResource show(@PathVariable Long id) {
        final Comment comment = Comment.createWithId(id);
        return commentResourceAssembler.toResource(comment);
    }

}
