package systemDesign.questions.parkingLot.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import systemDesign.questions.parkingLot.ParkingSlot;

@Builder
@Getter
@Setter
public class Ticket {
    String ticketNumber;
    long startTime;
    long endTime;
    Vehicle vehicle;
    ParkingSlot parkingSlot;

    public static Ticket createTicket(Vehicle vehicle,ParkingSlot parkingSlot){
        return Ticket.builder()
                .parkingSlot(parkingSlot)
                .startTime(System.currentTimeMillis())
                .vehicle(vehicle)
                .ticketNumber(vehicle.getVehicleNumber()+System.currentTimeMillis())
                .build();
    }
}
