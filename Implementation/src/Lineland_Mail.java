import java.io.*;
import java.util.*;

public class Lineland_Mail {
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		long []arr =new long[n];
		StringBuilder sb = new StringBuilder("");
		for(int i = 0 ; i < n ; i++)arr[i]=sc.nextLong();
		
		long max,min;
		for(int i = 0; i <n;i++) {
			max=0;min =Long.MAX_VALUE-1;
			max = Math.max(Math.abs(arr[i]-arr[0]), Math.abs(arr[i]-arr[n-1]));
			if(i>0)min=Math.min(min, Math.abs(arr[i]-arr[i-1]));
			if(i<n-1)min=Math.min(min, Math.abs(arr[i]-arr[i+1]));
			sb.append(min + " "+max+"\n");
		}
		System.out.println(sb);
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
