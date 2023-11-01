package exception;

public class InvalidBillException extends Throwable {
    public InvalidBillException(String billCannotBeNull) {
        super(billCannotBeNull);
    }
}
