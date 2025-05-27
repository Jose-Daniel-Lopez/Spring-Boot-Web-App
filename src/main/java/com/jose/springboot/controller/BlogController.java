package com.jose.springboot.controller;

import com.jose.springboot.dto.CommentDto;
import com.jose.springboot.dto.PostDto;
import com.jose.springboot.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {

    private final PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

    /**
     * Handles the request to display all blog posts.
     *
     * @param model the Model object to pass data to the view
     * @return the name of the view to render all posts
     */
    @GetMapping("/posts")
    public String viewBlogPosts(Model model) {
        List<PostDto> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "public/posts";
    }

    /**
     * Handles the request to view a specific blog post by its URL.
     *
     * @param postUrl the URL identifier of the post
     * @param model   the Model object to pass data to the view
     * @return the name of the view to render the specific post, or an error page if not found
     */
    @GetMapping("/posts/{postUrl}/view")
    public String viewPost(@PathVariable("postUrl") String postUrl,
                           Model model) {

        PostDto post = postService.findPostByUrl(postUrl);
        CommentDto commentDto = new CommentDto();
        model.addAttribute("post", post);
        model.addAttribute("comment", commentDto);

        return "public/view-post";
    }

    /**
     * Handles the request to search for blog posts based on a query.
     *
     * @param query the search query provided by the user
     * @param model the Model object to pass data to the view
     * @return the name of the view to render the search results
     */
    @GetMapping("/posts/dashboard/search")
    public String searchPost(@RequestParam(value = "query") String query, Model model) {

        List<PostDto> posts = postService.searchPosts(query);
        model.addAttribute("posts", posts);

        return "admin/posts";
    }
    
}
