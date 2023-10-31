package exception;

public class InvalidFloorNumberException extends Throwable {
    public InvalidFloorNumberException(String floorNumberCannotBeNegative) {
        super(floorNumberCannotBeNegative);
    }
}
