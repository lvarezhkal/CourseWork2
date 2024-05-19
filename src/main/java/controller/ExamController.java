package controller;

import org.apache.coyote.BadRequestException;
import pro.sky.exam.Question;
import service.ExaminerService;

import java.util.List;

public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    public List<Question> getQuestions(int amount) throws BadRequestException {
        return examinerService.getQuestions(amount);
    }
}
