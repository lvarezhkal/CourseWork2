package service;

import org.apache.coyote.BadRequestException;
import pro.sky.exam.Question;

import java.util.List;

public interface ExaminerService {

    List<Question> getQuestions(int count) throws BadRequestException;
}
