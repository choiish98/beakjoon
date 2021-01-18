import java.util.Scanner;

class bj2798 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int arr[] = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					int temp = arr[i] + arr[j] + arr[k];
					if (temp > m)
						continue;
					else if (temp > sum)
						sum = temp;
				}
			}
		}

		System.out.println(sum);
	}
}