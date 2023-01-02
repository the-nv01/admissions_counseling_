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
public class PersionalityType {
    @Id
    private Integer typeId;

    private String typeName;

    private String typeContent;

    private Integer totalAnswer;
}
