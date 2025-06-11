package com.labvision.labvision.repository;

import com.labvision.labvision.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}