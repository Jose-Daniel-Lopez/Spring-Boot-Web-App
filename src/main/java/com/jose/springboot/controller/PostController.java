package com.jose.springboot.controller;

import com.jose.springboot.dto.PostDto;
import com.jose.springboot.service.CommentService;
import com.jose.springboot.service.PostService;
import com.jose.springboot.util.ROLE;
import com.jose.springboot.util.SecurityUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private PostService postService;
    private CommentService commentService;

    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    // create handler method, GET request and return model and view
    @GetMapping("/posts/dashboard")
    public String posts(Model model) {
        String role = SecurityUtils.getRole();
        List<PostDto> posts = null;
        if (ROLE.ROLE_ADMIN.name().equals(role)) {
            posts = postService.findAllPosts();
        } else {
            posts = postService.findPostsByUser();
        }
        model.addAttribute("posts", posts);
        return "/admin/posts";
    }

    // Handler to remove comment
    @GetMapping("/posts/comments/{commentId}/delete")
    public String deleteComment(@PathVariable("commentId") Long commentId,
                                HttpServletRequest request) {
        commentService.deleteComment(commentId);

        // Obtener la URL de donde vino la petición
        String referer = request.getHeader("Referer");

        // Si existe el referer, redirigir ahí, sino a una página por defecto
        if (referer != null && !referer.isEmpty()) {
            return "redirect:" + referer;
        } else {
            return "redirect:/posts"; // fallback
        }
    }

    // Handler to create new post
    @GetMapping("/posts/new-post")
    public String newPostForm(Model model) {
        PostDto postDto = new PostDto();
        model.addAttribute("post", postDto);
        return "/admin/new-post";
    }


    @PostMapping("/posts/add")
    public String createPost(@Valid @ModelAttribute("post") PostDto postDto, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("post", postDto);
            return "/admin/new-post";
        }

        postDto.setUrl(getUrl(postDto.getTitle()));
        postService.createPost(postDto);

        return "redirect:/posts/dashboard";
    }

    private static String getUrl(String postTitle) {

        // Omit the spaces between words and replace them with hyphens
        return postTitle.trim().toLowerCase().replaceAll("\\s+", "-");
    }

    // Handler method to handle edit post request
    @GetMapping("/posts/{postId}/edit")
    public String editPostForm(@PathVariable("postId") Long postId, Model model) {

        PostDto postDto = postService.findPostById(postId);
        model.addAttribute("post", postDto);

        return "/admin/edit-post";
    }

    // Handler method to handle edit post form submit request
    @PostMapping("/posts/{postId}")
    public String updatePost(@PathVariable("postId") Long postId, @Valid @ModelAttribute("post") PostDto postDto, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("post", postDto);
            return "/admin/edit-post";
        }

        postDto.setId(postId);
        postService.updatePost(postDto);

        return "redirect:/posts/dashboard";
    }

    // Handler method to handle delete post request
    @GetMapping("/posts/{postId}/delete")
    public String deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);

        return "redirect:/posts/dashboard";
    }

    // Handler method to handle view post request
    /*
    @GetMapping("/posts/{postUrl}/view")
    public String viewPost(@PathVariable("postUrl") String postUrl, Model model) {
        PostDto postDto = postService.findPostByUrl(postUrl);
        model.addAttribute("post", postDto);

        return "admin/view-post";
    } */


    // Handler method for search blog posts request
    // Use example: localhost:8080/admin/posts/search?query='title || shortDescription'

    @GetMapping("/posts/search")
    public String searchPost(@RequestParam(value = "query") String query, Model model) {

        List<PostDto> posts = postService.searchPosts(query);
        model.addAttribute("posts", posts);

        return "public/posts";
    }

}
