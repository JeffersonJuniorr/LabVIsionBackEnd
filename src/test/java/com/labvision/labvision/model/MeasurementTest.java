package com.labvision.labvision.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {

    @Test
    public void testMeasurementCreation() {
        Measurement measurement = new Measurement();
        measurement.setWidthMm(10.5f);
        measurement.setLengthMm(20.0f);
        measurement.setHeightMm(5.0f);
        LocalDateTime now = LocalDateTime.now();
        measurement.setTimestamp(now);
        measurement.setImageData(new byte[200]);

        assertEquals(10.5f, measurement.getWidthMm(), 0.001);
        assertEquals(20.0f, measurement.getLengthMm(), 0.001);
        assertEquals(5.0f, measurement.getHeightMm(), 0.001);
        assertEquals(now, measurement.getTimestamp());
        assertEquals(200, measurement.getImageData().length);
    }

    @Test
    public void testMeasurementToString() {
        Measurement measurement = new Measurement();
        measurement.setId(1);
        measurement.setWidthMm(10.0f);
        measurement.setLengthMm(20.0f);
        measurement.setHeightMm(5.0f);
        LocalDateTime timestamp = LocalDateTime.of(2023, 1, 1, 12, 0);
        measurement.setTimestamp(timestamp);

        String result = measurement.toString();
        assertTrue(result.contains("Measurement {w=10.0mm, h=5.0mm, l=20.0mm @ 2023-01-01T12:00"));
    }
}