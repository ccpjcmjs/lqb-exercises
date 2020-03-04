package basics;
import java.util.Scanner;
/**		 查找整数
 * 时间限制：1.0s   内存限制：256.0MB
 *给出一个包含n个整数的数列，问整数a在数列中的第一次出现是第几个。 
 *第一行包含一个整数n。
  第二行包含n个非负整数，为给定的数列，数列中的每个数都不大于10000。
  第三行包含一个整数a，为待查找的数。 
 *如果a在数列中出现了，输出它第一次出现的位置(位置从1开始编号)，否则输出-1 
 *1 <= n <= 1000。
 *时间140ms	
 *内存22.82MB
 * */
public class Main5 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
//		if(n>1000||n<1) {
//			System.out.println("n need 1 and 1000");
//			n = sca.nextInt();
//		}	
		int arr[] = new int[n];
		for(int i=0;i<arr.length;i++)
			arr[i] = sca.nextInt();
		int m = sca.nextInt();
		boolean result = true;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==m){
				result = false;
				System.out.println(i+1);
				break;
			}
		}	
		if(result)
			System.out.println(-1);
	}
}
