package com.jose.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Long id;

    @NotEmpty(message = "Title can not be empty")
    private String title;

    private String url;

    @NotEmpty(message = "Content can not be empty")
    private String content;

    @NotEmpty(message = "Short description can not be empty")
    private String shortDescription;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    private Set<CommentDto> comments;
}
