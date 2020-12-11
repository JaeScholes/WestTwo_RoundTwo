public class SetMeal {
    //declare the variables
    private String mealName;
    private double price;
    private String chickenName;
    private Drinks drink;

    //create the construction method for SetMeal
    public SetMeal(String mealName,double price,String chickenName,Drinks drink){
        this.mealName=mealName;
        this.price=price;
        this.chickenName=chickenName;
        this.drink=drink;
    }

    //create the get method for Drink
    public Drinks getDrink() {
        return drink;
    }

    //create the get method for price
    public double getPrice() {
        return price;
    }

    //rewrite the toString method
    @Override
    public String toString(){
        return "Name of SetMeal: "+mealName+"\nPrice of SetMeal: "+price+"\nName of the fried chicken in SetMeal: "+chickenName
                +"\nName of the drink in SetMeal: "+drink.drinkName+"\nCost of the drink in SetMeal: "+drink.cost
                +"\nManufacturing time of the drink in SetMeal: "+drink.manufacturing_time+"\nShelf_time of the drink in SetMeal"+drink.shelf_time;

    }
}
