import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ultra_Fast_Mathematician {
	public static void main(String[]args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		String s1=  sc.nextLine();
		String s2=  sc.nextLine();
		
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0,n1,n2; i< s1.length();i++) {
			n1=Integer.parseInt(s1.charAt(i)+"");
			n2=Integer.parseInt(s2.charAt(i)+"");
			if(n1!=n2)
				sb.append(1);
			else
				sb.append(0);
		}
		System.out.println(sb.toString());
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
