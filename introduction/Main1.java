package introduction;
import java.util.Arrays;
import java.util.Scanner;
public class Main1 {
/**		����k������ѯ	(���� ����)
 * 	ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 * 	��������
	����һ�����У�ÿ��ѯ�������е�l��������r�����е�K��������ĸ���
 * 	�����ʽ
		��һ�а���һ����n����ʾ���г��ȡ�
		�ڶ��а���n������������ʾ���������С�
		����������һ��������m����ʾѯ�ʸ�����
		������m�У�ÿ��������l,r,K����ʾѯ�����д������ҵ�l��������r�����У��Ӵ���С��K��������ĸ�������Ԫ�ش�1��ʼ��š�
 * 	�����ʽ
		�ܹ����m�У�ÿ��һ��������ʾѯ�ʵĴ𰸡�
 * 	��������
	5
	1 2 3 4 5
	2
	1 5 2
	2 3 2
 * 	�������
	4
	2
 * 	���ݹ�ģ��Լ��
	����30%�����ݣ�n,m<=100��
	����100%�����ݣ�n,m<=1000��
	��֤k<=(r-l+1)�������е���<=106��
 *	 ʱ��	281ms
 * 	�ڴ�	33.42MB
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sca.nextInt();
		int m = sca.nextInt();
		int l,r,k;
		for(int i=0;i<m;i++) {
			l = sca.nextInt();
			r = sca.nextInt();
			k = sca.nextInt(); 
			System.out.println(find(k,Arrays.copyOfRange(arr, l-1, r)));	
			//copyOfRange(int[] original, int from, int to)��ָ�������ָ����Χ���Ƶ��������С� 
			}
		}
		private static int find(int k, int[] array) {
			Arrays.sort(array);		//��������
			return array[array.length - k];
		}
}
