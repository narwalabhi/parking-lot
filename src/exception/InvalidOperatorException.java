package exception;

public class InvalidOperatorException extends Throwable {
    public InvalidOperatorException(String operatorCannotBeNull) {
        super(operatorCannotBeNull);
    }
}
