package exception;

public class InvalidGateTypeException extends Throwable {
    public InvalidGateTypeException(String gateTypeCannotBeNull) {
        super(gateTypeCannotBeNull);
    }
}
