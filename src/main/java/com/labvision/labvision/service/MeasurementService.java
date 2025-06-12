package com.labvision.labvision.service;

import com.labvision.labvision.dto.MeasurementDTO;
import com.labvision.labvision.exception.ResourceNotFoundException;
import com.labvision.labvision.model.Measurement;
import com.labvision.labvision.model.Sample;
import com.labvision.labvision.repository.MeasurementRepository;
import com.labvision.labvision.repository.SampleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MeasurementService {
    private final MeasurementRepository measRepo;
    private final SampleRepository sampleRepo;

    public MeasurementService(MeasurementRepository measRepo, SampleRepository sampleRepo) {
        this.measRepo = measRepo;
        this.sampleRepo = sampleRepo;
    }

    public MeasurementDTO create(MeasurementDTO dto) {
        Sample s = sampleRepo.findById(dto.getSampleId())
                .orElseThrow(() -> new ResourceNotFoundException("Sample not found"));
        Measurement m = new Measurement();
        m.setSample(s); m.setWidthMm(dto.getWidthMm());
        m.setLengthMm(dto.getLengthMm()); m.setHeightMm(dto.getHeightMm());
        m.setTimestamp(dto.getTimestamp() != null
                ? dto.getTimestamp()
                : LocalDateTime.now()
        ); m.setImageData(dto.getImageData());
        Measurement saved = measRepo.save(m);
        dto.setId(saved.getId()); return dto;
    }

    public List<MeasurementDTO> findAll() {
        return measRepo.findAll().stream().map(m -> {
            MeasurementDTO d = new MeasurementDTO();
            d.setId(m.getId()); d.setSampleId(m.getSample().getId());
            d.setWidthMm(m.getWidthMm()); d.setLengthMm(m.getLengthMm());
            d.setHeightMm(m.getHeightMm()); d.setTimestamp(m.getTimestamp());
            d.setImageData(m.getImageData()); return d;
        }).collect(Collectors.toList());
    }

//    @Transactional
//    public Measurement criar(Measurement m) {
//        return measRepo.save(m);
//    }
//
//    @Transactional
//    public void remover(Measurement m) {
//        measRepo.delete(m);
//    }
}
