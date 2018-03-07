import java.io.*;
import java.util.*;


public class Friends {
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		boolean[][]check = new boolean[6][6];
		
		for(int i = 0,f1,f2 ; i< m ; i++) {
			f1=sc.nextInt(); f2 = sc.nextInt();
			check[f1][f2]=true;
			check[f2][f1]=true;
		}
		
		int acq=0,unAcq=0;
		for(int i = 0 ; i < 6 ; i ++)System.out.println(Arrays.toString(check[i]));
		for(int i =1,friends; i <=5 ; i++) {
			friends=0;
			for(int j = 1; j<=5 ; j++) {
				if(check[i][j])friends++;
			}
			if(friends>=3)acq++;
			else unAcq++;
			
			
		}
		System.out.println(acq==3||unAcq==3?"WIN":"FAIL");
		
		
		
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
