import java.util.LinkedList;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    //declare the variables
    private double balance;
    private LinkedList<Juice> juiceS;    //P.S S is placed here to represent multiplicity
    private LinkedList<Beer> beerS;      //P.S S is placed here to represent multiplicity
    private static LinkedList<SetMeal> mealS;//P.S S is placed here to represent multiplicity

    //the construction method for this fried chicken restaurant
    public West2FriedChickenRestaurant(double balance,LinkedList <Juice> juiceS,LinkedList <Beer> beerS,LinkedList <SetMeal> mealS){
        this.balance=balance;
        this.juiceS=juiceS;
        this.beerS=beerS;
        this.mealS=mealS;
    }

    //the use method for Beer
    private boolean use(Beer beer) throws IngredientSortOutException{
        //a boolean variable to check if the element is found
        boolean sign=false;
        int length = beerS.size();
        for(int count=0 ; count<length ; count++){
            //the situation where the element is found
                if(beerS.get(count).drinkName.equals(beer.drinkName)) {
                   beerS.remove(count);
                   sign=true;
                   break;
                }
        }
        if(!sign){
            //throw out the exception
            throw new IngredientSortOutException(beer);
        }
        return sign;
    }

    //the use method for Juice
    private boolean use(Juice juice) throws IngredientSortOutException{
        //a boolean variable to check if the element is found
        boolean sign=false;
        int length = juiceS.size();
        for(int count=0 ; count<length ; count++){
            //the situation where the element is found
            if(juiceS.get(count).drinkName.equals(juice.drinkName)) {
                juiceS.remove(count);
                sign=true;
                break;
            }
        }
        if(!sign){
            //throw out the exception
            throw new IngredientSortOutException(juice);
        }
        return sign;
    }

    //sellSetMeal Method
    @Override
    public void sellSetMeal(SetMeal meal) throws IngredientSortOutException{
        //the drink is beer
        if(meal.getDrink() instanceof Beer){
           Beer beer = (Beer)meal.getDrink();
           boolean sign = use(beer);
           if(sign){
               balance=balance+meal.getPrice();
           }
        }
        //the drink is juice
        else{
            Juice juice = (Juice)meal.getDrink();
            boolean sign = use(juice);
            if(sign){
                balance=balance+meal.getPrice();
            }
        }

    }

    //batchPurchase Method
    @Override
    public void batchPurchase(int amount,SetMeal meal) throws OverdraftBalanceException{
        double bill;
        //the drink is beer
        if(meal.getDrink() instanceof Beer){
            Beer beer = (Beer)meal.getDrink();
            bill = amount*beer.cost;
            if(balance-bill>=0){
                //minus the bill and print out the message
                balance = balance-bill;
                System.out.println("The batch purchase is sucessfully done!\nRemain: "+balance);
                //add the corresponding list
                for(int count=0 ; count<amount ; count++) {
                    beerS.add((Beer) meal.getDrink());
                }
            }
            else{
                //If the money is not enough, throw out the exception
                throw new OverdraftBalanceException(amount,beer,balance);
            }
        }
        //the drink is juice
        else {
            Juice juice = (Juice)meal.getDrink();
            bill = amount*juice.cost;
            if(balance-bill>=0){
                //minus the bill and print out the message
                balance = balance-bill;
                System.out.println("The batch purchase is sucessfully done!\nRemain: "+balance);
                //add the corresponding list
                for(int count=0 ; count<amount ; count++) {
                    juiceS.add((Juice) meal.getDrink());
                }
            }
            else{
                //If the money is not enough, throw out the exception
                throw new OverdraftBalanceException(amount,juice,balance);
            }
        }

    }

    //The get methods
    public double getBalance() {
        return balance;
    }

    public LinkedList<Beer> getBeerS() {
        return beerS;
    }

    public LinkedList<Juice> getJuiceS() {
        return juiceS;
    }

    public static LinkedList<SetMeal> getMealS() {
        return mealS;
    }
}
