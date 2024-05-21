package systemDesign.designPattern.behaviourPattern.observer;

public class TextMsgObserver implements NotificationObserverInterface {

    long mobileNo;
    Iobserverable iobserverable;

    TextMsgObserver(Iobserverable iobserverable, String mobileNo){

        this.iobserverable = iobserverable;
        this.mobileNo = Long.parseLong(mobileNo);
        System.out.println("Email observer created");
    }

    @Override
    public void update(String message) {
        System.out.println("Text message sent to  " + mobileNo + " with message: " + message);
    }

}
