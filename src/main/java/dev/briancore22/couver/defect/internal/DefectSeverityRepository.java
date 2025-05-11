package dev.briancore22.couver.defect.internal;

import dev.briancore22.couver.core.repository.BaseJPARepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DefectSeverityRepository extends BaseJPARepository<DefectSeverity, UUID> {
}
