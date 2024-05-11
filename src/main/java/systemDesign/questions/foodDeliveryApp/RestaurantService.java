package systemDesign.questions.foodDeliveryApp;

import org.springframework.stereotype.Service;
import systemDesign.questions.foodDeliveryApp.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {
    private Restaurant restaurant;


    //Restaurants can register themselves
    public void addRestaurant(){}

    public List<Integer> getAllRestaurant(){
        return new ArrayList<Integer>(Integer.parseInt(restaurant.getId()));
    }

    public int getRestaurantById(){ return 0;}

    public List<Integer> getAllRestaurantByCity(){
        return new ArrayList<Integer>(Integer.parseInt(restaurant.getId()));
    }

    public List<Integer> getAllRestaurantByName(){
        return new ArrayList<Integer>(Integer.parseInt(restaurant.getId()));
    }

}
