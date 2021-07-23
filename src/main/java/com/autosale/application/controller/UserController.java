package com.autosale.application.controller;

import com.autosale.application.model.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/user")
public interface UserController {

    @GetMapping
    ResponseEntity<List<UserDTO>> getUsers();

    @GetMapping("/{userId}")
    ResponseEntity<UserDTO> getUserById(@PathVariable Long userId);

    @PostMapping
    ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO);

    @PutMapping("/{userId}")
    ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @Valid @RequestBody UserDTO userDTO);

    @DeleteMapping("/{userId}")
    ResponseEntity<?> deleteUser(@PathVariable Long userId);
}
