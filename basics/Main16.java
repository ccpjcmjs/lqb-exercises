package basics;
import java.util.Scanner;
public class Main16 {
/**	�ֽ�������
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 * �������[a,b]�������������������ֽ⡣
 * �����ʽ
����	������������a��b��
 * �����ʽ
����	ÿ�����һ�����ķֽ⣬����k=a1*a2*a3...(a1<=a2<=a3...��kҲ�Ǵ�С�����)(����ɿ�����)
 * ��������
	3 10
 * �������
	3=3
	4=2*2
	5=5
	6=2*3
	7=7
	8=2*2*2
	9=3*3
	10=2*5
 * ��ʾ
������ɸ������������Ȼ���ٷֽ⡣
 * 2<=a<=b<=10000
 * ʱ��  328ms	
 * �ڴ�  33.12MB
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int start = sca.nextInt();
		int end = sca.nextInt();
		for(int i=start;i<=end;i++) {
			System.out.println(i+"="+reu(i).substring(1));
		}
	}
	private static String reu(int n) {
//		String str = "";
		for(int i=2;i<n;i++) {
			if(n%i==0)
				return "*"+i+reu(n/i);		//�ݹ����
		}
		return "*"+n;
	}

}
