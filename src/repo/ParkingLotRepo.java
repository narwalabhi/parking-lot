package repo;

import models.ParkingLot;

import java.util.HashMap;

public class ParkingLotRepo {

    public static final HashMap<Integer, ParkingLot> parkingLots = new HashMap<>();

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.put(parkingLot.getId(), parkingLot);
    }

    public ParkingLot getParkingLot(int parkingLotId) {
        return parkingLots.get(parkingLotId);
    }

    public void updateParkingLot(ParkingLot parkingLot) {
        parkingLots.put(parkingLot.getId(), parkingLot);
    }

    public void deleteParkingLot(int parkingLotId) {
        parkingLots.remove(parkingLotId);
    }

}
