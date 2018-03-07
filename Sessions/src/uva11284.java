import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class uva11284 {
	static int roads;
	static double streets[][];
	static double INF = 1e6;
	static int needed;
	static double memo[][];
	static int last[][];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		while (TC-- > 0) {
			sc.nextLine();
			roads = sc.nextInt();
			int n = sc.nextInt();
			streets = new double[roads + 1][roads + 1];

			for (int i = 0; i < roads + 1; i++)
				for (int j = 0; j < roads + 1; j++)
					streets[i][j] = INF;

			for (int i = 0, x, y; i < n; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				streets[x][y] = streets[y][x] = Double.parseDouble(sc.next());
			}
			int q = sc.nextInt();
			needed = 1;
			memo = new double[n + 1][(1 << (n + 1)) + 1];
			last = new int[n + 1][(1 << (n + 1)) + 1];

			for (int i = 0; i <= n; i++)
				Arrays.fill(memo[i], -1);

			double amount = 0;
			for (int i = 0; i < q; i++) {
				needed |= (1 << sc.nextInt());
				amount += Double.parseDouble(sc.next());
			}
			

			for (int i = 0; i <= roads; i++)
				System.out.println(Arrays.toString(streets[i]));

			System.out.println(Long.toBinaryString(needed));
			System.out.println(tsp(0, 1)*2);
			
		//	for(int i = 0 ; i<= roads;i++)
		//		System.out.println(Arrays.toString(last[i]));
			

			System.out.println(last[0][0]);
			System.out.println(last[1][needed]);
			System.out.println(last[2][needed]);
			System.out.println(last[3][needed]);
			System.out.println(last[4][needed]);

		}
	}

	static double tsp(int pos, int bitmask) {
		if (bitmask == needed || bitmask == (1 << (roads + 1) - 1) || pos > roads)
			return 0; // return trip to close the loop

		if (memo[pos][bitmask] != -1) {
			return memo[pos][bitmask];
		}

		double ans = INF;
		double temp;
		System.out.println("POSTION "+pos);
		for (int nxt = 1; nxt <= roads; nxt++) {
			if ((bitmask & (1 << nxt)) == 0  && streets[pos][nxt]!=INF ) {
				
				temp = streets[pos][nxt] + tsp(nxt, bitmask | (1 << nxt));
				if(ans>temp)
					last[pos][nxt]=nxt;
				ans = Math.min(ans, temp);
			}
		}
		
		if(ans>=INF)
			ans=0;
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
