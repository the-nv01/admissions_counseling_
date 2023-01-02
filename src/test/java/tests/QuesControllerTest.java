package tests;

import admissions_counseling.controller.QuestionController;
import admissions_counseling.repository.QuestionRepository;
import admissions_counseling.service.QuestionService;
import admissions_counseling.service.serviceImpl.QuestionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuesControllerTest {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuestionController questionController;

    @Autowired
    private QuestionService questionService;

    @BeforeEach
    void initView() {
        questionService = new QuestionServiceImpl(questionRepository);
        ReflectionTestUtils.setField(questionController, "questionService", questionService);
    }

//    @Test
//    private void testInitTest() {
//        ModelAndView result = questionController.initView();
//        assertEquals("QuestionForm", result.getViewName());
//    }
}