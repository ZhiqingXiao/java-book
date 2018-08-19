// A simple pattern matching demo.
import java.util.regex.*;

class RegExpr {
  public static void main(String[] args) {
    Pattern pat;
    Matcher mat;
    boolean found;

    pat = Pattern.compile("Alpha");
    mat = pat.matcher("Alpha");
    found = mat.matches(); // check for a match

    System.out.println("Testing Alpha against Alpha.");
    if(found) System.out.println("Matches");
    else System.out.println("No Match");

    System.out.println();

    System.out.println("Testing Alpha against Alpha Beta Gamma.");
    mat = pat.matcher("Alpha Beta Gamma"); // create a new matcher

    found = mat.matches(); // check for a match

    if(found) System.out.println("Matches");
    else System.out.println("No Match");
  }
}

// -------------------------------------------------------

// Use find() to find a subsequence.
import java.util.regex.*;

class RegExpr2 {
  public static void main(String[] args) {
    Pattern pat = Pattern.compile("Alpha");
    Matcher mat = pat.matcher("Alpha Beta Gamma");

    System.out.println("Looking for Alpha in Alpha Beta Gamma.");

    if(mat.find()) System.out.println("subsequence found");
    else System.out.println("No Match");
  }
}

// -------------------------------------------------------

// Use find() to find multiple subsequences.
import java.util.regex.*;

class RegExpr3 {
  public static void main(String[] args) {
    Pattern pat = Pattern.compile("Beta");
    Matcher mat = pat.matcher("Alpha Beta Gamma Beta Theta");

    while(mat.find()) {
      System.out.println("Beta found at index " + mat.start());
    }
  }
}

// -------------------------------------------------------

// Use a quantifier.
import java.util.regex.*;

class RegExpr4 {
  public static void main(String[] args) {
    Pattern pat = Pattern.compile("W+");
    Matcher mat = pat.matcher("W WW WWW");

    while(mat.find())
      System.out.println("Match: " + mat.group());
  }
}

// -------------------------------------------------------

// Use wildcard and quantifier.
import java.util.regex.*;

class RegExpr5 {
  public static void main(String[] args) {
    Pattern pat = Pattern.compile("e.+d");
    Matcher mat = pat.matcher("extend cup end table");

    while(mat.find())
      System.out.println("Match: " + mat.group());
  }
}

// -------------------------------------------------------

// Use a character class.
import java.util.regex.*;

class RegExpr6 {
  public static void main(String[] args) {
    // Match lowercase words.
    Pattern pat = Pattern.compile("[a-z]+");
    Matcher mat = pat.matcher("this is a test.");

    while(mat.find())
      System.out.println("Match: " + mat.group());
  }
}

// -------------------------------------------------------

// Use replaceAll().
import java.util.regex.*;

class RegExpr7 {
  public static void main(String[] args) {
    String str = "Jon Jonathan Frank Ken Todd";

    Pattern pat = Pattern.compile("Jon.*? ");
    Matcher mat = pat.matcher(str);

    System.out.println("Original sequence: " + str);

    str = mat.replaceAll("Eric ");

    System.out.println("Modified sequence: " + str);
  }
}
