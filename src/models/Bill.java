package models;

import exception.InvalidGateException;
import exception.InvalidPaymentException;
import exception.InvalidTicketException;

import java.time.LocalDateTime;

public class Bill extends BaseModel {
    private LocalDateTime exitTime;
    private Ticket ticket;
    private Gate gate;
    private Payment payment;
    private double amount;

    private Bill() {
    }

    public Bill(Builder builder) {
        super(builder.id, builder.createdBy);
        this.exitTime = LocalDateTime.now();
        this.ticket = builder.ticket;
        this.gate = builder.gate;
        this.payment = builder.payment;
        this.amount = builder.amount;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Gate getGate() {
        return gate;
    }

    public Payment getPayment() {
        return payment;
    }

    public double getAmount() {
        return amount;
    }

    public static class Builder {

        private int id;
        private String createdBy;
        private Ticket ticket;
        private Gate gate;
        private Payment payment;
        private double amount;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public void ticket(Ticket ticket) {
            this.ticket = ticket;
        }

        public void gate(Gate gate) {
            this.gate = gate;
        }

        public void payment(Payment payment) {
            this.payment = payment;
        }

        public void amount(double amount) {
            this.amount = amount;
        }

        public Bill build() throws InvalidTicketException, InvalidGateException, InvalidPaymentException {
            verify();
            return new Bill(this);
        }

        private void verify() throws InvalidTicketException, InvalidGateException, InvalidPaymentException {
            verifyTicket();
            verifyGate();
            verifyPayment();
            verifyAmount();
        }

        private void verifyAmount() {
            if (amount < 0) {
                throw new IllegalArgumentException("Amount cannot be negative");
            }
        }


        private void verifyPayment() throws InvalidPaymentException {
            if (payment == null) {
                throw new InvalidPaymentException("Payment cannot be null");
            }
        }

        private void verifyGate() throws InvalidGateException {
            if (gate == null) {
                throw new InvalidGateException("Gate cannot be null");
            }
        }


        private void verifyTicket() throws InvalidTicketException {
            if (ticket == null) {
                throw new InvalidTicketException("Ticket cannot be null");
            }
        }


    }

}
