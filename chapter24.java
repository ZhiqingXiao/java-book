// Demonstrate Locale.
import java.util.*;

class LocaleDemo {
  public static void main(String[] args) {

    // get the default locale.
    Locale defLocale = Locale.getDefault();

    // display name, country, and language
    System.out.println("Default locale: ");
    System.out.println("Name: " + defLocale.getDisplayName());
    System.out.println("Country: " + defLocale.getDisplayCountry());
    System.out.println("Language: " + defLocale.getDisplayLanguage());

    System.out.println();

    // manually, create a locale for Germany
    Locale germanLocale = new Locale("de", "DE");
    System.out.println("German locale: ");
    System.out.println("Name: " + germanLocale.getDisplayName());
    System.out.println("Country: " +
                        germanLocale.getDisplayCountry());
    System.out.println("Language: " +
                        germanLocale.getDisplayLanguage());

    System.out.println();

    // now, use standard locale for France.
    System.out.println("Locale.FRANCE: ");
    System.out.println("Name: " +
                        Locale.FRANCE.getDisplayName());
    System.out.println("Country: " +
                        Locale.FRANCE.getDisplayCountry());
    System.out.println("Language: " +
                        Locale.FRANCE.getDisplayLanguage());
  }
}

// -----------------------------------------

// Demonstrate GregorianCalendar
import java.util.*;

class CalendarDemo {
  public static void main(String[] args) {

    // Create a calendar initialized with the
    // current date and time.
    GregorianCalendar calendar = new GregorianCalendar();

    // Display current date and time information.
    System.out.print("Date: ");
    System.out.print(calendar.getDisplayName(Calendar.DAY_OF_WEEK,
                                             Calendar.LONG,
                                             Locale.getDefault()));
    System.out.print(" " + calendar.getDisplayName(Calendar.MONTH,
                                             Calendar.LONG,
                                             Locale.getDefault()));
    System.out.print(" " + calendar.get(Calendar.DATE) + ", ");
    System.out.println(calendar.get(Calendar.YEAR));

    System.out.print("Time: ");
    System.out.print(calendar.get(Calendar.HOUR) + ":");
    System.out.print(calendar.get(Calendar.MINUTE) + ":");
    System.out.print(calendar.get(Calendar.SECOND));

    // determine AM or PM
    int am = calendar.get(Calendar.AM_PM);
    if(am == Calendar.AM)
      System.out.println(" AM");
    else
      System.out.println(" PM");

    // Set the time information and display it.
    calendar.set(Calendar.HOUR, 10);
    calendar.set(Calendar.AM_PM, Calendar.PM);
    calendar.set(Calendar.MINUTE, 29);
    calendar.set(Calendar.SECOND, 22);
    System.out.print("Updated time: ");
    System.out.print(calendar.get(Calendar.HOUR) + ":");
    System.out.print(calendar.get(Calendar.MINUTE) + ":");
    System.out.print(calendar.get(Calendar.SECOND));

    am = calendar.get(Calendar.AM_PM);
    if(am == Calendar.AM)
      System.out.println(" AM");
    else
      System.out.println(" PM");
  }
}

// -----------------------------------------

// Demonstrate isLeapYear().

import java.util.*;

class LeapYearDemo {
  public static void main(String[] args) {

    // get the current system date and time
    GregorianCalendar calendar = new GregorianCalendar();

    // get the current year
    int year = calendar.get(Calendar.YEAR);

    System.out.print(year);

    // test if the current year is a leap year
    if(calendar.isLeapYear(year)) {
      System.out.println(" is a leap year");
    }
    else {
      System.out.println(" is not a leap year");
    }
  }
}

// -----------------------------------------

// A very simple example that uses Formatter.
import java.util.*;

class FormatDemo {
  public static void main(String[] args) {
    Formatter fmt = new Formatter();

    fmt.format("Formatting %s is easy %d %f", "with Java", 10, 98.6);

    System.out.println(fmt);
    fmt.close();
  }
}

// -----------------------------------------

// Demonstrate the %g format specifier.
import java.util.*;

class GFormatDemo {
  public static void main(String[] args) {
    Formatter fmt = new Formatter();

    for(double i=1000; i < 1.0e+10; i *= 100) {
      fmt.format("%g ", i);
      System.out.println(fmt);
    }
    fmt.close();

  }
}

// -----------------------------------------

// Formatting date and time.

import java.util.*;

class TimeDateFormat {
  public static void main(String[] args) {
    Formatter fmt = new Formatter();
    GregorianCalendar calendar = new GregorianCalendar();

    // standard 12-hour time format
    fmt.format("%tr\n", calendar);

    // complete date and time information
    fmt.format("%tc\n", calendar);

    // just hour and minute
    fmt.format("%tl:%tM\n", calendar, calendar);

    // month by name and number
    fmt.format("%tB %tb %tm", calendar, calendar, calendar);

    // display the formats
    System.out.println(fmt);
    fmt.close();
  }
}

// -----------------------------------------

// Demonstrate a field-width specifier.
import java.util.*;

class FieldWidthDemo {
  public static void main(String[] args) {
    Formatter fmt = new Formatter();

    fmt.format("|%f|\n|%12f|\n",
               10.12345, 10.12345);

    fmt.format("|%s|\n|%10s|",
               "Java", "Java");

    System.out.println(fmt);
    fmt.close();
  }
}

// -----------------------------------------

// Create a table of squares and cubes.
import java.util.*;

class TableFormatDemo {
  public static void main(String[] args) {
    Formatter fmt = new Formatter();

    for(int i=1; i <= 10; i++) {
      fmt.format("%4d %4d %4d\n", i, i*i, i*i*i);
    }

    System.out.println(fmt);
    fmt.close();
  }
}

// -----------------------------------------

// Demonstrate the precision modifier.
import java.util.*;

class PrecisionDemo {
  public static void main(String[] args) {
    Formatter fmt = new Formatter();

    // Format 4 decimal places.
    fmt.format("%.4f\n", 123.1234567);

    // Format to 2 decimal places in a 16 character field
    fmt.format("%16.2e\n", 123.1234567);

    // Display at most 15 characters in a string.
    fmt.format("%.15s\n", "Formatting with Java is now easy.");

    System.out.println(fmt);
    fmt.close();
  }
}

// -----------------------------------------

// Demonstrate left justification.
import java.util.*;

class LeftJustify {
  public static void main(String[] args) {
    Formatter fmt = new Formatter();

    // Right justify by default
    fmt.format("|%10.2f|\n", 123.123);

    // Now, left justify.
    fmt.format("|%-10.2f|", 123.123);

    System.out.println(fmt);
    fmt.close();
  }
}

// -----------------------------------------

// Use relative indexes to simplify the
// creation of a custom date and time format.
import java.util.*;

class RelativeIndexDemo {
  public static void main(String[] args) {
    Formatter fmt = new Formatter();
    GregorianCalendar calendar = new GregorianCalendar();

    fmt.format("Today is day %te of %<tB, %<tY", calendar);
    System.out.println(fmt);
    fmt.close();
  }
}

// -----------------------------------------

// Demonstrate a formatting difference based on locale.
import java.util.*;

class LocaleFormat {
  public static void main(String[] args) {
    Formatter usFmt = new Formatter(Locale.US);
    Formatter germanFmt = new Formatter(Locale.GERMAN);
    double n = 1234567.24;

    usFmt.format("English: %,.2f", n);
    System.out.println(usFmt);
    usFmt.close();

    germanFmt.format("German:  %,.2f", n);
    System.out.println(germanFmt);
    germanFmt.close();
  }
}

// -----------------------------------------

// Use automatic resource management with Formatter.
import java.util.*;

class FormatDemo {
  public static void main(String[] args) {

    try (Formatter fmt = new Formatter())
    {
      fmt.format("Formatting %s is easy %d %f", "with Java",
                  10, 98.6);
      System.out.println(fmt);
    }
  }
}

// -----------------------------------------

import java.util.*;

class City {
  String name;
  int pop; // current population

  City(String n, int p) {
    name = n;
    pop = p;
  }
}

public class CitiesDemo {

  public static void main(String[] args) {
    City[] cities = {
       new City("Dallas", 1197816),
       new City("Portland", 583776),
       new City("Frostbite Falls", 6424),
       new City("New York", 8175133)
    };

    String result = formatCities(cities);

    System.out.println(result);
  }

  static String formatCities(City[] cities) {
    Formatter formatter = new Formatter();
    String result;
    int col1 = 0, col2 = 0;

    // find width of the columns
    for(City city : cities) {
      if(city.name.length() > col1)
        col1 = city.name.length();
      if(Integer.toString(city.pop).length() > col2)
        col2 = Integer.toString(city.pop).length();
    }

    // construct the format string
    String frmt = "| %-" + col1 + "s | %" + col2 + "d |\n";
    for(City city : cities) {
      formatter.format(frmt, city.name, city.pop);
    }

    result = formatter.toString();
    formatter.close();
    return result;
  }
}

// -----------------------------------------

// Demonstrate printf().

class PrintfDemo {
  public static void main(String[] args) {
    System.out.println("Here are some numeric values " +
                      "in different formats.\n");

    System.out.printf("Various integer formats: ");
    System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);

    System.out.println();
    System.out.printf("Default floating-point format: %f\n",
                      1234567.123);
    System.out.printf("Floating-point with commas: %,f\n",
                      1234567.123);
    System.out.printf("Negative floating-point default: %,f\n",
                      -1234567.123);
    System.out.printf("Negative floating-point option: %,(f\n",
                      -1234567.123);

    System.out.println();

    System.out.printf("Line up positive and negative values:\n");
    System.out.printf("% ,.2f\n% ,.2f\n",
                      1234567.123, -1234567.123);
  }
}

// -----------------------------------------

// Use Scanner to compute an average of the values.
import java.util.*;

class AvgNums {
  public static void main(String[] args) {
    Scanner conin = new Scanner(System.in);

    int count = 0;
    double sum = 0.0;

    System.out.println("Enter numbers to average.");

    // Read and sum numbers.
    while(conin.hasNext()) {
      if(conin.hasNextDouble()) {
        sum += conin.nextDouble();
        count++;
      }
      else {
        String str = conin.next();
        if(str.equals("done")) break;
        else {
          System.out.println("Data format error.");
          return;
        }
      }
    }

    System.out.println("Average is " + sum / count);
    conin.close();
  }
}

// -----------------------------------------

// Use Scanner to compute an average of the values in a file.
import java.util.*;
import java.io.*;

class AvgFile {
  public static void main(String[] args)
    throws IOException {

    int count = 0;
    double sum = 0.0;

    // Write output to a file.
    FileWriter fout = new FileWriter("test.txt");
    fout.write("2 3.4 5 6 7.4 9.1 10.5 done");
    fout.close();

    FileReader fin = new FileReader("Test.txt");

    Scanner src = new Scanner(fin);

    // Read and sum numbers.
    while(src.hasNext()) {
      if(src.hasNextDouble()) {
        sum += src.nextDouble();
        count++;
      }
      else {
        String str = src.next();
        if(str.equals("done")) break;
        else {
          System.out.println("File format error.");
          return;
        }
      }
    }

    src.close();

    System.out.println("Average is " + sum / count);
  }
}

// -----------------------------------------

// Use Scanner to read various types of data from a file.
import java.util.*;
import java.io.*;

class ScanMixed {
  public static void main(String[] args)
    throws IOException {

    int i;
    double d;
    boolean b;
    String str;

    // Write output to a file.
    FileWriter fout = new FileWriter("test.txt");
    fout.write("Testing Scanner 10 12.2 one true two false");
    fout.close();

    FileReader fin = new FileReader("Test.txt");

    Scanner src = new Scanner(fin);

    // Read to end.
    while(src.hasNext()) {
      if(src.hasNextInt()) {
        i = src.nextInt();
        System.out.println("int: " + i);
      }
      else if(src.hasNextDouble()) {
        d = src.nextDouble();
        System.out.println("double: " + d);
      }
      else if(src.hasNextBoolean()) {
        b = src.nextBoolean();
        System.out.println("boolean: " + b);
      }
      else {
        str = src.next();
        System.out.println("String: " + str);
      }
    }

    src.close();
  }
}

// -----------------------------------------

// Demonstrate random Gaussian values.
import java.util.Random;

class RandomDemo {
  public static void main(String[] args) {
    Random r = new Random();
    double val;
    double sum = 0;
    int[] bell = new int[9];

    for(int i=0; i<100; i++) {
      val = r.nextGaussian();
      sum += val;
      double t = -2;

      for(int x=0; x < bell.length; x++, t += 0.5)
        if(val < t) {
          bell[x]++;
          break;
        }
    }
    System.out.println("Average of values: " + (sum/100));

    // display bell curve, sideways
    for(int i=0; i < bell.length; i++) {
      for(int x=bell[i]; x>0; x--)
        System.out.print("*");
      System.out.println();
    }
  }
}

// -----------------------------------------

// Demonstrate Observable and Observer.

import java.util.*;

// This is the first observing class.
class Watcher1 implements Observer {
  public void update(Observable obj, Object arg) {
    System.out.println("update() in Watcher1 called, count is " +
                       ((Integer)arg).intValue());
  }
}

// This is the second observing class.
class Watcher2 implements Observer {
  public void update(Observable obj, Object arg) {

    System.out.println("update() in Watcher2 called, count is " +
                       ((Integer)arg).intValue());

    // Ring bell when done
    if(((Integer)arg).intValue() == 0)
      System.out.print('\7');
  }
}

// This is the class being observed.
class BeingWatched extends Observable {

  // Just count down to zero. Each count
  // represents a change about which the
  // observers are notified.
  void counter(int count) {
    for( ; count >= 0; count--) {

      setChanged(); // set state to changed.

      notifyObservers(count); // notify observers

      try {
        Thread.sleep(200);
      } catch(InterruptedException e) {
        System.out.println("Sleep interrupted");
      }
    }
  }
}

class TwoObservers {
  public static void main(String[] args) {

    BeingWatched observed = new BeingWatched();

    Watcher1 observing1 = new Watcher1();
    Watcher2 observing2 = new Watcher2();

    // add both observers to the observed object
    observed.addObserver(observing1);
    observed.addObserver(observing2);

    observed.counter(5);
  }
}

// -----------------------------------------

// Demonstrate Timer and TimerTask.

import java.util.*;

class MyTimerTask extends TimerTask {
  public void run() {
    System.out.println("Timer task executed.");
  }
}

class TimerTest {
  public static void main(String[] args) {
    MyTimerTask myTask = new MyTimerTask();
    Timer myTimer = new Timer();

    // Set an initial delay of 1 second,
    // then repeat every half second.
    myTimer.schedule(myTask, 1000, 500);

    try {
      Thread.sleep(5000);
    } catch (InterruptedException exc) {}

    myTimer.cancel();
  }
}