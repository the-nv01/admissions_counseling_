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
public class Career {
    @Id
    private Integer careerId;

    private Integer typeId;

    private String careerName;

    private String careerList;
}
