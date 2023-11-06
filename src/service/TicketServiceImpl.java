package service;

import exception.*;
import models.*;
import models.constants.ParkingSlotStatus;
import repo.GateRepo;
import repo.ParkingLotRepo;
import repo.TicketRepo;

import java.time.LocalDateTime;

public class TicketServiceImpl implements TicketService {

    private GateRepo gateRepo;
    private ParkingLotRepo parkingLotRepo;
    private TicketRepo ticketRepo;

    public TicketServiceImpl(GateRepo gateRepo, ParkingLotRepo parkingLotRepo, TicketRepo ticketRepo) {
        this.gateRepo = gateRepo;
        this.parkingLotRepo = parkingLotRepo;
        this.ticketRepo = ticketRepo;
    }

    @Override
    public Ticket createTicket(Vehicle vehicle, int gateId, int parkingLotId, LocalDateTime entryTime) throws NoEmptyParkingSlotAvailableException, InvalidParkingSlotException, InvalidVehicleException, InvalidGateException, InvalidEntryTimeException {

        Gate gate = gateRepo.getGate(gateId);
        ParkingLot parkingLot = parkingLotRepo.getParkingLot(parkingLotId);

        ParkingSlot parkingSlot = parkingLot.getSlotAllocationStrategy().findParkingSlot(vehicle.getVehicleType(), parkingLot, gate);

        parkingSlot.setStatus(ParkingSlotStatus.OCCUPIED);

        Ticket ticket = new Ticket.Builder()
                .setEntryTime(entryTime)
                .setVehicle(vehicle)
                .setParkingSlot(parkingSlot)
                .setGate(gate)
                .build();

        ticketRepo.addTicket(ticket);

        return ticket;
    }
}
