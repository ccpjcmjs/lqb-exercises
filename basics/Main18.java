package basics;
import java.util.Scanner;
public class Main18 {
/**		���������(�ж� �߶ν�)
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 * ��������
����	ƽ�������������Σ����ǵı�ƽ����ֱ������ϵ��X���Y�ᡣ����ÿ�����Σ����Ǹ�������һ����Զ�������꣬����������������εĽ��������
 * �����ʽ
����	������������У�ÿ������һ�����Ρ�
����	��ÿ���У��������ε�һ����Զ�������꣬ÿ��������궼����������ֵ������10^7��ʵ����ʾ��
 * �����ʽ
����	���������һ��ʵ����Ϊ���������������С������λ��
 * ��������
	1 1 3 3
	2 2 4 4
         �������
	1.00
 * ʱ��	109ms	
 * �ڴ�	23.09MB
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		double x1 = sca.nextDouble();
		double y1 = sca.nextDouble();
		double x2 = sca.nextDouble();
		double y2 = sca.nextDouble();
		double x3 = sca.nextDouble();
		double y3 = sca.nextDouble();
		double x4 = sca.nextDouble();
		double y4 = sca.nextDouble();
		double n1,m1;	//������߽�
		double n2,m2;   //�����ұ߽�
		n1 = Math.max(Math.min(x1, x2), Math.min(x3, x4));
		m1 = Math.max(Math.min(y1, y2), Math.min(y3, y4));
		n2 = Math.min(Math.max(x1, x2), Math.max(x3, x4));
		m2 = Math.min(Math.max(y1, y2), Math.max(y3, y4));
		double length = n2 - n1 ;
		double wide = m2 - m1 ;
		double s= length * wide;
		if(length>0&&wide>0)
			System.out.printf("%.2f",s);		//����С�������λ
		else 
			System.out.println("0.00");			//��û�н�����ʱ��Ϊ0
	}

}
