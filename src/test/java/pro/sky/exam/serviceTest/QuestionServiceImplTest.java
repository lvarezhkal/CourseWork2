package pro.sky.exam.serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.exam.Question;
import service.QuestionServiceImpl;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuestionServiceImplTest {
    private QuestionServiceImpl questionService;

    @BeforeEach
    public void setUp() {
        questionService = new QuestionServiceImpl();
    }

    @Test
    public void addQuestion() {
        questionService.addQuestion("Сколько тебе лет?", "18");
        Collection<Question> questions =
                questionService.getAllQuestions();
        assertEquals(1, questions.size());
    }

    @Test
    public void removeQuestion() {
        questionService.addQuestion("Сколько тебе лет?", "18");
        Question question = questionService.getRandomQuestion();
        questionService.removeQuestion(question);
        Collection<Question> questions =
                questionService.getAllQuestions();
        assertTrue(questions.isEmpty());
    }

    @Test
    public void getAllQuestions() {
        questionService.addQuestion("Сколько тебе лет?", "18");
        Collection<Question> questions = questionService.getAllQuestions();
        assertEquals(1,questions.size());
    }

    @Test
    public void getRandomQuestion() {
        questionService.addQuestion("Сколько тебе лет?", "18");
        questionService.addQuestion("Как тебя зовут?", "Андрей");
        Collection<Question> questions = questionService.getAllQuestions();
        assertEquals(2, questions.size());
    }
}
