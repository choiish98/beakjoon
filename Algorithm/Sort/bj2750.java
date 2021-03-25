import java.util.Scanner;

public class bj2750 {
    public static void quickSort(int[] arr, int left, int right) {
        int i, j, pivot, tmp;
        if (left < right) {
            i = left;
            j = right;
            pivot = arr[(left + right) / 2];
            // 분할 과정
            while (i < j) {
                while (arr[j] > pivot)
                    j--;
                while (i < j && arr[i] < pivot)
                    i++;

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            // 정렬 과정
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}
