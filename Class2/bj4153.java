import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while (true) {
      int a = s.nextInt();
      int b = s.nextInt();
      int c = s.nextInt();
      s.close();
      if(a == 0 && b == 0 && c == 0) break;
      if(Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2)) {
        System.out.println("right");
      }
      else if(Math.pow(a,2) == Math.pow(b,2) + Math.pow(c,2)) {
        System.out.println("right");
      }
      else if(Math.pow(b,2) == Math.pow(a,2) + Math.pow(c,2)) {
        System.out.println("right");
      }
      else System.out.println("wrong");
    }
  }
}