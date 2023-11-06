package service;

import exception.*;
import models.Ticket;
import models.Vehicle;

import java.time.LocalDateTime;

public interface TicketService {

    Ticket createTicket(Vehicle vehicle, int gateId, int parkingLotId, LocalDateTime entryTime) throws NoEmptyParkingSlotAvailableException, InvalidParkingSlotException, InvalidVehicleException, InvalidGateException, InvalidEntryTimeException;

}
