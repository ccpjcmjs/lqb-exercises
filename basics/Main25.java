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
 * ʱ��
 * �ڴ�
 * 
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int m = sca.nextInt();
		int n = sca.nextInt();
		String arr[][] = new String[m][n];
		for(int i=0;i<m;i++)	//����m��n�о���
			for(int j=0;j<n;j++)
				arr[i][j] = sca.next();
		int i=0,j=0,k=m-1,l=n-1; //��߽磬�ϱ߽磬�±߽磬�ұ߽�
		int t = m*n;
		while(t>0) {
			for(int i1=i;i1<m;i1++) {
				System.out.print(arr[i1][j]+" ");
				t--;
			}
			i++;
			j++;
			for(int j1=j;j1<n;j1++) {
				System.out.print(arr[k][j1]+" ");
				t--;
			}
			j++;
			k--;
			for(int k1=k;k1>=0;k1--) {
				System.out.print(arr[k1][l]+" ");
				t--;
			}
			k--;
			l--;
			for(int l1=l;l1>=i;l1--) {
				System.out.print(arr[j][l1]+" ");
				t--;
			}
			l--;
		}
		
	}

}
