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
public class Career {
    @Id
    private Integer careerId;

    @Column
    private Integer typeId;

    @Column
    private String careerName;

    @Column
    private String careerList;
}
