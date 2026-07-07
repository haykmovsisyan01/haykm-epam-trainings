package homeworks.palmeto_pizza;

import homeworks.palmeto_pizza.models.enums.Ingredient;
import homeworks.palmeto_pizza.models.OrderItem;
import homeworks.palmeto_pizza.models.Pizza;
import homeworks.palmeto_pizza.models.enums.PizzaType;
import homeworks.palmeto_pizza.services.OrderService;

public class PizzaMain {
    public static void main(String[] args) {
        OrderService service = new OrderService(5454);

        service.order(new OrderItem(new Pizza("314", PizzaType.REGULAR, Ingredient.BACON, Ingredient.CORN, Ingredient.CHEESE, Ingredient.OLIVES), 2),new OrderItem(new Pizza("jd", PizzaType.CALZONE, Ingredient.BACON, Ingredient.CHEESE, Ingredient.OLIVES), 3));
        service.printCheck();

        Pizza pizza = new Pizza("My pizza", PizzaType.REGULAR);

        for (Ingredient value : Ingredient.values()) {
            pizza.addIngredient(value);
        }

        System.out.println(pizza);
    }
}