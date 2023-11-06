package dto;

import models.constants.VehicleType;

import java.time.LocalDateTime;

public class TicketRequestDTO {

    LocalDateTime entryTime;
    private String vehicleRegistrationNumber;
    private VehicleType vehicleType;
    private String vehicleModel;
    private int gateId;
    private int parkingLotId;

    public TicketRequestDTO(String vehicleRegistrationNumber, VehicleType vehicleType, String vehicleModel, int gateId, int parkingLotId, LocalDateTime entryTime) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.gateId = gateId;
        this.parkingLotId = parkingLotId;
        this.entryTime = entryTime;
    }

    public TicketRequestDTO() {
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

}
