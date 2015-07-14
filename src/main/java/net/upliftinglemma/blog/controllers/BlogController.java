package net.upliftinglemma.blog.controllers;

import net.upliftinglemma.blog.model.Blog;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Blog.class)
@RequestMapping("/blog")
public class BlogController {

    // TODO: Implement this controller

}
