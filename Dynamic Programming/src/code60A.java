import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class code60A {
	public static void main(String[]args) throws IOException {
		Scanner sc=  new Scanner(System.in);
		int n = sc.nextInt();
		int point1 = 1;//right handling
		int point2 = n;//left handling
		
		int m = sc.nextInt();
		String s [];
		int value=0;
		while(m-->0) {
			s=sc.nextLine().split(" ");
			value = Integer.parseInt(s[4]);
			if(s[2].equals("right"))
				point1=Math.max(point1,value+1);
			else 
				point2=Math.min(point2,value-1);
		
			if(point1>point2||point1>n || point2<1) {
				System.out.println(-1);
				return ;
			}
		}
		System.out.println(point2-point1+1);
		
	}
}