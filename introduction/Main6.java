package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
public class Main6 {
	/**		��ο��ţ	����С��������
	 * 	ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
	 * 	����������
	 * 		Farmer John��÷ǳ������������ټ���ά������ţ֮�乩ͨ�еĵ�·��
	 * 	��·����������N�������������������ر��Ϊ1��N��ÿһ����������һ����ţ�ļҡ�
	 * 	FJ�ƻ���ȥP����·�о����ܶ�ĵ�·�����ǻ�Ҫ��������֮�� ����ͨ�ԡ�������Ҫ������Щ��·����Ҫ������N-1����·��
	 * 	��j��˫���·����������Sj��Ej(1 <= Sj <= N; 1 <= Ej <= N; Sj != Ej)��������������ҪLj��ʱ�䡣
	 * 	û�����������Ǳ�һ�����ϵĵ�·�����ӡ���ţ�Ƿǳ����ģ���Ϊ���ǵĽ�ͨϵͳ�������ˡ�����Ҫ��ÿһ����ţ��ס��ȥ��ο���ǡ�
	 * 	ÿ���㵽���i��������ʱ��(��ʹ���Ѿ�����)������뻨ȥCi��ʱ�����ţ��̸����ÿ�����϶�����ͬһ������(���ǹ���ѡ���)��ҹ��
	 * 	ֱ����ţ�Ƕ��ӱ����л��������������� ���������ϻ�ȥ˯����ʱ���㶼��Ҫ������˯������������ţ��̸һ�Ρ���������������� ��̸����
	 * 	����Farmer John��������Ľ��飬������ʹ������ţ������ο������ʱ�䡣
	 * 	�����ʽ��
	 *	��1�а�����������N��P��
	 *	������N�У�ÿ�а���һ������Ci��
	 *	������P�У�ÿ�а�����������Sj, Ej��Lj��
	 * 	�����ʽ��
	 *	���һ������, ����Ҫ����ʱ��(�������������ڵ���������ţ������̸��ʱ��)��
	 * 	��������
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
	 * 	�������
	 *	176
	 * 	���ݹ�ģ��Լ��
	 *	5 <= N <= 10000��N-1 <= P <= 100000��0 <= Lj <= 1000��1 <= Ci <= 1,000��
	 * 	ʱ��	203ms
	 * 	�ڴ�	39.71MB
	 * 	���� ��Kruskal�㷨��https://www.cnblogs.com/liuzhen1995/p/6519646.html��
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
    //��ȡ�ڵ�a�ĸ��ڵ�
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
    //�ϲ�a�ڵ���������b�ڵ�������
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
    //��ȡ�������ս��
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
