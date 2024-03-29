import java.io.*;
import java.util.*;

public class B {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String paths = sc.nextLine();
		int prev=-1;
		int out = 0, x = 0, y = 0;boolean AtGate=true;
		for (int i = 0; i < n; i++) {
			if(paths.charAt(i)=='U')y++;
			else x++;
			if(AtGate) {
				if(prev==1&&x>y||prev==-1 || prev==0&&x<y) {
					if(x>y)prev=0;
					else prev=1;
					out++; // 
				}
				AtGate=false;
			}
			if(x==y)AtGate=true;
		}
		System.out.println(out-1);
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
