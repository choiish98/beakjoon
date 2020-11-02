package Class1;
import java.util.*;
public class bj2908 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int arr[] = new int[3];
		int arr2[] = new int[3];
		
		arr[0]=a%10; arr[1]=(a/10)%10; arr[2]=a/100;
		arr2[0]=b%10; arr2[1]=(b/10)%10; arr2[2]=b/100;
		
		for(int i = 0; i < 3; i ++) {
			if(arr[i] > arr2[i]) {
				System.out.println(arr[0] + "" + arr[1] + "" + arr[2]);
				break;
			}
			else if(arr[i] < arr2[i]) {
				System.out.println(arr2[0] + "" + arr2[1] + "" + arr2[2]);
				break;
			}
			else continue;
		}
	}
}
