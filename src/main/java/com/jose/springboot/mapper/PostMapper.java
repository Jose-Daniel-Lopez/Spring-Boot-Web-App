package com.jose.springboot.mapper;

import com.jose.springboot.dto.PostDto;
import com.jose.springboot.entity.Post;

import java.util.stream.Collectors;

public class PostMapper {

    // Map Post entity to PostDto
    public static PostDto mapToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .url(post.getUrl())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .createdOn(post.getCreatedOn())
                .updatedOn(post.getUpdatedOn())
                .comments(post.getComments()
                        .stream()
                        .map((comment) -> CommentMapper.mapToCommentDto(comment))
                        .collect(Collectors.toSet()))
                .build();
    }

    // Map PostDto to Post entity
    public static Post mapToPost(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setUrl(postDto.getUrl());
        post.setContent(postDto.getContent());
        post.setShortDescription(postDto.getShortDescription());
        post.setCreatedOn(postDto.getCreatedOn());
        post.setUpdatedOn(postDto.getUpdatedOn());
        return post;
    }
}
