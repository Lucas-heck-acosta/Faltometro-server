package faltas.faltometroserver.service;

import faltas.faltometroserver.converter.StudentConverter;
import faltas.faltometroserver.dto.StudentDTO;
import faltas.faltometroserver.model.Student;
import faltas.faltometroserver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentConverter studentConverter) {
        this.studentRepository = studentRepository;
        this.studentConverter = studentConverter;
    }


    public Student createStudent(StudentDTO studentDTO) {
        Student student = studentConverter.toEntity(studentDTO);
        return studentRepository.save(student);
    }

    public List<StudentDTO> getAllStudents() {
        return studentConverter.toDto(studentRepository.findAll());
    }

    public Optional<StudentDTO> getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(studentConverter::toDto);
    }

    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            if (studentDTO.getName() != null) {
                student.setName(studentDTO.getName());
            }
            if (studentDTO.getEmail() != null) {
                student.setEmail(studentDTO.getEmail());
            }
            Student updatedStudent = studentRepository.save(student);
            return studentConverter.toDto(updatedStudent);
        } else {
            throw new IllegalArgumentException("Student with ID " + id + " not found.");
        }
    }

}