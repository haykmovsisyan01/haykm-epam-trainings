package homeworks.palmeto_pizza.models.enums;

public enum PizzaType {
    REGULAR("Regular", 1.0),
    CALZONE("Calzone", 1.5);

    final private String name;
    final private double price;

    PizzaType(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
