package basics;
import java.util.Scanner;
/**		闰年判断
 * 时间限制：1.0s   内存限制：256.0MB
 *
 *给定一个年份，判断这一年是不是闰年。
当以下情况之一满足时，这一年是闰年：
1. 年份是4的倍数而不是100的倍数；
2. 年份是400的倍数。
其他的年份都不是闰年。 
 * 输入包含一个整数y，表示当前的年份
 *输出一行，如果给定的年份是闰年，则输出yes，否则输出no。 
 *时间78ms	
 *内存22.06MB
 * */

public class Main1 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int y = sca.nextInt();
		if((y%4==0 && y%100!=0)||y%400==0)
			System.out.println("yes");
		else
			System.out.println("no");
	}

}
