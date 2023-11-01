package exception;

public class InvalidTransactionNumber extends Throwable {
    public InvalidTransactionNumber(String transactionNumberCannotBeNull) {
        super(transactionNumberCannotBeNull);
    }
}
