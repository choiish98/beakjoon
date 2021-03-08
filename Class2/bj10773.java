import java.util.*;

public class bj10773 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int a = sc.nextInt();

            if (a != 0) {
                stack.push(a);
            } else {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            int sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }
            System.out.println(sum);
        }
    }
}