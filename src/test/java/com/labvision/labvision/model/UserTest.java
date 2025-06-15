package com.labvision.labvision.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testUserCreation() {
        User user = new User();
        user.setName("Admin User");
        user.setEmail("admin@labvision.com");
        user.setPassword("secure123");
        user.setRole("ADMIN");

        assertEquals("Admin User", user.getName());
        assertEquals("admin@labvision.com", user.getEmail());
        assertEquals("secure123", user.getPassword());
        assertEquals("ADMIN", user.getRole());
    }

    @Test
    public void testUserToString() {
        User user = new User();
        user.setId(1);
        user.setName("Test User");
        user.setEmail("test@example.com");
        user.setRole("USER");

        String result = user.toString();
        assertTrue(result.contains("User {name='Test User', email='test@example.com', role='USER'}"));
    }
}