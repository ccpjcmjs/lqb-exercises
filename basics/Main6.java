package basics;
import java.util.Scanner;
/**		���������
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 *����������ֳ�Pascal�����Σ����ĵ�i+1����(a+b)i��չ��ʽ��ϵ������
  ����һ����Ҫ�����ǣ��������е�ÿ�����ֵ����������ϵ�������ӡ� 
 *�����������������ε�ǰ4�У�
   1

  1 1

 1 2 1

1 3 3 1 
 *����n���������ǰn�С�
 *�������һ����n�� 
 *�����������ε�ǰn�С�ÿһ�д���һ�еĵ�һ������ʼ����������м�ʹ��һ���ո�ָ����벻Ҫ��ǰ���������Ŀո�
 *1 <= n <= 34��
 *ʱ��78ms	
 *�ڴ�22.54MB
 * */
public class Main6 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0||i==j)
					arr[i][j] = 1;
				else
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}	
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}

}
