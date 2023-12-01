package com.cba.Rule.Engine.service;

import com.cba.Rule.Engine.dto.UserResponseDto;
import com.cba.Rule.Engine.model.User;

import java.util.List;

public interface UserService {

    List<UserResponseDto> getAllUsers();

}
