package homeworks.palmeto_pizza;

public record Ingredient(String name, double price) {
    public static Ingredient fromString(String name){
        double price = switch (name){
            case "Tomato paste" -> 1;
            case "Cheese" -> 1;
            case "Salami" -> 1.5;
            case "Bacon" -> 1.2;
            case "Garlic" -> 0.3 ;
            case "Corn" -> 0.7;
            case "Pepperoni"-> 0.6;
            case "Olives"-> 0.5 ;
            default -> -1;
        };

        return new Ingredient(price == -1 ? null : name, price);
    }

    public static Ingredient fromPizzaTypeString(String type){
        double price = switch (type){
            case "Regular" -> 1;
            case "Calzone" -> 1.5;
            default -> 0;
        };

        return new Ingredient(type, price);
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass() &&((Ingredient) obj).name.equals(this.name);
    }

    @Override
    public String toString() {
        return name + " " + price + "$";
    }
}