import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class uva10819 {
	static int money, n;
	static item[] items;
	static int[][][] memo;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st;
		String s;

		// while(sc.ready()) {
		while (!(s = sc.nextLine()).equals("")) {
			// while ((s=sc.nextLine())!=null) {
			st = new StringTokenizer(s);

			// st = new StringTokenizer(sc.nextLine());

			money = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			items = new item[n];
			for (int i = 0; i < n; i++)
				items[i] = new item(sc.nextInt(), sc.nextInt());

			memo = new int[n][money + 1][2];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= money; j++) {
					Arrays.fill(memo[i][j], -1);
				}
			}
			sb.append(dp(0, money, 0, 0, true)+"\n");
		}
		System.out.println(sb);
	}

	static int dp(int index, int money, int track, int state, boolean canRefund) {
		if (money <= 0) {
			if (canRefund) {
				if ((money + 200) < 0)
					return -20000;
				else {
					money += 200;
					canRefund = false;
					state = 1;
				}
			} else if (money < 0)
				return -20000;
			else
				return 0;
		}
		if (index == n)
			if (!canRefund && track <= 2000) {
				return -20000;
			} else
				return 0;

		if (memo[index][money][state] != -1)
			return memo[index][money][state];

		int ignore = dp(index + 1, money, track, state, canRefund);
		int taken = items[index].favor
				+ dp(index + 1, money - items[index].price, track + items[index].price, state, canRefund);

		return memo[index][money][state] = Math.max(ignore, taken);

	}

	static class item {
		int price;
		int favor;

		public item(int price, int favor) {
			this.price = price;
			this.favor = favor;
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
