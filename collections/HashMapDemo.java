import java.util.HashMap;

public class HashMapDemo {
   public static void main(String[] args) {
    
    HashMap<String, Double> population = new HashMap<>();     // Map of Population of country in Billions 

    // Insert  Key-Value Pair  
    population.put("China", 1.23);
    population.put("India", 1.4);
    population.put("USA", 0.34);
    population.put("Japan", 0.34);
    population.put("France", 0.12);

    System.out.println(population);

    // Get Value of Key
    System.out.println("China's Population : " + population.get("China"));

    // Checking whether the specified Key exist in map or Not
    System.out.println("China Exist in HashMap : " + population.containsKey("China"));

    // Deletion by Key
    population.remove("China");
    population.remove("France");

    System.out.println("HashMap After deletion : " + population);

    // Updation
    population.put("USA", 0.3);
    System.out.println(population);

    // Clearing the Map  
    population.clear();

    System.out.println(population);
   }
}
