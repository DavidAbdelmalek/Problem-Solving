import java.io.*;
import java.util.*;

public class Combination_Lock {
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s1 = sc.nextLine();
		String original = sc.nextLine();
		long out=0;
		for(int i = 0,n1,n2,forw=0,back=0 ; i < n ; i++) {
			n1 = Integer.parseInt(s1.charAt(i)+"");
			n2 = Integer.parseInt(original.charAt(i)+"");

			if(n1>n2) {
				forw = (9-n1)+n2+1;
				back = n1-n2;
			}else if(n1<n2){
				forw=n2-n1;
				back=n1+(9-n2)+1;
			}
			out += Math.min(back,forw);
		}
		System.out.println(out);

	}
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}

		public boolean ready() throws IOException {return br.ready();}


	}

}
