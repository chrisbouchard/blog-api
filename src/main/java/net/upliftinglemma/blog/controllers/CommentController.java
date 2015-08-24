package net.upliftinglemma.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.upliftinglemma.blog.dao.CommentRepository;
import net.upliftinglemma.blog.model.Comment;
import net.upliftinglemma.blog.resources.CommentResource;
import net.upliftinglemma.blog.resources.CommentResourceAssembler;

@RestController
@ExposesResourceFor(Comment.class)
@RequestMapping(value = "/comment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentResourceAssembler commentResourceAssembler;

    @Autowired
    public CommentController(final CommentRepository commentRepository,
            final CommentResourceAssembler commentResourceAssembler) {
        this.commentRepository = commentRepository;
        this.commentResourceAssembler = commentResourceAssembler;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CommentResource> showAll() {
        return commentResourceAssembler.toResources(commentRepository.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommentResource show(@PathVariable final Long id) {
        return commentResourceAssembler.toResource(commentRepository.findOne(id));
    }

}
