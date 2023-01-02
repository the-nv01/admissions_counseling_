package admissions_counseling.controller;

import admissions_counseling.model.AdmissionScore;
import admissions_counseling.model.Career;
import admissions_counseling.model.University;
import admissions_counseling.service.AdmissionScoreService;
import admissions_counseling.service.CareerService;
import admissions_counseling.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.text.DecimalFormat;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/counseling-result")
public class CounselingResultController {

    private final AdmissionScoreService admissionScoreService;

    private final CareerService careerService;

    private final UniversityService universityService;

    @GetMapping("")
    public ModelAndView initView(@RequestParam(value = "careerChose") @NotNull Integer careerChose,
                                 @RequestParam(value = "score") @NotNull Integer score,
                                 @RequestParam(value = "blockName") @NotNull Integer blockName) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

       ModelAndView modelAndView = new ModelAndView("CounselingResultForm");
       Career career = careerService.getCareerById(careerChose);
       List<University> universityList = universityService.getUniversityByCareerId(careerChose);
       universityList.stream().map(university -> {
           List<AdmissionScore> admissionScoreList =
                   admissionScoreService.getAdmissionByUniversityIdAndBlockId(university.getUniversityId(), blockName);
           university.setAverageScore(calcAverageScore(admissionScoreList));
           if ((float) score >= calcAverageScore(admissionScoreList)) {
               university.setCollegePassing("100");
           }
           else {
               university.setCollegePassing(df.format(100 * score / calcAverageScore(admissionScoreList)));
           }
           return university;
       });
       modelAndView.addObject("universityList", universityList);
       modelAndView.addObject("careerName", career.getCareerName());

       return modelAndView;
    }

    private Float calcAverageScore(List<AdmissionScore> admissionScoreList) {
        int totalScore = 0;
        for (AdmissionScore admissionScore: admissionScoreList) {
            totalScore += admissionScore.getScore();
        }
        return (float) (totalScore/admissionScoreList.size());
    }
}
