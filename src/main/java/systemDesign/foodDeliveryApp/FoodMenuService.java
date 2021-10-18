package systemDesign.foodDeliveryApp;

import systemDesign.foodDeliveryApp.model.FoodMenu;

public interface FoodMenuService {

    void addMenuByRestaurantId();
    void addMenuByMenuId();

    FoodMenu getMenuById();
    FoodMenu getMenuByRestaurantId();

}
