import java.io.*;
import java.util.*;

public class Registration_System {
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int n  =sc.nextInt();
		StringBuilder sb = new StringBuilder("");
		String curr;int value;
		while(n-->0) {
			curr = sc.nextLine();
			//System.out.println(curr);
			//System.out.println(map.toString());
			if(map.containsKey(curr)) {
				value = map.get(curr);
				sb.append(curr+""+value+"\n");
				map.put(curr,value+1);
			}else {sb.append("OK\n");map.put(curr, 1);};
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
