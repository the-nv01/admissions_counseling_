package admissions_counseling.controller;

import admissions_counseling.model.PersionalityType;
import admissions_counseling.model.Question;
import admissions_counseling.service.PersionalityTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/your-persionality-type")
public class PersionalityTypeController {

    private final PersionalityTypeService persionalityTypeService;

    @GetMapping("")
    public ModelAndView initView(@ModelAttribute("questionList") List<Question> questionList) {
        ModelAndView modelAndView = new ModelAndView("PersionalityType");

        List<PersionalityType> type = persionalityTypeService.getAllPersionalityType();

        int questionStat = 0;
        while (questionStat/6 < 6) {
            type.get(questionStat/6).setTotalAnswer(
                    type.get(questionStat/6).getTotalAnswer() +
                            Integer.parseInt(questionList.get(questionStat).getAnswer()));
            questionStat ++;
        }

        modelAndView.addObject("typeList", persionalityTypeService.getAllPersionalityType());
        return modelAndView;
    }
}
