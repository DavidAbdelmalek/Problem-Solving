import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class uva11341 {
	static int N;
	static int M;
	static int table[][];
	static float memo[][];
	static boolean flags[];
	public static void main(String[]args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder("");
		while(T-->0) {
			N=sc.nextInt();
			M=sc.nextInt();

			memo = new float[N][M+1];
			table = new int[N][M+1];
			for(int i = 0 ; i < N ; i++) {
				Arrays.fill(memo[i], -1);
				for(int j = 1 ; j <= M ; j++)
					table[i][j]=sc.nextInt();
			}
			flags = new boolean[N];
			float ans = dp(0,M);
			float average=(float)ans/N;
			boolean good = true;
			for(int i = 0 ; good&&i < N ; i++)good&=flags[i];

			if(good) {
				sb.append("Maximal possible average mark - "+String.format("%.2f", average)+".");
			}else {	
				sb.append("Peter, you shouldn't have played billiard that much.");
			}

			if(T!=0)sb.append("\n");
		}
		pw.println(sb);
		pw.flush();
		pw.close();
	}
	static float dp (int course , int remHours) {		
		if(course ==  N)return 0;
		if(memo[course][remHours]!=-1)return memo[course][remHours];
		float ans= 0;
		for(int i = 1 ;i <= M && i<=remHours ; i++) 
			if(table[course][i]>=5) {
				ans = Math.max(ans,table[course][i]+dp(course+1,remHours-i));
				flags[course]=true;
			}

		return memo[course][remHours]=ans;

	}
}
