package models;

import exception.*;
import models.constants.Status;
import models.constants.VehicleType;
import service.strategy.feeCalculationStrategy.FeeCalculationStrategy;
import service.strategy.slotAllocationStrategy.SlotAllocationStrategy;

import java.util.List;

public class ParkingLot extends BaseModel{
    private String name;
    private Address address;
    private Status status;
    private List<VehicleType> allowedVehicleTypes;
    private List<ParkingFloor> parkingFloors;
    private FeeCalculationStrategy feeCalculationStrategy;
    private SlotAllocationStrategy slotAllocationStrategy;

    private ParkingLot() {
    }

    public ParkingLot(Builder builder) {
        super(builder.id, builder.createdBy);
        this.name = builder.name;
        this.address = builder.address;
        this.allowedVehicleTypes = builder.allowedVehicleTypes;
        this.parkingFloors = builder.parkingFloors;
        this.feeCalculationStrategy = builder.feeCalculationStrategy;
        this.slotAllocationStrategy = builder.slotAllocationStrategy;
        this.status = Status.OPEN;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Status getStatus() {
        return status;
    }

    public List<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public List<ParkingFloor> getParkingSlots() {
        return parkingFloors;
    }

    public FeeCalculationStrategy getFeeCalculationStrategy() {
        return feeCalculationStrategy;
    }

    public void setFeeCalculationStrategy(FeeCalculationStrategy feeCalculationStrategy) {
        this.feeCalculationStrategy = feeCalculationStrategy;
    }

    public SlotAllocationStrategy getSlotAllocationStrategy() {
        return slotAllocationStrategy;
    }

    public void setSlotAllocationStrategy(SlotAllocationStrategy slotAllocationStrategy) {
        this.slotAllocationStrategy = slotAllocationStrategy;
    }

    public List<ParkingFloor> getParkingFloors(){
        return parkingFloors;
    }

    public static class Builder {
        private int id;
        private String createdBy;
        private String name;
        private Address address;
        private List<VehicleType> allowedVehicleTypes;
        private List<ParkingFloor> parkingFloors;
        private FeeCalculationStrategy feeCalculationStrategy;
        private SlotAllocationStrategy slotAllocationStrategy;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder allowedVehicleTypes(List<VehicleType> allowedVehicleTypes) {
            this.allowedVehicleTypes = allowedVehicleTypes;
            return this;
        }

        public Builder parkingFloors(List<ParkingFloor> parkingFloors) {
            this.parkingFloors = parkingFloors;
            return this;
        }

        public Builder feeCalculationStrategy(FeeCalculationStrategy feeCalculationStrategy) {
            this.feeCalculationStrategy = feeCalculationStrategy;
            return this;
        }

        public Builder slotAllocationStrategy(SlotAllocationStrategy slotAllocationStrategy) {
            this.slotAllocationStrategy = slotAllocationStrategy;
            return this;
        }

        public ParkingLot build() throws InvalidSlotAllocationStrategyException, InvalidParkingSlotCountException, InvalidAllowedVehicleTypesException, InvalidFeeCalculationStrategyException, InvalidAddressException, InvalidParkingLotNameException {
            verify();
            return new ParkingLot(this);
        }

        private void verify() throws InvalidParkingLotNameException, InvalidAddressException, InvalidAllowedVehicleTypesException, InvalidParkingSlotCountException, InvalidFeeCalculationStrategyException, InvalidSlotAllocationStrategyException {
            veifyName();
            verifyAddress();
            verifyAllowedVehicleTypes();
            verifyParkingSlots();
            verifyFeeCalculationStrategy();
            verifySlotAllocationStrategy();
        }

        private void verifySlotAllocationStrategy() throws InvalidSlotAllocationStrategyException {
            if (slotAllocationStrategy == null) {
                throw new InvalidSlotAllocationStrategyException("Slot allocation strategy cannot be null");
            }
        }

        private void verifyFeeCalculationStrategy() throws InvalidFeeCalculationStrategyException {
            if (feeCalculationStrategy == null) {
                throw new InvalidFeeCalculationStrategyException("Fee calculation strategy cannot be null");
            }
        }

        private void verifyParkingSlots() throws InvalidParkingSlotCountException {
            if (parkingFloors == null || parkingFloors.isEmpty()) {
                throw new InvalidParkingSlotCountException("Parking slots cannot be null or empty");
            }
        }

        private void verifyAllowedVehicleTypes() throws InvalidAllowedVehicleTypesException {
            if (allowedVehicleTypes == null || allowedVehicleTypes.isEmpty()) {
                throw new InvalidAllowedVehicleTypesException("Allowed vehicle types cannot be null or empty");
            }
        }

        private void verifyAddress() throws InvalidAddressException {
            if (address == null) {
                throw new InvalidAddressException("Address cannot be empty");
            }
        }

        private void veifyName() throws InvalidParkingLotNameException {
            if (name == null || name.isEmpty()) {
                throw new InvalidParkingLotNameException("Parking lot name cannot be null or empty");
            }
        }

    }

}
