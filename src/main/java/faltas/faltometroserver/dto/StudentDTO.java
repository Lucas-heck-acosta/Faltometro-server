package faltas.faltometroserver.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
}
