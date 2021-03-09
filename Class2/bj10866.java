import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class bj10866 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Deque<String> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("push_front")) {
                deque.addFirst(cmd[1]);
            } // push_front
            else if (cmd[0].equals("push_back")) {
                deque.addLast(cmd[1]);
            } // push_back
            else if (cmd[0].equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(deque.removeFirst() + "\n");
                }
            } // pop_front
            else if (cmd[0].equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(deque.removeLast() + "\n");
                }
            } // pop_back
            else if (cmd[0].equals("size")) {
                sb.append(deque.size() + "\n");
            } // size
            else if (cmd[0].equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            } // empty
            else if (cmd[0].equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(deque.getFirst() + "\n");
                }
            } // front
            else if (cmd[0].equals("back")) {
                if (deque.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(deque.getLast() + "\n");
                }
            } // back
        } // for
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}