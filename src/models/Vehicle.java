package models;

import exception.InvalidRegistrationNumber;
import exception.InvalidVehicleTypeException;
import models.constants.VehicleType;

public class Vehicle extends BaseModel {

    private String registrationNumber;
    private String model;
    private VehicleType vehicleType;

    private Vehicle() {
        super();
    }

    public Vehicle(Builder builder) {
        super(builder.id, builder.createdBy);
        this.registrationNumber = builder.registrationNumber;
        this.model = builder.model;
        this.vehicleType = builder.vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public static class Builder{
        private int id;
        private String createdBy;
        private String registrationNumber;
        private VehicleType vehicleType;
        private String model;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder createdBy(String createdBy){
            this.createdBy = createdBy;
            return this;
        }

        public Builder model(String model){
            this.model = model;
            return this;
        }

        public Builder registrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
            return this;
        }

        public Builder vehicleType(VehicleType vehicleType) {
            this.vehicleType = vehicleType;
            return this;
        }

        public Vehicle build() throws InvalidRegistrationNumber, InvalidVehicleTypeException {
            verify();
            return new Vehicle(this);
        }

        private void verify() throws InvalidRegistrationNumber, InvalidVehicleTypeException {
            verifyRegistrationNumber();
            verifyVehicleType();
        }

        private void verifyVehicleType() throws InvalidVehicleTypeException {
            if(this.vehicleType == null){
                throw new InvalidVehicleTypeException("Vehicle type cannot be null");
            }
        }

        private void verifyRegistrationNumber() throws InvalidRegistrationNumber {
            if(this.registrationNumber == null || this.registrationNumber.isEmpty()){
                throw new InvalidRegistrationNumber("Registration number cannot be null or empty");
            }
        }

    }

}
