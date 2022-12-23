package io.davi.platform.repositories;

import io.davi.platform.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section,Long> {
}
