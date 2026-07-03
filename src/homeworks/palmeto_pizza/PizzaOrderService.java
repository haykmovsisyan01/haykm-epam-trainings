package homeworks.palmeto_pizza;

import java.util.Arrays;

public class PizzaOrderService {
    private static int orderStartNumber = 10000;

    final public int orderNumber;
    final public String customerName;

    private PizzaOrder[] pizzaOrders = new PizzaOrder[0];
    public double totalAmount = 0;

    public PizzaOrderService(String customerName) {
        if (orderStartNumber >= 100000) {
            orderStartNumber = 10000;
        }
        orderNumber = orderStartNumber++;

        this.customerName = customerName;
    }

    public void orderPizza(String pizzaName, String pizzaType, int quantity, String... ingredients) {
        if (!PizzaValidator.validQuantity(quantity)) {
            quantity = 10;
        }

        Pizza[] pizzas = new Pizza[quantity];

        if (!PizzaValidator.validName(pizzaName)) {
            for (int i = 0; i < quantity; i++) {
                pizzas[i] = new Pizza(customerName + ": " + i + 1, pizzaType, ingredients);
            }
        } else {
            for (int i = 0; i < quantity; i++) {
                pizzas[i] = new Pizza(pizzaName, pizzaType, ingredients);
            }
        }

        PizzaOrder order = new PizzaOrder(pizzas, quantity);

        addPizzaOrder(order);
    }

    private void addPizzaOrder(PizzaOrder order) {
        if (order == null) return;

        pizzaOrders = Arrays.copyOf(pizzaOrders, pizzaOrders.length + 1);

        pizzaOrders[pizzaOrders.length - 1] = order;
        calculateTotalAmount();
    }

    private void calculateTotalAmount(){
        totalAmount = 0;
        for (PizzaOrder pizzaOrder : pizzaOrders) {
            totalAmount+=pizzaOrder.amount;
        }
    }

    public void showPizzaAttributes(String pizzaName) {
        if (pizzaName == null) return;

        for (PizzaOrder pizzaOrder : pizzaOrders) {
            if (pizzaOrder.getPizza().name.equals(pizzaName)) {
                System.out.println("[" + orderNumber + " : " + customerName + " : " + pizzaName + " : " + pizzaOrder.quantity + "]");
                return;
            }
        }

        System.out.println("We coudnt find your pizza!");
    }

    public PizzaOrder[] getPizzaOrders(){
        return pizzaOrders;
    }

    public void printCheck() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("********************************").append("\n");
        result.append("Order: ").append(orderNumber).append("\n");
        result.append("Client: ").append(customerName).append("\n\n");
        for (PizzaOrder pizza : pizzaOrders) {
            result.append(pizza).append("\n");
        }
        result.append("Total amount: ").append(totalAmount).append("$").append("\n");
        result.append("********************************");

        return result.toString();
    }
}
