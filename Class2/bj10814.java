import java.util.*;

public class bj10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[][] = new int[N][2];
        HashMap<Integer, String> map = new HashMap();

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = i;
            map.put(i, sc.next());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return Integer.compare(o1[0], o2[0]);
                return 0;
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + map.get(arr[i][1]));
        }
    }
}