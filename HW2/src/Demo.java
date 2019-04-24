import java.io.*;
import java.util.*;

public class Demo {

   // Prints all movies that occur in both lists.
   public static void intersection(List<String> list1, List<String> list2) {
      // Fill in.
	   //System.out.println("***intersection***");
	   Set<String> set = new HashSet<String>();
	   
	   for(int i = 0; i < list2.size(); i++) {
		   
		   set.add(list2.get(i));
	   }
	   
	   for(int j = 0; j < list1.size(); j++) {
		   
		   if(set.contains(list1.get(j))) {
			   System.out.println(list1.get(j));
		   }
	   }
   }

   // Prints all movies in the list that occur at least k times
   // (print the movie followed by the number of occurrences in parentheses).
   public static void frequent(List<String> list, int k) {
      // Fill in.
	   
	   Map<String, Integer> map = new HashMap<String, Integer>();
	   
	   for(int i = 0; i < list.size(); i++) {
		   
		   String key = list.get(i);
		   
		   if(map.containsKey(key)) {
			   
			   
			   int value = map.get(key);
			   ++value;
			  map.replace(key, value);
			   
		   }
		   else {
			   map.put(list.get(i), 1);
		   }
	   }
	   
	   for (Map.Entry<String, Integer> entry : map.entrySet()) {
		    String key = entry.getKey();
		    int value = entry.getValue();
		    
		    if(value >= k)
		    	System.out.println(key + " (" + value + ")");
		}
   }

   // Prints all movies in the list, grouped by number of characters.
   // All movies with the same number of characters are printed on the same line.
   // Movies with fewer characters are listed first.
   public static void groupByNumChars(List<String> list) {
      // Fill in.
	   
	   Map<Integer, List<String>> map = new TreeMap<Integer, List<String>>();
	   
	   for(int i = 0; i < list.size(); i++) {
		   
		   int l = list.get(i).length();
		   
		   if(map.containsKey(l)) {
			   
			   String s = list.get(i);
			   List<String> llist = map.get(l);
			   llist.add(s);
			   map.replace(l, llist);
		   }
		   else {
			   List<String> llist = new ArrayList<String>();
			   llist.add(list.get(i));
			   map.put(l,llist);
		   }
	   }
	   
	   for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
		   
		   	int key = entry.getKey();
		    List<String> value = entry.getValue();
		    
		    StringBuilder sb = new StringBuilder();
		    
		    sb.append(key + " = [");
		    
		    for(int k = 0; k < value.size(); k++) {
		    	
		    	sb.append(value.get(k));
		    	
		    	if(k < value.size() - 1) {
		    		sb.append(", ");
		    	}
		    }	    
		   sb.append("]");
		   System.out.println(sb.toString());
		}
	   
   }

   // Returns a List of all movies in the specified file (assume there is one movie per line).
   public static List<String> getList(String filename) {
      List<String> list = new ArrayList<>();
      try (Scanner in = new Scanner(new FileReader(filename))) {
         while (in.hasNextLine()) {
            String line = in.nextLine();
            list.add(line);
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      return list;
   }

   public static void main(String[] args) {
      List<String> list1 = getList("imdb.txt");
      List<String> list2 = getList("sight_and_sound.txt");
      List<String> list3 = getList("3_lists.txt");

      System.out.println("***intersection***");
      intersection(list1, list2);

      System.out.println("***frequent***");
      frequent(list3, 3);

      System.out.println("***groupByNumChars***");
      groupByNumChars(list3);
   }
}