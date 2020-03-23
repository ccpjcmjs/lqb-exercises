package basics;
import java.util.Scanner;
public class Main27 {
/**		2n�ʺ�����	���˻ʺ����� ������
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 * ��������
����	����һ��n*n�����̣���������һЩλ�ò��ܷŻʺ�����Ҫ�������з���n���ڻʺ��n���׻ʺ�
	ʹ����������ڻʺ󶼲���ͬһ�С�ͬһ�л�ͬһ���Խ����ϣ�����������׻ʺ󶼲���ͬһ�С�ͬ
	һ�л�ͬһ���Խ����ϡ����ܹ��ж����ַŷ���nС�ڵ���8��
 * �����ʽ
����	����ĵ�һ��Ϊһ������n����ʾ���̵Ĵ�С��
����	������n�У�ÿ��n��0��1�����������һ������Ϊ1����ʾ��Ӧ��λ�ÿ��ԷŻʺ����һ������Ϊ0����ʾ��Ӧ��λ�ò����ԷŻʺ�
 * �����ʽ
����	���һ����������ʾ�ܹ��ж����ַŷ���
 * ��������
	4
	1 1 1 1
	1 1 1 1
	1 1 1 1
	1 1 1 1
 * �������
	2
 * ʱ��	140ms
 * �ڴ�	23.07MB
 * */
	public static int n = 0;	//�ʺ����� ����2Ϊ�׻ʺ�3Ϊ�ڻʺ�
	public static int count = 0;	//����
	public static int map[][] = new int [10][10];	//��Ÿ���������
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		for(int i=0;i<map.length;i++) {	//��ʼ����һ�е�һ��
			map[0][i] = -1;
			map[i][0] = -1;		
		}
		n = sca.nextInt();		//��ȡ�ʺ�����
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				map[i][j] = sca.nextInt();
		res(1,2);	//���ڵ�һ�з��ð׻ʺ�
		System.out.println(count);
	}
	public static void res(int row, int queen) {	//��row�з�queen�ʺ�
		if(row == n+1) { 		//�ж��Ƿ��Ѿ����һ������
			if(queen==2) {		//�������2˵���������ǰ׻ʺ�
				res(1,3);		//��ʼ�����ڻʺ�
			}
			else {		//�������3 ˵���Ѿ���ɺڰ׻ʺ�ķ��ã�������+1
				count++;
				return;
			}
		} 
		for(int col=1;col<=n;col++) {	//ÿ�з���һ���ʺ������ʺ��λ��
			if(isOK(row,col,queen)) {		//�ж��ڵ�row��col�ܷ����queen�ʺ�
				map[row][col] = queen; 		//���ûʺ�
				res(row+1,queen);		//�ݹ�
				map[row][col] = 1;		//����
			}
		}	
	}
	private static boolean isOK(int row, int col, int queen) {
		if(map[row][col]==0) return false;		//���Ϊ�㲻�ܷ��ûʺ� ����false
		if(queen==3) {			
			if(map[row][col]==2)		//�Ѿ������˰׻ʺ����ٷŷŻ�false
				return false;	
		}
		for(int i=1;i<row;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j]==queen) {
					if(j==col) return false;	//col�з����˻ʺ�
					if(row-i==Math.abs(col-j)) return false;  //�ж϶Խ������Ƿ��лʺ�
				}
			}
		}
		return true;
	}
}
