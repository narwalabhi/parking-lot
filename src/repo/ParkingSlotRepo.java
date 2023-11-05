package repo;

import models.ParkingSlot;

import java.util.HashMap;

public class ParkingSlotRepo {

    private static final HashMap<Integer, ParkingSlot> parkingSlots = new HashMap<>();

    public void addParkingSlot(ParkingSlot parkingSlot) {
        parkingSlots.put(parkingSlot.getId(), parkingSlot);
    }

    public ParkingSlot getParkingSlot(int parkingSlotId) {
        return parkingSlots.get(parkingSlotId);
    }

    public void updateParkingSlot(ParkingSlot parkingSlot) {
        parkingSlots.put(parkingSlot.getId(), parkingSlot);
    }

    public void deleteParkingSlot(int parkingSlotId) {
        parkingSlots.remove(parkingSlotId);
    }

}
