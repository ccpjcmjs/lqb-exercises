package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
/**		操作格子	(线段树)
 * 时间限制：1.0s   内存限制：256.0MB
 * 问题描述:
 * 有n个格子，从左到右放成一排，编号为1-n。
	共有m次操作，有3种操作类型：
	1.修改一个格子的权值，
	2.求连续一段格子权值和，
	3.求连续一段格子的最大值。
	对于每个2、3操作输出你所求出的结果。
 * 输入格式:
	第一行2个整数n，m。
	接下来一行n个整数表示n个格子的初始权值。
	接下来m行，每行3个整数p,x,y，p表示操作类型，p=1时表示修改格子x的权值为y，
	p=2时表示求区间[x,y]内格子权值和，p=3时表示求区间[x,y]内格子最大的权值。
 * 输出格式:
	有若干行，行数等于p=2或3的操作总数。
	每行1个整数，对应了每个p=2或3操作的结果。
 * 样例输入:
	4 3
	1 2 3 4
	2 1 3
	1 4 3
	3 1 4
 * 样例输出:
	6
	3
 * 数据规模与约定
	对于20%的数据n <= 100，m <= 200。
	对于50%的数据n <= 5000，m <= 5000。
	对于100%的数据1 <= n <= 100000，m <= 100000，0 <= 格子权值 <= 10000。
 * 时间	484ms
 * 内存	77.74MB
 * 解析
 * */
 
public class Main8{
	
	PrintWriter out = new PrintWriter(System.out);
	InputReader cin = new InputReader(System.in);
	
	final static int MAX_N = 100007;
	
	class Node {
		int l, r;
		int sum, max;
		Node () {
			
		}
		Node (int l, int r, int sum, int max) {
			this.l = l;
			this.r = r;
			this.sum = sum;
			this.max = max;
		}
	}
	
	int n, m;
	Node tree[] = new Node[MAX_N << 2];
	int a[] = new int[MAX_N];
	
	void up(int id) {
		tree[id].sum = tree[id << 1].sum + tree[id << 1 | 1].sum;
		tree[id].max = Math.max(tree[id << 1].max, tree[id << 1| 1].max);
	}
	
	void build(int id, int l, int r) {
		tree[id] = new Node(l, r, 0, 0);
		if (l == r) {
			tree[id].sum = tree[id].max = a[l];
			return ;
		}
		int mid = (l + r) >> 1;
		build(id << 1, l, mid);
		build(id << 1 | 1, mid + 1, r);
		up(id);
	}
	
	
	void update(int id, int pos, int val) {
		if (tree[id].l == tree[id].r) {
			tree[id].sum = tree[id].max = val;
			return ;
		}
		int mid = (tree[id].l + tree[id].r) >> 1;
		if (pos <= mid) update(id << 1, pos, val);
		else update(id << 1 | 1, pos, val);
		up(id);
	}
	
	int sum(int id, int l, int r) {
		if (l <= tree[id].l && tree[id].r <= r) {
			return tree[id].sum;
		}
		int mid = (tree[id].l + tree[id].r) >> 1;
		if (r <= mid) return sum(id << 1, l, r);
		else if (l > mid) return sum(id << 1 | 1, l, r);
		else {
			return sum(id << 1, l, mid) + sum(id << 1 | 1, mid + 1, r);
		}
	}
	
	int max(int id, int l, int r) {
		if (l <= tree[id].l && tree[id].r <= r) {
			return tree[id].max;
		}
		int mid = (tree[id].l + tree[id].r) >> 1;
		if (r <= mid) return max(id << 1, l, r);
		else if (l > mid) return max(id << 1 | 1, l, r);
		else {
			return Math.max(max(id << 1, l, mid), max(id << 1 | 1, mid + 1, r));
		}
	}
	
	void run() throws IOException {
		n = cin.nextInt();
		m = cin.nextInt();
		for (int i = 1; i <= n; ++i)
			a[i] = cin.nextInt();
		build(1, 1, n);
		for (int i = 0; i < m; ++i) {
			int type = cin.nextInt();
			int l = cin.nextInt();
			int r = cin.nextInt();
			if (type == 1) update(1, l, r);
			else if (type == 2) out.println(sum(1, l, r));
			else out.println(max(1, l, r));
		}
		out.close(); 
	}
 
	public static void main(String[] args) throws IOException {
		new Main8().run();
	}
	
 
	class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;
		InputReader(InputStream in) {
			reader = new BufferedReader(new InputStreamReader(in));
			tokenizer = new StringTokenizer("");
		}
 
		private String next() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}
 
		public Integer nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		
	}
}