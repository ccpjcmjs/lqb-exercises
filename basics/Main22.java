package basics;
import java.util.Scanner;
public class Main22 {
/**		 FJ���ַ���	(�ַ��� �ݹ�)
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 * ��������
����	FJ��ɳ����д������һЩ�ַ�����
����	A1 = ��A��
����	A2 = ��ABA��
����	A3 = ��ABACABA��
����	A4 = ��ABACABADABACABA��
����	�� ��
����	�����ҳ����еĹ��ɲ�д���е�����AN��
 * �����ʽ
����	����һ������N �� 26��
 * �����ʽ
����	�������Ӧ���ַ���AN����һ�����з�����������в��ú��ж���Ŀո���С��س�����
 * ��������
	3
         �������
	ABACABA
 * ʱ��	93ms
 * �ڴ�	22.55MB
 * 
 * 		������԰�ÿ�β��ΪAn = An-1 + 'A'+n-1 +An-1;��������ֱ�Ӿͳ�����
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int N = sca.nextInt();		//����N
		An(N);
	}
	public static void An(int n) {
		char a = 'A';	//�������ÿ���м���ַ�
		if(n==1) {	//��n=1ʱ�������ݹ�
			a+=n-1;
			System.out.print(a);
			return;		//�����ݹ�
		}	
		An(n-1);	
		a+=n-1;
		System.out.print(a);
		An(n-1);
	}
}
