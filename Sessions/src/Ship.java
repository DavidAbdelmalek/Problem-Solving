import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Ship {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int lineSize = sc.nextInt();
		int number = sc.nextInt();
		int size = sc.nextInt();

		int hits = sc.nextInt();

		TreeSet<Integer> tree = new TreeSet<Integer>();
		int count=0;
		TreeSet<Integer> temp = new TreeSet<Integer>();
		
		for (int i = 1, in; i <= hits; i++) {
			tree.addAll(temp);
			in = sc.nextInt();
			tree.add(in);
			count=0;
			int current=0;
			System.out.println(tree.toString());
			for(int j =1,calc, prev = 1  ; j<=i ;j++) {
				
				tree.remove(current = tree.first());
				temp.add(current);
			
				calc=Math.abs((current-prev-1)/size);
				
				count+=calc;
				System.out.println("PREV "+prev + " current "+current + " CALC "+calc);
				System.out.println(count);
				prev = current;
			}
			count+=(lineSize-current)/size;
			System.out.println("FINAL COUNT "+count);
			if(count<number) {
				System.out.println(i);
				return;
			}
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
