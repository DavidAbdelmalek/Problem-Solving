import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class uva10050 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int T = sc.nextInt();
		int days;
		int P;
		StringBuilder sb = new StringBuilder("");
		HashMap<Integer, Integer> map;
		while (T-- > 0) {
			days = sc.nextInt();
			P = sc.nextInt();
			arr = new int[P];
			map = new HashMap<Integer, Integer>();
			for (int i = 0; i < P; i++)
				arr[i] = sc.nextInt();
			int count = 0;
			for (int i = 1; i <= days; i++) {
				for (int j = 0, t; j < P; j++) {
					t = arr[j];
					if (i % t == 0 && i % 7 != 0 && i % 7 != 6 && !map.containsKey(i)) {
						count++;
						map.put(i, 1);
					}
				}
			}
			sb.append(count);
			if (T != 0)
				sb.append("\n");
		}
		pw.println(sb);
		pw.flush();
		pw.close();
	}
	static	class Scanner 
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
		
		public boolean ready() throws IOException {return br.ready();}
	
	
	}

}
