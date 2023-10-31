package exception;

public class InvalidPaymentException extends Throwable {
    public InvalidPaymentException(String paymentCannotBeNull) {
        super(paymentCannotBeNull);
    }
}
