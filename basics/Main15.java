package basics;
import java.util.Scanner;
//import java.util.concurrent.locks.Condition;
public class Main15 {
/**		�ַ����Ա�
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 * ��������
���������������ɴ�д��ĸ��Сд��ĸ��ɵ��ַ���(���Ƚ���1��10֮��)������֮��Ĺ�ϵ������4�����֮һ��
����1�������ַ������Ȳ��ȡ����� Beijing �� Hebei
����2�������ַ�������������ȣ�������Ӧλ���ϵ��ַ���ȫһ��(���ִ�Сд)������ Beijing �� Beijing
����3�������ַ���������ȣ���Ӧλ���ϵ��ַ����ڲ����ִ�Сд��ǰ���²��ܴﵽ��ȫһ�£�Ҳ����˵���������������2�������� beijing �� BEIjing
����4�������ַ���������ȣ����Ǽ�ʹ�ǲ����ִ�СдҲ����ʹ�������ַ���һ�¡����� Beijing �� Nanjing
��������ж�����������ַ���֮��Ĺ�ϵ�����������е���һ�࣬������������ı�š�
 * �����ʽ
����	�������У�ÿ�ж���һ���ַ���
 * �����ʽ
����	����һ�����֣������������ַ����Ĺ�ϵ���
 * ��������
	BEIjing
	beiJing
 * �������
	3
 * ʱ�� 62ms	
 * �ڴ� 21.96MB
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		String str = sca.next();
		String str1 = sca.next();
		int result=0;
		if(str.length()!=str1.length()) {
			result = 1;
			System.out.println(result);
		}
		else {
			if(str.equals(str1)) {	//str.equals(str1) �Ƚ�str��str1�����ȷ���true
				result = 2;
				System.out.println(result);
			}
			else{
				int point = 0;
				for(int i=0;i<str.length();i++) {
					char []st = str.toCharArray();
					char []st1 = str1.toCharArray();
					if(st[i]>=65&&st[i]<=90)		//��Сдȫ��ת��Ϊ��д
						st[i]+=32;					//�ַ���������str.toLowerCase();ת��Сд	
					if(st1[i]>=65&&st1[i]<=90)		//str.toUpperCase();ת����д
						st1[i]+=32;
					if(st[i]==st1[i])
						point++;
				}
				if(point==str.length()) {
					result = 3;
					System.out.println(result);
				}
				else {
					result = 4;
					System.out.println(result);
				}
			}
		}
	}
}
