package service.strategy.feeCalculationStrategy;

import models.Ticket;
import models.constants.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DefaultFeeCalculationStrategy implements FeeCalculationStrategy {

    private static final int PER_HOUR_CHARGE_2_WHEELER = 50;
    private static final int PER_HOUR_CHARGE_4_WHEELER = 100;

    private static final double INCREMENT_FACTOR = 0.1;

    @Override
    public double calculateFee(Ticket ticket, LocalDateTime exitTime) {

        LocalDateTime entryTime = ticket.getEntryTime();

        long totalHours = entryTime.until(exitTime, ChronoUnit.HOURS);

        int costPerHour = costPerHour(ticket.getVehicle().getVehicleType());

        double baseCost = costPerHour * totalHours;

        return baseCost + (baseCost * (INCREMENT_FACTOR * (totalHours - 1)));
    }

    private int costPerHour(VehicleType vehicleType) {
        return vehicleType.equals(VehicleType.CAR) ? PER_HOUR_CHARGE_4_WHEELER : PER_HOUR_CHARGE_2_WHEELER;
    }

}
