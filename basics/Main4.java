package basics;
import java.util.Scanner;
/**		��������
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 * ����n�������ҳ���n���������ֵ����Сֵ���͡�
 *��һ��Ϊ����n����ʾ���ĸ�����
   �ڶ�����n������Ϊ������n������ÿ�����ľ���ֵ��С��10000�� 
 *������У�ÿ��һ����������һ�б�ʾ��Щ���е����ֵ���ڶ��б�ʾ��Щ���е���Сֵ�������б�ʾ��Щ���ĺ͡� 
 *1 <= n <= 10000��
 *ʱ��171ms	
 *�ڴ�34.07MB 
 * */
public class Main4 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<arr.length;i++ )
			arr[i] = sca.nextInt();
		int sum = 0;
		int max = -99999;
		int min = 99999;
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
				sum+=arr[i];			
			}
			else
				sum+=arr[i];
			if(arr[i]<min)
				min = arr[i];
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(sum);
	}
}