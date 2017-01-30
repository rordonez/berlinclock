package rafael.ordonez.berlinclock;

/**
 * Created by rafa on 30/1/17.
 */
public class MainBerlinClock {

     public static void main(String [] args) {
         if (args == null || args.length !=3)
             return;
         BerlinClock berlinClock = new BerlinClock(Integer.parseInt(args[0]),Integer.parseInt(args[1]), Integer.parseInt(args[2]));

         System.out.println(berlinClock.toString());
     }
}
