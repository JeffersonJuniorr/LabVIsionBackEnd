package com.labvision.labvision.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

@Entity
@Table(name = "samples")
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String patient;

    @Column(nullable = false)
    private LocalDate collectionDate;

    @Column(nullable = false)
    private String tissueType;

    private String notes;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getPatient() { return patient; }
    public void setPatient(String patient) { this.patient = patient; }
    public LocalDate getCollectionDate() { return collectionDate; }
    public void setCollectionDate(LocalDate collectionDate) { this.collectionDate = collectionDate; }
    public String getTissueType() { return tissueType; }
    public void setTissueType(String tissueType) { this.tissueType = tissueType; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

}