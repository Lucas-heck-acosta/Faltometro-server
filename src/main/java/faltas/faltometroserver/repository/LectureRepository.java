package faltas.faltometroserver.repository;

import faltas.faltometroserver.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
}
