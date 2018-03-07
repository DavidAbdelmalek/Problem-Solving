import java.io.*;
import java.util.*;


public class uva725 {
	static int N;
	
	static StringBuilder solve() {
		
		StringBuilder out = new StringBuilder("");
		int abcde,fghij;
		String fg;
		int T=0;
		for(fghij=1234;fghij<=98765;fghij++) {
		
			abcde=fghij*N;
			fg=fghij+"";
			int temp,used=(1<<10);
			if(abcde>98765)break;
			if(fghij<10000) {used|=(1<<0);fg="0"+fghij;}
			
			temp=fghij;while(temp>0) {used|=1<<(temp%10);temp/=10;}
			temp=abcde;while(temp>0) {used|=1<<(temp%10);temp/=10;}
			
			if(used==(1<<11)-1) {	
				if(T>0)out.append("\n");
				out.append(abcde+" / "+fg+" = "+N+"");	
				T++;
			}
		}
		
		return out;
		
	}
	
	
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int T=0;
		while(true) {
			N=sc.nextInt();
			if(N==0)break;
			if(T>0)pw.println();
			StringBuilder out = solve();
			T++;
			pw.print(out.length()==0?"There are no solutions for "+N+".\n":out+"\n");
		}
		//pw.println();
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
