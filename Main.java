import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.IntPredicate;

public class Main {
private static int deep = 0;

  public static void main(String[] args) {
    for(int pn: findPrimeNumbers(120)) {
      System.out.println(pn);
    }
  }

  // n - limit
  public static Set<Integer> findPrimeNumbers(int limit) {
        int last = 2;
        // prime list
        Set<Integer> nums = new LinkedHashSet<Integer>();

    if(limit < last) return nums;

    for(int i = last; i <= limit; i++){
      nums.add(i);
    }

    nums = filterList(nums, last, limit);
    System.out.println("====");
    return nums;
  }

  private static Set<Integer> filterList(Set<Integer> list, int last, int limit) {
    System.out.println("list " + list);
    System.out.println("last " + last);

    int squared = last*last;
    if(squared < limit) {
      ++deep;

      for(int i=squared; i <= limit; i += last) {
        final int val = i;
        list.removeIf(x -> {
          if (x == val){ 
            System.out.println("filter " + x);
            return true;
          }
          return false;
        });
      }

      System.out.println("---");
      System.out.println("list " + list);
      for(Iterator<Integer> i = list.iterator(); i.hasNext();) {
        Integer val = i.next();
        if(val > last) {
          System.out.println("test " + val);
          return filterList(list, val, limit);
        }
      }
  } else {
    System.out.println("enought filtered");
    System.out.println("deep " + deep);
  }

    return list; 
  }
}