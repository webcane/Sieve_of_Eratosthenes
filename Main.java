import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.function.IntPredicate;

public class Main {
private static int deep = 0;

  public static void main(String[] args) {
    for(Map.Entry<Integer, Boolean> pn: findPrimeNumbers(100).entrySet()) {
      System.out.println(pn.getKey());
    }
  }

  // n - limit
  public static Map<Integer, Boolean> findPrimeNumbers(int limit) {
        int last = 2;
        // prime list
        TreeMap<Integer, Boolean> nums = new TreeMap<>();

    if(limit < last) return nums;

    for(int i = last; i <= limit; i++){
      nums.put(i, false);
    }

    nums = filterList(nums, last, limit);

    for(Iterator<Map.Entry<Integer, Boolean>> i = nums.entrySet().iterator(); i.hasNext(); ) {
        Map.Entry<Integer, Boolean> entry = i.next();
        if(entry.getValue()) {
          i.remove();
        }
      }

    System.out.println("====");
    return nums;
  }

  private static TreeMap<Integer, Boolean> filterList(TreeMap<Integer, Boolean> list, int last, int limit) {
    System.out.println("list " + list);
    System.out.println("last " + last);

    int squared = last*last;
    if(squared < limit) {
      ++deep;

    for(int i=squared; i <= limit; i += last) {
      list.replace(i, true);    
    }

    System.out.println("---");
    System.out.println("list " + list);

    int next = list.higherKey(last);
    return filterList(list, next, limit);

  } else {
    System.out.println("enought filtered");
    System.out.println("deep " + deep);
  }

    return list; 
  }
}