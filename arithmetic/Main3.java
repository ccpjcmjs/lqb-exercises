package arithmetic;
import java.util.Scanner;
/**		Բ�����
 * 	ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 * ����Բ�İ뾶r����Բ�����
 *�������һ������r����ʾԲ�İ뾶 
 *���һ�У�����һ��ʵ�����������뱣��С�����7λ����ʾԲ�����
 *1 <= r <= 10000
 * ʱ��140ms
 * �ڴ�	22.25MB
 * */

public class Main3 {
	public static final double PI = 3.14159265358979323;
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int r = sca.nextInt();
		if(r>10000||r<1) {
			System.out.println("please imput 0and10001 between the two");
			r = sca.nextInt();
		}
			
		double area = 0;
		area = PI*r*r;
		System.out.println(String.format("%.7f", area));	//����С��
	}

}
