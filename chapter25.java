// Demonstrate ArrayList.

import java.util.*;

class ArrayListDemo {
  public static void main(String[] args) {
    // Create an array list.
    ArrayList<Character> al = new ArrayList<Character>();

    System.out.println("Initial size: " + al.size());

    // Add elements to the end of the list one at a time.
    al.add('A');
    al.add('B');
    al.add('C');
    al.add('D');
    al.add('E');

    System.out.println("\nSize after additions: " + al.size());

    // Display the array list using its toString() representation.
    System.out.println("Contents: " + al);

    // Now, add elements to middle of the list.
    // This will cause the array to expand.
    for(int i = 0; i < 3; i++)
      al.add(2, (char) ('x' + i));

    System.out.println("\nSize after additions: " + al.size());
    System.out.println("Contents: " + al);

    // Now, delete the elements just added.
    // This will cause the array to contract.
    for(int i = 0; i < 3; i++)
      al.remove(2);

    System.out.println("\nSize after deletions: " + al.size());
    System.out.println("Contents: " + al);

    // Use set() to set the value at an index.
    for(int i=0; i < al.size(); i++)
      al.set(i, Character.toLowerCase(al.get(i)));

    System.out.println("\nAfter changing to lowercase.");
    System.out.println("Contents: " + al);

    // Find and remove a value
    int idx = al.indexOf('d');
    if(idx >= 0) al.remove(idx);

    System.out.println("\nAfter finding and removing d.");
    System.out.println("Contents: " + al);

    // Empty the list.
    al.clear();
    System.out.println("\nAfter clearing the list.");
    System.out.println("Contents: " + al);

    // Add the digits 0 through 9
    for(int i=0; i < 10; i++)
      al.add((char) ('0' + i));

    // Display every other element.
    System.out.print("\nHere is every other digit: ");
    for(int i=0; i < al.size(); i+=2)
      System.out.print(al.get(i) + " ");
  }
}

// -----------------------------------------

// Demonstrate LinkedList.

import java.util.*;

class LinkedListDemo {
  public static void main(String[] args) {
    // Create a linked list.
    LinkedList<Character> ll = new LinkedList<Character>();

    // Add elements to the linked list.
    ll.add('B');
    ll.add('E');
    ll.add('F');
    System.out.println("Original contents: " + ll);

    // Demonstrate addLast() and addFirst().
    ll.addLast('G');
    ll.addFirst('A');
    System.out.println("\nAfter calls to addFirst() and addLast().");
    System.out.println("Contents: " + ll);

    // Add elements at an index.
    ll.add(2, 'D');
    ll.add(2, 'C');
    System.out.println("\nAfter insertions.");
    System.out.println("Contents: " + ll);

    // Display first and last elements.
    System.out.println("\nHere are the first and last elements: " +
                       ll.getFirst() + " " + ll.getLast());

    // Create a sublist view.
    List<Character> sub = ll.subList(2, 5);
    System.out.println("\nContents of sublist view: " + sub);

    // Create a new list that contains the sublist
    LinkedList<Character> ll2 = new LinkedList<Character>(sub);

    // Remove the elements in ll2 from ll.
    ll.removeAll(ll2);

    System.out.println("\nAfter removing ll2 from ll.");
    System.out.println("Contents: " + ll);

    // Remove first and last elements.
    ll.removeFirst();
    ll.removeLast();

    System.out.println("\nAfter deleting first and last element: ");
    System.out.println("Contents: " + ll);

    // Get and set a value through an index.
    ll.set(0, Character.toLowerCase(ll.get(0)));

    System.out.println("\nAfter change: " + ll);
  }
}

// -----------------------------------------

import java.util.*;

public class ViewAndArrayDemo {
  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<String>();

    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");

    String[] array = list.toArray(new String[4]);
    List<String> sublist = list.subList(0,4);
    array[1] = "F";
    sublist.set(2,"O");
    System.out.println(list);
  }
}

// -----------------------------------------

// Demonstrate HashSet.

import java.util.*;

class HashSetDemo {
  public static void main(String[] args) {
    // Create a hash set.
    HashSet<Character> hs = new HashSet<Character>();

    // Add elements to the hash set.
    hs.add('A');
    hs.add('B');
    hs.add('C');
    hs.add('D');
    System.out.println("Original contents: " + hs);

    // Add more elements.
    hs.add('E');
    hs.add('F');
    hs.add('G');
    hs.add('H');
    System.out.println("\nContents after additions: " + hs);

    // Delete E and H.
    hs.remove('E');
    hs.remove('H');
    System.out.println("\nContents after deleting E and H: " + hs);

    // Add E back in.
    hs.add('E');
    System.out.println("\nContents after adding E: " + hs);

    // Add a collection of elements to hash set.
    ArrayList<Character> al = new ArrayList<Character>();
    al.add('X');
    al.add('Y');
    al.add('Z');
    hs.addAll(al);

    System.out.println("\nContents after adding collection: " + hs);
  }
}

// -----------------------------------------

// A TreeSet creates a sorted tree.

import java.util.*;

class TreeSetDemo {
  public static void main(String[] args) {
    char[] chrs = { 'V', 'J', 'L', 'E', 'T', 'Q', 'C', 'P' };

    // Create a tree set and a hash set.
    TreeSet<Character> ts = new TreeSet<Character>();
    HashSet<Character> hs = new HashSet<Character>();

    System.out.print("Contents of chrs:      ");
    for(char ch : chrs)
      System.out.print(ch + "  ");

    System.out.println();

    // First, add the characters to the hash set.
    for(char ch : chrs)
      hs.add(ch);

    System.out.println("Contents of hash set: " + hs);

    // Next, add the characters to the tree set.
    for(char ch : chrs)
      ts.add(ch);

    System.out.println("Contents of tree set: " + ts);
  }
}

// -----------------------------------------

// LinkedHashSet compared with HashSet and TreeSet.

import java.util.*;

class SetsDemo {
  public static void main(String[] args) {
    char[] chrs = { 'V', 'J', 'L', 'E', 'T', 'Q', 'C', 'P' };

    // Create all three sets.
    TreeSet<Character> ts = new TreeSet<Character>();
    HashSet<Character> hs = new HashSet<Character>();
    LinkedHashSet<Character> lhs = new LinkedHashSet<Character>();

    System.out.print("Contents of chrs:             ");
    for(char ch : chrs)
      System.out.print(ch + "  ");

    System.out.println();

    // First, add the characters to the hash set.
    for(char ch : chrs)
      hs.add(ch);

    System.out.println("Contents of hash set:        " + hs);

    // Next, add the characters to the tree set.
    for(char ch : chrs)
      ts.add(ch);

    System.out.println("Contents of tree set:        " + ts);

    // Finally, add the characters to the linked hash set.
    for(char ch : chrs)
      lhs.add(ch);

    System.out.println("Contents of linked hash set: " + lhs);
  }
}

// -----------------------------------------

// Demonstrate ArrayDeque.
// First the use the deque as as a stack.
// Then, use it as a FIFO queue.

import java.util.*;

class ArrayDequeDemo {
  public static void main(String[] args) {
    // Create an array deque.
    ArrayDeque<Character> adq = new ArrayDeque<Character>();

    System.out.println("Using adq as a stack.");
    // Use adq like a stack.
    System.out.print("Pushing: ");

    // push items on the stack
    for(char ch = 'A'; ch <= 'Z'; ch++) {
      adq.push(ch);
      System.out.print(ch);
    }

    System.out.println();

    // now, pop them off
    System.out.print("Popping: ");
    while(adq.peek() != null)
      System.out.print(adq.pop());

    System.out.println("\n");

    System.out.println("Using adq as a FIFO queue.");
    // Now, use adq as a FIFO queue.
    System.out.print("Queueing: ");
    for(char ch = 'A'; ch <= 'Z'; ch++) {
      adq.offerLast(ch);
      System.out.print(ch);
    }

    System.out.println();

    // now, remove them
    System.out.print("Removing: ");
    while(adq.peek() != null)
      System.out.print(adq.pollFirst());
  }
}

// -----------------------------------------

// Demonstrate both Iterator and ListIterator.

import java.util.*;

class IteratorDemo {
  public static void main(String[] args) {
    // Create a list of strings.
    ArrayList<String> al = new ArrayList<String>();

    // Add entries to the array list.
    al.add("Alpha");
    al.add("Beta");
    al.add("Gamma");
    al.add("Delta");
    al.add("Epsilon");
    al.add("Zeta");
    al.add("Eta");

    // First, use Iterator.

    // Use Iterator to display the contents of the list.
    System.out.print("Original contents:       ");
    Iterator<String> itr = al.iterator();
    while(itr.hasNext())
      System.out.print(itr.next() + " ");
    System.out.println();

    // Use Iterator to remove Gamma from the list.
    itr = al.iterator();
    while(itr.hasNext()) {
      if(itr.next().equals("Gamma"))
        itr.remove();
    }

    System.out.print("Contents after deletion: ");
    itr = al.iterator();
    while(itr.hasNext())
      System.out.print(itr.next() + " ");
    System.out.println();


    // Now, use ListIterator.

    // Use ListIterator to add Gamma back to the list.
    ListIterator<String> litr = al.listIterator();
    while(litr.hasNext()) {
      if(litr.next().equals("Beta"))
        litr.add("Gamma");
    }

    System.out.print("Contents after addition: ");
    litr = al.listIterator();
    while(litr.hasNext())
      System.out.print(litr.next() + " ");
    System.out.println();

    // Use ListIterator to modify the objects being iterated.
    String str;
    litr = al.listIterator();
    while(litr.hasNext()) {
      str = litr.next();

      if(str.equals("Eta"))
        litr.set("Omega");
      else if(str.equals("Zeta"))
        litr.set("Psi");
      else if(str.equals("Epsilon"))
        litr.set("Chi");
      else if(str.equals("Delta"))
        litr.set("...");
    }

    System.out.print("Contents after changes:  ");
    litr = al.listIterator();
    while(litr.hasNext())
      System.out.print(litr.next() + " ");
    System.out.println();

    // Use ListIterator to display the list backwards.
    System.out.print("Modified list backwards: ");
    while(litr.hasPrevious()) {
      System.out.print(litr.previous() + " ");
    }
    System.out.println();
  }
}

// -----------------------------------------

import java.util.*;

class HashMapDemo {
  public static void main(String[] args) {

    // Create a hash map.
    HashMap<String, Double> hm = new HashMap<String, Double>();

    // Put elements to the map
    hm.put("John Doe", 3434.34);
    hm.put("Tom Smith", 123.22);
    hm.put("Jane Baker", 1378.00);
    hm.put("Todd Hall", 99.22);
    hm.put("Ralph Smith", -19.08);

    // Get a set of the entries.
    Set<Map.Entry<String, Double>> set = hm.entrySet();

    // Display the set.
    for(Map.Entry<String, Double> me : set) {
      System.out.print(me.getKey() + ": ");
      System.out.println(me.getValue());
    }

    System.out.println();

    // Deposit 1000 into John Doe's account.
    double balance = hm.get("John Doe");
    hm.put("John Doe", balance + 1000);

    System.out.println("John Doe's new balance: " +
      hm.get("John Doe"));
  }
}

// -----------------------------------------

import java.util.*;

class TreeMapDemo {
  public static void main(String[] args) {

    // Create a tree map.
    TreeMap<String, Double> tm = new TreeMap<String, Double>();

    // Put elements to the map.
    tm.put("John Doe", 3434.34);
    tm.put("Tom Smith", 123.22);
    tm.put("Jane Baker", 1378.00);
    tm.put("Todd Hall", 99.22);
    tm.put("Ralph Smith", -19.08);

    // Get a set of the entries.
    Set<Map.Entry<String, Double>> set = tm.entrySet();

    // Display the elements.
    for(Map.Entry<String, Double> me : set) {
       System.out.print(me.getKey() + ": ");
       System.out.println(me.getValue());
    }
    System.out.println();

    // Deposit 1000 into John Doe's account.
    double balance = tm.get("John Doe");
    tm.put("John Doe", balance + 1000);

    System.out.println("John Doe's new balance: " +
      tm.get("John Doe"));
  }
}

// -----------------------------------------

// Use a comparator to sort accounts by last name.
import java.util.*;

// Compare last whole words in two strings.
class NameComp implements Comparator<String> {
  public int compare(String aStr, String bStr) {
    int i, j, k;

    // Find index of beginning of last name.
    i = aStr.lastIndexOf(' ');
    j = bStr.lastIndexOf(' ');

    k = aStr.substring(i).compareTo(bStr.substring(j));
    if(k==0) // last names match, check entire name
      return aStr.compareTo(bStr);
    else
      return k;
  }

  // No need to override equals.
}

class TreeMapDemo2 {
  public static void main(String[] args) {
    // Create a tree map that uses the specified comparator.
    TreeMap<String, Double> tm = new TreeMap<String,
                                             Double>(new NameComp());

    // Put elements to the map.
    tm.put("John Doe", 3434.34);
    tm.put("Tom Smith", 123.22);
    tm.put("Jane Baker", 1378.00);
    tm.put("Todd Hall", 99.22);
    tm.put("Ralph Smith", -19.08);

    // Get a set of the entries.
    Set<Map.Entry<String, Double>> set = tm.entrySet();

    // Display the elements.
    for(Map.Entry<String, Double> me : set) {
      System.out.print(me.getKey() + ": ");
      System.out.println(me.getValue());
    }
    System.out.println();

    // Deposit 1000 into John Doe's account.
    double balance =  tm.get("John Doe");
    tm.put("John Doe", balance + 1000);

    System.out.println("John Doe's new balance: " +
      tm.get("John Doe"));
  }
}

// -----------------------------------------

// Demonstrate several algorithms.

import java.util.*;

class AlgorithmsDemo {
  public static void main(String[] args) {

    // Create a linked list.
    LinkedList<Character> ll = new LinkedList<Character>();

    // Put items in the list.
    for(int i = 0; i < 26; i+=2) {
      ll.add((char) ('A' + i));
      ll.add((char) ('Z' - i));
    }

    // Display original list.
    System.out.print("Original list: ");
    for(char ch : ll)
      System.out.print(ch);

    System.out.println();

    // Sort the list.
    Collections.sort(ll);
    System.out.print("List sorted:   ");
    for(char ch : ll)
      System.out.print(ch);

    System.out.println("\n");

    // Search the list.
    System.out.println("Using binarySearch() to find X.");
    int i = Collections.binarySearch(ll, 'X');
    if(i >= 0)
      System.out.println("X found. Index is " + i);

    System.out.println();

    // Reverse the list.
    Collections.reverse(ll);
    System.out.print("List reversed: ");
    for(char ch : ll)
      System.out.print(ch);

    System.out.println("\n");

    // Rotate the List.
    Collections.rotate(ll, 5);
    System.out.print("List rotated:  ");
    for(char ch : ll)
      System.out.print(ch);

    System.out.println("\n");

    // Create a new list.
    ll = new LinkedList<Character>();

    // Add a string to it.
    String str = "this is a test";
    for(char ch : str.toCharArray())
      ll.add(ch);

    System.out.print("Here is the new list: ");
    for(char ch : ll)
      System.out.print(ch);

    System.out.println();

    // Replace all t's with *
    Collections.replaceAll(ll, 't', '*');
    System.out.print("After replacements:   ");
    for(char ch : ll)
      System.out.print(ch);
  }
}
