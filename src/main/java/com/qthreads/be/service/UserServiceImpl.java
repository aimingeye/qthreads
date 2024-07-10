package com.qthreads.be.service;

import com.qthreads.be.db.dto.UserDto;
import com.qthreads.be.db.entity.UserEntity;
import com.qthreads.be.dto.UserRegistrationRequestDto;
import com.qthreads.be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDto saveUser(UserRegistrationRequestDto dto) {
        UserEntity user = new UserEntity();
        UserDto userDto = new UserDto();
        try{
            UserEntity user1 = userRepository.findByEmail(dto.getEmail());
            if(user1 != null){
                return null;
            }
            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            userRepository.save(user);
            return null;
        }catch(Exception e){
            return null;
        }
    }
}
