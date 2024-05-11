package systemDesign.designPattern.creationalPatterns.factoryMethod;

public class LocalPlanFactory {

    //use getPlan method to get object of type Plan
    public PlanAbstractClass getPlan(String planType){

        if(planType == null){
            return null;
        }
        if(planType.equalsIgnoreCase("DOMESTICPLAN")) {
            return new DomesticPlan();
        }
        else if(planType.equalsIgnoreCase("COMMERCIALPLAN")){
//            return new CommercialPlan();
        }
        else if(planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
            return new InstitutionalPlan();
        }
        return null;
    }


    public static void main(String args[])throws Exception{
        LocalPlanFactory planFactory = new LocalPlanFactory();
        PlanAbstractClass domesticplan= planFactory.getPlan("DOMESTICPLAN");

        System.out.println("Enter the name of plan for which the bill will be generated: " + domesticplan.getRate());
        //Not abstract method
        domesticplan.calculateBill(2);
    }


}
