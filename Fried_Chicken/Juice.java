import java.time.LocalDate;

public class Juice extends Drinks {
    //the shelf_time of Juice is 2
    private final int shelf_time;

    //create the construction method for juice
    public Juice(String drinkName, double cost, LocalDate manufacturing_time, int shelf_time){
        super(drinkName,cost,manufacturing_time,shelf_time);
        this.shelf_time=2;
    }

    //rewrite the toString method for juice
    public String toString(){
        return "Name of juice: "+drinkName+"\nCost of juice: "+cost+"\nManufacturing time of juice: "+ manufacturing_time+
                "Shelf time of juice: "+shelf_time;
    };
}
