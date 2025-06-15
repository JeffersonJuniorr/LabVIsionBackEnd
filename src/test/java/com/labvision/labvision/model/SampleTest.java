package com.labvision.labvision.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

    @Test
    public void testSampleCreation() {
        Sample sample = new Sample();
        sample.setPatient("John Doe");
        sample.setCollectionDate(LocalDate.of(2023, 1, 1));
        sample.setTissueType("Skin");
        sample.setNotes("Biopsy sample");

        assertEquals("John Doe", sample.getPatient());
        assertEquals(LocalDate.of(2023, 1, 1), sample.getCollectionDate());
        assertEquals("Skin", sample.getTissueType());
        assertEquals("Biopsy sample", sample.getNotes());
    }

    @Test
    public void testDaysSinceCollection() {
        Sample sample = new Sample();
        sample.setCollectionDate(LocalDate.now().minusDays(5));

        assertEquals(5, sample.daysSinceCollection());
    }

    @Test
    public void testSampleToString() {
        Sample sample = new Sample();
        sample.setId(1);
        sample.setPatient("Jane Smith");
        sample.setTissueType("Blood");
        sample.setCollectionDate(LocalDate.now().minusDays(2));

        String result = sample.toString();
        assertTrue(result.contains("Sample patient='Jane Smith', tissueType='Blood'"));
        assertTrue(result.contains("(2d ago)"));
    }
}