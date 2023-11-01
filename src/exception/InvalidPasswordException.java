package exception;

public class InvalidPasswordException extends Throwable {
    public InvalidPasswordException(String s) {
        super(s);
    }
}
