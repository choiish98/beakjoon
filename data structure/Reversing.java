import java.util.Stack;
public class Reversing {
  public static void main(String[] args) {
    Stack<Character> stack = new Stack<Character>();
    String str = "?가건는먹 은택스";
    
    for(int i=0; i<str.length(); i++){
        stack.push(str.charAt(i));
    }

    stack.toString();

    for(int i=0; i<str.length(); i++){
        System.out.println(stack.pop());
    }
  }
}