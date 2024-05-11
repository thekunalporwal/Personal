package systemDesign.questions.parkingLot.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class Vehicle {
    String vehicleNumber;
    VehicleCategory vehicleCategory;
}