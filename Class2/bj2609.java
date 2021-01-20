import java.util.Scanner;

//최대공약수와 최소공배수
public class bj2609 {
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int gcd = gcd(a, b);
        int lcm = (a * b / gcd); // 최소 공배수 구하기
        System.out.println(gcd);
        System.out.println(lcm);

    }

}