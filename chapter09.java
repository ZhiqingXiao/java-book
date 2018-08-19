// A short package demonstration.
package bookpack;

class Book {
  private String title;
  private String author;
  private int pubDate;

  Book(String t, String a, int d) {
    title = t;
    author = a;
    pubDate = d;
  }

  void show() {
    System.out.println(title);
    System.out.println(author);
    System.out.println(pubDate);
  }
}

class BookDemo {
  public static void main(String[] args) {
    Book[] books = new Book[5];

    books[0] = new Book("The Art of Computer Programming, Vol 3",
                        "Knuth", 1973);
    books[1] = new Book("Moby Dick",
                        "Melville", 1851);
    books[2] = new Book("Thirteen at Dinner",
                        "Christie", 1933);
    books[3] = new Book("Red Storm Rising",
                        "Clancy", 1986);
    books[4] = new Book("On the Road",
                        "Kerouac", 1955);

    for(int i=0; i < books.length; i++) {
      books[i].show();
      System.out.println();
    }
  }
}

// -----------------------------------------

// Book recoded for public access.
package bookpack;

public class Book {
  private String title;
  private String author;
  private int pubDate;

  // Now public.
  public Book(String t, String a, int d) {
    title = t;
    author = a;
    pubDate = d;
  }

  // Now public.
  public void show() {
    System.out.println(title);
    System.out.println(author);
    System.out.println(pubDate);
  }
}

// -----------------------------------------

// This class is in package mypack.
package mypack;

// Use the Book Class from bookpack.
class UseBook {
  public static void main(String[] args) {
    bookpack.Book[] books = new bookpack.Book[5];

    books[0] = new bookpack.Book("The Art of Computer Programming, Vol 3",
                        "Knuth", 1973);
    books[1] = new bookpack.Book("Moby Dick",
                        "Melville", 1851);
    books[2] = new bookpack.Book("Thirteen at Dinner",
                        "Christie", 1933);
    books[3] = new bookpack.Book("Red Storm Rising",
                       "Clancy", 1986);
    books[4] = new bookpack.Book("On the Road",
                       "Kerouac", 1955);

    for(int i=0; i < books.length; i++) {
      books[i].show();
      System.out.println();
    }
  }
}

// -----------------------------------------

// Make the instance variables in Book protected.
package bookpack;

public class Book {
  // these are now protected
  protected String title;
  protected String author;
  protected int pubDate;

  public Book(String t, String a, int d) {
    title = t;
    author = a;
    pubDate = d;
  }

  public void show() {
    System.out.println(title);
    System.out.println(author);
    System.out.println(pubDate);
  }
}

// -----------------------------------------

// Demonstrate protected.
package bookpackext;

class ExtBook extends bookpack.Book {
  private String condition;

  public ExtBook(String t, String a, int d, String c) {
    super(t, a, d);
    condition = c;
  }

  public void show() {
    super.show();
    System.out.print("Condition is " + condition);
    System.out.println();
  }

  public String getCondition() { return condition; }
  public void setCondition(String c) { condition = c; }

  /* These are OK because subclass can access
     a protected member. */
  public String getTitle() { return title; }
  public void setTitle(String t) { title = t; }
  public String getAuthor() { return author; }
  public void setAuthor(String a) { author = a; }
  public int getPubDate() { return pubDate; }
  public void setPubDate(int d) { pubDate = d; }
}

class ProtectDemo {
  public static void main(String[] args) {
    ExtBook[] books = new ExtBook[5];

    books[0] = new ExtBook("The Art of Computer Programming, Vol 3",
                        "Knuth", 1973, "well used");
    books[1] = new ExtBook("Moby Dick",
                        "Melville", 1851, "like new");
    books[2] = new ExtBook("Thirteen at Dinner",
                        "Christie", 1933, "fair");
    books[3] = new ExtBook("Red Storm Rising",
                      "Clancy", 1986, "good");
    books[4] = new ExtBook("On the Road",
                      "Kerouac", 1955, "fair");

    for(int i=0; i < books.length; i++) {
      books[i].show();
      System.out.println();
    }

    // Find condition of Moby Dick.
    System.out.print("Condition of Moby Dick is ");
    for(int i=0; i < books.length; i++)
      if(books[i].getTitle() == "Moby Dick")
        System.out.println(books[i].getCondition());

//    books[0].title = "test title"; // Error - not accessible
  }
}

// -----------------------------------------

// Demonstrate import.
package mypack;
import bookpack.*;

// Use the Book Class from bookpack.
class UseBook {
  public static void main(String[] args) {
    Book[] books = new Book[5];

    books[0] = new Book("The Art of Computer Programming, Vol 3",
                        "Knuth", 1973);
    books[1] = new Book("Moby Dick",
                        "Melville", 1851);
    books[2] = new Book("Thirteen at Dinner",
                        "Christie", 1933);
    books[3] = new Book("Red Storm Rising",
                        "Clancy", 1986);
    books[4] = new Book("On the Road",
                        "Kerouac", 1955);

    for(int i=0; i < books.length; i++) {
      books[i].show();
      System.out.println();
    }
  }
}

// -----------------------------------------

package owner;

public class Dog {
  String name;

  public Dog(String n) { name = n; }

  public String toString() {
    return name;
  }
}

public class Owner {
  String name;
  Dog dog;

  public Owner(String n, Dog d) {
    name = n; dog = d;
  }

  public String toString() {
    return name + " owns " + dog;
  }
}

// -----------------------------------------

package dogownerdemo;

import owner.*;

class DogOwnerDemo {
  public static void main(String[] args) {
    Owner owner = new Owner("Fred", new Dog("Sam"));
    System.out.println(owner);
  }
}

// -----------------------------------------

// Find the solutions to a quadratic equation.
class Quadratic {
  public static void main(String[] args) {

    // a, b, and c represent the coefficients in the
    // quadratic equation: ax2 + bx + c = 0
    double a, b, c, x;

    // Solve 4x2 + x - 3 = 0 for x.
    a = 4;
    b = 1;
    c = -3;

    // Find first solution.
    x = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
    System.out.println("First solution: " + x);

    // Find second solution.
    x = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
    System.out.println("Second solution: " + x);
  }
}

// -----------------------------------------

// Use static import to bring sqrt() and pow() into view.
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

class Quadratic {
  public static void main(String[] args) {

    // a, b, and c represent the coefficients in the
    // quadratic equation: ax2 + bx + c = 0
    double a, b, c, x;

    // Solve 4x2 + x - 3 = 0 for x.
    a = 4;
    b = 1;
    c = -3;

    // Find first solution.
    x = (-b + sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
    System.out.println("First solution: " + x);

    // Find second solution.
    x = (-b - sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
    System.out.println("Second solution: " + x);
  }
}
