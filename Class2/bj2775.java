import java.util.Scanner;

class bj2775 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			int k = s.nextInt();
			int n = s.nextInt();

			int result = re(k, n);
			System.out.println(result);
		}
	}

	public static int re(int k, int n) {
		if (k == 0)
			return n;
		if (n == 1)
			return 1;
		else
			return re(k - 1, n) + re(k, n - 1);
	}
}