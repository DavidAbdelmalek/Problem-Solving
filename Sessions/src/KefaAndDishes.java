
import java.util.Arrays;
import java.util.Scanner;

public class KefaAndDishes {

	static int n , m , dishes ,x[];
	static long memo[][];
	static int bonus[][];

	static long TSP(int pos, int bitmask) {
		
		if(Integer.bitCount(bitmask) == m)
			return 0;

		if(memo[pos][bitmask] != -1)
			return memo[pos][bitmask];

		long  ans = 0;
		int nxt;
		
		for (nxt = 1;nxt <=  n ; nxt++) {
			if ((bitmask & (1 << nxt)) == 0)
				ans = Math.max(ans,x[nxt]+bonus[pos][nxt]+ TSP (nxt, bitmask | (1 << nxt)));
		}
	
		return memo[pos][bitmask] = ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		int  rules = sc.nextInt();

		x = new int[n+1];
		
		for(int i=1;i<=n;i++)
			x[i] = sc.nextInt();

		bonus = new int[n+1][n+1];
		
		for(int i=0;i<rules;i++)
			bonus[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		
		memo = new long[n+1][(int)Math.pow(2, n+1)+2];
		
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], -1);
		}
		
		System.out.println(TSP(0,0));
		sc.close();
	}
	
}