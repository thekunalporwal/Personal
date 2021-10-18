package systemDesign.foodDeliveryApp;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import systemDesign.foodDeliveryApp.model.UserData;

public class UserService {
    private UserData userData;

    @Autowired
    public UserService(UserData userData){this.userData=userData;}

    public void addUser(@NonNull final UserData userData){};
    public void deleteUser(@NonNull final UserData userData){};
    public void updateUser(@NonNull final UserData userData){};

}
