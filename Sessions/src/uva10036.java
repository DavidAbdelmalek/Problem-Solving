import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class uva10036 {
	static int n, target;
	static int memo[][];
	static int[] arr;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		PrintWriter pw = new PrintWriter(System.out);
		StringBuilder sb  = new StringBuilder("");

		while (TC-- > 0) {
			n = sc.nextInt();
			target = sc.nextInt();

			arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			
			memo = new int[n][100];
			
			for (int i = 0; i < n; i++)
				Arrays.fill(memo[i], -1);
			

			sb.append(dp(0,0)==0?"Divisible\n":"Not divisible\n");

		}
		pw.print(sb);
		pw.flush();
		pw.close();
		
	}

	static int fix(int a) {

		return (((a % target) + target) % target);
	}

	static int dp(int index, int lastMOD) {

		if (index == n)
			return lastMOD;

		if (memo[index][lastMOD] != -1)
			return memo[index][lastMOD];
		
		int sum1 = dp(index + 1, fix(arr[index] - lastMOD));
		int sum2 = dp(index + 1, fix(arr[index] + lastMOD));
	
		
		return memo[index][lastMOD] = Math.min(sum1, sum2);

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
