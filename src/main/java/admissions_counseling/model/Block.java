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
public class Block {
    @Id
    private Integer blockId;

    @Column
    private String blockName;

    private Integer score;

    private Integer careerChose;
}
