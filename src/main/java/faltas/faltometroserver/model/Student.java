package faltas.faltometroserver.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 80)
    private String name;
    @Column(unique = true)

    @Size(max = 80)
    private String email;
    @Size(max = 30)
    private String password;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
