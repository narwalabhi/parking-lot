package models;

import exception.InvalidVehicleSlotNumberException;
import exception.InvalidVehicleTypeException;
import models.constants.ParkingSlotStatus;
import models.constants.VehicleType;

public class ParkingSlot extends BaseModel{
    private final int slotNumber;
    private final VehicleType vehicleType;
    private ParkingSlotStatus status;
    private Vehicle vehicle;

    public ParkingSlot(Builder builder) {
        super(builder.id, builder.createdBy);
        this.slotNumber = builder.slotNumber;
        this.vehicleType = builder.vehicleType;
        this.status = ParkingSlotStatus.VACANT;
    }


    public int getSlotNumber() {
        return slotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public ParkingSlotStatus getStatus() {
        return status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setStatus(ParkingSlotStatus status) {
        this.status = status;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getSupportedVehicleType() {
        return vehicleType;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return status;
    }

    public static class Builder{

        private int id;
        private String createdBy;
        private int slotNumber;
        private VehicleType vehicleType;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder createdBy(String createdBy){
            this.createdBy = createdBy;
            return this;
        }

        public Builder slotNumber(int slotNumber){
            this.slotNumber = slotNumber;
            return this;
        }

        public Builder vehicleType(VehicleType vehicleType){
            this.vehicleType = vehicleType;
            return this;
        }

        public ParkingSlot build() throws InvalidVehicleSlotNumberException, InvalidVehicleTypeException {
            verify();
            return new ParkingSlot(this);
        }

        private void verify() throws InvalidVehicleTypeException, InvalidVehicleSlotNumberException {
            verifyVehicleType();
            verifySlotNumber();
        }

        private void verifySlotNumber() throws InvalidVehicleSlotNumberException {
            if(slotNumber < 0){
                throw new InvalidVehicleSlotNumberException("Slot Number cannot be negative");
            }
        }

        private void verifyVehicleType() throws InvalidVehicleTypeException {
            if(vehicleType == null){
                throw new InvalidVehicleTypeException("Vehicle Type cannot be null");
            }
        }



    }

}
