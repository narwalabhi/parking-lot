package exception;

public class InvalidEmailException extends Throwable {
    public InvalidEmailException(String s) {
        super(s);
    }
}
