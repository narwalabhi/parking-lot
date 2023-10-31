package exception;

public class InvalidGateException extends Throwable {
    public InvalidGateException(String gateCannotBeNull) {
        super(gateCannotBeNull);
    }
}
