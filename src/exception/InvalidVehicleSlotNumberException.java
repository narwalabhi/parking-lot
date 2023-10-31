package exception;

public class InvalidVehicleSlotNumberException extends Throwable {
    public InvalidVehicleSlotNumberException(String slotNumberCannotBeNegative) {
        super(slotNumberCannotBeNegative);
    }
}
