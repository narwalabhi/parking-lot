package repo;

import models.Ticket;

import java.util.HashMap;

public class TicketRepo {

     private static final HashMap<Integer, Ticket> tickets = new HashMap<>();

        public static void addTicket(Ticket ticket) {
            tickets.put(ticket.getId(), ticket);
        }

        public static Ticket getTicket(int ticketId) {
            return tickets.get(ticketId);
        }

        public static void updateTicket(Ticket ticket) {
            tickets.put(ticket.getId(), ticket);
        }

        public static void deleteTicket(int ticketId) {
            tickets.remove(ticketId);
        }

}
