package com.labvision.labvision.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.labvision.labvision.model.audit.*;

public interface AuditLogRepository extends JpaRepository<AuditLog, Integer> {

}