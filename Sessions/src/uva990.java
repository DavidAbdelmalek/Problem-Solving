import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class uva990 {
	static int seconds, w, n;
	static Treasure[] arr;
	static int memo[][];
	static String out = new String("");
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static String temp[];
	static StringBuilder sb = new StringBuilder("");
	static Queue<Integer> helper = new LinkedList<Integer>();
	static StringBuilder hoy;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		memo = new int[31][1001];

		String s;
		int t = 0;
		while (sc.ready()) {

			if (t > 0)
				sb.append("\n");
			t++;
			hoy = new StringBuilder("");
			seconds = sc.nextInt();
			w = sc.nextInt();
			n = sc.nextInt();
			arr = new Treasure[n + 1];
			for (int i = 0; i < 31; i++)
				Arrays.fill(memo[i], -1);
			for (int i = 1; i <= n; i++)
				arr[i] = new Treasure(sc.nextInt(), sc.nextInt());

			int dp = dp(1, seconds, 0);
			sb.append(dp + "\n" + print(1, seconds, 0) + "\n");
			sb.append(hoy); 
		}
		System.out.print(sb.toString());
	}

	static int dp(int index, int rem, int prev) {
		if (rem < 0)
			return -100000000;

		if (rem == 0 || index > n)
			return 0;

		if (memo[index][rem] != -1)
			return memo[index][rem];

		int dp1 = dp(index + 1, rem, prev);// prev doesn't change because i don't take it.
		int dp2 = arr[index].value + dp(index + 1, rem - (w * arr[index].depth + 2 * w * arr[index].depth), index);

		return memo[index][rem] = Math.max(dp1, dp2);

	}	
	static int print(int index, int rem, int prev) {

		if (rem <= 0 || index > n)
			return 0;

		int best = dp(index, rem, prev);

		int dp2 = arr[index].value + dp(index + 1, rem - (3 * w * arr[index].depth), index);

		if (best == dp2) {
			hoy.append(arr[index].depth + " " + arr[index].value + "\n");
			return 1 + print(index + 1, rem - (3 * w * arr[index].depth), index);
		} else
			return print(index + 1, rem, prev);
	}

	static class Treasure {
		int depth;
		int value;

		public Treasure(int depth, int value) {
			this.depth = depth;
			this.value = value;
		}

		@Override
		public String toString() {
			return this.depth + " " + this.value;
		}

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
