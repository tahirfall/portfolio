package com.portfolio_backend.service;


import com.portfolio_backend.service.dto.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto dto);
    CommentDto getComment(Long id);
    List<CommentDto> getAllComments();
    CommentDto updateComment(Long id, CommentDto dto);
    void deleteComment(Long id);
}

