package com.portfolio_backend.mapper;

import com.portfolio_backend.domain.Comment;
import com.portfolio_backend.service.dto.CommentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment toEntity(CommentDto dto);
    CommentDto toDto(Comment entity);
}
