package faltas.faltometroserver.controller;


import faltas.faltometroserver.dto.StudentDTO;
import faltas.faltometroserver.model.Student;
import faltas.faltometroserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) { this.studentService = studentService; }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable long studentId) {
        return studentService.getStudentById(studentId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Long> createStudent(@RequestBody StudentDTO dto) {
        try {
            Student student = studentService.createStudent(dto);
            return ResponseEntity.created(URI.create("/api/students/" + student.getId())).build();
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Void> updateStudent(@PathVariable long studentId, @RequestBody StudentDTO dto) {
        try {
            studentService.updateStudent(studentId, dto);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
