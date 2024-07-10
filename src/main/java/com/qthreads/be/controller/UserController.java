package com.qthreads.be.controller;

import com.qthreads.be.db.dto.UserDto;
import com.qthreads.be.db.entity.UserEntity;
import com.qthreads.be.dto.QthreadsAppResponseDto;
import com.qthreads.be.dto.UserRegistrationRequestDto;
import com.qthreads.be.service.UserService;
import com.qthreads.be.utility.CommonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommonUtility commonUtility;

    @GetMapping("/health")
    public ResponseEntity<QthreadsAppResponseDto> getHealth(){
        return commonUtility.getResponseSuccessObject(new HashMap<>(), "SUCCESS");
    }

    @PostMapping("/register")
    public ResponseEntity<QthreadsAppResponseDto> registerUser(@RequestBody UserRegistrationRequestDto dto) {
        return userService.saveUser(dto);
    }

    // Other endpoints
}
