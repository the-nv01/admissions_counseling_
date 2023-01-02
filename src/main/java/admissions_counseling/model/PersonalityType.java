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
public class PersonalityType {
    @Id
    private Integer typeId;

    @Column
    private String typeName;

    @Column
    private String typeContent;

    @Column
    private Integer totalAnswer;
}
