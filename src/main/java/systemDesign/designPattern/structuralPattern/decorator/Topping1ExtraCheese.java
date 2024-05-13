package systemDesign.designPattern.structuralPattern.decorator;

public class Topping1ExtraCheese extends DecoratorTopping {

    BasePizzaAbstract basePizzaAbstract;

    public Topping1ExtraCheese(BasePizzaAbstract basePizzaAbstract) {
        this.basePizzaAbstract = basePizzaAbstract;
    }

    @Override
    public int getCost() {
        return this.basePizzaAbstract.getCost()+20;
    }
}
