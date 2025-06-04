package faltas.faltometroserver.repository;

import faltas.faltometroserver.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
