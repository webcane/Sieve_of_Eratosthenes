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
    for(int pn: findPrimeNumbers(100)) {
      System.out.println(pn);
    }
  }

  // n - limit
  public static List<Integer> findPrimeNumbers(int limit) {
        int last = 2;
        // prime list
        List<Integer> nums = new ArrayList<Integer>();

    if(limit < last) return nums;

    for(int i = last; i <= limit; i++){
      nums.add(i);
    }

    nums = filterList(nums, last, limit);
    System.out.println("====");
    return nums;
  }

  private static List<Integer> filterList(List<Integer> list, int last, int limit) {
    System.out.println("list " + list);
    System.out.println("last " + last);

if(last*last < limit) {
    ++deep;

    for(ListIterator<Integer> i = list.listIterator(list.size()); i.hasPrevious();) {
      Integer val = i.previous();
      System.out.println("test " + val);
      if(val != last && val % last == 0) {
        System.out.println("filter " + val);
        i.remove();
      }
    }

    System.out.println("---");
    System.out.println("list " + list);
    for(ListIterator<Integer> i = list.listIterator(); i.hasNext();) {
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