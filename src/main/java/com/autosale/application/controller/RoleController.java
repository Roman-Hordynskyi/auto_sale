package com.autosale.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/role")
public class RoleController {
    @GetMapping
    ResponseEntity<String> getRole() {
        return ResponseEntity.ok("role");
    }
}
