package exception;

public class InvalidBillingAmountException extends Throwable {
    public InvalidBillingAmountException(String s) {
        super(s);
    }
}
