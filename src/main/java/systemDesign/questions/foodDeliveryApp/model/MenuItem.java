package systemDesign.questions.foodDeliveryApp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuItem {

    private String id;
    private String name;
    private String MealType;
    private Double price;

}
