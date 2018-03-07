import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class uva562 {
	static int n;
	static int[] arr;
	static int memo[][];
	static int total;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		StringBuilder sb = new StringBuilder("");
		while (TC-- > 0) {
			n = sc.nextInt();
			arr = new int[n];
			total = 0;
			for (int i = 0; i < n; i++)
				total += arr[i] = sc.nextInt();
			memo = new int[n][50001];
			for (int i = 0; i < n; i++)
				Arrays.fill(memo[i], -1);

			Arrays.sort(arr);

			int ans = dp(0, total / 2);
			sb.append((total - ans - ans) + "\n");
		}
		System.out.print(sb);
	}

	static int dp(int index, int sum) {
		if (sum < 0)
			return -100000;
		if (index == n || sum == 0)
			return 0;

		if (memo[index][sum] != -1)
			return memo[index][sum];

		int dp1 = dp(index + 1, sum);
		int dp2 = Integer.MIN_VALUE;
		dp2 = arr[index] + dp(index + 1, sum - arr[index]);

		return memo[index][sum] = Math.max(dp1, dp2);
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
