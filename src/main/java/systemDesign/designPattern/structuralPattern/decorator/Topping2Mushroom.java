package systemDesign.designPattern.structuralPattern.decorator;

public class Topping2Mushroom extends DecoratorTopping{

    BasePizzaAbstract basePizzaAbstract;
    public Topping2Mushroom(BasePizzaAbstract basePizzaAbstract) {
        this.basePizzaAbstract = basePizzaAbstract;
    }

    @Override
    public int getCost() {

        return this.basePizzaAbstract.getCost()+40;
    }
}
