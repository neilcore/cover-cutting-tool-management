package dev.briancore22.couver.tools.internal;

import dev.briancore22.couver.core.repository.BaseJPARepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CuttingToolCategoryRepository extends BaseJPARepository<CuttingToolCategory, UUID> {
    // Custom query methods can be defined here if needed
}
