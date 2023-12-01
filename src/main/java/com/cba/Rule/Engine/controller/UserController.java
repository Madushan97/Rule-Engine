package com.cba.Rule.Engine.controller;

import com.cba.Rule.Engine.dto.UserResponseDto;
import com.cba.Rule.Engine.model.User;
import com.cba.Rule.Engine.service.UserService;
import com.cba.Rule.Engine.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/${application.resource.users}")
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/getAll")
    public ResponseEntity<StandardResponse> getAll() {

        List<UserResponseDto> getAllUsers = userService.getAllUsers();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "get all users successfully",
                        getAllUsers
                ),
                HttpStatus.OK
        );
    }

}
