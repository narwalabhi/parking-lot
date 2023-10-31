package models;

import exception.InvalidEntryTimeException;
import exception.InvalidGateException;
import exception.InvalidParkingSlotException;
import exception.InvalidVehicleException;
import models.constants.TicketStatus;

import java.util.Date;

public class Ticket extends BaseModel{
    private Date entryTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private Gate gate;
    private TicketStatus status;

    private Ticket() {
    }

    private Ticket(Builder builder) {
        super(builder.id, builder.createdBy);
        this.entryTime = builder.entryTime;
        this.vehicle = builder.vehicle;
        this.parkingSlot = builder.parkingSlot;
        this.gate = builder.gate;
        this.status = TicketStatus.ACTIVE;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public Gate getGate() {
        return gate;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public static class Builder{

        private int id;
        private String createdBy;
        private Date entryTime;
        private Vehicle vehicle;
        private ParkingSlot parkingSlot;
        private Gate gate;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder createdBy(String createdBy){
            this.createdBy = createdBy;
            return this;
        }

        public Builder setEntryTime(Date entryTime) {
            this.entryTime = entryTime;
            return this;
        }

        public Builder setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public Builder setParkingSlot(ParkingSlot parkingSlot) {
            this.parkingSlot = parkingSlot;
            return this;
        }

        public Builder setGate(Gate gate) {
            this.gate = gate;
            return this;
        }

        public Ticket build() throws InvalidParkingSlotException, InvalidVehicleException, InvalidGateException, InvalidEntryTimeException {
            verify();
            return new Ticket(this);
        }

        private void verify() throws InvalidEntryTimeException, InvalidVehicleException, InvalidParkingSlotException, InvalidGateException {
            verifyEntryTime();
            verifyVehicle();
            verifyParkingSlot();
            verifyGate();
        }

        private void verifyGate() throws InvalidGateException {
            if (gate == null){
                throw new InvalidGateException("Gate cannot be null");
            }
        }

        private void verifyParkingSlot() throws InvalidParkingSlotException {
            if(parkingSlot == null){
                throw new InvalidParkingSlotException("Parking slot cannot be null");
            }
        }

        private void verifyVehicle() throws InvalidVehicleException {
            if(vehicle == null){
                throw new InvalidVehicleException("Vehicle cannot be null");
            }
        }

        private void verifyEntryTime() throws InvalidEntryTimeException {
            if(entryTime == null || entryTime.getTime() > new Date().getTime()){
                throw new InvalidEntryTimeException("Entry time cannot be empty or in future");
            }
        }

    }

}
