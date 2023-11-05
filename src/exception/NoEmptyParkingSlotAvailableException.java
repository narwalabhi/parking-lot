package exception;

public class NoEmptyParkingSlotAvailableException extends Throwable {
    public NoEmptyParkingSlotAvailableException(String s) {
        super(s);
    }
}
