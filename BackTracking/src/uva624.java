import java.io.*;
import java.util.*;

public class uva624 {
	static int N;
	static int CDS;
	static int CD[];
	static boolean taken[];
	static boolean track[];
	static Queue<Integer> queue;
	static int max=0;

	static void backTrack(int index,int currSum) {
		if(index==CDS) {
			if(currSum>max&&currSum<=N) {
				max=currSum;
				for(int i = 0 ; i<CDS;i++)if(taken[i])track[i]=true;
				else track[i]=false;
			}
			return;
		}

		taken[index]=true;
		backTrack(index+1,currSum+CD[index]);
		taken[index]=false;
		backTrack(index+1,currSum);

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s;
		StringTokenizer st;
		StringBuilder sb ;
		sb = new StringBuilder("");

		while (!(s = sc.nextLine()).equals("")) {
			st = new StringTokenizer(s);
			N = Integer.parseInt(st.nextToken());
			CDS = Integer.parseInt(st.nextToken());
			CD = new int[CDS];
			for (int i = 0; i < CDS; i++)
				CD[i] = Integer.parseInt(st.nextToken());


			taken = new boolean[CDS];
			track = new boolean[CDS];
			max=0;
			backTrack(0,0);
			for(int i = 0 ; i <CDS;i++)if(track[i])sb.append(CD[i]+" ");
			sb.append("sum:"+max+"\n");
		}
		System.out.print(sb);
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
