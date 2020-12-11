import java.nio.file.LinkOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class Testing_FriedChickenRestaurant {
    public static void main(String[] args) {
        //declare the items
        LocalDate time1 = LocalDate.parse("2020-11-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate time2 = LocalDate.parse("2020-11-13", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate time3 = LocalDate.parse("2020-11-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Juice orange = new Juice("Orange",15,time1,2);
        Juice mango = new Juice("Mango",20,time1,2);
        Juice apple = new Juice("Apple",12,time2,2);
        LinkedList<Juice> myJuice = new LinkedList<Juice>();
        myJuice.add(orange);
        myJuice.add(mango);
        myJuice.add(apple);

        Beer beer1 = new Beer("Beer1",15,time3,20);
        Beer beer2 = new Beer("Beer2",17,time3,20);
        Beer beer3 = new Beer("Beer3",20,time3,20);
        LinkedList<Beer> myBeer = new LinkedList<Beer>();
        myBeer.add(beer1);
        myBeer.add(beer2);
        myBeer.add(beer3);

        SetMeal setMeal1 = new SetMeal("seatMeal1",25,"shredded chicken",orange);
        SetMeal setMeal2 = new SetMeal("seatMeal2",30,"Colonel chicken",beer1);
        SetMeal setMeal3 = new SetMeal("seatMeal3",35,"Colonel chicken",beer3);
        LinkedList<SetMeal> mySetMeal = new LinkedList<SetMeal>();
        mySetMeal.add(setMeal1);
        mySetMeal.add(setMeal2);
        mySetMeal.add(setMeal3);

        West2FriedChickenRestaurant FZUchicken = new West2FriedChickenRestaurant(20000,myJuice,myBeer,mySetMeal);
        //the original property
        System.out.println(FZUchicken.getBalance());
        System.out.println(FZUchicken.getJuiceS().size());

        //**Test sellSetMeal**
        FZUchicken.sellSetMeal(setMeal1);
        System.out.println(FZUchicken.getBalance());
        System.out.println(FZUchicken.getJuiceS().size());
        //**Test batchPurchase**
        FZUchicken.batchPurchase(800,setMeal1);
        System.out.println(FZUchicken.getBalance());
        System.out.println(FZUchicken.getJuiceS().size());

        //throw the self-defined exception
        FZUchicken.batchPurchase(800,setMeal1);
        System.out.println(FZUchicken.getBalance());
        System.out.println(FZUchicken.getJuiceS().size());





    }



}
