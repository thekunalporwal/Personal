package systemDesign.designPattern.behaviourPattern.observer;

import java.util.ArrayList;
import java.util.List;

public interface Iobserverable {


    void registerObserver(NotificationObserverInterface observer);
    void removeObserver(NotificationObserverInterface observer);
    void notifyObserver();


}
