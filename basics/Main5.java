package basics;
import java.util.Scanner;
/**		 ��������
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 *����һ������n�����������У�������a�������еĵ�һ�γ����ǵڼ����� 
 *��һ�а���һ������n��
  �ڶ��а���n���Ǹ�������Ϊ���������У������е�ÿ������������10000��
  �����а���һ������a��Ϊ�����ҵ����� 
 *���a�������г����ˣ��������һ�γ��ֵ�λ��(λ�ô�1��ʼ���)���������-1 
 *1 <= n <= 1000��
 *ʱ��140ms	
 *�ڴ�22.82MB
 * */
public class Main5 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
//		if(n>1000||n<1) {
//			System.out.println("n need 1 and 1000");
//			n = sca.nextInt();
//		}	
		int arr[] = new int[n];
		for(int i=0;i<arr.length;i++)
			arr[i] = sca.nextInt();
		int m = sca.nextInt();
		boolean result = true;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==m){
				result = false;
				System.out.println(i+1);
				break;
			}
		}	
		if(result)
			System.out.println(-1);
	}
}
