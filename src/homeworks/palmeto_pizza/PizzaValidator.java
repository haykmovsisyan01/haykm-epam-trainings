package homeworks.palmeto_pizza;

public class PizzaValidator {
    public static boolean validName(String pizzaName){
        return pizzaName.length() > 3 && pizzaName.length() < 20;
    }
    public static boolean validQuantity(int quantity){
        return quantity <= 10;
    }
}
