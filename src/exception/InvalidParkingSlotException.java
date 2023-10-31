package exception;

public class InvalidParkingSlotException extends Throwable {
    public InvalidParkingSlotException(String parkingSlotCannotBeNull) {
        super(parkingSlotCannotBeNull);
    }
}
