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
/**		���ѡ��	(���ζ�̬�滮)
 * 	ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 * 	����������
 * 		��һ�� n ���ڵ����������ÿ���ڵ㶼��һ��������Ȩֵ�����һ���㱻ѡ���ˣ���ô�����Ϻ������ڵĵ㶼���ܱ�ѡ����ѡ���ĵ��Ȩֵ������Ƕ��٣�
 * 	�����ʽ��
 * 		��һ�а���һ������ n ��
 * 		��������һ�а��� n ������������ i ������������� i ��Ȩֵ��
 *		������һ�� n-1 �У�ÿ���������ϵ�һ���ߡ�
 * 	�����ʽ��
 *		���һ������������ѡ���ĵ��Ȩֵ�͵����ֵ��
 * 	�������룺
 *		5
 *		1 2 3 4 5
 *		1 2
 *		1 3
 *		2 4
 *		2 5
 *	���������
 *		12
 * 	����˵����
 *		ѡ��3��4��5�ŵ㣬Ȩֵ��Ϊ 3+4+5 = 12 ��
 * 		���ݹ�ģ��Լ��
 *		����20%�����ݣ� n <= 20��
 *		����50%�����ݣ� n <= 1000��
 *		����100%�����ݣ� n <= 100000��
 *		Ȩֵ��Ϊ������1000����������
 * 	ʱ�䣺	218ms
 * 	�ڴ棺	39.36MB
 * 	���� ����������....70�� δ����
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