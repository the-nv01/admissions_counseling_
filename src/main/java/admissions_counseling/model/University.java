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
public class University {
    @Id
    private Integer universityId;

    private Integer careerId;

    private String universityName;
}
