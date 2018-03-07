import java.io.*;
import java.util.*;

public class Ilya_And_Queries {
	static String s;
	static long memo[];
	static int len;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder("");
		s = sc.nextLine();
		len = s.length();

		memo = new long[len];
		long sum = 0;
		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1))
				sum++;
			memo[i] = sum;
		}
		memo[len - 1] = sum;
	

		int m = sc.nextInt();
		for (int i = 0, L, R; i < m; i++) {
			L = sc.nextInt() - 1;
			R = sc.nextInt() - 1;
			if (L == 0)
				sb.append(memo[R - 1] + "\n");
			else if (R == 0)
				sb.append(memo[0]);
			else
				sb.append((memo[R - 1] - memo[L - 1]) + "\n");
		}
		System.out.println(sb);

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

	}

}
