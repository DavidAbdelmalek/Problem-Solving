import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Translation {
	public static void main(String[]args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s1 = (bf.readLine());
		String s3 = (bf.readLine());
		s3=reverse(s3);
		if(s1.equals(s3))System.out.println("YES");
		else System.out.println("NO");
	}
	static String reverse(String s){
		String out="";
		for(int i = s.length()-1; i >=0;i--)
			out+=s.charAt(i);
	return  out;
	}
}
