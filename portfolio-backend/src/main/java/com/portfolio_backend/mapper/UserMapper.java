package com.portfolio_backend.mapper;

import com.portfolio_backend.domain.User;
import com.portfolio_backend.service.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User entity);
    User toEntity(UserDto dto);
}
