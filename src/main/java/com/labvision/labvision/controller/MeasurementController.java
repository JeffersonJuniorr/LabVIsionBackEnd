package com.labvision.labvision.controller;

import com.labvision.labvision.dto.MeasurementDTO;
import com.labvision.labvision.service.MeasurementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/measurements")
public class MeasurementController {
    private final MeasurementService service;
    public MeasurementController(MeasurementService service) { this.service = service; }

    @PostMapping
    public MeasurementDTO create(@RequestBody MeasurementDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<MeasurementDTO> list() { return service.findAll(); }
}
