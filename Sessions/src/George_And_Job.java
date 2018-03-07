import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class George_And_Job {
	static long memo[][];
	static long arr[];
	static int n, m;
	static long inf = -1000000;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int k = sc.nextInt();

		arr = new long[n + 1];
		memo = new long[n + 1][k + 1];
		long sum = 0;
		arr[0] = 0;
		for (int i = 1; i <= n; i++) {
			Arrays.fill(memo[i], -1);
			arr[i] = sum += sc.nextLong();
		}
		System.out.println(dp(m, k));

	}

	static long dp(int index, int rem) {
		if (rem == 0)
			return 0;
		if (index > n)
			return inf;
		if (memo[index][rem] != -1)
			return memo[index][rem];

		long leave = dp(index + 1, rem);
		long take = arr[index] - arr[index - m] + dp(index + m, rem - 1);

		return memo[index][rem] = Math.max(leave, take);

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

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public boolean nextEmpty() throws IOException {
			String s = nextLine();
			st = new StringTokenizer(s);
			return s.isEmpty();
		}
	}

}
