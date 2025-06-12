package com.labvision.labvision.controller;

import com.labvision.labvision.dto.MeasurementDTO;
import com.labvision.labvision.model.Measurement;
import com.labvision.labvision.repository.MeasurementRepository;
import com.labvision.labvision.repository.SampleRepository;
import com.labvision.labvision.service.MeasurementService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/api/measurements")
public class MeasurementController {
    private final MeasurementRepository measurementRepo;
    private final SampleRepository sampleRepo;
    private final MeasurementService measurementService;

    public MeasurementController(MeasurementRepository measurementRepo,
                                 SampleRepository sampleRepo, MeasurementService measurementService) {
        this.measurementRepo = measurementRepo;
        this.sampleRepo = sampleRepo;
        this.measurementService = measurementService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MeasurementDTO> createMeasurement(
            @ModelAttribute MeasurementDTO dto,
            @RequestPart("image") MultipartFile imageFile
    ) throws IOException {
        dto.setImageData(imageFile.getBytes());
        MeasurementDTO created = measurementService.create(dto);
        return ResponseEntity
                .created(URI.create("/api/measurements/" + created.getId()))
                .body(created);
    }

    @GetMapping(path = "/{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        Measurement m = measurementRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found"));
        return ResponseEntity
                .ok()
                .body(m.getImageData());
    }
}
