package systemDesign.designPattern.behaviourPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class IPhoneObserverClass implements Iobserverable {

        List<NotificationObserverInterface> observers = new ArrayList<>();

        public void registerObserver(NotificationObserverInterface observer){
            observers.add(observer);
        }
        public void removeObserver(NotificationObserverInterface observer){
            observers.remove(observer);
        }
        public void notifyObserver(){

             for(NotificationObserverInterface observer: observers){
                observer.update("New message");
            }
        }
}
