package systemDesign.designPattern.structuralPattern.decorator;

public class Flavour2Marghita extends BasePizzaAbstract{

    public Flavour2Marghita() {
        this.cost = 200;
    }

    @Override
    public int getCost() {
        return this.cost;
    }
}
