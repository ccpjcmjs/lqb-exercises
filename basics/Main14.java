package basics;
import java.util.Scanner;
/**		ʱ��ת��
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 * 		����һ������Ϊ��λ��ʱ��t��Ҫ���á�<H>:<M>:<S>���ĸ�ʽ����ʾ���ʱ�䡣
 * <H>��ʾʱ�䣬<M>��ʾ���ӣ���<S>��ʾ�룬���Ƕ���������û��ǰ���ġ�0�������磬��
 * t=0����Ӧ����ǡ�0:0:0������t=3661���������1:1:1����
 * ����ֻ��һ�У���һ������t��0<=t<=86399����
 * ���ֻ��һ�У����ԡ�<H>:<M>:<S>���ĸ�ʽ����ʾ��ʱ�䣬���������š�
 * ��������
	5436
 * �������
	1:30:36
 * ʱ��  125ms	
 * �ڴ�  21.50MB
 * */
public class Main14 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int t = sca.nextInt();
		int hour,minute,sec;
		hour = t/3600;		//Сʱ
		minute = t%3600/60; //����
		sec = t%3600%60;	//����
		System.out.println(hour+":"+minute+":"+sec);
	}
}