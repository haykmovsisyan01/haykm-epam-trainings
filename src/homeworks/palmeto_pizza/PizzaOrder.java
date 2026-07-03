package homeworks.palmeto_pizza;

import java.time.LocalTime;

public final class PizzaOrder {
    public final Pizza[] pizzas;
    public final int quantity;
    public final LocalTime orderedTime;
    public double amount = 0;

    PizzaOrder(Pizza[] pizzas, int quantity){
        this.quantity =  quantity;
        this.pizzas = pizzas;
        this.orderedTime = LocalTime.now();
        calculateOrderAmount();
    }

    public void calculateOrderAmount(){
         amount = getPizza().calculateAmount() * quantity;
    }

    public Pizza getPizza(String name){
        for (Pizza pizza : pizzas) {
            if(pizza.name.equals(name)){
                return pizza;
            }
        }
        return null;
    }

    public Pizza getPizza(){
        return pizzas[0];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(getPizza()).append("\n");
        result.append("Amount: ").append(amount).append("$").append("\n");
        result.append("Quantity: ").append(quantity).append("\n\n");
        result.append("--------------------------------");

        return result.toString();
    }
}