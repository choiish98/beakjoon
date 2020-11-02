import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();

    for(int i = 0; i < t; i++){
      int h = s.nextInt();
      int w = s.nextInt();
      int n = s.nextInt();
      System.out.println(h + " " + w + " " + n);
    }
  }
}