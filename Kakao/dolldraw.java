import java.util.Stack;

class dolldraw {
    public int main(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i : moves) {
            int j = 0, k = i - 1;
            while (board[j][k] == 0) {
                if (j == board.length - 1) {
                    break;
                } else
                    j++;
            }
            if (board[j][k] != 0) {
                if (stack.isEmpty()) {
                    stack.push(board[j][k]);
                    board[j][k] = 0;
                } else if (stack.peek() == board[j][k]) {
                    board[j][k] = 0;
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(board[j][k]);
                    board[j][k] = 0;
                }
            }
        }

        return answer;
    }
}