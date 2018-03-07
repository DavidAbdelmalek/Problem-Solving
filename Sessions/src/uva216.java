import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class uva216 {
	static int n;
	static double memo[][];
	static double dist[][];
	static double x[];
	static double y[];
	static int print[][];
	static double temp;
	static int memo2[][];
	static ArrayList list[];
	static StringBuilder hoy;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int TC = 0;
		PrintWriter pw = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder("");
		while (true) {

			n = sc.nextInt();
			if (n == 0)
				break;
			TC++;
			hoy = new StringBuilder("");
			memo = new double[9][1 << 9];
			memo2 = new int[9][1 << 9];
			dist = new double[9][9];
			x = new double[9];
			y = new double[9];

			for (int i = 0; i < n; i++) {
				x[i] = Double.parseDouble(sc.next());
				y[i] = Double.parseDouble(sc.next());
			}
			double x1, y1;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					x1 = Math.abs(x[i] - x[j]);
					y1 = Math.abs(y[i] - y[j]);
					if (i == j)
						dist[i][j] = 0;
					else
						dist[i][j] = Math.sqrt((x1 * x1) + (y1 * y1)) + 16;

				}
			}
			for (int i = 0; i < 8; i++)
				Arrays.fill(memo[i], -1);

			print = new int[n][n];

			double TSP = (TSP(0, 1));
			sb.append("**********************************************************\n");
			sb.append("Network #" + TC + "\n");
			print(0, 1);

			System.out.println(TSP);
			System.out.println(hoy);

			double out;

		}
	}

	static void print(int pos, int bitmask) {
		if (bitmask == ((1 << n) - 1))// best case
		{
			System.out.println("OUT " + bitmask);
			return;

		}
		double ans = 1e8;
		int idx = 0;
		int nxt;
		for ( nxt = 0; nxt < n; nxt++) {
			if (nxt != pos && (bitmask & (1 << nxt)) == 0) {
				temp = dist[pos][nxt] + TSP(nxt, bitmask | (1 << nxt));
				if (ans > temp) {
					ans = temp;
					System.out.println(Long.toBinaryString(bitmask));
					 hoy.append(nxt);
				}
			}
		}
	}

	static double TSP(int pos, int bitmask) {
		if (bitmask == ((1 << n) - 1))// best case
			return memo[pos][0];

		if (memo[pos][bitmask] != -1)
			return memo[pos][bitmask];

		double ans = 1e6;
		int idx = 0;
		for (int nxt = 0; nxt < n; nxt++) {
			if (nxt != pos && (bitmask & (1 << nxt)) == 0) {
				temp = dist[pos][nxt] + TSP(nxt, bitmask | (1 << nxt));
				if (ans > temp) {
					ans = temp;
					idx = nxt;
				}
			}
		}
		return memo[pos][bitmask] = ans;
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
