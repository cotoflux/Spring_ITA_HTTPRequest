package com.ITAcademy.simplehttpservice.service.impl;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.ITAcademy.simplehttpservice.dto.UserResponseDto;
import com.ITAcademy.simplehttpservice.repository.UserRepository;
import com.ITAcademy.simplehttpservice.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserResponseDto getUser(String uuid){
        return userRepository.getUser(uuid);
    }

}