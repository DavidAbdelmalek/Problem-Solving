import java.util.Scanner;


public class Decoding {
	public static void main(String[]args){
		Scanner sc= new Scanner(System.in);
		int n  = sc.nextInt();
		String s = sc.next();
		int i = n-1;
		String out="";
		while(i>=0){
			if(i-1>=0){
				out+=s.charAt(i-1)+""+s.charAt(i);
				i-=2;
			}else{
				out+=s.charAt(i);
				i--;
			}
		}
	System.out.println(check(n-1,s,n));
	}
	static String check(int i , String s , int n ){
		if(i==-1)return "";
		if(i==0)return s.charAt(0)+"";
		return s.charAt(i-1)+check(i-2,s,n)+s.charAt(i);
	}
}
