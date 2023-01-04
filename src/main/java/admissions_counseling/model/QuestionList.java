package admissions_counseling.model;

import lombok.Data;

import java.util.List;

@Data
public class QuestionList {
    List<Question> questionList;

    Integer autoNo;
}
