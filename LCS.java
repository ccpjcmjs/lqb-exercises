package introduction;
import java.util.Scanner;
import java.util.Stack;

public class LCS {
/**		DP ��󹫹�������
 * ʱ�临�Ӷ� O��m*n��
 * ͨ��һ����ά����b[m][n], �ֱ��ʾ����s1������s2 
 * ���αȽ�b[0][1]��b[1][0],b[2][0]...�ȵ���������õ�ֵΪ����Ԫ��ֵ+1 ��b[m][n]��Ϊ���LCS(��󹫹�������)�ĳ���
 * */
	static String s1;	
	static String s2;	
	static int b[][];	
	static int c[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sca = new Scanner(System.in);
		s1 = sca.next();
		s2 = sca.next();
		String str1[] = new String[s1.length()];
		String str2[] = new String[s2.length()];
		str1 = s1.split("");	//���ַ���ת��Ϊ�ַ�������
		str2 = s2.split("");
		dpLCS(str1, str2);	
	}
	private static void dpLCS(String x[],String y[]) {
		int m = x.length+1;
		int n = y.length+1;
		b = new int[m][n];	//��ʼ����ά����b��c
		c = new int[m][n];
		for(int i=0;i<m-1;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(x[i].equals(y[j]))	//�Ƚ�x[i]��y[i]�����ͬ����true���򷵻�false
				{
					c[i+1][j+1] = c[i][j] + 1;
					b[i+1][j+1] = 1;
				}
				else if(c[i][j+1]>=c[i+1][j])
				{
					c[i+1][j+1] = c[i][j+1];
					b[i+1][j+1] = 2;
				}
				else
				{
					c[i+1][j+1] = c[i+1][j];
					b[i+1][j+1] = 3;
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
		Stack<String> same = new Stack<String>();		//����ջsame�������lcs
		Stack<Integer> same1 = new Stack<Integer>();   //ջsame1��same2������Ź��������е��±�
		Stack<Integer> same2 = new Stack<Integer>();
		for(int i=m-1,j=n-1;i>=0&&j>=0;) 
		{
			if(b[i][j] == 1)
			{
				i--;j--;
				same.push(x[i]);	//����Ŀ���͵��˶�ջ�Ķ���
				same1.push(i);
				same2.push(j);
			}
			else if(b[i][j] == 2)
					i--;
				else
					j--;
		}
		System.out.println(s1);	//����ַ���s1
		for(int i=0;i<m && !same1.empty();i++)	//���s1�Ĺ����Ӵ��±�
		{
			if(i==same1.peek())	//if i��ջ�����
			{
				System.out.print(1);	//����±�
				same1.pop();	//ɾ���˶�ջ�����Ķ��� 
			}
			else
				System.out.print(" ");	
		}
		System.out.println();
		System.out.println(s2);		//����ַ���s2
		for(int i=0;i<n && !same2.empty();i++)	//���s2�����Ӵ��±�
		{
			if(i==same2.peek())
			{
				System.out.print(1);
				same2.pop();
			}
			else
				System.out.print(" ");
		}
		System.out.println();
		System.out.print("The longest common subsequence is: ");
		while(!same.empty())	//���ջ��Ϊ��
		{
			System.out.print(same.peek());
			same.pop();	
		}
		System.out.println("\n"+"The length is : "+c[m-1][n-1]);	//�����󹫹�������
	}
}
