import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class uva11517 {
	static int bill;
	static int n;
	static int coins[];
	static Pair memo[][];

	static class Pair {
		long val, coins;

		Pair(long v, long c) {
			val = v;
			coins = c;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int TC = sc.nextInt();
		while (TC-- > 0) {
			bill = sc.nextInt();
			n = sc.nextInt();
			memo = new Pair[n][10001];
			coins = new int[n];
			for (int i = 0; i < n; i++) coins[i] = sc.nextInt();
			

			Pair out = dp(0, bill);
			pw.println(out.val + " "+out.coins);

		}
		pw.flush();
		pw.close();
	}

	static Pair dp(int index, int rem) {
		if (rem <= 0)
			return new Pair(0, 0);

		if (index == n)
			return new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);

		if (memo[index][rem] != null)
			return memo[index][rem];

		Pair leave = dp(index + 1, rem);
		Pair take = dp(index + 1, rem - coins[index]);

		if (take.val + coins[index] < leave.val)
			return memo[index][rem] = new Pair(take.val + coins[index], take.coins + 1);
		else if (take.val + coins[index] > leave.val)
			return memo[index][rem] = leave;
		else if (take.coins + 1 < leave.coins)
			return memo[index][rem] = new Pair(take.val + coins[index], take.coins + 1);
		else
			return memo[index][rem] = leave;

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
