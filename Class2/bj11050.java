
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(fac(a) / (fac(a - b) * fac(b)));
    }

    public static int fac(int n) {
        int i = 1;
        for (int j = 1; j <= n; j++) {
            i *= j;
        }
        return i;
    }
}
