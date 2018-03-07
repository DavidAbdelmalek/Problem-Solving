import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class uva10313 {
	static long memo[][][];
	static int amount;
	static int start = 0;
	static int end = 300;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");
		memo = new long[302][302][1002];
		for (int i = 0; i <= 301; i++)
			for (int j = 0; j <= 301; j++)
				Arrays.fill(memo[i][j], -1);
		while (!(s = sc.nextLine()).equals("")) {

			st = new StringTokenizer(s);

			amount = Integer.parseInt(st.nextToken());

			end = 300;
			start = 0;
			if (st.hasMoreTokens())
				end = Integer.parseInt(st.nextToken());

			if (st.hasMoreTokens()) {
				start = end;
				end = Integer.parseInt(st.nextToken());
			}
			if (start > 0)
				start--;
			if (start == 0)
				sb.append(dp(amount, amount, end) + "\n");
			else
				sb.append(dp(amount, amount, end) - dp(amount, amount, start) + "\n");

		}
		System.out.print(sb.toString());
	}

	static long dp(int rem, int coin, int used) {
		if (used < 0)
			return 0;

		if (rem == 0)
			return 1;

		if (rem < 0 || coin < 0)
			return 0;

		if (memo[rem][coin][used] != -1)
			return memo[rem][coin][used];

		long sum1 = dp(rem, coin - 1, used);
		long sum2 = 0;
		if (rem - coin >= 0)
			sum2 = dp(rem - coin, coin, used - 1);

		return memo[rem][coin][used] = sum1 + sum2;
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
