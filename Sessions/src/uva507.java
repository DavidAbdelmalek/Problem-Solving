import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class uva507 {
	static int stops;
	static int current;
	static PrintWriter pw = new PrintWriter(System.out);

	static int arr[];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s;
		current = 0;
		int n = sc.nextInt();
		while (n-->0) {
			current++;
			stops = sc.nextInt();
			arr = new int[stops + 1];
			for (int i = 1; i < stops; i++)
				arr[i] = sc.nextInt();

			int sum = 0, ans = 0, last = 0;
			int temp1=1;
			int start =0 , len =-1 ;
			
			for (int i = 1; i < stops; i++) {		
				sum += arr[i];
				if (ans <= sum) {
					if(sum>ans||len<i-temp1) {// new length akbar.(i-temp1).
						last = i;
						start = temp1;
						len = i-temp1;
					}
					ans = sum;
				}
				if (sum < 0) {
					sum = 0;
					temp1=i+1;//start of a new segmant.
				}
			}
			if (ans == 0)
				pw.printf("Route %d has no nice parts\n", current);
			else {
				
				last++;
				pw.printf("The nicest part of route %d is between stops %d and %d\n", current,start,last);
			}

		}

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

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
