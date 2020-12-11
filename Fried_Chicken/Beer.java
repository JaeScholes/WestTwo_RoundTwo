import java.time.LocalDate;

public class Beer extends Drinks {
    //the shelf_time of Juice is 20
    private final int shelf_time;
    private double alcohol_volume;

    //create the construction method for Beer
    public Beer(String drinkName, double cost, LocalDate manufacturing_time, int shelf_time){
    super(drinkName,cost,manufacturing_time,shelf_time);
    this.shelf_time=20;
    }

    //rewrite the toString method for beer
    public String toString(){
        return "Name of beer: "+drinkName+"\nCost of beer: "+cost+"\nManufacturing time of beer: "+ manufacturing_time+
                   "Shelf time of beer: "+shelf_time+"\n Alcohol volume of beer: " +alcohol_volume;

    };
}
