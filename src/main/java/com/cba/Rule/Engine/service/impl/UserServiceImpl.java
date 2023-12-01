package com.cba.Rule.Engine.service.impl;

import com.cba.Rule.Engine.dto.UserResponseDto;
import com.cba.Rule.Engine.model.User;
import com.cba.Rule.Engine.repository.UserRepository;
import com.cba.Rule.Engine.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserResponseDto> getAllUsers() {
        try {
            List<User> userList = userRepository.findAll();
            List<UserResponseDto> userResponseDtoList = new ArrayList<>();
            for(User user : userList) {
                UserResponseDto userResponseDto = modelMapper.map(user, UserResponseDto.class);
                userResponseDtoList.add(userResponseDto);
            }
            return userResponseDtoList;
        } catch (Exception e) {
            throw e;
        }
    }
}
