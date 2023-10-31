package exception;

public class InvalidGateNumberException extends Throwable {
    public InvalidGateNumberException(String invalidGateNumber) {
        super(invalidGateNumber);
    }
}
