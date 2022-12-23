package io.davi.platform.repositories;

import io.davi.platform.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource,Long> {
}
