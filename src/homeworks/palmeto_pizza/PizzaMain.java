package homeworks.palmeto_pizza;



public class PizzaMain {
    public static void main(String[] args) {
        PizzaOrderService pizzaOrderService = new PizzaOrderService("7717");

        pizzaOrderService.orderPizza("Margarita", "Calzone", 2, "Tomato paste", "Pepper", "Garlic", "Bacon");

        pizzaOrderService.printCheck();

        pizzaOrderService = new PizzaOrderService("4372");

        pizzaOrderService.orderPizza("Peperoni", "Regular", 2, "Tomato paste", "Pepperoni", "Cheese");

        pizzaOrderService.printCheck();

        pizzaOrderService.showPizzaAttributes("Peperoni");


        //////////

        Pizza pizza = new Pizza("Margarita", "Calzone","Tomato paste", "Olives", "Garlic", "Bacon");

        System.out.println(pizza);
        System.out.println(pizza.addIngredient("Corn"));
        System.out.println(pizza.addIngredient("Corn"));
        System.out.println(pizza);
    }
}