package exception;

public class InvalidVehicleTypeException extends Throwable {
    public InvalidVehicleTypeException(String vehicleTypeCannotBeNull) {
        super(vehicleTypeCannotBeNull);
    }
}
