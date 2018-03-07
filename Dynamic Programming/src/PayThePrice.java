import java.io.*;
import java.util.Arrays;

 class PayThePrice {
	static int amount;
	static int st;
	static int end;
	static long memo[][][];
	public static void main(String[]args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(System.out);
		String s;
		String [] n;
		StringBuilder sb = new StringBuilder("");


		
		amount = 300;
		memo = new long[301][301][301];//coin needed nextCoin ways

		for(int i  = 0 ; i < 301 ; i++)
			for(int j = 0 ; j < 301 ; j++)
				Arrays.fill(memo[i][j], -1);
		
		long res;
		st = 1;
		end = 300;
		
		while (!(s=bf.readLine()).equals("")) {
			n= s.split(" ");

			amount = Integer.parseInt(n[0]);
			st=0;
			end=amount;//1*amount = amount if we used one 1 dollar so the max number of coins can be use same as the amount.
			
			if(n.length>=2)end=Integer.parseInt(n[1]);
			if(n.length==3) {
			
				st=Integer.parseInt(n[1]);
				if(st>1)st-=1;
				end=Integer.parseInt(n[2]);
			}
		//	res = memo[amount][st][end];
			res =dp(amount,end,1);

			sb.append(res+"\n");
			
		}
		pw.println(sb);
		pw.flush();
		pw.close();
	}
	//sum of coins added, number of the added coins , nextCoin.
	static long dp(int sum ,int added ,int nextCoin) {	
		
		if(sum==0) 
			if(added>=st)
				return 1;
		
		
		if(added<st || nextCoin > sum) 
			return 0;
	
		if(memo[sum][st][added]!=-1)return memo[sum][st][added];
		

		long ans1=0,ans2=0 ;

		ans2 = dp(sum,added,nextCoin+1);
		ans1 = dp(sum-nextCoin,added-1,nextCoin);


		return memo[sum][st][added]=ans1+ans2;
		
	}
}
