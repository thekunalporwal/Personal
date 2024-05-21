package systemDesign.designPattern.creationalPatterns.abstractFactory;

import systemDesign.designPattern.creationalPatterns.factoryMethod.LocalPlanFactory;
import systemDesign.designPattern.creationalPatterns.factoryMethod.PlanAbstractClass;

public class Main extends AbstractFactoryOfFactory{
    @Override
    InternationFactory getInternationalFactory(String factoryType) {
        if (String.valueOf(factoryType).equals("International")) {
            return new InternationFactory();
        }
        return null;
    }

    @Override
    LocalPlanFactory getPlanFactory(String factoryType) {
        if (String.valueOf(factoryType).equals("OTHERS")) {
            return new LocalPlanFactory();
        }
        return null;
    }

    public static void main(String[] args) {
        Main abstractFactoryProducer = new Main();
        InternationFactory internationFactory = abstractFactoryProducer.getInternationalFactory("International");
        System.out.println(internationFactory.getPlan("China").getInternationPlan());
        LocalPlanFactory localPlanFactory = abstractFactoryProducer.getPlanFactory("OTHERS");
        PlanAbstractClass domesticplan = localPlanFactory.getPlan("DOMESTICPLAN");
        System.out.println(domesticplan.getRate());
    }

}
