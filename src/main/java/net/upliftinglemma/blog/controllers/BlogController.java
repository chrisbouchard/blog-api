package net.upliftinglemma.blog.controllers;

import javax.ws.rs.core.MediaType;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.upliftinglemma.blog.model.Blog;

@RestController
@ExposesResourceFor(Blog.class)
@RequestMapping(value = "/blog", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
public class BlogController {

    // TODO: Implement this controller

}
