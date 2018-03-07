import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class uva1213 {
	static int n, k;
	static long memo[][][];
	static ArrayList<Integer> primes;
	static int sizeList;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder("");
		primes = generatePrimes();
		
		while (true) {
			n = sc.nextInt();
			k = sc.nextInt();
			if (n == 0 && k == 0)
				break;

			memo = new long[n + 1][k + 1][200];
			
			for (int i = 0; i <= n; i++)
				for(int j = 0 ;j <=k;j++)
					Arrays.fill(memo[i][j], -1);

			sizeList = primes.size();

			sb.append(dp(0, k, n) + "\n");
		}
		pw.print(sb);
		pw.flush();
		pw.close();
	}

	static long dp(int index, int k, int sum) {
		if (k == 0) {
			if (sum == 0)
				return 1;
			else
				return 0;
		}
		if (index == sizeList  ||  sum - primes.get(index) < 0 )
			return 0;
		int num = primes.get(index);

		if (memo[sum][k][index] != -1) 
			return memo[sum][k][index];
		
		long take = dp(index + 1, k - 1, (sum - num));

		long ignore = dp(index + 1, k, sum);



		return memo[sum][k][index] = take + ignore;
	}

	static boolean isPrime(int num) {
		if (num < 2)
			return false;

		for (int i = 2; i <= (num / 2); i++)
			if (num % i == 0)
				return false;

		return true;
	}

	static ArrayList<Integer> generatePrimes() {
		ArrayList<Integer> primes = new ArrayList<Integer>();

		for (int i = 2; i <= 1120; i++)
			if (isPrime(i))
				primes.add(i);
		return primes;
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
