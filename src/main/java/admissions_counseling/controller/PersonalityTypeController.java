package admissions_counseling.controller;

import admissions_counseling.model.Block;
import admissions_counseling.model.PersonalityType;
import admissions_counseling.model.Question;
import admissions_counseling.model.QuestionList;
import admissions_counseling.service.CareerService;
import admissions_counseling.service.PersonalityTypeService;
import admissions_counseling.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/your-personality-type")
public class PersonalityTypeController {

    private final PersonalityTypeService personalityTypeService;

    private final QuestionService questionService;

    private final CareerService careerService;

    @PostMapping("")
    public ModelAndView initView(@ModelAttribute("answerList") QuestionList questionList) {
        ModelAndView modelAndView = new ModelAndView("PersonalityForm");

        List<Question> questions = questionList.getQuestionList();
        List<PersonalityType> typeList = personalityTypeService.getAllPersonalityType();

        int questionStat = 0;
        while (questionStat/9 < 6) {
            typeList.get(questionStat/9).setTotalAnswer(typeList.get(questionStat/9).getTotalAnswer() +
                    Integer.parseInt(questions.get(questionStat).getAnswer()) *
                    questions.get(questionStat).getQuestionWeight());
            questionStat ++;
        }
        for (PersonalityType type : typeList) {
            type.setTotalAnswer(type.getTotalAnswer() * 100 / 180);
        }

        PersonalityType personalityType = new PersonalityType();
        Integer maxQuestionScore = 0;
        for (PersonalityType type: typeList) {
            if (type.getTotalAnswer() > maxQuestionScore) {
                maxQuestionScore = type.getTotalAnswer();
                personalityType = type;
            }
        }
        modelAndView.addObject("type", personalityType);
        modelAndView.addObject("typeList", typeList);
        modelAndView.addObject("careerList", careerService.getCareerByTypeId(personalityType.getTypeId()));
        modelAndView.addObject("estimateScore", new Block());
        return modelAndView;
    }
}
