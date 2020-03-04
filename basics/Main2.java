package basics;
/**		01字串
 * 时间限制：1.0s   内存限制：256.0MB
 *对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是： 
00000
00001
00010
00011
00100 
 *请按从小到大的顺序输出这32种01串
 *本试题没有输入
 *输出32行，按从小到大的顺序每行一个长度为5的01串 
 *时间62ms	（方法一）
 *内存 19.78MB
 *时间62ms	（方法二）
 *内存 20.32MB
 * */
public class Main2 {

	public static void main(String[] args) {   
//		System.out.println("00000");		//方法一 ：暴力法
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
		for(int i =0;i<32;i++) {			//方法二 ：进制转换
			System.out.print(i%32/16);		//十进制转换为二进制共五位从0到31
			System.out.print(i%16/8);
			System.out.print(i%8/4);
			System.out.print(i%4/2);			
			System.out.println(i%2);
	
		}
	}

}
