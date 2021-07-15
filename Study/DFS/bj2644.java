import java.io.*;
import java.util.*;

public class bj2644 {
    static ArrayList<Integer>[] node;
    static boolean[] check;

    static class Relation {
        int person;
        int villager;

        Relation(int person, int villager) {
            this.person = person;
            this.villager = villager;
        }
    }

    public static void dfs(int x, int y) {
        boolean isFind = false;
        Stack<Relation> stack = new Stack<Relation>();
        stack.add(new Relation(x, 0));
        check[x] = true;

        while (!stack.isEmpty()) {
            Relation temp = stack.pop();
            if (temp.person == y) {
                isFind = true;
                System.out.println(temp.villager);
                break;
            }

            for (int i : node[temp.person]) {
                if (!check[i]) {
                    stack.add(new Relation(i, temp.villager + 1));
                    check[i] = true;
                }
            }
        }

        if (!isFind)
            System.out.println("-1");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람 수를 입력 받고 node 초기화
        int n = Integer.parseInt(br.readLine());
        node = new ArrayList[n + 1];
        check = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            node[i] = new ArrayList<Integer>();
        }

        // 관계를 유추할 x, y 입력 받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        // 사람들 관계 정의 (node 간선 구성)
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
        }

        // 정렬
        for (int i = 0; i < n; i++) {
            Collections.sort(node[i], Comparator.reverseOrder());
        }

        dfs(x, y);
    }
}