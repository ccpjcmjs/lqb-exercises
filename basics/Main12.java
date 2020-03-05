package basics;
import java.util.Scanner;
/**		ʮ������ת�˽���
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 *����n��ʮ��������������������Ƕ�Ӧ�İ˽������� 
 *������ĵ�һ��Ϊһ��������n ��1<=n<=10����
����������n�У�ÿ��һ����0~9����д��ĸA~F��ɵ��ַ�������ʾҪת����ʮ��������������ÿ��ʮ�����������Ȳ�����100000�� 
 *���n�У�ÿ��Ϊ�����Ӧ�İ˽����������� 
 *��ע�⡿
���������ʮ��������������ǰ��0������012A��
��������İ˽�����Ҳ������ǰ��0�� 
��������
����2
����39
����123ABC
�������
����71
����4435274
����ʾ��
�����Ƚ�ʮ��������ת����ĳ������������ĳ������ת���ɰ˽��ơ�
ʱ��187ms
�ڴ�	48.71MB
* */
public class Main12 {
	static String[] Bin = {"0000","0001","0010","0011","0100","0101",
			"0110","0111","1000","1001","1010","1011","1100","1101",
			"1110","1111"};
	static String[] Oct = {"0","1","2","3","4","5","6","7"};
	
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();			//�����ַ�������
		String[] str = new String[n]; 	//����ʮ������������������
		
		for(int i=0;i<n;i++)			//����n��ʮ�������ַ���
			str[i] = sca.next();	
//			str[i] = sca.nextLine(); //�˴������nextLine���������ܹ���������
		
		for(int i=0;i<n;i++) {		
			String result = hexToBin(str[i]).toString();	//ʮ������ת��Ϊ������
			String octResult = binToOct(result);		//������ת��Ϊ�˽���
			if(octResult.startsWith("0"))		//String.startsWith(" ") ����ַ�����ָ����ǰ׺��ʼ���򷵻� true�����򷵻� false��
				octResult = octResult.substring(1);		//ȥ��ǰ׺ 0
			if(octResult.startsWith("0"))
				octResult = octResult.substring(1);
			System.out.println(octResult);
		}	
	}
	//ʮ������ת��Ϊ������
	private static StringBuffer hexToBin(String str) {
		StringBuffer result = new StringBuffer();
		int start = 0;
		int end = 1;
		for(int i=0;i<str.length();i++) {
			String st = str.substring(start,end);
			start++;
			end++;
			String st1 = transformHex(st);
			result.append(st1);
		}
		return result;
	}
	//������ת��Ϊ�˽���
	private static String binToOct(String str) {
		int start = 0;
		int end = 3;
		StringBuffer SB = new StringBuffer();
		if(str.length()%3==1)
			str = "00"+str;
		else if(str.length()%3==2)
			str = "0"+str;
		for(int i=0;i<str.length()/3;i++) {
			String st = str.substring(start,end);
			start += 3;
			end += 3;
			String st1 = transformBin(st);
			SB.append(st1);   //���ַ���st1��ӵ�SB��
		}
		return SB.toString();
	}
	private static String transformHex(String str) {		//��ʮ������ת��Ϊ�������ַ�
		String result = "";
		switch(str) {
			case "0" : result = Bin[0]; break;
			case "1" : result = Bin[1]; break;
			case "2" : result = Bin[2]; break;
			case "3" : result = Bin[3]; break;
			case "4" : result = Bin[4]; break;
			case "5" : result = Bin[5]; break;
			case "6" : result = Bin[6]; break;
			case "7" : result = Bin[7]; break;
			case "8" : result = Bin[8]; break;
			case "9" : result = Bin[9]; break;
			case "A" : result = Bin[10]; break;
			case "B" : result = Bin[11]; break;
			case "C" : result = Bin[12]; break;
			case "D" : result = Bin[13]; break;
			case "E" : result = Bin[14]; break;
			case "F" : result = Bin[15]; break;
			default : break;
		}
		return result;
	}

	private static String transformBin(String str) {	//��������ת��Ϊ�˽����ַ�
		String result = "";
		switch(str) {
			case "000" : result = Oct[0]; break;
			case "001" : result = Oct[1]; break;
			case "010" : result = Oct[2]; break;
			case "011" : result = Oct[3]; break;
			case "100" : result = Oct[4]; break;
			case "101" : result = Oct[5]; break;
			case "110" : result = Oct[6]; break;
			case "111" : result = Oct[7]; break;
			default : break;
		}
		return result;
	} 					    
}