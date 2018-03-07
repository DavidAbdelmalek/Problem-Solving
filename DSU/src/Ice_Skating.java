import java.io.*;
import java.util.*;

public class Ice_Skating {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		
		Pair[]arr = new Pair[n];
		int max1 = 0,max2=0;
		for(int i = 0,x,y; i<n;i++) {
			x=sc.nextInt();
			y=sc.nextInt();
			max1=Math.max(max1, x);
			max2=Math.max(max2, y);
			arr[i]=new Pair(x,y);
		}
		
		max1 = Math.max(max1, max2);
		
		DsuMainClass DSUROW = new DsuMainClass(max1+1);
		DsuMainClass DSUCOL = new DsuMainClass(max1+1);


		int prevCOL = arr[0].x;
		int prevROW = arr[0].y;
		
		int ans = 0;
		boolean flag = false;

//		System.out.println(DSUCOL.numSets-1);

		for (int i = 1, currROW, currCOL; i < n; i++) {
			flag = false;
			currCOL = arr[i].x;
			currROW = arr[i].y;
			
			

			if (DSUROW.isSameSet(prevROW, currROW) || DSUCOL.isSameSet(prevCOL, currCOL)
					|| DSUROW.rank[currROW]!=0 || DSUCOL.rank[currCOL]!=0 )
				flag = true;

			DSUROW.unionSet(prevROW, currROW);
			DSUCOL.unionSet(prevCOL, currCOL);

			prevROW = currROW;
			prevCOL = currCOL;

			if (!flag)
				ans++;

		}
		
		System.out.println(ans);

	}

	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x=x;
			this.y=y;
		}
	}
	static class DsuMainClass {
		int[] parent, rank, setSize;
		// number of disjoint sets
		int numSets;

		public DsuMainClass(int N) {
			parent = new int[numSets = N];
			rank = new int[N];
			setSize = new int[N];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
				setSize[i] = 1;
			}
		}

		// The trick is to make the parentaths for all those nodes shorter, by setting
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
			if (rank[x] > rank[y]) {
				parent[y] = x;
				setSize[x] += setSize[y];
				rank[y] = 0;
			} else {
				parent[x] = y;
				setSize[y] += setSize[x];
				if (rank[x] == rank[y])
					rank[y]++;

				rank[x] = 0;
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

	}
}
