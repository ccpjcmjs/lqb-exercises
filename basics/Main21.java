package basics;
import java.util.Scanner;
public class Main21 {
/**		Sine֮��	(�ַ��� �ݹ� ����)

 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 * ��������
����	���FJΪ������ţ�ǿ�������ѧ�����Σ�FJ֪����Ҫѧ�����ſΣ�������һ���õ����Ǻ�����������
	������׼������ţ����һ����Sine֮�衱����Ϸ��Ԣ�����֣������ţ�ǵļ���������
����	������
����	An=sin(1�Csin(2+sin(3�Csin(4+...sin(n))...)
����	Sn=(...(A1+n)A2+n-1)A3+...+2)An+1
����	FJ������ţ�Ǽ���Sn��ֵ���������FJ��ӡ��Sn���������ʽ���Է�����ţ�����⡣
 * �����ʽ
����	����һ������N<201��
 * �����ʽ
����	�������Ӧ�ı��ʽSn����һ�����з�����������в��ú��ж���Ŀո���С��س�����
 * ��������
	3
         �������
	((sin(1)+3)sin(1�Csin(2))+2)sin(1�Csin(2+sin(3)))+1
 * ʱ��	125ms
 * �ڴ�	21.62MB
 * */	
	static int N;
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int N = sca.nextInt();
		for(int i=0;i<N-1;i++) 
			System.out.print("(");
		Sn(1,N);
	}
	public static void An(int n,int k1) {
		int k=N-n+1;
		System.out.print("sin("+k1);
		if(n==1) {
			System.out.print(")");
			return;
		}
		if(k%2==1)
			System.out.print("-");
		else
			System.out.print("+");
		An(n-1,k+1);
		System.out.print(")");
	}
	public static void Sn(int x,int n) {
		N = x; 
		An(x,1);
		System.out.print("+"+n);
		if(n==1)
			return;
		System.out.print(")");
		Sn(x+1,n-1);
	}
}
