package systemDesign.questions.foodDeliveryApp;

import systemDesign.questions.foodDeliveryApp.model.FoodMenu;

public interface FoodMenuService {

    void addMenuByRestaurantId();
    void addMenuByMenuId();

    FoodMenu getMenuById();
    FoodMenu getMenuByRestaurantId();

}
