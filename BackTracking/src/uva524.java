import java.io.*;
import java.util.*;

public class uva524 {
	static int n;
	static int row[];
	static boolean check[];
	//static boolean primes[];
	static StringBuilder sb2 = new StringBuilder("");
	
	static boolean isPrime(int n) {
		if(n==1)return false;
		for(int i = 2;i<=(n/2);i++)
			if(n%i==0)return false;
		return true;
	}

	static void print() {
		sb2.append("\n");
		for (int i = 1; i <= n; i++) {
			sb2.append(row[i] );
			if(i<n)sb2.append(" ");
		}
	
	}

	static void backTrack(int index, int curr) {
		if (index > n) {
			if (isPrime(row[n] + row[1])) {
				print();
			}
		}

		for (int i = 1; i <= n; i++) {
			if (!check[i] && isPrime(curr + i)) {

				check[i] = true;
				row[index] = i;

				backTrack(index + 1, i);

				row[index] = 0;
				check[i] = false;

			}
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st;
		String s;
  		
		StringBuilder sb = new StringBuilder("");
		int T = 0;
		
		while (!(s = sc.nextLine()).equals("")) {
			st = new StringTokenizer(s);
			n = Integer.parseInt(st.nextToken());
			T++;
			check = new boolean[n + 1];
			row = new int[n + 1];

			row[1] = 1;
			check[1] = true;

			backTrack(2, 1);
			if(T>1)pw.println("\n");
			sb = new StringBuilder("Case " + T + ":");
			pw.print(sb.append(sb2));
			sb2 = new StringBuilder("");
		}
		pw.println();
		pw.flush();
		pw.close();
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
