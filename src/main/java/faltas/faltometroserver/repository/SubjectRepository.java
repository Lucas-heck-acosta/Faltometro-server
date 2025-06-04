package faltas.faltometroserver.repository;

import faltas.faltometroserver.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
