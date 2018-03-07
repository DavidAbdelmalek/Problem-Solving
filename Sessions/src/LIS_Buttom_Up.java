
import java.util.*;
import java.io.*;

class LIS_Buttom_Up {
	static long[][] memo;
	static int n;
	static ArrayList<Pair> arr;
	static int LIS[];
	static int max;
	static boolean visited[];

	static ArrayList<Integer> PRINT[];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder("");
		int T = sc.nextInt();

		while (T-- > 0) {

			n = sc.nextInt();
			arr = new ArrayList<Pair>();

			visited = new boolean[n];

			for (int i = 0; i < n; i++)
				arr.add(new Pair(sc.nextInt(), sc.nextInt()));

			Collections.sort(arr, new Comparator<Pair>() {
				@Override
				public int compare(Pair o1, Pair o2) {
					return o1.width > o2.width ? 1 : (o1.width < o2.width ? -1 : 0); // Sorted in Ascending
				}
			});

			LIS = new int[n];

			Arrays.fill(LIS, 1);

			int out = 1;
			
			lis(arr);
		//	System.out.println(Arrays.toString(LIS));
	
			
			pw.print(n-max);
	
		}
		pw.flush();
		pw.close();

	}

	static int findMaxLisIndex() {
		// TODO Auto-generated method stub
		int maxIndex = 0;
		
		for (int i = 1; i < LIS.length; i++) {
			if (LIS[i] > LIS[maxIndex])
				maxIndex = i;

		}
		return maxIndex;

	}

	static void lis(ArrayList<Pair> arr) {
		int n = arr.size();
		ArrayList<Integer> L = new ArrayList<>();
		int liss = 0;
		for (int i = 0; i < n; i++) {
			int num = arr.get(i).height;
			 int pos = Collections.binarySearch(L, num);
			//int pos = BinarySearch(arr, num);
			// System.out.println(pos);
			if (pos < 0)
				pos = -pos - 1;
			// if the number is not listed in the array it will output a number in negative
			// and pos = -pos -1 will translate it to the exact loc.

			if (pos + 1 > liss) {
				liss++;
				L.add(num);
				// at the end of array;
			} else {
				L.set(pos, num);
			}
			LIS[i] = pos + 1;
		}
		max = liss;
		
	}

	static int BinarySearch(ArrayList<Integer> arr, int number) {
		int low = 0;
		int high = arr.size() - 1;
		int mid;
		while (low < high) {
			mid = (low + high) >>> 1;
			if (arr.get(mid) > arr.get(number))
				high = mid - 1;
			else
				low = mid + 1;
		
		}
		return low;
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

class Pair {
	int width;
	int height;

	public Pair(int widht, int height) {
		this.width = widht;
		this.height = height;
	}
}
