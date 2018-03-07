import java.util.*;
import java.io.*;

public class PresidentsOffice {
	static int n;
	static int m;
	static String c;
	static String arr[][];
	static HashMap<String,Integer>map;
	static int dx[]={1,-1,0,0};
	static int dy[]={0,0,1,-1};
	public static void main(String[]args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String [] in = new String[3];
		in = bf.readLine().split(" ");
		n  =  Integer.parseInt(in[0]);
		m  = Integer.parseInt(in[1]);
		c = in[2];
		String s;
		arr = new String[n][m];
		map  = new HashMap<String,Integer>();

		for(int i = 0 ; i < n ; i ++){
			s=bf.readLine();
			for(int j = 0 ; j < m ; j++)arr[i][j]=s.charAt(j)+"";
		}

		for(int i = 0 ; i < n ; i++)
			for(int j = 0 ; j < m ; j++){
				if(arr[i][j].equals(c))check(i,j);

			}
		System.out.println(map.size());

	}
	static boolean valid(int x , int y ){
		if(x>=0&&x<n&&y>=0&&y<m)return true;
		return false;
	}
	static void check(int x ,int y){
		for(int i = 0 ; i < 4 ; i++){
			if(valid(x+dx[i],y+dy[i])) 
				if(!arr[dx[i]+x][dy[i]+y].equals(c)&&!arr[dx[i]+x][dy[i]+y].equals("."))
					map.put(arr[dx[i]+x][dy[i]+y],1);

		}}
}
