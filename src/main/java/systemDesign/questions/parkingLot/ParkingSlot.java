package systemDesign.questions.parkingLot;
import systemDesign.questions.parkingLot.model.ParkingSlotType;
import systemDesign.questions.parkingLot.model.Vehicle;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSlot {
    String name;
    @Builder.Default
    boolean isAvailable = true;
    Vehicle vehicle;
    ParkingSlotType parkingSlotType;

    public ParkingSlot(String name, ParkingSlotType parkingSlotType) {
        this.name = name;
        this.parkingSlotType = parkingSlotType;
    }

    protected void addVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isAvailable=false;
    }

    protected void removeVehicle(Vehicle vehicle){
        this.vehicle=null;
        this.isAvailable=true;
    }
}
