import java.util.Scanner;


public class IWannaBeAGuy {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		boolean [] visited = new boolean [n];
		int p = sc.nextInt();
		while(p-->0)visited[(sc.nextInt())-1]=true;
		int q = sc.nextInt();
		while(q-->0)visited[(sc.nextInt())-1]=true;
		
		boolean res=true;
		for(int i = 0 ; i < n &&res; i++)res&=visited[i];
		
		System.out.println(res?"I become the guy.":"Oh, my keyboard!");
	}
}
