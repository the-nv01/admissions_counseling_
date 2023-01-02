package admissions_counseling.service.serviceImpl;

import admissions_counseling.model.Question;
import admissions_counseling.repository.QuestionRepository;
import admissions_counseling.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestion() {
        Map<String, List> result = new HashMap<>();
        List<Question> questionList = questionRepository.findAllByOrderByTypeIdAscQuestionIdAsc();
        for (Question question : questionList) {
            getQuestionOrdinal(question);
        }
        return questionList;
    }

    private void getQuestionOrdinal(Question question) {
        Integer questionId = question.getQuestionId();
        while (questionId > 9) {
            questionId -= 9;
        }
        question.setQuestionId(questionId);
    }
}
