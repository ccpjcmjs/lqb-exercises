package basics;
import java.util.Scanner;
public class Main21 {
/**		Sine之舞	(字符串 递归 递推)

 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述
　　	最近FJ为他的奶牛们开设了数学分析课，FJ知道若要学好这门课，必须有一个好的三角函数基本功。
	所以他准备和奶牛们做一个“Sine之舞”的游戏，寓教于乐，提高奶牛们的计算能力。
　　	不妨设
　　	An=sin(1–sin(2+sin(3–sin(4+...sin(n))...)
　　	Sn=(...(A1+n)A2+n-1)A3+...+2)An+1
　　	FJ想让奶牛们计算Sn的值，请你帮助FJ打印出Sn的完整表达式，以方便奶牛们做题。
 * 输入格式
　　	仅有一个数：N<201。
 * 输出格式
　　	请输出相应的表达式Sn，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。
 * 样例输入
	3
         样例输出
	((sin(1)+3)sin(1–sin(2))+2)sin(1–sin(2+sin(3)))+1
 * 时间	125ms
 * 内存	21.62MB
 * */	
	static int N;
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int N = sca.nextInt();
		for(int i=0;i<N-1;i++) 
			System.out.print("(");
		Sn(1,N);
	}
	public static void An(int n,int k1) {
		int k=N-n+1;
		System.out.print("sin("+k1);
		if(n==1) {
			System.out.print(")");
			return;
		}
		if(k%2==1)
			System.out.print("-");
		else
			System.out.print("+");
		An(n-1,k+1);
		System.out.print(")");
	}
	public static void Sn(int x,int n) {
		N = x; 
		An(x,1);
		System.out.print("+"+n);
		if(n==1)
			return;
		System.out.print(")");
		Sn(x+1,n-1);
	}
}
