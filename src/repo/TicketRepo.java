package repo;

import models.Ticket;

import java.util.HashMap;

public class TicketRepo {

     private static final HashMap<Integer, Ticket> tickets = new HashMap<>();

        public void addTicket(Ticket ticket) {
            tickets.put(ticket.getId(), ticket);
        }

        public Ticket getTicket(int ticketId) {
            return tickets.get(ticketId);
        }

        public void updateTicket(Ticket ticket) {
            tickets.put(ticket.getId(), ticket);
        }

        public void deleteTicket(int ticketId) {
            tickets.remove(ticketId);
        }

}
