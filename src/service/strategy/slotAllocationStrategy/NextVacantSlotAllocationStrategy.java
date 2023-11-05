package service.strategy.slotAllocationStrategy;

import exception.NoEmptyParkingSlotAvailableException;
import models.Gate;
import models.ParkingLot;
import models.ParkingSlot;
import models.constants.ParkingSlotStatus;
import models.constants.VehicleType;

import java.util.List;

public class NextVacantSlotAllocationStrategy implements SlotAllocationStrategy {
    @Override
    public ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate) throws NoEmptyParkingSlotAvailableException {

        int floorNumber = entryGate.getFloorNumber();

        ParkingSlot parkingSlot = findNextParkingSlot(vehicleType, parkingLot.getParkingFloors().get(floorNumber).getParkingSlots());

        if (parkingSlot != null) {
            return parkingSlot;
        }

        int i = floorNumber - 1;
        int j = floorNumber + 1;

        while (i >= 0 || j < parkingLot.getParkingFloors().size()) {
            if (i >= 0) {
                parkingSlot = findNextParkingSlot(vehicleType, parkingLot.getParkingFloors().get(i).getParkingSlots());
                if (parkingSlot != null) {
                    return parkingSlot;
                }
            }
            if (j < parkingLot.getParkingFloors().size()) {
                parkingSlot = findNextParkingSlot(vehicleType, parkingLot.getParkingFloors().get(j).getParkingSlots());
                if (parkingSlot != null) {
                    return parkingSlot;
                }
            }
            i--;
            j++;
        }

        throw new NoEmptyParkingSlotAvailableException("No available parking slot as of now, please try again later.");

    }

    private ParkingSlot findNextParkingSlot(VehicleType vehicleType, List<ParkingSlot> parkingSlots) {
        for (ParkingSlot slot : parkingSlots) {
            if (slot.getSupportedVehicleType().equals(vehicleType) && slot.getParkingSlotStatus().equals(ParkingSlotStatus.VACANT))
                return slot;
        }
        return null;
    }

}
