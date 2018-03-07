import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva10405 {
	static int memo[][];
	static String s1;
	static String s2;
	static int len1;
	static int len2;

	public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(br);

		StringBuilder sb = new StringBuilder("");
		
        while(sc.hasNext()) {
			
			s1=sc.nextLine();
			s2 = sc.nextLine();
			
			memo = new int[1001][1001];

			len1 = s1.length();
			len2 = s2.length();

			for (int i = 0; i <= 1000; i++)
				Arrays.fill(memo[i], -1);
					
			sb.append(dp(0,0)+ "\n");
		}
		System.out.print(sb);
	}

	static int dp(int index1, int index2) {
		if (index1 == len1 || index2 == len2)
			return 0;

		if (memo[index1][index2] != -1)
			return memo[index1][index2];
	
		if (s1.charAt(index1) == s2.charAt(index2))
				memo[index1][index2] = 1 + dp(index1 + 1, index2 + 1);
			else 
				memo[index1][index2] = Math.max(dp(index1 + 1, index2),dp(index1, index2 + 1));

		
		return  memo[index1][index2];


	}
	}
