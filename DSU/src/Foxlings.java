import java.io.*;
import java.util.*;

public class Foxlings {
	
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int N  =sc.nextInt();
		int M = sc.nextInt();
		
		DsuMainClass DSU = new DsuMainClass(Math.min(N,(int)2e5));
		
		int num1 ,num2;
		HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
		int index=0;
		for(int i= 0,i1,i2 ;i < M ; i++) {
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			if(!map.containsKey(num1)) {i1=index;map.put(num1, index);index++;}
			else i1=map.get(num1);
			
			
			if(!map.containsKey(num2)) {i2=index;map.put(num2, index);index++;}
			else i2=map.get(num2);
			
			DSU.unionSet(i1,i2);
		
		}
		int ans = DSU.numSets+Math.max(0,N - (int)2e5);
		pw.println(ans);
		pw.flush();
		pw.close();
	
	}

	
	static class DsuMainClass {
		int[] parent, rank, setSize;
		static int fake;
		// number of disjoint sets
		int numSets;
		int connected;

		public DsuMainClass(int N) {
			parent = new int[numSets = N];
			rank = new int[N];
			setSize = new int[N];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
				setSize[i] = 1;
			}
		}

		// The trick is to make the path for all those nodes shorter, by setting
		// the parentarent of each visited vertex directly to parent.
		public int findSet(int i) {
			return parent[i] == i ? i : (parent[i] = findSet(parent[i]));
		}

		public boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		public void unionSet(int i, int j) {
			if (isSameSet(i, j))
				return;
			numSets--;
			int x = findSet(i), y = findSet(j);
			if (rank[x] >= rank[y]) {
				parent[y] = x;
				setSize[x] += setSize[y];
			} else {
				parent[x] = y;
				setSize[y] += setSize[x];
				if (rank[x] == rank[y])
					rank[y]++;
			}
		}

		public int numDisjointSets() {
			return numSets;
		}

		public int sizeOfSet(int i) {
			return setSize[findSet(i)];
		}
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

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public boolean nextEmpty() throws IOException {
			String s = nextLine();
			st = new StringTokenizer(s);
			return s.isEmpty();
		}
	}

}
