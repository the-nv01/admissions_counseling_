package admissions_counseling.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class University {
    @Id
    private Integer universityId;

    @Column
    private Integer careerId;

    @Column
    private String universityName;

    private Float averageScore;

    private String collegePassing;
}
