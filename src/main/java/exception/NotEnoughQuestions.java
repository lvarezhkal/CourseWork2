package exception;

public class NotEnoughQuestions extends RuntimeException {
    public NotEnoughQuestions(String message) {
        super(message);
    }
}