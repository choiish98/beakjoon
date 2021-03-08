import java.util.*;

public class bj4949 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            String a = sc.nextLine();
            Stack<Character> stack = new Stack<>();

            if (a.equals("."))
                break;

            if (isBalance(a, stack)) {
                System.out.println("yes");
            } else if (!isBalance(a, stack)) {
                System.out.println("no");
            }
        }
    }

    public static boolean isBalance(String a, Stack<Character> stack) {
        boolean isPrime = true;

        for (char one : a.toCharArray()) {
            if (one == '(' || one == '[') {
                stack.push(one);
            } else if (one == ')') {
                while (stack.isEmpty() || stack.pop() != '(') {
                    isPrime = false;
                    break;
                }
            } else if (one == ']') {
                while (stack.isEmpty() || stack.pop() != '[') {
                    isPrime = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            isPrime = false;
        }

        return isPrime;
    }
}