package admissions_counseling.controller;

import admissions_counseling.model.AdmissionScore;
import admissions_counseling.model.Career;
import admissions_counseling.model.University;
import admissions_counseling.service.AdmissionScoreService;
import admissions_counseling.service.BlockService;
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

    private final BlockService blockService;

    @GetMapping("")
    public ModelAndView initView(@RequestParam(value = "careerChose") @NotNull Integer careerChose,
                                 @RequestParam(value = "score") @NotNull Float score,
                                 @RequestParam(value = "blockName") @NotNull String blockName) {
        Boolean existUniversity = false;
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

       ModelAndView modelAndView = new ModelAndView("CounselingResultForm");
       Career career = careerService.getCareerById(careerChose);
       List<University> universityList = universityService.getUniversityByCareerId(careerChose);

       for (University university : universityList) {
           List<AdmissionScore> admissionScoreList =
                   admissionScoreService.getAdmissionByUniversityIdAndBlockId(university.getUniversityId(), blockService.getBlockByName(blockName).getBlockId());
           if (!admissionScoreList.isEmpty()) existUniversity = true;
           university.setAverageScore(calcAverageScore(admissionScoreList, university));
           if ((float) score >= calcAverageScore(admissionScoreList, university)) {
               university.setCollegePassing("100");
           }
           else if (calcAverageScore(admissionScoreList, university) - score > 7) {
               university.setCollegePassing("0");
           }
           else {
               university.setCollegePassing(df.format(100 * (score + 7 - calcAverageScore(admissionScoreList, university)) / 7));
           }
       }
//
//        for (University university : universityList) {
//            if (university.getAverageScore() <= 0) {
//                if (university.getUniversityName().substring(0,6).toLowerCase().equals("đại họ")
//                        || university.getUniversityName().substring(0,6).toLowerCase().equals("học vi")) {
//                    university.setAverageScore((float) 19.6);
//                }
//                else if (university.getUniversityName().substring(0,6).toLowerCase().equals("trung ")
//                        || university.getUniversityName().substring(0,6).toLowerCase().equals("trung ")) {
//                    university.setAverageScore((float) 0);
//                }
//                else if(university.getUniversityName().substring(0,6).toLowerCase().equals("cao đẳ")) {
//                    university.setAverageScore((float) 13.6);
//                }
//            }
//        }

       if (existUniversity == false) {
           modelAndView.setViewName("ResultErrorForm");
       }
       modelAndView.addObject("universityList", universityList);
       modelAndView.addObject("blockName", blockName);
       modelAndView.addObject("careerName", career.getCareerName());

       return modelAndView;
    }

    private Float calcAverageScore(List<AdmissionScore> admissionScoreList, University university) {
        int totalScore = 0;
        for (AdmissionScore admissionScore: admissionScoreList) {
            totalScore += admissionScore.getScore();
        }
        if (admissionScoreList.size() == 0) {
            if (university.getUniversityName().substring(0,6).toLowerCase().equals("đại họ")
                    || university.getUniversityName().substring(0,6).toLowerCase().equals("học vi")) {
                return (float) 19.6;
            } if (university.getUniversityName().substring(0,6).toLowerCase().equals("cao đẳ")) {
                return (float) 13.6;
            }
            return (float) 0;
        }
        return (float) (totalScore/admissionScoreList.size());
    }
}
