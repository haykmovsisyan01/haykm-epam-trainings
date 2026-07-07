package homeworks.palmeto_pizza.models;

import homeworks.palmeto_pizza.models.enums.Ingredient;
import homeworks.palmeto_pizza.models.enums.PizzaType;
import homeworks.palmeto_pizza.utill.Strings;

import java.util.Arrays;

public class Pizza implements MenuItem{
    private String name;
    private double amount;
    private final PizzaType type;
    private Ingredient[] ingredients;

    public Pizza(String name, PizzaType type, Ingredient... ingredients) {
        if(name == null) name = "Pizza";
        if(type == null) type = PizzaType.REGULAR;
        this.name = name;
        this.type = type;

        this.ingredients = new Ingredient[0];
        for (Ingredient ingredient : ingredients) {
            addIngredient(ingredient);
        }
    }

    private void calculatePrice(){
        amount = 0;
        amount +=type.getPrice();
        for (Ingredient ingredient : ingredients) {
            amount +=ingredient.getPrice();
        }
    }

    public void addIngredient(Ingredient ingredient) {
        if(ingredient == null) return;

        if(ingredients.length == 7){
            System.out.println("Pizza is full");
            return;
        }

        for (Ingredient ingredient1 : ingredients) {
            if(ingredient == ingredient1) {
                System.out.println("Pizza already contains " + ingredient1.getName() + "!");
                return;
            }
        }
        ingredients = Arrays.copyOf(ingredients, ingredients.length+1);

        ingredients[ingredients.length-1] = ingredient;

        calculatePrice();
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String newName) {
        name = newName;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ").append(getName()).append("\n");
        stringBuilder.append(Strings.DIVIDER).append("\n");
        for (Ingredient ingredient : ingredients) {
            stringBuilder.append(ingredient.getName()).append(" ").append(ingredient.getPrice()).append("$").append("\n");
        }
        stringBuilder.append(Strings.DIVIDER).append("\n");

        return stringBuilder.toString();
    }
}
