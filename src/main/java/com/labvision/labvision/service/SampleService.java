package com.labvision.labvision.service;

import com.labvision.labvision.dto.SampleDTO;
import com.labvision.labvision.exception.ResourceNotFoundException;
import com.labvision.labvision.model.Sample;
import com.labvision.labvision.model.User;
import com.labvision.labvision.repository.SampleRepository;
import com.labvision.labvision.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SampleService {
    private final SampleRepository sampleRepo;
    private final UserRepository userRepo;

    public SampleService(SampleRepository sampleRepo, UserRepository userRepo) {
        this.sampleRepo = sampleRepo;
        this.userRepo = userRepo;
    }

    public SampleDTO create(SampleDTO dto) {
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Sample s = new Sample();
        s.setUser(user); s.setPatient(dto.getPatient());
        s.setCollectionDate(dto.getCollectionDate()); s.setTissueType(dto.getTissueType());
        s.setNotes(dto.getNotes());
        Sample saved = sampleRepo.save(s);
        dto.setId(saved.getId()); return dto;
    }

    public List<SampleDTO> findAll() {
        return sampleRepo.findAll().stream().map(s -> {
            SampleDTO d = new SampleDTO();
            d.setId(s.getId()); d.setUserId(s.getUser().getId());
            d.setPatient(s.getPatient()); d.setCollectionDate(s.getCollectionDate());
            d.setTissueType(s.getTissueType()); d.setNotes(s.getNotes());
            return d;
        }).collect(Collectors.toList());
    }

//    public Sample buscar (UUID id) {
//        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Amostra não encontrada"));
//    }
//
//    @Transactional
//    public Sample criar(Sample a) {
//        return repo.save(a);
//    }
//
//    @Transactional
//    public void remover(UUID id) {
//        repo.deleteById(id);
//    }
}
