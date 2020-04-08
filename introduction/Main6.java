package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
public class Main6 {
	/**		安慰奶牛	（最小生成树）
	 * 	时间限制：1.0s   内存限制：256.0MB
	 * 	问题描述：
	 * 		Farmer John变得非常懒，他不想再继续维护供奶牛之间供通行的道路。
	 * 	道路被用来连接N个牧场，牧场被连续地编号为1到N。每一个牧场都是一个奶牛的家。
	 * 	FJ计划除去P条道路中尽可能多的道路，但是还要保持牧场之间 的连通性。你首先要决定那些道路是需要保留的N-1条道路。
	 * 	第j条双向道路连接了牧场Sj和Ej(1 <= Sj <= N; 1 <= Ej <= N; Sj != Ej)，而且走完它需要Lj的时间。
	 * 	没有两个牧场是被一条以上的道路所连接。奶牛们非常伤心，因为她们的交通系统被削减了。你需要到每一个奶牛的住处去安慰她们。
	 * 	每次你到达第i个牧场的时候(即使你已经到过)，你必须花去Ci的时间和奶牛交谈。你每个晚上都会在同一个牧场(这是供你选择的)过夜，
	 * 	直到奶牛们都从悲伤中缓过神来。在早上 起来和晚上回去睡觉的时候，你都需要和在你睡觉的牧场的奶牛交谈一次。这样你才能完成你的 交谈任务。
	 * 	假设Farmer John采纳了你的建议，请计算出使所有奶牛都被安慰的最少时间。
	 * 	输入格式：
	 *	第1行包含两个整数N和P。
	 *	接下来N行，每行包含一个整数Ci。
	 *	接下来P行，每行包含三个整数Sj, Ej和Lj。
	 * 	输出格式：
	 *	输出一个整数, 所需要的总时间(包含和在你所在的牧场的奶牛的两次谈话时间)。
	 * 	样例输入
	 *	5 6
	 *	10
	 *	10
	 *	20
	 *	6
	 *	30
	 *	1 2 5
	 *	2 3 5
	 *	2 4 12
	 *	3 4 17
	 *	2 5 15
	 *	3 5 6
	 * 	样例输出
	 *	176
	 * 	数据规模与约定
	 *	5 <= N <= 10000，N-1 <= P <= 100000，0 <= Lj <= 1000，1 <= Ci <= 1,000。
	 * 	时间	203ms
	 * 	内存	39.71MB
	 * 	解析 ：Kruskal算法（https://www.cnblogs.com/liuzhen1995/p/6519646.html）
	 * */
    
	class edge {
        public int a;
        public int b;
        public int value;
        
        edge(int a, int b, int value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }
    }
    
    public void edgeSort(edge[] A){
        if(A.length > 1) {
            edge[] leftA = getHalfEdge(A, 0);
            edge[] rightA = getHalfEdge(A, 1);
            edgeSort(leftA);
            edgeSort(rightA);
            mergeEdgeArray(A, leftA, rightA);
        }
    }
    
    public edge[] getHalfEdge(edge[] A, int judge) {
        edge[] half;
        if(judge == 0) {
            half = new edge[A.length / 2];
            for(int i = 0;i < A.length / 2;i++)
                half[i] = A[i];
        } else {
            half = new edge[A.length - A.length / 2];
            for(int i = 0;i < A.length - A.length / 2;i++)
                half[i] = A[A.length / 2 + i];
        }
        return half;
    }
    
    public void mergeEdgeArray(edge[] A, edge[] leftA, edge[] rightA) {
        int i = 0;
        int j = 0;
        int len = 0;
        while(i < leftA.length && j < rightA.length) {
            if(leftA[i].value < rightA[j].value) {
                A[len++] = leftA[i++];
            } else {
                A[len++] = rightA[j++];
            }
        }
        while(i < leftA.length) A[len++] = leftA[i++];
        while(j < rightA.length) A[len++] = rightA[j++];
    }
    //获取节点a的根节点
    public int find(int[] id, int a) {
        int x, r, k;
        r = a;
        while(id[r] >= 0) r = id[r];
        k = a;
        while(k != r) {
            x = id[k];
            id[k] = r;
            k = x;
        }
        return r;
    }
    //合并a节点所在树和b节点所在树
    public void union(int[] id, int a, int b) {
        int ida = find(id, a);
        int idb = find(id, b);
        int num = id[ida] + id[idb];
        if(id[ida] < id[idb]) {
            id[idb] = ida;
            id[ida] = num;
        } else {
            id[ida] = idb;
            id[idb] = num;
        }
    }
    //获取题意最终结果
    public void getMinSpanTree(edge[] A, int[] valueN) {
    	PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int sum = 0;
        int[] id = new int[valueN.length];
        
        for(int i = 0;i < valueN.length;i++) 
            id[i] = -1;
        edgeSort(A);
        int count = 0;
        for(int i = 0;i < A.length;i++) {
            int a = A[i].a;
            int b = A[i].b;
            int ida = find(id, a - 1);
            int idb = find(id, b - 1);
            if(ida != idb) {
                sum += A[i].value;
                count++;
                union(id, a - 1, b - 1);
            }
            if(count >= valueN.length - 1)
                break;
        }
        
        int minValueN = valueN[0];
        for(int i = 0;i < valueN.length;i++) {
            if(minValueN > valueN[i]) {
                minValueN = valueN[i];
            }
        }
        sum += minValueN;
        out.println(sum);
        out.flush();
    }
    
    public static void main(String[] args)throws IOException{
        Main6 test = new Main6();
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int p = (int) in.nval;
        if(n > 10000 || n < 5)
            return;
        if(p > 100000 || p < n - 1)
            return;
        int[] valueN = new int[n];
        for(int i = 0;i < n;i++)
        {    in.nextToken(); valueN[i] = (int) in.nval;}
        edge[] A = new edge[p];
        for(int i = 0;i < p;i++) {
        	in.nextToken(); int a = (int) in.nval;
            in.nextToken(); int b = (int) in.nval;
            in.nextToken(); int value = (int) in.nval * 2 + valueN[a - 1] + valueN[b - 1];
            A[i] = test.new edge(a, b, value);
        }
        test.getMinSpanTree(A, valueN);
    }
}
