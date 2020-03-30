package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
public class Main4 {
/**		结点选择	(树形动态规划)
 * 	时间限制：1.0s   内存限制：256.0MB
 * 	问题描述：
 * 		有一棵 n 个节点的树，树上每个节点都有一个正整数权值。如果一个点被选择了，那么在树上和它相邻的点都不能被选择。求选出的点的权值和最大是多少？
 * 	输入格式：
 * 		第一行包含一个整数 n 。
 * 		接下来的一行包含 n 个正整数，第 i 个正整数代表点 i 的权值。
 *		接下来一共 n-1 行，每行描述树上的一条边。
 * 	输出格式：
 *		输出一个整数，代表选出的点的权值和的最大值。
 * 	样例输入：
 *		5
 *		1 2 3 4 5
 *		1 2
 *		1 3
 *		2 4
 *		2 5
 *	样例输出：
 *		12
 * 	样例说明：
 *		选择3、4、5号点，权值和为 3+4+5 = 12 。
 * 		数据规模与约定
 *		对于20%的数据， n <= 20。
 *		对于50%的数据， n <= 1000。
 *		对于100%的数据， n <= 100000。
 *		权值均为不超过1000的正整数。
 * 	时间：	218ms
 * 	内存：	39.36MB
 * 	解析 ：代码借鉴的....70分 未完善
 * */
	
	static int dp[][];
	static int value[];
	static List <Integer>[]list;
	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();
		int n = (int) in.nval;
		value = new int[n];
		dp = new int[n][2];
		list = new ArrayList[n];
		
		for(int i=0;i<n;i++) {
			list[i] = new ArrayList<>();
			}
		for(int i=0;i<n;i++) {
			in.nextToken();
			value[i] = (int)in.nval;
		}
		for(int i=0;i<n-1;i++) {
			in.nextToken(); int t1 = (int) in.nval;
			in.nextToken(); int t2 = (int) in.nval;
			list[t1-1].add(t2-1);
			list[t2-1].add(t1-1);
		}
		dfs(0,-1);
		int value = max(dp[0][0],dp[0][1]);
		out.println(value);
		out.flush();
	}
	
	private static void dfs(int x,int y) {
		for(int i=0;i<list[x].size();i++) {
			int num = list[x].get(i);
			if(num!=y)
			{
				dfs(num,x);
				dp[x][0]+=max(dp[num][0],dp[num][1]);
				dp[x][1]+=dp[num][0];
			}
		}
		dp[x][1]+=value[x];
	}
	
	private static int max(int i,int j) {
		return i>=j?i:j;
	}

}