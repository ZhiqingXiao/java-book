// Demonstrate InetAddress.

import java.net.*;

class InetAddressDemo {
  public static void main(String[] args) {

    try {
      InetAddress address = InetAddress.getByName("www.mcgraw-hill.com");
      System.out.println("Host name: " + address.getHostName());
      System.out.println("Address: " + address.getHostAddress());

      System.out.println();

      address = InetAddress.getByName("www.mhhe.com");
      System.out.println("Host name: " + address.getHostName());
      System.out.println("Address: " + address.getHostAddress());

      System.out.println();

      address = InetAddress.getByName("www.mheducation.com");
      System.out.println("Host name: " + address.getHostName());
      System.out.println("Address: " + address.getHostAddress());
    } catch (UnknownHostException exc) {
      System.out.println(exc);
    }
  }
}

// -----------------------------------------

// Demonstrate Sockets.

import java.net.*;
import java.io.*;

class SocketDemo {
  public static void main(String[] args) {
    int ch;
    Socket socket = null;

    try {
      // Create a socket connected to whois.internic.net, port 43.
      socket = new Socket("whois.internic.net", 43);

      // Obtain input and output streams.
      InputStream in = socket.getInputStream();
      OutputStream out = socket.getOutputStream();

      // Construct a request string.
      String str = (args.length == 0 ? "mcgraw-hill.com" :
                                      args[0]) + "\n";
      // Convert to bytes.
      byte[] buf = str.getBytes();

      // Send request.
      out.write(buf);

      // Read and display response.
      while ((ch = in.read()) != -1) {
        System.out.print((char) ch);
      }
    } catch(IOException exc) {
      System.out.println(exc);
    } finally {
      try {
        if(socket != null) socket.close();
      } catch(IOException exc) {
        System.out.println("Error closing socket: " + exc);
      }
    }
  }
}

// -----------------------------------------

// Use automatic resource management to close a socket.

import java.net.*;
import java.io.*;

class SocketDemo {
    public static void main(String[] args) {
      int ch;

      // Create a socket connected to internic.net, port 43. Manage this
      // socket with a try-with-resources block.
      try ( Socket socket = new Socket("whois.internic.net", 43) ) {

        // Obtain input and output streams.
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        // Construct a request string.
        String str = (args.length == 0 ? "mcgraw-hill.com" :
                                          args[0]) + "\n";
        // Convert to bytes.
        byte[] buf = str.getBytes();

        // Send request.
        out.write(buf);

        // Read and display response.
        while ((ch = in.read()) != -1) {
          System.out.print((char) ch);
        }
      } catch(IOException exc) {
        System.out.println(exc);
      }
      // The socket is now closed.
    }
}

// -----------------------------------------

// Demonstrate URL.

import java.net.*;

class URLDemo {
  public static void main(String[] args) {

    try {
      URL url = new URL("http://www.mhhe.com:80/index.html");

      System.out.println("Protocol: " + url.getProtocol());
      System.out.println("Port: " + url.getPort());

      System.out.println("Host: " + url.getHost());
      System.out.println("File: " + url.getFile());
    } catch (MalformedURLException exc) {
      System.out.println("Invalid URL: " + exc);
    }
  }
}

// -----------------------------------------

// Demonstrate URLConnection.
import java.net.*;
import java.io.*;
import java.util.*;

class UCDemo
{
  public static void main(String[] args) {

    InputStream in = null;
    URLConnection connection = null;

    try {
      URL url = new URL("http://www.mcgraw-hill.com");

      connection = url.openConnection();

      // get date
      long d = connection.getDate();
      if(d==0)
        System.out.println("No date information.");
      else
        System.out.println("Date: " + new Date(d));

      // get content type
      System.out.println("Content-Type: " +
                          connection.getContentType());

      // get expiration date
      d = connection.getExpiration();
      if(d==0)
        System.out.println("No expiration information.");
      else
        System.out.println("Expires: " + new Date(d));

      // get last-modified date
      d = connection.getLastModified();
      if(d==0)
        System.out.println("No last-modified information.");
      else
        System.out.println("Last-Modified: " + new Date(d));

      // get content length
      long len = connection.getContentLengthLong();
      if(len == -1)
        System.out.println("Content length unavailable.");
      else
        System.out.println("Content-Length: " + len);

      if(len != 0) {
        System.out.println("=== Content ===");
        in = connection.getInputStream();

        int ch;
        while (((ch = in.read()) != -1)) {
          System.out.print((char) ch);
        }
      } else {
        System.out.println("No content available.");
      }
    } catch(IOException exc) {
      System.out.println("Connection Error: " + exc);
    } finally {
      try {
        if(in != null) in.close();
      } catch(IOException exc) {
        System.out.println("Error closing connection: " + exc);
      }
    }
  }
}

// -----------------------------------------

import java.net.*;
import java.io.*;

class GetFileFromSite {
  public static void main(String[] args) {
    if(args.length != 2) {
      System.out.println("Usage: java GetFileFromSite url file");
      return;
    }

    InputStream in = null;
    URLConnection connection = null;
    FileOutputStream fout = null;

    try {
      URL url = new URL(args[0]);
      connection = url.openConnection();
      in = connection.getInputStream();
      fout = new FileOutputStream(args[1]);

      // Download and save the file.
      int b;
      while (((b = in.read()) != -1)) {
        fout.write(b);
      }
    } catch (IOException exc) {
      System.out.println("Connection Error: " + exc);
    } finally {
      try {
        if(in != null) in.close();
        if(fout != null) fout.close();
      } catch (IOException exc) {
        System.out.println("Error closing stream: " + exc);
      }
    }
  }
}

// -----------------------------------------

// Demonstrate HttpURLConnection.

import java.net.*;
import java.io.*;
import java.util.*;

class HttpURLConnectionDemo
{
  public static void main(String[] args) {

    try {
      URL url = new URL("http://www.mcgraw-hill.com");
          HttpURLConnection connection =
             (HttpURLConnection) url.openConnection();

      // Display request method.
      System.out.println("Request method is " +
                         connection.getRequestMethod());

      // Display response code.
      System.out.println("Response code is " +
                         connection.getResponseCode());

      // Display response message.
      System.out.println("Response Message is " +
                         connection.getResponseMessage());

      // Get a list of the header fields and a set
      // of the header keys.
      Map<String, List<String>> hdrMap = connection.getHeaderFields();
      Set<String> hdrKeys = hdrMap.keySet();

      System.out.println("\nHere is the header:");

      // Display all header keys and values.
      for(String k : hdrKeys) {
        System.out.println("Key: " + k +
                           "  Value: " + hdrMap.get(k));
      }
    } catch(IOException exc) {
      System.out.println(exc);
    }
  }
}

// -----------------------------------------

// Demonstrate datagrams -- server side.

import java.net.*;
import java.io.*;

class DGServer {
  // These ports were chosen arbitrarily. You must use
  // unused ports on your machine.
  public static int clientPort = 50000;
  public static int serverPort = 50001;

  public static DatagramSocket ds;

  public static void dgServer() throws IOException {
    byte[] buffer;
    String str;

    BufferedReader conin = new BufferedReader(
                                 new InputStreamReader(System.in));

    System.out.println("Enter characters. Enter 'stop' to quit.");
    for(;;) {
      // read a string from the keyboard
      str = conin.readLine();

      // convert string to byte array for transmission
      buffer = str.getBytes();

      // send a new packet that contains the string
      ds.send(new DatagramPacket(buffer, buffer.length,
              InetAddress.getLocalHost(), clientPort));

      // quit when "stop" is entered
      if(str.equals("stop")) {
        System.out.println("Server Quits.");
        return;
      }
    }
  }

  public static void main(String[] args) {
    ds = null;

    try {
      ds = new DatagramSocket(serverPort);
      dgServer();
    } catch(IOException exc) {
      System.out.println("Communication error: " + exc);
    } finally {
      if(ds != null) ds.close();
    }
  }
}

// -----------------------------------------

// Demonstrate datagrams -- client side.

import java.net.*;
import java.io.*;

class DGClient {
  // This ports was choosen arbitrarily. You must use
  // an unused port on your machine.
  public static int clientPort = 50000;
  public static int buffer_size = 1024;

  public static DatagramSocket ds;

  public static void dgClient() throws IOException {
    String str;
    byte[] buffer = new byte[buffer_size];

    System.out.println("Receiving Data");
    for(;;) {
      // create a new packet to receive the data
      DatagramPacket p = new DatagramPacket(buffer, buffer.length);

      // wait for a packet
      ds.receive(p);

      // convert buffer into String
      str = new String(p.getData(), 0, p.getLength());

      // display the string on the client
      System.out.println(str);

      // quit when "stop" is received.
      if(str.equals("stop")) {
        System.out.println("Client Stopping.");
        break;
      }
    }
  }

  public static void main(String[] args) {
    ds = null;

    try {
      ds = new DatagramSocket(clientPort);
      dgClient();
    } catch(IOException exc) {
      System.out.println("Communication error: " + exc);
    } finally {
      if(ds != null) ds.close();
    }
  }
}