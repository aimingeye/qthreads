package com.qthreads.be.service;

import com.qthreads.be.db.dto.UserDto;
import com.qthreads.be.dto.QthreadsAppResponseDto;
import com.qthreads.be.dto.UserRegistrationRequestDto;
import org.springframework.http.ResponseEntity;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Save user user dto.
     *
     * @param dto the user registration request dto
     * @return the user dto
     */
    public ResponseEntity<QthreadsAppResponseDto> saveUser(UserRegistrationRequestDto dto);
}
