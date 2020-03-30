package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main5 {
/**	 	最短路
 * 	时间限制：1.0s   内存限制：256.0MB
 * 	问题描述
 *	给定一个n个顶点，m条边的有向图（其中某些边权可能为负，但保证没有负环）。请你计算从1号点到其他点的最短路（顶点从1到n编号）。
 * 	输入格式
 *	第一行两个整数n, m。
 *	接下来的m行，每行有三个整数u, v, l，表示u到v有一条长度为l的边。	
 *	输出格式
 *	共n-1行，第i行表示1号点到i+1号点的最短路。 
 * 	样例输入
 *	3 3
 *	1 2 -1
 *	2 3 -1
 *	3 1 2
 * 	样例输出
 *	-1
 *	-2
 * 	数据规模与约定
 *	对于10%的数据，n = 2，m = 2。
 *	对于30%的数据，n <= 5，m <= 10。
 *	对于100%的数据，1 <= n <= 20000，1 <= m <= 200000，-10000 <= l <= 10000，保证从任意顶点都能到达其他所有顶点。
 * 	时间	203ms
 * 	内存	37.91MB
 * 	解析：SPFA算法
 * 		由于本体数据过大 ，所以不在用Scanner类来输入 这里用StreamTokenizer和PrintWriter来实现输入和输出
 * */
	static int leng[];
	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();int n =(int) in.nval;	
		in.nextToken();int m =(int) in.nval;
		List<node> list[] = new ArrayList[n];	//存放路径
		for(int i=0;i<n;i++) 	//声明
		{
			list[i] = new ArrayList<node>();
		}
		leng = new int[n];	//存放最短路径
		boolean jud[] = new boolean[n];	//来判断是否存在在队列里
		for(int i=1;i<n;i++) {leng[i] = Integer.MAX_VALUE;}	//除了0之外所有长度均为最大值即∞
		for(int i=0;i<m;i++) 
		{
			in.nextToken();int u =(int) in.nval;
			in.nextToken();int v =(int) in.nval;
			in.nextToken();int l =(int) in.nval;
			list[u-1].add(new node(v-1, l));
		}
		Queue<Integer> q1 = new ArrayDeque<Integer>(); 
		q1.add(0);	//第一个
		while(!q1.isEmpty()) {	//如果队列为不为空则执行循环
			int x = q1.poll();	//返回队首指针并删除队首指针
			jud[x] = false;	
			for(int i=0;i<list[x].size();i++) {	//遍历
				int index = list[x].get(i).x;	//邻居该节点的编号
				int length = list[x].get(i).leng;	//x到这个邻居的距离
				if(leng[index] > leng[x] + length) {	//如果松弛过后路径值变小了
					leng[index] = leng[x] + length;		//更新该值
					if(!jud[index]) {	//如果队列中没有该点
						q1.add(index);jud[index] = true;
					}
				}
			}
		}
		for(int i=1;i<n;i++) {		//输出最短路径
			out.println(leng[i]);
		}
		out.flush();
		
	}
	static class node{
		int x;
		int leng;
		public node(int x,int leng) {
			this.x=x;
			this.leng=leng;
		}
	}

}
