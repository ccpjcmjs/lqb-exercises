package basics;
import java.util.Scanner;
public class Main17 {
/**		 ����˷�
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 * ��������
��������һ��N�׾���A�����A��M���ݣ�M�ǷǸ�������
�������磺
����A =
����1 2
����3 4
����A��2����
����7 10
����15 22
 * �����ʽ
����	��һ����һ��������N��M��1<=N<=30, 0<=M<=5������ʾ����A�Ľ�����Ҫ�������
����	������N�У�ÿ��N������ֵ������10�ķǸ���������������A��ֵ
 * �����ʽ
����	�����N�У�ÿ��N����������ʾA��M��������Ӧ�ľ������ڵ���֮����һ���ո����
 * ��������
	2 2
	1 2
	3 4
 * �������
	7 10
	15 22
 * ʱ��	109ms	
 * �ڴ�	22.18MB
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int N = sca.nextInt();
		int M = sca.nextInt();
		long [][] a1 = new long[N][N];
		long [][] a2 = new long[N][N];
 	//����N�׾���
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				a1[i][j] = a2[i][j] = sca.nextInt();	
		if(M==0) {			//�����0���ݵ��ڵ�λ����E
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i==j)
						System.out.print("1 ");
					else
						System.out.print("0 ");
					}
				System.out.println();
			}
		}
		else if(M==1) {		//1���ݵ��ڱ���
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++)
					System.out.print(a1[i][j]+" ");
				System.out.println();
			}
		}	
		else {		//���о����M����
			for(int l=1;l<M;l++) {
				long tmp[][] = new long[N][N];
				for(int i=0;i<N;i++) {		//����Ķ��η�
					for(int j=0;j<N;j++) {
						long result = 0;
						for(int k=0;k<N;k++) {	
							result += a1[i][k] * a2[k][j];	             
						}
						tmp[i][j] = result;
					}
				}
				a2 = tmp;
			}	//�������
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++)
					System.out.print(a2[i][j]+" ");
				System.out.println();
			}
		}		
	}
}
