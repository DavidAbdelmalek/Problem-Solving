import java.util.Arrays;
import java.util.Scanner;

public class code545c {
	static long[] arr;
	static long[] height;
	static int n;
	static int memo[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new long[(int) (1e5 + 5)];
		height = new long[(int) (1e5 + 5)];

		memo = new int[n][2];
		System.out.println(memo.length);
		
		
		Arrays.fill(arr, -1);
		for (int i = 0; i < n; i++)
			Arrays.fill(memo[i], -1);

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
			height[i] = sc.nextLong();
		}

		int count = n == 1 ? 1 : 2;
		n--;
		System.out.println(count + dp(1, 0));
	}

	static int dp(int i, int status) {//  0 stay 1
		if (i == n)
			return 0; // i == n // means that i reaches

		if (memo[i][status] != -1)
			return memo[i][status];

		int stay = 0;
		int left = 0;
		int right = 0;

		// System.out.println("KHLST STAY "+i);

		
		if (status == 1) { //prev is shifted to the right
			if (arr[i] - height[i] > arr[i - 1] + height[i - 1]) { // shefting left
				left = 1 + dp(i + 1, 0);
			}
			
		} else {
			if (status == 0||status == 1) 
				if (arr[i] - height[i] > arr[i - 1])  // shefting left
					left = 1 + dp(i + 1, 0);
			
		}
		
		if (arr[i] + height[i] < arr[i + 1]) {// shefting right;
			right = 1 + dp(i + 1, 1);
		}
		stay = dp(i + 1, 0);

		
		return memo[i][status] = Math.max(left, Math.max(right, stay));
	}

}