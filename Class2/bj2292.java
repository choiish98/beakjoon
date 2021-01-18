import java.util.Scanner;

class bj2292 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int sum = 1;
        int n = 1;

        while (a > sum) {
            sum += 6 * n;
            n++;
        }

        System.out.println(n);
    }
}