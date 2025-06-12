package com.labvision.labvision.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sample_id", nullable = false)
    private Sample sample;

    @Column(nullable = false)
    private float widthMm;

    @Column(nullable = false)
    private float lengthMm;

    @Column(nullable = false)
    private float heightMm;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Lob
    @Column(name = "image_blob")
    private byte[] imageData;

    // private String cameraTipo;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Sample getSample() { return sample; }
    public void setSample(Sample sample) { this.sample = sample; }
    public float getWidthMm() { return widthMm; }
    public void setWidthMm(float widthMm) { this.widthMm = widthMm; }
    public float getLengthMm() { return lengthMm; }
    public void setLengthMm(float lengthMm) { this.lengthMm = lengthMm; }
    public float getHeightMm() { return heightMm; }
    public void setHeightMm(float heightMm) { this.heightMm = heightMm; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public byte[] getImageData() { return imageData; }
    public void setImageData(byte[] imageData) { this.imageData = imageData; }

}