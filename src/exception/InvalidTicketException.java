package exception;

public class InvalidTicketException extends Throwable {
    public InvalidTicketException(String ticketCannotBeNull) {
        super(ticketCannotBeNull);
    }
}
