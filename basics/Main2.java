package basics;
/**		01�ִ�
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 *���ڳ���Ϊ5λ��һ��01����ÿһλ��������0��1��һ����32�ֿ��ܡ����ǵ�ǰ�����ǣ� 
00000
00001
00010
00011
00100 
 *�밴��С�����˳�������32��01��
 *������û������
 *���32�У�����С�����˳��ÿ��һ������Ϊ5��01�� 
 *ʱ��62ms	������һ��
 *�ڴ� 19.78MB
 *ʱ��62ms	����������
 *�ڴ� 20.32MB
 * */
public class Main2 {

	public static void main(String[] args) {   
//		System.out.println("00000");		//����һ ��������
//		System.out.println("00001");
//		System.out.println("00010");
//		System.out.println("00011");
//		System.out.println("00100");
//		System.out.println("00101");
//		System.out.println("00110");
//		System.out.println("00111");
//		System.out.println("01000");
//		System.out.println("01001");
//		System.out.println("01010");
//		System.out.println("01011");
//		System.out.println("01100");
//		System.out.println("01101");
//		System.out.println("01110");
//		System.out.println("01111");
//		System.out.println("10000");
//		System.out.println("10001");
//		System.out.println("10010");
//		System.out.println("10011");
//		System.out.println("10100");
//		System.out.println("10101");
//		System.out.println("10110");
//		System.out.println("10111");
//		System.out.println("11000");
//		System.out.println("11001");
//		System.out.println("11010");
//		System.out.println("11011");
//		System.out.println("11100");
//		System.out.println("11101");
//		System.out.println("11110");
//		System.out.println("11111");
		for(int i =0;i<32;i++) {			//������ ������ת��
			System.out.print(i%32/16);		//ʮ����ת��Ϊ�����ƹ���λ��0��31
			System.out.print(i%16/8);
			System.out.print(i%8/4);
			System.out.print(i%4/2);			
			System.out.println(i%2);
	
		}
	}

}
