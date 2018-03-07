import java.util.*;
import java.io.*;

public class UVA11953 {
	static char [][]dfs;
	static int n;
	static boolean visited[][];
	static StringBuilder sb ;
	static int okok[][];
	static ArrayList<Integer>res;
	static int count;
	static int index=0;
	public static void main(String[]args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		while(T-->0){
			n  = Integer.parseInt(bf.readLine());
			dfs= new char[n][n];
			visited=new boolean [n][n];
			okok= new int[n*2+2][2];
			String in;
			count =0;
			for	(int i = 0 ; i < n ; i++){
				in= bf.readLine();
				for(int j = 0 ; j < n ; j++)
					dfs[i][j]=in.charAt(j);
			}
			fillPlease(true);
			fillPlease(false);
		}

	}
	static boolean dfs(int x, int y){
		visited[x][y]=true;
		boolean all =true;
		for(int  i = 0 ,newX,newY; i <okok.length;i++){
			if(dfs[x][y]=='@'){
				boolean all=true;
			}
			newX=okok[i][0];
			newY=okok[i][1];

			if(!boundry(x,y,newX,newY)){
				newX+=x;
				newY+=y;
				if(dfs[newX][newY]=='.'){
					return true;
				}
				else{
					if(dfs[newX][newY]=='x'|dfs[newX][newY]==''){
						return dfs(newX,newY);
					}
					else{
						
					}
						
				}
			}
		}
	}
	static boolean boundry(int curenX,int curenY,int newX,int newY){
		curenX+=newX;
		curenY+=newY;
		return curenX==-1||curenX>=n||curenY==-1||curenY>=n;
	}
	static void fillPlease(boolean fill){
		count=-(n/2);
		while(count<=(n/2)){
			System.out.println();
			if(fill){
				okok[index][0]=0;
				okok[index][1]=count++;

			}else{
				okok[index][0]=count++;
				okok[index][1]=0;
			}
			index++;
		}
	}
}

