package systemDesign.foodDeliveryApp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FoodMenu {

    private String id;
    private List<String> restaurantId;
    private List<MenuItem> menuItemList;
}
