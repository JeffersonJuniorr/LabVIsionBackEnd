package com.labvision.labvision.service;

import com.labvision.labvision.dto.UserDTO;
import com.labvision.labvision.exception.ResourceNotFoundException;
import com.labvision.labvision.model.User;
import com.labvision.labvision.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    private  final UserRepository userRepo;

    public UserService(UserRepository userRepo) {this.userRepo = userRepo;}

    public UserDTO create(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        User saved = userRepo.save(user);
        dto.setId(saved.getId());
        dto.setPassword(null);
        return dto;
    }

    public List<UserDTO> findAll () {
        return userRepo.findAll().stream().map(u -> {
            UserDTO d = new UserDTO();
            d.setId(u.getId()); d.setName(u.getName());
            d.setEmail(u.getEmail()); d.setRole(u.getRole());
            return d;
        }).collect(Collectors.toList());
    }

    public UserDTO findById(Integer id) {
        User u = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        UserDTO d = new UserDTO();
        d.setId(u.getId()); d.setName(u.getName()); d.setEmail(u.getEmail()); d.setRole(u.getRole());
        return d;
    }

//    @Transactional
//    public User saveUser(User user) {
//        // validações, hashing de senha, etc.
//        return userRepo.save(user);
//    }
//
//    @Transactional
//    public void deleteUser(UUID id) {
//        userRepo.deleteById(id);
//    }
}
