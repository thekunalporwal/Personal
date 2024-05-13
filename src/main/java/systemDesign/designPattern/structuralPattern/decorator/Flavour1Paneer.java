package systemDesign.designPattern.structuralPattern.decorator;

public class Flavour1Paneer extends BasePizzaAbstract {

    public Flavour1Paneer() {
        this.cost = 100;
    }

    @Override
    public int getCost() {
        return this.cost;
    }
}
