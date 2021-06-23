import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Please input your file:");
    String file = input.nextLine();
    input.close();
    System.out.println("\nFile Name: " + file);

    //Original input
    Reader reader = new Reader(file);
    String originalInput = reader.getFileText();
    System.out.println("\nOriginal Contents: " + originalInput);
    int originalLength = originalInput.length();
    System.out.println("\nOriginal Length: " + originalLength);

    //Modified input
    String alphaOnly = originalInput.replaceAll("[^a-zA-Z]", "");
    String modifiedInput = alphaOnly.toUpperCase();
    System.out.println("\nModified Contents: " + modifiedInput);
    int modifiedLength = modifiedInput.length();
    System.out.println("\nModified Length: " + modifiedLength);

    LPS i = new LPS();

    //Longest palindromic non-contiguous subsequence
    String u = new StringBuilder(modifiedInput).reverse().toString();
    System.out.println("\nLongest palindromic non-contiguous subsequence:" + i.nclps(modifiedInput, u));
		int x = i.nclpser(modifiedInput);
    System.out.println("\nLongest palindromic non-contiguous subsequence length: " + x);

    //Longest palindromic contiguous subsequence
    //also prints out the contiguous subsequence
    int z = i.clps(modifiedInput);
    System.out.println("\nLongest palindromic contiguous subsequence length: " + z);
  }
}