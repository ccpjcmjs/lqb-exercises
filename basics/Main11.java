package basics;
import java.util.*;
/**		ʮ������תʮ����
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 * �Ӽ�������һ��������8λ������ʮ���������ַ���������ת��Ϊ����ʮ�������������
����ע��ʮ���������е�10~15�ֱ��ô�д��Ӣ����ĸA��B��C��D��E��F��ʾ��
 * ��������
  FFFF
 *�������
  65535 
 *ʱ�� 78ms
 *�ڴ�	21.39MB
 * */
public class Main11 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();		//������ϣ��
        map.put("0",0);
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        map.put("5",5);
        map.put("6",6);
        map.put("7",7);
        map.put("8",8);
        map.put("9",9);
        map.put("A",10);
        map.put("B",11);
        map.put("C",12);
        map.put("D",13);
        map.put("E",14);
        map.put("F",15);
		Scanner sca = new Scanner(System.in);
		String str = sca.next();
		long DEC = 0;
		for(int i=0;i<str.length();i++) {
			DEC+=(map.get(str.substring(str.length()-i-1,str.length()-i)))*((long)Math.pow(16, i));
/*
 substring(,) ��ȡ�ַ���  Math.pow(n,m)����n��m�η� �� map.get()
 */			
		}
		System.out.println(DEC);
	}

}
