package com.labvision.labvision.controller;

import com.labvision.labvision.dto.UserDTO;
import com.labvision.labvision.model.User;
import com.labvision.labvision.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;
    public UserController(UserService service) {this.service = service;}

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto) {
        UserDTO created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/users/" + created.getId())).body(created);
    }

    @GetMapping
    public List<UserDTO> list() { return service.findAll(); }

    @GetMapping("/{id}")
    public UserDTO get(@PathVariable Integer id) { return service.findById(id); }

}
