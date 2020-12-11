import java.time.LocalDate;
import java.util.Date;

public abstract class Drinks {
    protected String drinkName;
    protected double cost;
    protected LocalDate manufacturing_time;
    protected int shelf_time;

    //create the construction method for drinks
    public Drinks(String drinkName,double cost, LocalDate manufacturing_time,int shelf_time) {
        this.drinkName=drinkName;
        this.cost=cost;
        this.manufacturing_time=manufacturing_time;
        this.shelf_time=shelf_time;
    }

    //create the method to judge if it is overdue
    public boolean judgeOverdue(){
        LocalDate today = LocalDate.now();
        //calculate the interval time
        int interval_time = today.until(manufacturing_time).getDays();
        //judge if the interval time is greater than the shelf_time.
        //If so, the drink is overdue.
        if(interval_time>shelf_time){
           return true;
        }
        else{
           return false;
        }
    }

    //create the abstract method for drinks
    public abstract String toString();

}
