package com.jose.springboot.service;

import com.jose.springboot.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    // List all Posts
    List<PostDto> findAllPosts();

    // List Posts by User Id
    List<PostDto> findPostsByUser();

    // Create new Post
    void createPost(PostDto postDto);

    // Find Post by Id
    PostDto findPostById(Long id);

    // Update Post
    void updatePost(PostDto postDto);

    // Delete Post
    void deletePost(Long id);

    // Find post by URL
    PostDto findPostByUrl(String postUrl);

    // Search posts by query
    List<PostDto> searchPosts(String query);
}
