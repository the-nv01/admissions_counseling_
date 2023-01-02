package admissions_counseling.controller;

import admissions_counseling.model.PersionalityType;
import admissions_counseling.model.Question;
import admissions_counseling.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("")
    public ModelAndView initView() throws Exception{
        ModelAndView modelAndView = new ModelAndView("QuestionForm");
        modelAndView.addObject("questionList", questionService.getAllQuestion());
        return modelAndView;
    }

}
