package systemDesign.designPattern.behaviourPattern.observer;

public class EmailObserver implements NotificationObserverInterface{

    String email;
    Iobserverable iobserverable;

    EmailObserver(Iobserverable iobserverable, String email){

        this.iobserverable = iobserverable;
        this.email = email;
        System.out.println("Email observer created");
    }

    @Override
    public void update(String message) {
        System.out.println("Email sent to  " + email + " with message: " + message);
    }

}
