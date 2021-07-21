package com.autosale.application.controller.impl;

import com.autosale.application.controller.UserController;
import com.autosale.application.model.domain.User;
import com.autosale.application.model.dto.UserDTO;
import com.autosale.application.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers().stream()
                .map(user -> mapper.map(user, UserDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<List<UserDTO>> getUserById(Long userId) {
        return ResponseEntity.ok(userService.getAllUsers().stream()
                .map(user -> mapper.map(user, UserDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        User user = userService.createUser(mapper.map(userDTO, User.class));

        return ResponseEntity.ok(mapper.map(user, UserDTO.class));
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(Long userId, UserDTO userDTO) {
        User user = userService.updateUser(userId ,mapper.map(userDTO, User.class));

        return ResponseEntity.ok(mapper.map(user, UserDTO.class));
    }

    @Override
    public ResponseEntity<?> deleteUser(Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
