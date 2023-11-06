package controller;

import dto.TicketRequestDTO;
import dto.TicketResponseDTO;
import exception.*;
import models.Ticket;
import models.Vehicle;
import repo.GateRepo;
import repo.ParkingLotRepo;
import repo.TicketRepo;
import service.TicketService;
import service.TicketServiceImpl;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public TicketController(ParkingLotRepo parkingLotRepo, GateRepo gateRepo, TicketRepo ticketRepo) {
        this.ticketService = new TicketServiceImpl(gateRepo, parkingLotRepo, ticketRepo);
    }

    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO) {
        Vehicle vehicle = null;
        try {
            vehicle = new Vehicle.Builder()
                    .registrationNumber(ticketRequestDTO.getVehicleRegistrationNumber())
                    .vehicleType(ticketRequestDTO.getVehicleType())
                    .model(ticketRequestDTO.getVehicleModel())
                    .build();
        } catch (InvalidRegistrationNumber e) {
            System.out.println("Invalid registration number");
        } catch (InvalidVehicleTypeException e) {
            System.out.println("Invalid vehicle type");
        }

        try {
            Ticket ticket = ticketService.createTicket(vehicle, ticketRequestDTO.getGateId(), ticketRequestDTO.getParkingLotId(), ticketRequestDTO.getEntryTime());

            TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
            ticketResponseDTO.setEntryTime(ticket.getEntryTime().toString());
            ticketResponseDTO.setSlotNumber(ticket.getParkingSlot().getSlotNumber());
            ticketResponseDTO.setVehicleNumber(ticket.getVehicle().getRegistrationNumber());
            return ticketResponseDTO;

        } catch (NoEmptyParkingSlotAvailableException e) {
            System.out.println("No empty parking slot available");
        } catch (InvalidParkingSlotException e) {
            System.out.println("Invalid parking slot");
        } catch (InvalidVehicleException e) {
            System.out.println("Invalid vehicle");
        } catch (InvalidGateException e) {
            System.out.println("Invalid gate");
        } catch (InvalidEntryTimeException e) {
            System.out.println("Invalid entry time");
        }
        return null;
    }

}
