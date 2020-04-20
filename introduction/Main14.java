package introduction;
import java.util.Scanner;
public class Main14 {
/**		回文数	(模拟 高精度计算)
 * 时间限制：1.0s   内存限制：256.0MB
 * 问题描述:
　　	若一个数（首位不为零）从左向右读与从右向左读都一样，我们就将其称之为回文数。
　　	例如：给定一个10进制数56，将56加65（即把56从右向左读），得到121是一个回文数。
　　	又如：对于10进制数87：
　　	STEP1：87+78 = 165 STEP2：165+561 = 726
　　	STEP3：726+627 = 1353 STEP4：1353+3531 = 4884
　　	在这里的一步是指进行了一次N进制的加法，上例最少用了4步得到回文数4884。
　　	写一个程序，给定一个N（2<=N<=10或N=16）进制数M（其中16进制数字为0-9与A-F），
		求最少经过几步可以得到回文数。
　　	如果在30步以内（包含30步）不可能得到回文数，则输出“Impossible!”
 * 输入格式:
　　	两行，N与M
 * 输出格式:
　　	如果能在30步以内得到回文数，输出“STEP=xx”（不含引号），其中xx是步数；
	否则输出一行”Impossible!”（不含引号）
 * 样例输入:
	9
	87
 * 样例输出:
	STEP=6
 * 时间	78ms
 * 内存	22.12MB
 * 解析:	使用Long方法中的parseLong来对不同进制的数转换然后相加
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String M = in.next();
		int index = 0;
		while(!palnum(M))
		{
			index++;
			if(index > 30)
				break;
			long tempa = Long.parseLong(M, N);	//将N进制M转换为带符号的十进制long 
			String st = ""; //存放倒过来后的M
			for(int i=M.length()-1;i>=0;i--)
			{
				String str = String.valueOf(M.charAt(i));
				st+=str;
			}
			long tempb = Long.parseLong(st, N);  //将M的回文转换为long
			long sum = tempa + tempb;		//相加
			M = Long.toString(sum,N);		//将sum转换为N进制的字符串类型
		}
		if(index>30)
			System.out.println("Impossible!");
		else
			System.out.println("STEP="+index);
	}
	public static boolean palnum(String s) {
		boolean bo = true;
		for(int i=0;i<s.length()/2;i++)
		{
			if(s.charAt(i) != s.charAt(s.length()-1-i))	//将字符串的首尾字符进行对比
			{
				bo = false;
				break;
			}
		}
		return bo;
	}
}
