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
public class AdmissionScore {
    @Id
    private Integer admissionScoreId;

    @Column
    private Integer universityId;

    @Column
    private Integer blockId;

    @Column
    private String year;

    @Column
    private Integer score;
}
