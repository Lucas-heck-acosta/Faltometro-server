package faltas.faltometroserver.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {
    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 50)
    private String name;

    @Size(max = 6)
    private String code;

    private int limitAbsences;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "lecture_id")
    private List<Lecture> lectures = new ArrayList<>();
}
