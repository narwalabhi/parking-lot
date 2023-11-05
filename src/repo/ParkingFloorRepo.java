package repo;

import models.ParkingFloor;

import java.util.HashMap;

public class ParkingFloorRepo {

    private static final HashMap<Integer, ParkingFloor> parkingFloors = new HashMap<>();

    public void addParkingFloor(ParkingFloor parkingFloor) {
        parkingFloors.put(parkingFloor.getId(), parkingFloor);
    }

    public ParkingFloor getParkingFloor(int parkingFloorId) {
        return parkingFloors.get(parkingFloorId);
    }

    public void updateParkingFloor(ParkingFloor parkingFloor) {
        parkingFloors.put(parkingFloor.getId(), parkingFloor);
    }

    public void deleteParkingFloor(int parkingFloorId) {
        parkingFloors.remove(parkingFloorId);
    }

}
