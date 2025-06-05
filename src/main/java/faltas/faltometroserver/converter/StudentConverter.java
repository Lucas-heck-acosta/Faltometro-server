package faltas.faltometroserver.converter;

import faltas.faltometroserver.dto.StudentDTO;
import faltas.faltometroserver.model.Student;
import faltas.faltometroserver.model.Course;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter implements Converter<Student, StudentDTO> {

    @Autowired
    private  ModelMapper modelMapper;


    @Override
    public StudentDTO toDto(Student entity) {
        if (entity == null) {
            return null;
        }
        return modelMapper.map(entity, StudentDTO.class);
    }

    @Override
    public Student toEntity(StudentDTO dto) {
        if (dto == null) {
            return null;
        }
        return modelMapper.map(dto, Student.class);
    }

    @Override
    public List<StudentDTO> toDto(List<Student> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Student> toEntity(List<StudentDTO> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}