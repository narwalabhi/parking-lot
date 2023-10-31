package service.strategy.feeCalculationStrategy;

import models.Ticket;

import java.time.LocalDateTime;

public interface FeeCalculationStrategy {

    double calculateFee(Ticket ticket, LocalDateTime exitTime);

}
