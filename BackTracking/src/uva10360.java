import java.io.*;
import java.util.*;

public class uva10360 {
	static int d, n, killed[][];


	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		int TC = sc.nextInt();
		while (TC-- > 0) {
			d = sc.nextInt();
			n = sc.nextInt();
			killed = new int[1025][1025];
			
			for (int i = 0, x, y, stX, stY, edX, edY, pop; i < n; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				pop = sc.nextInt();
				edX = Math.min(1024, x + d);
				edY = Math.min(1024, y + d);

				for (stX = Math.max(x - d, 0); stX <= edX; stX++)
					for (stY = Math.max(y - d, 0); stY <= edY; stY++)
						killed[stX][stY] += pop;
			}

			int bestX=0,bestY=0,max=0;

			for(int i = 0 ; i<1025;i++) {
				for(int j = 0 ; j<1025;j++) {
					if(max<killed[i][j] ) {
						bestX=i;bestY=j;max=killed[i][j];
					}
				}
			}

			pw.println(bestX+" "+bestY+" "+max);
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
