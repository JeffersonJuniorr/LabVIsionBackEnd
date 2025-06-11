package com.labvision.labvision.dto;

import java.time.LocalDate;

public class SampleDTO {
    private Integer id;
    private Integer userId;
    private String patient;
    private LocalDate collectionDate;
    private String tissueType;
    private String notes;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public String getPatient() { return patient; }
    public void setPatient(String patient) { this.patient = patient; }
    public LocalDate getCollectionDate() { return collectionDate; }
    public void setCollectionDate(LocalDate collectionDate) { this.collectionDate = collectionDate; }
    public String getTissueType() { return tissueType; }
    public void setTissueType(String tissueType) { this.tissueType = tissueType; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
