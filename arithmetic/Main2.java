package arithmetic;
import java.util.Scanner;
/**		�������
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 * ��1+2+3+...+n��ֵ
 *�������һ������n 
 *���һ�У�����һ����������ʾ1+2+3+...+n��ֵ
 *1 <= n <= 1,000,000,000
 *����һ
 *ʱ��500ms
 *�ڴ�22.32MB
 *������
 *ʱ��125ms
 *�ڴ�22.04MB
 * */
public class Main2 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		if(n>1000000000||n<1) {
			System.out.println("please imput 0and1000000001 between the two");
			n = sca.nextInt();
		}
		long sum = 0;				//������
		int i = 1;
		sum = (long)(i+n)*n/2;		//��ѧ���ţ��
//		for(int i = 1;i<=n;i++) {		//����һ
//			sum+=i;
//		}
		System.out.println(sum);
	}

}
