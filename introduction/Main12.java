package introduction;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main12 {
/**		�ݷ��ֽ�	(�ݹ�)
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 * ����������
����	�κ�һ����������������2���ݴη���ʾ�����磺
����	137=27+23+20 
����	ͬʱԼ����������������ʾ����ab �ɱ�ʾΪa��b����
����	�ɴ˿�֪��137�ɱ�ʾΪ��
����	2��7��+2��3��+2��0��
����	��һ����7= 22+2+20 ��21��2��ʾ��
����	3=2+20 
����	�������137�ɱ�ʾΪ��
����	2��2��2��+2+2��0����+2��2+2��0����+2��0��
����	���磺
��	��1315=210 +28 +25 +2+1
	����1315���ɱ�ʾΪ��
	��2��2��2+2��0����+2��+2��2��2+2��0������+2��2��2��+2��0����+2+2��0��
 * �����ʽ��
����	�������һ��������N��N<=20000����ΪҪ��ֽ��������
 * �����ʽ��
����	�����������һ���ַ�����Ϊ����Լ����n��0��2��ʾ���ڱ�ʾ�в����пո�
 * ʱ�䣺	78ms
 * �ڴ棺	20.41MB
 * ���� ��
 * */
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String str = func(n);
		System.out.print(str);
	}
	private static String func(double n) {
		if(n==2)
			return "2";
		else if(n==1)
			return "2(0)";
		else if(n==0)
			return "0";
		for(int i=2;;i++)	//ǰ���ų���2��1�η�����ֱ�Ӵ�2�η���ʼ
		{
			if(Math.pow(2, i)>n) 	//���2��i�η�����n
			{	String str;
				if(i - 1 == 1)
					str = "2";
				else
					str = "2("+func(i-1)+")";
				if(Math.pow(2, i-1)<n)
					str += "+" + func(n-Math.pow(2, i-1));
				return str;
			}
			else if(Math.pow(2, i)==n) 
			{
				String str = "2("+func(i)+")";
				return str;
			}
		}
		
	}
}
