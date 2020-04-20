package introduction;
import java.util.Scanner;
public class Main11 {
/**		瓷砖铺放	(递归)
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述:
　　	有一长度为N(1<=Ｎ<=10)的地板，给定两种不同瓷砖：一种长度为1，另一种长度为2，
		数目不限。要将这个长度为N的地板铺满，一共有多少种不同的铺法？
　　	例如，长度为4的地面一共有如下5种铺法：
　　	4=1+1+1+1
　　	4=2+1+1
　　	4=1+2+1
　　	4=1+1+2
　　	4=2+2
　　		编程用递归的方法求解上述问题。
 * 输入格式:
　　	只有一个数N，代表地板的长度
 * 输出格式:
　　	输出一个数，代表所有不同的瓷砖铺放方法的总数
 * 样例输入:
	4
 * 样例输出:
	5
 * 时间:	62ms
 * 内存:	22.03MB
 * 解析：当长度为4时
 	   f(4)--f(3)--f(2)--f(1)--f(0)	 // 4=1+1+1+1
 	   f(4)--f(3)--f(2)--f(0)		// 4=1+1+2
 	   f(4)--f(3)--f(1)--f(0)		// 4=1+2+1
 	   f(4)--f(2)--f(1)--f(0)		// 4=2+1+1
 	   f(4)--f(2)--f(0)				// 4=2+2
 * */
	public static int a;
	public static int sum = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		func(a);
		System.out.println(sum);
	}
	private static void func(int x) {
		if(x==0) {
			sum++;
			return;
		}
		if(x<0)
			return;
		func(x-1);
		func(x-2);
	}

}
