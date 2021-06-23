import java.io.*;
import java.util.*;

class LPS {

  //Using provided code from LPS slide in Lecture 9 
  public int nclpser(String file) {
    int n = file.length();
    int L[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      L[i][i] = 1;
    }
    for (int sublen = 2; sublen <= n; sublen++) {
      for (int i = 0; i < n - sublen + 1; i++) {
        int j = i + sublen - 1;
        if (file.charAt(i) == file.charAt(j) && sublen == 2){
          L[i][j] = 2;
        }
        else if (file.charAt(i) == file.charAt(j)){
          L[i][j] = L[i + 1][j - 1] + 2;
        }
        else{
          L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
        }
      }
    }
    return L[0][n - 1];
  }

  //read the both regular string and reversed strings
  public String nclps(String str, String rev) {
    int m = str.length();
    int n = rev.length();
    char S[] = str.toCharArray();
    char R[] = rev.toCharArray();
    int L[][] = new int[m + 1][n + 1];

    //build matrix using the regular and reverse lengths for future string building
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          L[i][j] = 0;
        } else if (S[i - 1] == R[j - 1]) {
          L[i][j] = L[i - 1][j - 1] + 1;
        } else {
          L[i][j] = Math.max(L[i][j - 1], L[i - 1][j]);
        }
      }
    }
    int index = L[m][n];
    char[] lps = new char[index + 1]; //storing in char array to later append into a string
    while (m > 0 && n > 0) {
      if (S[m - 1] == R[n - 1]) {
        lps[index - 1] = S[m - 1];
        m--;
        n--;
        index--;
      } else if (L[m - 1][n] > L[m][n - 1]) {
        m--;
      } else {
        n--;
      }
    }
    String maxStr = "";
    for (int x = 0; x < lps.length; x++) {
      maxStr += lps[x];
    }
    return maxStr;
  }

  public int clps(String file) {
    int n = file.length();
    boolean L[][] = new boolean[n][n];
    int maxLength = 1;
    int begin = 0;
    for (int i = 0; i < n; i++) {
      L[i][i] = true;
    }
    for (int i = 0; i < n - 1; i++) {
      if (file.charAt(i) == file.charAt(i + 1)) {
        L[i][i + 1] = true;
        begin = i;
        maxLength = 2;
      }
    }
    for (int k = 3; k <= n; k++) {
      for (int i = 0; i < n - k + 1; i++) {
        int j = i + k - 1;
        if (L[i + 1][j - 1] && file.charAt(i) == file.charAt(j)) {
          L[i][j] = true;
          if (k > maxLength) {
            begin = i;
            maxLength = k;
          }
        }
      }
    }
    System.out.println("\nLongest palindromic contiguous subsequence: " + file.substring(begin, begin+maxLength));
    return maxLength;
  }
}