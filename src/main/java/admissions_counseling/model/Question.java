package admissions_counseling.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Question {
    @Id
    private Integer questionId;

    @Column
    private Integer typeId;

    @Column
    private String questionContent;

    @Column
    private Integer questionWeight;

    @Column
    private String answer;

    private Integer autoNo = 0;
}
