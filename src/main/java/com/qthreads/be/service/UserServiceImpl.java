package com.qthreads.be.service;

import com.qthreads.be.db.dto.UserDto;
import com.qthreads.be.db.entity.UserEntity;
import com.qthreads.be.dto.QthreadsAppResponseDto;
import com.qthreads.be.dto.UserRegistrationRequestDto;
import com.qthreads.be.repository.UserRepository;
import com.qthreads.be.utility.CommonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * The Password encoder.
     */
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * The Common utility.
     */
    @Autowired
    CommonUtility commonUtility;

    @Override
    public ResponseEntity<QthreadsAppResponseDto> saveUser(UserRegistrationRequestDto dto) {
        UserEntity user = new UserEntity();
        UserDto userDto = new UserDto();
        Map<Object, Object> data= new HashMap<>();
        try{
            UserEntity user1 = userRepository.findByEmail(dto.getEmail());
            if(user1 != null){
                return null;
            }
            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            userRepository.save(user);

            return commonUtility.getResponseSuccessObject(data, "Successfully registered the user !");
        }catch(Exception e){
            return commonUtility.getResponseFailureObject(data, "Failed to register user");
        }
    }
}
