package com.labvision.labvision.model;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image extends BaseEntity {

    @Column(nullable = false)
    private String filename;

    //@Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "data_blob", nullable = false)
    private byte[] data;

    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }

    public byte[] getData() { return data; }
    public void setData(byte[] data) { this.data = data; }

    /** método de negócio: verifica se há dados carregados */
    public boolean hasData() {
        return data != null && data.length > 0;
    }

    @Override
    public String toString() {
        return super.toString()
                + " Image{file='" + filename
                + "', size=" + (data != null ? data.length : 0) + "}";
    }
}