import java.io.*;
import java.util.*;

public class uva11195 {
	static int n;
	static boolean column[], LeftDig[], RightDig[];
	static char grid[][];
	static int ans=0;
	
	static void backTrack(int row) {
		if(row==n) {
			ans++;
			return;
		}
		for(int col = 0 ; col< n ; col++) {
			if(!column[col] &&!LeftDig[col+row]&&!RightDig[col-row+n]&&grid[row][col]!='*') {
				column[col]=LeftDig[col+row]=RightDig[col-row+n]=true; //do
				backTrack(row+1);									 //recur
				column[col]=LeftDig[col+row]=RightDig[col-row+n]=false;//undo
			}
				
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int T=0;
		while (true) {
			n = sc.nextInt();
			if (n == 0)
				break;
			T++;
			ans=0;
			column = new boolean[n];
			LeftDig = new boolean[2*n+1];
			RightDig = new boolean[2*n+1];
			grid = new char[n][n];
			for (int i = 0; i < n; i++)
				grid[i] = sc.nextLine().toCharArray();
			backTrack(0);
			pw.printf("Case %d: %d\n", T,ans);
		}
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
