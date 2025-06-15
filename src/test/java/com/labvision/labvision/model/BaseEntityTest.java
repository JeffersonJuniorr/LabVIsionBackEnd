package com.labvision.labvision.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BaseEntityTest {

    @Test
    public void testBaseEntityCreation() {
        BaseEntity entity = new BaseEntity() {}; // Classe anônima para testar a abstrata

        assertNull(entity.getId());
        assertNotNull(entity.getCreatedAt());
        assertTrue(entity.getCreatedAt().isBefore(LocalDateTime.now().plusSeconds(1)));
    }

    @Test
    public void testBaseEntitySetters() {
        BaseEntity entity = new BaseEntity() {};
        entity.setId(1);

        assertEquals(1, entity.getId());
    }
}