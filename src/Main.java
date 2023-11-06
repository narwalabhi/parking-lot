import controller.TicketController;
import dto.TicketRequestDTO;
import dto.TicketResponseDTO;
import models.Gate;
import models.constants.VehicleType;
import repo.*;
import service.InitService;
import service.IntiServiceImpl;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        GateRepo gateRepo = new GateRepo();
        ParkingLotRepo parkingLotRepo = new ParkingLotRepo();
        TicketRepo ticketRepo = new TicketRepo();
        ParkingSlotRepo parkingSlotRepo = new ParkingSlotRepo();
        ParkingFloorRepo parkingFloorRepo = new ParkingFloorRepo();
        TicketController ticketController = new TicketController(parkingLotRepo, gateRepo, ticketRepo);

        InitService initService = new IntiServiceImpl(parkingSlotRepo, parkingLotRepo, gateRepo, parkingFloorRepo);
        initService.init();

        TicketRequestDTO ticketRequestDTO = new TicketRequestDTO();
        ticketRequestDTO.setParkingLotId(1);
        ticketRequestDTO.setGateId(1);
        ticketRequestDTO.setVehicleModel("Mercedez");
        ticketRequestDTO.setVehicleRegistrationNumber("1234");
        ticketRequestDTO.setVehicleType(VehicleType.CAR);
        ticketRequestDTO.setEntryTime(LocalDateTime.now());


        ticketController.createTicket(ticketRequestDTO);

        TicketResponseDTO ticketResponseDTO = ticketController.createTicket(ticketRequestDTO);

        TicketResponseDTO ticketResponseDTO2 = ticketController.createTicket(ticketRequestDTO);
        System.out.println(ticketResponseDTO);
        System.out.println(ticketResponseDTO2);
    }
}