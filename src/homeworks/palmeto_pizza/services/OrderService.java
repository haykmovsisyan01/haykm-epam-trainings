package homeworks.palmeto_pizza.services;

import homeworks.palmeto_pizza.models.OrderItem;
import homeworks.palmeto_pizza.utill.Strings;
import homeworks.palmeto_pizza.utill.Validator;

public class OrderService {
    final private int customerId;
    final private int orderId;
    private static int orderCounter = 10000;
    private OrderItem[] orderItems;
    private double totalAmount = 0;

    public OrderService(int customerId) {
        if(orderCounter > 100000) orderCounter = 10000;
        this.customerId = customerId;
        this.orderId = orderCounter++;
    }

    public OrderItem[] order(OrderItem... orderItems){
        if(orderItems == null){
            System.out.println("You didnt select any orders!");
            return new OrderItem[0];
        }

        checkNames(orderItems);

        //  Կարելի էր նաև ոչ թե ուղղակի վերագրել, այլ orderItems ավելացնել նոր orderItems
        this.orderItems = orderItems;
        calculateTotalAmount();
        return this.orderItems;
    }
    public OrderItem order(OrderItem orderItem){
        // Մի հարց այստեղ 21 տողի պես ոնց ճիշտ check անեմ
        checkNames(orderItem);

        this.orderItems  = new OrderItem[] {orderItem};
        calculateTotalAmount();
        return this.orderItems[0];
    }

    private void checkNames(OrderItem... orderItems){
        for (int i = 0; i < orderItems.length; i++) {
            if(!Validator.validateName(orderItems[i].getMenuItem().getName())){
                orderItems[i].getMenuItem().setName(customerId + "_" + i);
            }
        }
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    private void calculateTotalAmount(){
        totalAmount = 0;
        for (OrderItem orderItem : orderItems) {
            totalAmount+=orderItem.getOrderPrice();
        }
    }

    public void printCheck(){
        System.out.println(Strings.CHECK_BORDER);
        System.out.println("Order: " + orderId);
        System.out.println("Client: " + customerId);
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
        System.out.println("Total amount: " + totalAmount + "$");
        System.out.println(Strings.CHECK_BORDER);
    }
}