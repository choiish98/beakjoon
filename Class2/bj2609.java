import java.util.Scanner;

class bj2609 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println(gcf(num1, num2) + " " + lcf(num1, num2));
    }

    public static int gcf(int num1, int num2) {
        if (num1 % num2 == 0)
            return num2;
        if (num2 % num1 == 0)
            return num1;
        for (int i = num1 / 2; i > 0; i--) {
            if (num1 % i == 0 && num2 % i == 0)
                return i;
        }
        return 0;
    }

    public static int lcf(int num1, int num2) {
        int i = 1;
        while (true) {
            if ((num1 * i) % num2 == 0)
                break;
            i++;
        }
        return num1 * i;
    }
}