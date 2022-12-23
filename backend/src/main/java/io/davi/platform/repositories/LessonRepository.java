package io.davi.platform.repositories;

import io.davi.platform.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
}
