package io.davi.platform.repositories;

import io.davi.platform.entities.Enrollment;
import io.davi.platform.entities.pk.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {
}
