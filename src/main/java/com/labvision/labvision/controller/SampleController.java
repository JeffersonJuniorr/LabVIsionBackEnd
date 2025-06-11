package com.labvision.labvision.controller;

import com.labvision.labvision.dto.SampleDTO;
import com.labvision.labvision.service.SampleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/samples")
public class SampleController {
    private final SampleService service;
    public SampleController(SampleService service) { this.service = service; }

    @PostMapping
    public SampleDTO create(@RequestBody SampleDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<SampleDTO> list() { return service.findAll(); }
}
