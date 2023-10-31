package exception;

public class InvalidAddressException extends Throwable {
    public InvalidAddressException(String addressCannotBeEmpty) {
        super(addressCannotBeEmpty);
    }
}
