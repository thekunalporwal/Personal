package systemDesign.designPattern.creationalPatterns.abstractFactory;

public class InternationFactory {
    public InternationalPlan getPlan(String planType){
        if(planType == null){
            return null;
        }
        if(planType.equalsIgnoreCase("China")){
            return new ChinaPlan();
        } else if(planType.equalsIgnoreCase("America")){
            return new AmericaPlan();
        }
        return null;
    }
}
