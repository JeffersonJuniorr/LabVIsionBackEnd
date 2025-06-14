package com.labvision.labvision.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "measurements")
public class Measurement extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sample_id")
    private Sample sample;

    @Column(name = "width_mm", nullable = false)
    private float widthMm;

    @Column(name = "length_mm", nullable = false)
    private float lengthMm;

    @Column(name = "height_mm", nullable = false)
    private float heightMm;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    //@Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "image_blob", nullable = false, columnDefinition = "LONGBLOB")
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

    @Override
    public String toString() {
        return super.toString()
                + " Measurement{w=" + widthMm
                + "mm, h=" + heightMm
                + "mm, l=" + lengthMm
                + "mm @ " + timestamp + "}";
    }
}