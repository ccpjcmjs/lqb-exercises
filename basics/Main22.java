package basics;
import java.util.Scanner;
public class Main22 {
/**		 FJ的字符串	(字符串 递归)
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述
　　	FJ在沙盘上写了这样一些字符串：
　　	A1 = “A”
　　	A2 = “ABA”
　　	A3 = “ABACABA”
　　	A4 = “ABACABADABACABA”
　　	… …
　　	你能找出其中的规律并写所有的数列AN吗？
 * 输入格式
　　	仅有一个数：N ≤ 26。
 * 输出格式
　　	请输出相应的字符串AN，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。
 * 样例输入
	3
         样例输出
	ABACABA
 * 时间	93ms
 * 内存	22.55MB
 * 
 * 		此题可以把每次拆分为An = An-1 + 'A'+n-1 +An-1;这样这题直接就出来了
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int N = sca.nextInt();		//接收N
		An(N);
	}
	public static void An(int n) {
		char a = 'A';	//用于输出每次中间的字符
		if(n==1) {	//当n=1时，结束递归
			a+=n-1;
			System.out.print(a);
			return;		//结束递归
		}	
		An(n-1);	
		a+=n-1;
		System.out.print(a);
		An(n-1);
	}
}
