package com.portfolio_backend.controller;

import com.portfolio_backend.domain.User;
import com.portfolio_backend.exception.ResourceNotFoundException;
import com.portfolio_backend.mapper.UserMapper;
import com.portfolio_backend.repository.UserRepository;
import com.portfolio_backend.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<UserDto> getUser() {
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        UserDto dto = userMapper.toDto(user);
        return ResponseEntity.ok(dto);
    }
}

