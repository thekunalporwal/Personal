package systemDesign.questions.foodDeliveryApp;

import systemDesign.questions.foodDeliveryApp.model.MenuItem;

import java.util.List;

interface CartService {

    void clearCart();
    void updateCart();
    List<MenuItem> getAllItemsOnCart();

}
