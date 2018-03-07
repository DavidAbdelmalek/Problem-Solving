import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class uva10664 {
	static ArrayList<Integer> list;
	static int total;
	static int memo[][];
	static int n;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int TC = sc.nextInt();
		StringTokenizer st;
		int temp;
		StringBuilder sb = new StringBuilder("");
		while (TC-- > 0) {
			st = new StringTokenizer(sc.nextLine());
			total = 0;
			list = new ArrayList<Integer>();
			while (st.hasMoreTokens()) {
				temp = Integer.parseInt(st.nextToken());
				total += temp;
				list.add(temp);
			}
			
			n = list.size();
			memo = new int[n][201];
			for (int i = 0; i < n; i++)
				Arrays.fill(memo[i], -1);

			sb.append(dp(0, 0) == 0 ? "NO\n" : "YES\n");
		
		}
		pw.print(sb);
		pw.flush();
		pw.close();
	}

	static int dp(int index, int sum) {
		if (sum == total - sum) {
			// System.out.println("sum "_sum);
			return 1;
		}
		if (index == n)
			return 0;
		if (memo[index][sum] != -1)
			return memo[index][sum];

		int taken = dp(index + 1, sum + list.get(index));
		int ignore = dp(index + 1, sum);

		return memo[index][sum] = taken + ignore;
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
