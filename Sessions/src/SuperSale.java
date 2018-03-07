import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SuperSale {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int memo[][];// Items //weight
		int arr[][];
		StringBuilder sb = new StringBuilder("");
		while (T-- > 0) {
			
			int items = sc.nextInt();
			arr = new int[items][2];
			for (int i = 0; i < items; i++) {
				arr[i][0] = sc.nextInt();// Price
				arr[i][1] = sc.nextInt();// Weight

			}
			memo = new int[1001][31];
			int numPeople = sc.nextInt();

			int out =0;
			//bottom UP=
				for (int i = items-1; i>=0 ; i--) {
					for(int w = 0 ; w < 31 ; w++) {
						if (w - arr[i][1] >= 0)
							memo[i][w] = Math.max(memo[i+1][w], arr[i][0] + memo[i+1][w - arr[i][1]]);
						else 
							memo[i][w]=memo[i+1][w];
					}
				}
				
				for(int i = 0 ; i < numPeople  ; i++)
					out += memo[0][sc.nextInt()];
				
			sb.append(out+"\n");
		}
		System.out.print(sb);
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
