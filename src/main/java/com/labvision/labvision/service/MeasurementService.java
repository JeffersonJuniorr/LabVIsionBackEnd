package com.labvision.labvision.service;

import com.labvision.labvision.dto.MeasurementDTO;
import com.labvision.labvision.exception.ResourceNotFoundException;
import com.labvision.labvision.model.Measurement;
import com.labvision.labvision.model.Sample;
import com.labvision.labvision.repository.MeasurementRepository;
import com.labvision.labvision.repository.SampleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasurementService {

    private final MeasurementRepository measRepo;
    private final SampleRepository sampleRepo;

    public MeasurementService(MeasurementRepository measRepo, SampleRepository sampleRepo) {
        this.measRepo = measRepo;
        this.sampleRepo = sampleRepo;
    }

    @Transactional
    public MeasurementDTO create(MeasurementDTO dto) {
        Sample sample = sampleRepo.findById(dto.getSampleId())
                .orElseThrow(() -> new ResourceNotFoundException("Amostra não encontrada"));

        Measurement m = new Measurement();
        m.setSample(sample); m.setWidthMm(dto.getWidthMm());
        m.setLengthMm(dto.getLengthMm()); m.setHeightMm(dto.getHeightMm());
        m.setTimestamp(dto.getTimestamp() != null
                ? dto.getTimestamp()
                : LocalDateTime.now()
        ); m.setImageData(dto.getImageData());
        Measurement saved = measRepo.save(m);
        return toDto(saved);
    }

    @Transactional(readOnly = true)
    public List<MeasurementDTO> findAll() {
        return measRepo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MeasurementDTO findById(Integer id) {
        Measurement m = measRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medição não encontrada"));
        return toDto(m);
    }

    @Transactional(readOnly = true)
    public byte[] getImageData(Integer id) {
        Measurement m = measRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medição não encontrada"));
        return m.getImageData();
    }

    private MeasurementDTO toDto(Measurement m) {
        MeasurementDTO dto = new MeasurementDTO();
        dto.setId(m.getId());
        dto.setSampleId(m.getSample().getId());
        dto.setWidthMm(m.getWidthMm());
        dto.setLengthMm(m.getLengthMm());
        dto.setHeightMm(m.getHeightMm());
        dto.setTimestamp(m.getTimestamp());
        dto.setImageData(m.getImageData());
        return dto;
    }
}
