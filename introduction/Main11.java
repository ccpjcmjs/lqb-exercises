package introduction;
import java.util.Scanner;
public class Main11 {
/**		��ש�̷�	(�ݹ�)
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 * ��������:
����	��һ����ΪN(1<=��<=10)�ĵذ壬�������ֲ�ͬ��ש��һ�ֳ���Ϊ1����һ�ֳ���Ϊ2��
		��Ŀ���ޡ�Ҫ���������ΪN�ĵذ�������һ���ж����ֲ�ͬ���̷���
����	���磬����Ϊ4�ĵ���һ��������5���̷���
����	4=1+1+1+1
����	4=2+1+1
����	4=1+2+1
����	4=1+1+2
����	4=2+2
����		����õݹ�ķ�������������⡣
 * �����ʽ:
����	ֻ��һ����N������ذ�ĳ���
 * �����ʽ:
����	���һ�������������в�ͬ�Ĵ�ש�̷ŷ���������
 * ��������:
	4
 * �������:
	5
 * ʱ��:	62ms
 * �ڴ�:	22.03MB
 * ������������Ϊ4ʱ
 	   f(4)--f(3)--f(2)--f(1)--f(0)	 // 4=1+1+1+1
 	   f(4)--f(3)--f(2)--f(0)		// 4=1+1+2
 	   f(4)--f(3)--f(1)--f(0)		// 4=1+2+1
 	   f(4)--f(2)--f(1)--f(0)		// 4=2+1+1
 	   f(4)--f(2)--f(0)				// 4=2+2
 * */
	public static int a;
	public static int sum = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		func(a);
		System.out.println(sum);
	}
	private static void func(int x) {
		if(x==0) {
			sum++;
			return;
		}
		if(x<0)
			return;
		func(x-1);
		func(x-2);
	}

}
