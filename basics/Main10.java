package basics;
import java.util.Scanner;
/**		ʮ����תʮ������
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 *ʮ�����������ڳ������ʱ����Ҫʹ�õ���һ�������ı�ʾ��ʽ������0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F��16�����ţ�
 *�ֱ��ʾʮ��������0��15��ʮ�����Ƶļ�����������16��1������ʮ������16��ʮ����������10����ʮ���Ƶ�17��ʮ��
 *��������11���Դ����ƣ�ʮ���Ƶ�30��ʮ����������1E��
��������һ���Ǹ�������������ʾ��ʮ�����Ƶ���ʽ�� 
 * �������һ���Ǹ�����a����ʾҪת��������0<=a<=2147483647
 *������������16���Ʊ�ʾ 
 *ʱ��93ms	
 *�ڴ�21.52MB
 * */
public class Main10 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		StringBuffer s = new StringBuffer();	//����StringBuffer��
		int a = sca.nextInt();
		String str;
		char []c = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		if(a==0)
			System.out.println(0);
		while(a!=0) {
			s = s.append(c[a%16]);	// append(char[] str) �� char����������ַ�����ʾ���ӵ������С�
			
			a/=16;
		}
		str = s.reverse().toString();	// reverse() ���¸��ַ����б����е��෴���档toString() ���ر�ʾ��˳���е����ݵ��ַ�����		
		System.out.println(str);
	}

}
