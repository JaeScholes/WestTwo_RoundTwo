import javax.management.loading.MLet;
import java.util.Scanner;
import java.util.concurrent.*;


public class MultithReading{
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //using Scanner get values from users
        Scanner inputs = new Scanner(System.in);
        int target = inputs.nextInt();
        long result=0;
        System.out.println("Before "+result);

        //define the Range (the original range is 1000000000, but because of the code written below the range should be the (original range)/10
        long range=100000000;

        //create 10 Threads
        containing No1 = new containing(target,1,range);
        containing No2 = new containing(target,range,range*2);
        containing No3 = new containing(target,range*2,range*3);
        containing No4 = new containing(target,range*3,range*4);
        containing No5 = new containing(target,range*4,range*5);
        containing No6 = new containing(target,range*5,range*6);
        containing No7 = new containing(target,range*6,range*7);
        containing No8 = new containing(target,range*7,range*8);
        containing No9 = new containing(target,range*8,range*9);
        containing No10 = new containing(target,range*9,range*10);

        //create the ThreadPool containing 10 threads
        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<Long> r1 = service.submit(No1);
        Future<Long> r2 = service.submit(No2);
        Future<Long> r3 = service.submit(No3);
        Future<Long> r4 = service.submit(No4);
        Future<Long> r5 = service.submit(No5);
        Future<Long> r6 = service.submit(No6);
        Future<Long> r7 = service.submit(No7);
        Future<Long> r8 = service.submit(No8);
        Future<Long> r9 = service.submit(No9);
        Future<Long> r10 = service.submit(No10);

        //get the values from these 10 defined Threads
        long R1 = r1.get();
        long R2 = r2.get();
        long R3 = r3.get();
        long R4 = r4.get();
        long R5 = r5.get();
        long R6 = r6.get();
        long R7 = r7.get();
        long R8 = r8.get();
        long R9 = r9.get();
        long R10 = r10.get();

        //shutdown the service
        service.shutdown();
        //calculate the result
        result = R1+R2+R3+R4+R5+R6+R7+R8+R9+R10;
        System.out.println("After "+result);
    }
    



}

class containing implements Callable {
    //the variables to define the range and set target
    private final long range1;
    private final long range2;
    private long result = 0;
    private final int target;

    //construction method
    public containing(int target,long range1,long range2){
        this.range1=range1;
        this.range2=range2;
        this.target=target;
    }

    //override the call method
    @Override
    public Long call(){
        for (long i = range1; i < range2; i++) {
            if (contain(i, target)) {
                result += i;
            }
        }
        return result;
    }

    //the method to judge if it is satisfied the condition
    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }



}
