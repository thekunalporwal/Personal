package systemDesign.designPattern.structuralPattern.decorator;

public class PizzaDriver {

    /**
     * The Decorator Pattern uses COMPOSITION instead of inheritance to extend the functionality of an object at runtime.
     */

    public static void main(String[] args) {

        BasePizzaAbstract basePizza= new Topping2Mushroom(new Flavour2Marghita());
        BasePizzaAbstract cheesePizza = new Topping1ExtraCheese(basePizza);
        System.out.println("cost of cheese  " +cheesePizza.getCost());
        System.out.println("cost is " +basePizza.getCost());

        BasePizzaAbstract pizza2 = new Flavour2Marghita();
        System.out.println(pizza2.getCost());
    }
}
