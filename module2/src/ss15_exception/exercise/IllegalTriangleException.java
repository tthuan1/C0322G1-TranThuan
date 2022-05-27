package ss15_exception.exercise;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException() {
    }
    public IllegalTriangleException(String message) {
        super(message);
    }
}
