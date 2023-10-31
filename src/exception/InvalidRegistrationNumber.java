package exception;

public class InvalidRegistrationNumber extends Throwable {
    public InvalidRegistrationNumber(String s) {
        super(s);
    }
}
