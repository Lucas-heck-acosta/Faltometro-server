package faltas.faltometroserver.repository;

import faltas.faltometroserver.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {


}
