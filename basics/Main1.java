package basics;
import java.util.Scanner;
/**		�����ж�
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 *
 *����һ����ݣ��ж���һ���ǲ������ꡣ
���������֮һ����ʱ����һ�������꣺
1. �����4�ı���������100�ı�����
2. �����400�ı�����
��������ݶ��������ꡣ 
 * �������һ������y����ʾ��ǰ�����
 *���һ�У������������������꣬�����yes���������no�� 
 *ʱ��78ms	
 *�ڴ�22.06MB
 * */

public class Main1 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int y = sca.nextInt();
		if((y%4==0 && y%100!=0)||y%400==0)
			System.out.println("yes");
		else
			System.out.println("no");
	}

}
