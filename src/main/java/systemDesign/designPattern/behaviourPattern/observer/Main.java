package systemDesign.designPattern.behaviourPattern.observer;


/**
 An Observer Pattern says that "just define a one-to-one dependency so that when one object changes state,
 all its dependents are notified and updated automatically".
 The observer pattern is also known as Dependents or Publish-Subscribe.

 */
public class Main {

    public static void main(String[] args) {
        Iobserverable iobserverable = new IPhoneObserverClass();
        NotificationObserverInterface emailObserver = new EmailObserver(iobserverable, "kg@gmail.com");
        NotificationObserverInterface emailObserver1 = new EmailObserver(iobserverable, "kg@gmail.com");
        NotificationObserverInterface textMsgObserver = new TextMsgObserver(iobserverable, "8181818181");


        iobserverable.registerObserver(emailObserver);
        iobserverable.registerObserver(emailObserver1);
        iobserverable.registerObserver(textMsgObserver);

        iobserverable.notifyObserver();
    }

}
