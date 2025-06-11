package com.labvision.labvision.repository;

import com.labvision.labvision.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Integer> {

}