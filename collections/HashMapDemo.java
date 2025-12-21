import java.util.HashMap;

public class HashMapDemo {
   public static void main(String[] args) {
    
    HashMap<String, Double> poplton = new HashMap<>();     // Map of Population of country in Billions 

    // Guessed Values 
    poplton.put("China", 1.23);
    poplton.put("India", 1.4);
    poplton.put("USA", 0.34);
    poplton.put("Japan", 0.34);

    System.out.println(poplton);
   }
}
