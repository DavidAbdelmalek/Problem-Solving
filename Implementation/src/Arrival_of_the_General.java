import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Arrival_of_the_General {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// ArrayList<Integer>list = new ArrayList<Integer>();
		int arr[] = new int[n];

		int min = (int) 1e8;
		int minINDEX = 0, maxINDEX = 0;
		int max = 0;
		int arr2[]=new int[n];

		for (int i = 0, num; i < n; i++) {
			num = sc.nextInt();
			if (num <= min) {
				min = num;
				minINDEX = i;
			}
			if (num > max) {
				max = num;
				maxINDEX = i;
			}
			arr[i] = num;
			arr2[i]=num;
		}
		
		int temp, count = 0,first=0;;
		
		for (int i = maxINDEX - 1; i >= 0; i--) {
			
			if(arr[i]==min&&first==0&&i==minINDEX) {
				minINDEX++;
				first++;
			}
			
			temp = arr[i];
			arr[i] = max;
			arr[i + 1] = temp;

			count++;
		}
	
		for (int i = minINDEX + 1; i < n; i++) {
			temp = arr[i];
			arr[i] = min;
			arr[i - 1] = temp;

			count++;
		}
	
		System.out.println(count);

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
