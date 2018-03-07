import java.io.*;
import java.util.*;

public class uva639 {
	static int n;
	static char[][] grid;
	static int []dx= {1,-1,0,0};
	static int []dy= {0,0,1,-1};
	
	static int res;
	static boolean place(int r, int c,char[][]grid) {

		int lastInRow = 0, lastInCol = 0;

		for (int i = 0; i < c; i++)
			if (grid[r][i] != '.')
				lastInRow = i;

		for (int i = 0; i < r; i++)
			if (grid[i][c] != '.')
				lastInCol = i;

		System.out.println("our row is "+r + " while c "+c);
		for(int i = 0 ; i < n ; i++)System.out.println(Arrays.toString(grid[i]));
		System.out.println( "last In Row value "+lastInRow + " in "+grid[r][lastInRow]  + " while last in column "+lastInCol+ " in grid "+ grid[lastInCol][c]);
		System.out.println(grid[r][lastInRow]!='R' && grid[lastInCol][c]!='R'&&grid[r][c]!='X');
		return grid[r][lastInRow]!='R' && grid[lastInCol][c]!='R'&&grid[r][c]!='X';

	}

	static void backTrack(int row,int col,int out) {
		if(col==n||row==n||row<0||col<0) {
		//	res=Math.max(out, res);
			return;
		}
		res=Math.max(out, res);
	//	backTrack(row,col+1, out,grid);
	//	backTrack(row+1,col,out,grid);
	
		for(int i = 0 ;i < 4 ;i++) {
			//
			if(place(row,col,grid)) {
				grid[row][col]='R';
				backTrack(row+dx[i],col+dy[i], out+1);
				grid[row][col]='.';
			}
			backTrack(row+dx[i], col+dy[i] ,  out );
		}
		

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			n = sc.nextInt();
			if (n == 0)
				break;
			grid = new char[n][n];
			for (int i = 0; i < n; i++)
				grid[i] = sc.nextLine().toCharArray();

			int out =0;
			res=0;
			//	for(int i = 0 ; i< n ; i++) {
			//	res=0;	
			backTrack(0,0, 0);
			//	out+=res;
			//	}
			System.out.println(res);

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
