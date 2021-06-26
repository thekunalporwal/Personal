package springdemo;

public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Spend 5 minutes on batting practice";
    }

    @Override
    public String getFortune() {
        return null;
    }

}
