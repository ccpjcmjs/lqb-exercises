package basics;
import java.util.Scanner;
public class Main25 {
/**		����ȡ��	(��ά���� ѭ��)
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 * ��������
����	����ȡ�������ؾ���ı�ȡ��������ǰ������������ȡ���Ѿ�ȡ��������ת90�ȡ�һ��ʼλ�ھ������Ͻǣ��������¡�
 * �����ʽ
����	�����һ��������������200��������m, n����ʾ������к��С�������m��ÿ��n����������ʾ�������
 * �����ʽ
����	���ֻ��һ�У���mn������Ϊ����������ȡ���õ��Ľ������֮����һ���ո�ָ�����ĩ��Ҫ�ж���Ŀո�
 * ��������
	3 3
	1 2 3
	4 5 6
	7 8 9
        �������
	1 4 7 8 9 6 3 2 5
 * ��������
	3 2
	1 2
	3 4
	5 6
        �������
	1 3 5 6 4 2
 * ʱ��	515ms
 * �ڴ� 	49.89MB
 *		����˼· ��������ϵ���Ȼ���������������� ��p��q��m��nΪ�������ұ߽�
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int m = sca.nextInt();
		int n = sca.nextInt();
		String arr[][] = new String[m][n];
		for(int i=0;i<m;i++)	//����m��n�о���
			for(int j=0;j<n;j++)
				arr[i][j] = sca.next();
		int i=0,j=0,p=0,q=1;	
		int t = m*n;
		while(t>0) {
			for(;i<m&&t>0;i++) {
				System.out.print(arr[i][j]+" ");
				t--;
			}
			i--;	//����ѭ������ i = m ��i--�պõ������½�	
			j++;		//j++�����ظ�����Ǵ�����
			m--;		//�±߽��һ
			for(;j<n&&t>0;j++) {
				System.out.print(arr[i][j]+" ");
				t--;
			}
			j--;	// j--����n-1
		    i--;	
		    n--;	//�ұ߽��һ
			for(;i>p&&t>0;i--) {
				System.out.print(arr[i][j]+" ");
				t--;
			}
			p++;	//�ϱ߽��һ
			for(;j>q&&t>0;j--) {
				System.out.print(arr[i][j]+" ");
				t--;
			}
			q++;	//��߽��һ
		}
		
	}

}
