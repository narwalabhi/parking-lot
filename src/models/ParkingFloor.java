package models;

import exception.InvalidFloorNumberException;
import exception.InvalidGateCountException;
import exception.InvalidParkingFloorsException;
import models.constants.Status;

import java.util.List;

public class ParkingFloor extends BaseModel {
    private int floorNumber;
    private Status status;
    private List<ParkingSlot> parkingSlots;
    private List<Gate> gate;

    private ParkingFloor() {
        super();
    }

    public ParkingFloor(Builder builder) {
        super(builder.id, builder.cretedBy);
        this.status = Status.OPEN;
        this.floorNumber = builder.floorNumber;
        this.parkingSlots = builder.parkingSlots;
        this.gate = builder.gate;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Status getStatus() {
        return status;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public List<Gate> getGate() {
        return gate;
    }

    public static class Builder {

        private int id;
        private String cretedBy;
        private int floorNumber;
        private List<ParkingSlot> parkingSlots;
        private List<Gate> gate;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder createdBy(String createdBy) {
            this.cretedBy = createdBy;
            return this;
        }

        public Builder FloorNumber(int floorNumber) {
            this.floorNumber = floorNumber;
            return this;
        }

        public Builder ParkingSlots(List<ParkingSlot> parkingSlots) {
            this.parkingSlots = parkingSlots;
            return this;
        }

        public Builder Gate(List<Gate> gate) {
            this.gate = gate;
            return this;
        }

        public ParkingFloor build() throws InvalidFloorNumberException, InvalidParkingFloorsException, InvalidGateCountException {
            verify();
            return new ParkingFloor(this);
        }

        private void verify() throws InvalidFloorNumberException, InvalidParkingFloorsException, InvalidGateCountException {
            verifyFloorNumber();
            verifyParkingSlots();
            verifyGates();
        }

        private void verifyGates() throws InvalidGateCountException {
            if (this.gate == null || this.gate.isEmpty()) {
                throw new InvalidGateCountException("Gates cannot be null or empty");
            }
        }

        private void verifyParkingSlots() throws InvalidParkingFloorsException {
            if (this.parkingSlots == null || this.parkingSlots.isEmpty()) {
                throw new InvalidParkingFloorsException("Parking slots cannot be null or empty");
            }
        }

        private void verifyFloorNumber() throws InvalidFloorNumberException {
            if (this.floorNumber < 0) {
                throw new InvalidFloorNumberException("Floor number cannot be negative");
            }
        }


    }

}
