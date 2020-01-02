import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.IntPredicate;

public class Main {
private static int deep = 0;

  public static void main(String[] args) {
    for(int pn: findPrimeNumbers(100)) {
      System.out.println(pn);
    }
  }

  // n - limit
  public static Set<Integer> findPrimeNumbers(int limit) {
        int last = 2;
        // prime list
        TreeSet<Integer> nums = new TreeSet<>();

    if(limit < last) return nums;

    for(int i = last; i <= limit; i++){
      nums.add(i);
    }

    nums = filterList(nums, last, limit);
    System.out.println("====");
    return nums;
  }

  private static TreeSet<Integer> filterList(TreeSet<Integer> list, int last, int limit) {
    System.out.println("last " + last);

    int squared = last*last;
    if(squared < limit) {
      ++deep;

      for(int i=squared; i <= limit; i += last) {
        list.remove(i);
      }

      System.out.println("---");
      System.out.println("list " + list);
      return filterList(list, list.higher(last), limit);
  } else {
    System.out.println("enought filtered");
    System.out.println("deep " + deep);
  }

    return list; 
  }
}