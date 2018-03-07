
import java.util.TreeSet;

public class TreeSetDemo {
   public static void main(String[] args) {

      // creating a TreeSet 
      TreeSet <Integer>tree = new TreeSet<Integer>();

      // adding in the tree set
      tree.add(1);
      tree.add(13);
      tree.add(17);
      tree.add(2);

      // rmoving 17 from the set
      int current = tree.first();
      System.out.println("Remove 1: "+tree.remove(current));      
      System.out.println(tree.size());
      System.out.println(tree.toString());
   }     
}