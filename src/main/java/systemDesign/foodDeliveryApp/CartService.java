package systemDesign.foodDeliveryApp;

import systemDesign.foodDeliveryApp.model.MenuItem;

import java.util.List;

interface CartService {

    void clearCart();
    void updateCart();
    List<MenuItem> getAllItemsOnCart();

}
