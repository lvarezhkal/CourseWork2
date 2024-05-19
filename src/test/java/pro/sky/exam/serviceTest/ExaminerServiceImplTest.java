package pro.sky.exam.serviceTest;

import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.exam.Question;
import service.ExaminerService;
import service.ExaminerServiceImpl;
import service.QuestionService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ExaminerServiceImplTest {
    private QuestionService questionService;
    private ExaminerService examinerService;

    @BeforeEach
    void setUp() {
        questionService = mock(QuestionService.class);
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    void getQuestions_ShouldReturnListOfQuestions_WhenEnoughQuestionsAvailable() throws BadRequestException {
        Question question1 = new Question("Вопрос 1", "ответ 1");
        Question question2 = new Question("Вопрос 2", "ответ 2");
        when(questionService.getRandomQuestion()).thenReturn(question1, question2);

        List<Question> result = examinerService.getQuestions(2);

        assertEquals(Arrays.asList(question1, question2), result);
        verify(questionService, times(2)).getRandomQuestion();
    }

    @Test
    void getQuestions_ShouldThrowBadRequestException_WhenNotEnoughQuestionsAvailable() {

        when(questionService.getRandomQuestion()).thenReturn(new Question("Вопрос 1", "ответ 2"));

        assertThrows(BadRequestException.class, () -> examinerService.getQuestions(2));
        verify(questionService, atLeast(2)).getRandomQuestion();
    }
}
