package com.labvision.labvision.dto;

import java.time.LocalDateTime;

public class MeasurementDTO {
    private Integer id;
    private Integer sampleId;
    private float widthMm;
    private float lengthMm;
    private float heightMm;
    private LocalDateTime timestamp;
    private byte[] imageData;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getSampleId() { return sampleId; }
    public void setSampleId(Integer sampleId) { this.sampleId = sampleId; }
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
