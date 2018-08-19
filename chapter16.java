class DataHolder {
  private int[] data;

  public DataHolder() {
    data = new int[0];
  }

  public void insert(int x, int index) {
    increaseCapacity();
    shift(index);
    put(x, index);
  }

  private void increaseCapacity() {
    int[] newData = new int[data.length+1];
    for(int i = 0; i < data.length; i++)
      newData[i] = data[i];
    data = newData;
  }

  private void shift(int index) {
    for(int i = index; i < data.length-1; i++)
       data[i+1] = data[i];
  }

  private void put(int x, int index) {
    data[index] = x;
  }
  public int get(int index) {
    return data[index];
  }
  public int size() {
    return data.length;
  }
}

// -----------------------------------------

public class Rectangle {

  private int x, y, width, height;

  public Rectangle(int x, int y, int w, int h) {
    this.x = x; this.y = y; width = w; height = h;
  }

  public int getWidth() { return width; }

  public int getHeight() { return height; }

  public int getArea() { return width * height; }

  public int getPerimeter() { return 2 * (width + height); }

  public void setTopLeft(int newx, int newy) { x = newx; y = newy; }

  public void setSize(int w, int h) { width = w; height = h; }
}

public class Square extends Rectangle
{
  public Square(int x, int y, int side) {
    super(x, y, side, side);
  }
}

// -----------------------------------------

import java.util.ArrayDeque;

class PureQueue<E> {
  private ArrayDeque<E> data;

  PureQueue() {
    data = new ArrayDeque<E>();
  }

  void enqueue(E o) { data.offer(o); }

  E dequeue() { return data.poll(); }

  E peek() { return data.peek(); }

  int size() { return data.size(); }

  public String toString() {
     return data.toString();
  }
}

class PureQueueDemo {

  public static void main(String[] args) {
    PureQueue<String> q = new PureQueue<String>();
    System.out.println(q);
    q.enqueue("3");
    q.enqueue("abc");
    System.out.println(q);
    q.dequeue();
    System.out.println(q);
  }
}

// -----------------------------------------

class Printer {
  void printRect(RectI r) {
    System.out.println(r.getWidth() + ", " + r.getHeight());
  }
}

interface RectI {
  int getWidth();
  int getHeight();
}

class SimpleRect implements RectI {
  int width, height;

  SimpleRect(int w, int h) {
    width = w; height = h;
  }

  public int getWidth() { return width; }
  public int getHeight() { return height; }
}


class NonConformingRect {
  int top, left, bottom, right;

  NonConformingRect(int a, int b, int c, int d) {
    top = a; left = b; bottom = c; right = d;
  }

  public int getTop() { return top; }
  public int getLeft() { return left; }
  public int getBottom() { return bottom; }
  public int getRight() { return right; }
}

class RectAdapter implements RectI {
  NonConformingRect ncRect;

  RectAdapter(NonConformingRect r) {
    ncRect = r;
  }

  public int getWidth() { return ncRect.getRight() - ncRect.getLeft(); }
  public int getHeight() { return ncRect.getBottom() - ncRect.getTop(); }
}

class AdapterDemo {
  public static void main(String[] args) {
    Printer prntr = new Printer();
    prntr.printRect(new SimpleRect(3,4));
    prntr.printRect(new RectAdapter(new NonConformingRect(1,2,3,4)));
  }
}

// -----------------------------------------

class SavingsAccount {
  String owner;
  int acctNumber;
  int balance;  // in US dollars
  BalanceChangeHandler[] subscribers;
  int numSubscribers;

  SavingsAccount(String o, int a) {
    owner = o;
    acctNumber = a;
    balance = 0;
    subscribers = new BalanceChangeHandler[20];
    // At most 20 subscribers are allowed
    numSubscribers = 0;
  }

  void addHandler(BalanceChangeHandler h) {
    if(numSubscribers < 20) {
      subscribers[numSubscribers] = h;
      numSubscribers++;
    }
  }

  // positive amount means deposit
  // negative amount means withdrawal
  void changeBalance(int amount) {
    if(amount != 0) {

      // Change the balance
      balance += amount;

      // Notify all subscribers of the change
      for(int i = 0; i < numSubscribers; i++)
        subscribers[i].balanceChanged(amount, this);
    }
  }

  int getBalance() { return balance; }
  int getAcctNumber() { return acctNumber; }
  String getOwner() { return owner; }
}


class FeeHandler implements BalanceChangeHandler {

  public void balanceChanged(int change, SavingsAccount acct) {
    System.out.println("Deducting a fee from account " +
                       acct.getAcctNumber());
  }
}

class FraudHandler implements BalanceChangeHandler {

  public void balanceChanged(int change, SavingsAccount acct) {
    System.out.println("Checking for fraudulent withdrawal" +
                       " of amount: " + change + " from" +
                       " account " + acct.getAcctNumber());
  }
}

interface BalanceChangeHandler {
  void balanceChanged(int change, SavingsAccount acct);
}

class SavingsAccountDemo {
  public static void main(String[] args) {
    SavingsAccount acct = new SavingsAccount("Sam", 1234);
    FeeHandler feeHandler = new FeeHandler();
    FraudHandler fraudHandler = new FraudHandler();

    acct.addHandler(feeHandler);
    acct.addHandler(fraudHandler);

    acct.changeBalance(0); // nothing happens
    acct.changeBalance(10);
    acct.changeBalance(-10);
  }
}
