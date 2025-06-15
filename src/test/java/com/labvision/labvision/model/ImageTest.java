package com.labvision.labvision.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageTest {

    @Test
    public void testImageCreation() {
        Image image = new Image();
        image.setFilename("test.png");
        image.setData(new byte[]{1, 2, 3});

        assertEquals("test.png", image.getFilename());
        assertArrayEquals(new byte[]{1, 2, 3}, image.getData());
        assertTrue(image.hasData());
    }

    @Test
    public void testImageNoData() {
        Image image = new Image();
        image.setFilename("empty.png");
        image.setData(new byte[0]);

        assertFalse(image.hasData());
    }

    @Test
    public void testImageToString() {
        Image image = new Image();
        image.setId(1);
        image.setFilename("test.jpg");
        image.setData(new byte[100]);

        String result = image.toString();
        assertTrue(result.contains("Image {file='test.jpg', size=100}"));
        assertTrue(result.contains("createdAt="));
    }
}