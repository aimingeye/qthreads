package com.qthreads.be.controller;

import com.qthreads.be.db.dto.UserDto;
import com.qthreads.be.db.entity.UserEntity;
import com.qthreads.be.dto.UserRegistrationRequestDto;
import com.qthreads.be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserRegistrationRequestDto dto) {
        return ResponseEntity.ok(userService.saveUser(dto));
    }

    // Other endpoints
}
