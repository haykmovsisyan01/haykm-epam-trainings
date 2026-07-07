package homeworks.palmeto_pizza.models;

import homeworks.palmeto_pizza.utill.Strings;

public class OrderItem {
    final private MenuItem menuItem;
    final private int quantity;

    public OrderItem(MenuItem menuItem, int quantity){
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public double getOrderPrice(){
        return menuItem.getAmount() * quantity;
    }

    public MenuItem getMenuItem(){
        return menuItem;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(getMenuItem().toString()).append("\n");
        stringBuilder.append("Amount: ").append(getOrderPrice()).append("\n");
        stringBuilder.append("Quantity: ").append(quantity).append("\n");
        stringBuilder.append(Strings.DIVIDER).append("\n");

        return stringBuilder.toString();
    }
}
