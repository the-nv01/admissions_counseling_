package admissions_counseling.model;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
@Getter
@Setter
public class AdmissionScore {
    @Id
    private Integer admissionScoreId;

    private Integer universityId;

    private Integer blockId;

    private String year;

    private Integer score;
}
