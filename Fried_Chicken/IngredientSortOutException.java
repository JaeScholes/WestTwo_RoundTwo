import java.util.LinkedList;

public class IngredientSortOutException extends RuntimeException{
      //exception message
      private String message;
      IngredientSortOutException(Drinks drink){
      String type = drink.getClass().getSimpleName();

      //create the message depending on the type of drinks
      message = "Sorry sir, the "+type+" has been sold out.";

      //print out the messages
      System.out.println(message);
    }
}
