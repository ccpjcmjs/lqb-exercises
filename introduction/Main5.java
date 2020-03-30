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
/**	 	���·
 * 	ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 * 	��������
 *	����һ��n�����㣬m���ߵ�����ͼ������ĳЩ��Ȩ����Ϊ��������֤û�и���������������1�ŵ㵽����������·�������1��n��ţ���
 * 	�����ʽ
 *	��һ����������n, m��
 *	��������m�У�ÿ������������u, v, l����ʾu��v��һ������Ϊl�ıߡ�	
 *	�����ʽ
 *	��n-1�У���i�б�ʾ1�ŵ㵽i+1�ŵ�����·�� 
 * 	��������
 *	3 3
 *	1 2 -1
 *	2 3 -1
 *	3 1 2
 * 	�������
 *	-1
 *	-2
 * 	���ݹ�ģ��Լ��
 *	����10%�����ݣ�n = 2��m = 2��
 *	����30%�����ݣ�n <= 5��m <= 10��
 *	����100%�����ݣ�1 <= n <= 20000��1 <= m <= 200000��-10000 <= l <= 10000����֤�����ⶥ�㶼�ܵ����������ж��㡣
 * 	ʱ��	203ms
 * 	�ڴ�	37.91MB
 * 	������SPFA�㷨
 * 		���ڱ������ݹ��� �����Բ�����Scanner�������� ������StreamTokenizer��PrintWriter��ʵ����������
 * */
	static int leng[];
	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();int n =(int) in.nval;	
		in.nextToken();int m =(int) in.nval;
		List<node> list[] = new ArrayList[n];	//���·��
		for(int i=0;i<n;i++) 	//����
		{
			list[i] = new ArrayList<node>();
		}
		leng = new int[n];	//������·��
		boolean jud[] = new boolean[n];	//���ж��Ƿ�����ڶ�����
		for(int i=1;i<n;i++) {leng[i] = Integer.MAX_VALUE;}	//����0֮�����г��Ⱦ�Ϊ���ֵ����
		for(int i=0;i<m;i++) 
		{
			in.nextToken();int u =(int) in.nval;
			in.nextToken();int v =(int) in.nval;
			in.nextToken();int l =(int) in.nval;
			list[u-1].add(new node(v-1, l));
		}
		Queue<Integer> q1 = new ArrayDeque<Integer>(); 
		q1.add(0);	//��һ��
		while(!q1.isEmpty()) {	//�������Ϊ��Ϊ����ִ��ѭ��
			int x = q1.poll();	//���ض���ָ�벢ɾ������ָ��
			jud[x] = false;	
			for(int i=0;i<list[x].size();i++) {	//����
				int index = list[x].get(i).x;	//�ھӸýڵ�ı��
				int length = list[x].get(i).leng;	//x������ھӵľ���
				if(leng[index] > leng[x] + length) {	//����ɳڹ���·��ֵ��С��
					leng[index] = leng[x] + length;		//���¸�ֵ
					if(!jud[index]) {	//���������û�иõ�
						q1.add(index);jud[index] = true;
					}
				}
			}
		}
		for(int i=1;i<n;i++) {		//������·��
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
