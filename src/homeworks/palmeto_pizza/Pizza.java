package homeworks.palmeto_pizza;

import java.util.Arrays;

public class Pizza {
    final public String name;
    final public Ingredient type;
    private Ingredient[] ingredients;

    public Pizza(String name, String type, String... ingredients) {
        this.ingredients = new Ingredient[0];
        this.name = name;
        this.type = Ingredient.fromPizzaTypeString(type);
        for (String ingredient : ingredients) {
            addIngredient(ingredient);
        }
    }

    public Ingredient[] getIngredients() {
        return ingredients.clone();
    }

    public String addIngredient(String ingredientStr){
        Ingredient ingredient = Ingredient.fromString(ingredientStr);

        if(ingredient.name() == null) return "Invalid ingredient name";

        if(ingredients.length > 7){
            return "Pizza is full, there is no more place to add " + ingredientStr + "!";
        }

        for (Ingredient ingredient1 : ingredients) {
            if(ingredient1.equals(ingredient)){
                return "Please make sure that you are not adding ingredient that pizza already has";
            }
        }

        ingredients = Arrays.copyOf(ingredients, ingredients.length+1);

        ingredients[ingredients.length-1] = ingredient;

        return ingredientStr + " has been added successfully!";
    }

    public double calculateAmount(){
        double amount = type.price();

        for (Ingredient ingredient : getIngredients()) {
            amount += ingredient.price();
        }
        return amount;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Name: ").append(name).append("\n");
        result.append("Pizza Base(").append(type.name()).append(") ").append(type.price()).append("$").append("\n");
        result.append("--------------------------------").append("\n");
        for (Ingredient ingredient : getIngredients()) {
            result.append(ingredient);
            result.append("\n");
        }
        result.append("--------------------------------");
        return result.toString();
    }
}
