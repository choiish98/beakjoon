import java.io.*;
import java.util.*;

public class bj1541 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] arr = br.readLine().split("-");
    int sum = Integer.MAX_VALUE;

    for(String i : arr) {
      String[] arr2 = i.split("\\+");

      int temp = 0;
      for(String j : arr2) {
        temp += Integer.parseInt(j);
      }

      if(sum == Integer.MAX_VALUE) sum = temp;
      else sum -= temp;
    }

    System.out.println(sum);
  }
}