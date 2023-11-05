package service;

import exception.*;
import models.*;
import models.constants.GateType;
import models.constants.VehicleType;
import repo.GateRepo;
import repo.ParkingFloorRepo;
import repo.ParkingLotRepo;
import repo.ParkingSlotRepo;
import service.strategy.feeCalculationStrategy.DefaultFeeCalculationStrategy;
import service.strategy.slotAllocationStrategy.NextVacantSlotAllocationStrategy;

import java.util.ArrayList;
import java.util.Arrays;

public class IntiServiceImpl implements InitService {

    private final ParkingSlotRepo parkingSlotRepo;
    private final ParkingLotRepo parkingLotRepo;
    private final GateRepo gateRepo;
    private final ParkingFloorRepo parkingFloorRepo;

    public IntiServiceImpl(ParkingSlotRepo parkingSlotRepo, ParkingLotRepo parkingLotRepo, GateRepo gateRepo, ParkingFloorRepo parkingFloorRepo) {
        this.parkingSlotRepo = parkingSlotRepo;
        this.parkingLotRepo = parkingLotRepo;
        this.gateRepo = gateRepo;
        this.parkingFloorRepo = parkingFloorRepo;
    }

    @Override
    public void init() {

        ArrayList<ParkingFloor> parkingFloors = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            Gate entryGate = null;
            Gate exitGate = null;
            try {
                entryGate = new Gate.Builder()
                        .gateNumber(i * 10 + 1)
                        .floorNumber(i)
                        .gateType(GateType.ENTRY)
                        .build();

                exitGate = new Gate.Builder()
                        .gateNumber(i * 10 + 2)
                        .floorNumber(i)
                        .gateType(GateType.EXIT)
                        .build();

            } catch (InvalidOperatorException | InvalidGateNumberException | InvalidGateTypeException |
                     InvalidFloorNumberException e) {
                throw new RuntimeException(e);
            }

            gateRepo.addGate(entryGate);
            gateRepo.addGate(exitGate);

            ArrayList<ParkingSlot> parkingSlots = new ArrayList<>();

            for (int j = 1; j <= 10; j++) {

                try {
                    ParkingSlot parkingSlot = new ParkingSlot.Builder()
                            .slotNumber(i * 100 + j)
                            .vehicleType(j % 2 != 0 ? VehicleType.BIKE : VehicleType.CAR)
                            .build();
                    parkingSlots.add(parkingSlot);
                    parkingSlotRepo.addParkingSlot(parkingSlot);
                } catch (InvalidVehicleSlotNumberException | InvalidVehicleTypeException e) {
                    throw new RuntimeException(e);
                }

            }

            try {
                ParkingFloor parkingFloor = new ParkingFloor.Builder()
                        .FloorNumber(i)
                        .Gate(Arrays.asList(entryGate, exitGate))
                        .ParkingSlots(parkingSlots)
                        .id(i)
                        .build();

                parkingFloors.add(parkingFloor);
                parkingFloorRepo.addParkingFloor(parkingFloor);

            } catch (InvalidFloorNumberException | InvalidParkingFloorsException | InvalidGateCountException e) {
                throw new RuntimeException(e);
            }

        }

        try {
            try {
                ParkingLot parkingLot = new ParkingLot.Builder()
                        .parkingFloors(parkingFloors)
                        .allowedVehicleTypes(Arrays.asList(VehicleType.BIKE, VehicleType.CAR))
                        .name("Parking Lot 1")
                        .address(new Address.Builder()
                                .fullAddress("Street A, City B, State C")
                                .city("City B")
                                .country("Country D")
                                .zipCode("123456")
                                .landmark("Landmark E")
                                .state("State C")
                                .houseNumber("123")
                                .build()
                        )
                        .feeCalculationStrategy(new DefaultFeeCalculationStrategy())
                        .slotAllocationStrategy(new NextVacantSlotAllocationStrategy())
                        .build();
                parkingLotRepo.addParkingLot(parkingLot);
            } catch (InvalidSlotAllocationStrategyException | InvalidParkingSlotCountException |
                     InvalidAllowedVehicleTypesException | InvalidFeeCalculationStrategyException |
                     InvalidAddressException | InvalidParkingLotNameException e) {
                throw new RuntimeException(e);
            }
        } catch (InvalidHouseNumberException | InvalidAddressLineException | InvalidCountryException |
                 InvalidZipCodeException | InvalidStateException | InvalidCityException e) {
            throw new RuntimeException(e);
        }


    }
}
