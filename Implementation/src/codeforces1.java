import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class codeforces1 {
	public static void main(String[]args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
	
		int k = sc.nextInt();
		
		int a = sc.nextInt();
		
		int m =sc.nextInt();
		
	
		ArrayList<Integer>list = new ArrayList<Integer>();
		
		list.add(0, 0);
		for(int i=1 ; i<=size;i++)list.add(i);
		
		int before , after,num,indexOf;
		
		for(int i = 1 ; i <= m ;i++) {
			num = sc.nextInt();
			indexOf= list.indexOf(num);
			before = ((indexOf-1)/a);
			after= (size-indexOf)/a;
			
			if(before+after<k) {
				System.out.println(i);
				return ;
			}
			size--;

		//	System.out.println(before + " "+after );
			list.remove(indexOf);
		}
		System.out.println(-1);
	
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
