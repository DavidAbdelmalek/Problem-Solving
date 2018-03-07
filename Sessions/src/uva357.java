import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class uva357 {
	static int arr[] = { 50,25, 10, 5, 1 };
	static int num;
	static long memo[][];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		String s;
		memo = new long[30001][6];
		for (int i = 0; i <= 30000; i++)
			Arrays.fill(memo[i], -1);

		while (!(s = sc.nextLine()).equals("")) {
			num = Integer.parseInt(s);
			
			long out = dp(num,0);
			if(out==1)
				pw.printf("There is only 1 way to produce %d cents change.\n",num);
			else
				pw.printf("There are %d ways to produce %d cents change.\n",dp(num,0),num);
		}
		pw.flush();
		pw.close();
	}

	static long dp(int rem, int index) {
		if (rem == 0)
			return 1l;
		if (rem < 0 || index == 5)
			return 0;
		if(memo[rem][index]!=-1)
			return memo[rem][index];
		
		long taken = dp(rem-arr[index],index);
		long drop  = dp(rem,index+1);
		
		return memo[rem][index]=taken+drop;
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
