import java.util.LinkedList;

public class OverdraftBalanceException extends RuntimeException {
    //exception message
    private final String message;
    //the constructor method
    OverdraftBalanceException(int amount,Drinks drink,double balance){
        String type = drink.getClass().getSimpleName();
        double difference = Math.abs(balance - amount*drink.cost);
        message = "Warning: the current balance is not enough to pay the bill of "+type+"\nThe amount of money you need to pay the bill is "+difference;
        System.out.println(message);
    }

}