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
public class Block {
    @Id
    private Integer blockId;

    private String blockName;
}
