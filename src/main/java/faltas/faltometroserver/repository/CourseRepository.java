package faltas.faltometroserver.repository;

import faltas.faltometroserver.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
