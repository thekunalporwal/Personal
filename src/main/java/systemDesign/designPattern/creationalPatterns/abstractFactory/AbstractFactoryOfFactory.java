package systemDesign.designPattern.creationalPatterns.abstractFactory;

import systemDesign.designPattern.creationalPatterns.factoryMethod.LocalPlanFactory;

abstract class AbstractFactoryOfFactory  {
    abstract InternationFactory getInternationalFactory(String factoryType);
    abstract LocalPlanFactory getPlanFactory(String factoryType);

}
