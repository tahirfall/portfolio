package com.portfolio_backend.service.impl;


import com.portfolio_backend.domain.Comment;
import com.portfolio_backend.exception.ResourceNotFoundException;
import com.portfolio_backend.mapper.CommentMapper;
import com.portfolio_backend.repository.CommentRepository;
import com.portfolio_backend.service.CommentService;
import com.portfolio_backend.service.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public CommentDto createComment(CommentDto dto) {
        Comment comment = commentMapper.toEntity(dto);
        return commentMapper.toDto(commentRepository.save(comment));
    }

    @Override
    public CommentDto getComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
        return commentMapper.toDto(comment);
    }

    @Override
    public List<CommentDto> getAllComments() {
        return commentRepository.findAll().stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto updateComment(Long id, CommentDto dto) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
        comment.setUserFullName(dto.getUserFullName());
        comment.setPosition(dto.getPosition());
        comment.setCommentText(dto.getCommentText());
        comment.setSnapshotUrl(dto.getSnapshotUrl());

        return commentMapper.toDto(commentRepository.save(comment));
    }

    @Override
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
        commentRepository.delete(comment);
    }
}

