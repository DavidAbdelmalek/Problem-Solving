	import java.util.*;
	import java.io.*;
	
	public class uva352 {
		static int n ;
		static int [][]arr;
		static boolean visited[][];
		static int count=0;
		static int T=1;
		static StringBuilder sb=new StringBuilder("");
		static int [][]check={{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
		public static void main(String[]args) throws IOException{
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(System.out);
			String s;
			
			while((s=bf.readLine())!=null&&!s.equals("")&&!s.equals(" ")){
				if(T>1)sb.append("\n");
				n = Integer.parseInt(s);
				visited=new boolean[n][n];
				arr=new int[n][n];
				for(int i = 0;i<n;i++){
					String s2 = bf.readLine();
					for(int j = 0 ; j < n ; j++)
						arr[i][j]=Integer.parseInt(s2.charAt(j)+"");
				}
				
				for(int i = 0 ; i < n;i++)
					for(int j =0 ;j<n ; j++)
						if(arr[i][j]==1&&!visited[i][j]){
							count++;
							dfs(i,j);
						}
				
				sb.append("Image number "+T+" contains "+count+" war eagles.");
				T++;
				count=0;
			}
			pw.println(sb);
			pw.flush();
			pw.close();
		}
		static void dfs(int x,  int y){
			visited[x][y]=true;
			for(int i = 0 ;i < 8 ; i++){
				if(notBoundries(x, y, i)){
					if(!visited[x+check[i][0]][y+check[i][1]]){
						if(arr[x][y]==1){
							dfs(x+check[i][0],y+check[i][1]);
						}	
						else ; // don't go anywhere
					}else ;//Already Visited
				}else ;
			}
		}
		static boolean notBoundries(int x, int y,int i){
			if(x+check[i][0]<n && x+check[i][0]>=0
					&&y+check[i][1]<n&&y+check[i][1]>=0)
				return true;
			return false;
		}
	}
