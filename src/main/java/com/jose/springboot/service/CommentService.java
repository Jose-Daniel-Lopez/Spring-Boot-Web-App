package com.jose.springboot.service;

import com.jose.springboot.dto.CommentDto;
import java.util.List;

public interface CommentService {
    void createComment(String postUrl, CommentDto commentDto);

    List<CommentDto> findAllComments();

    void deleteComment(Long commentId);
}
