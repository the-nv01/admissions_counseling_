package admissions_counseling.controller;

import admissions_counseling.model.QuestionList;
import admissions_counseling.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("")
    public ModelAndView initView() {
        ModelAndView modelAndView = new ModelAndView("QuestionForm");
        QuestionList questionList = new QuestionList();
        questionList.setQuestionList(questionService.getAllQuestion());
        modelAndView.addObject("questionList", questionList);
//        modelAndView.addObject("answerList", new QuestionList());
        return modelAndView;
    }

}
