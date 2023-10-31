package exception;

public class InvalidVehicleException extends Throwable {
    public InvalidVehicleException(String vehicleCannotBeNull) {
        super(vehicleCannotBeNull);
    }
}
