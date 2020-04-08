package introduction;
import java.util.Scanner;
import java.util.Stack;

public class LCS {
/**		DP 最大公共子序列
 * 时间复杂度 O（m*n）
 * 通过一个二维数组b[m][n], 分别表示序列s1，序列s2 
 * 依次比较b[0][1]和b[1][0],b[2][0]...等等如果相等则该点值为左上元素值+1 则b[m][n]即为最大LCS(最大公共子序列)的长度
 * */
	static String s1;	
	static String s2;	
	static int b[][];	
	static int c[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sca = new Scanner(System.in);
		s1 = sca.next();
		s2 = sca.next();
		String str1[] = new String[s1.length()];
		String str2[] = new String[s2.length()];
		str1 = s1.split("");	//将字符串转换为字符串数组
		str2 = s2.split("");
		dpLCS(str1, str2);	
	}
	private static void dpLCS(String x[],String y[]) {
		int m = x.length+1;
		int n = y.length+1;
		b = new int[m][n];	//初始化二维数组b，c
		c = new int[m][n];
		for(int i=0;i<m-1;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(x[i].equals(y[j]))	//比较x[i]和y[i]如果相同返回true否则返回false
				{
					c[i+1][j+1] = c[i][j] + 1;
					b[i+1][j+1] = 1;
				}
				else if(c[i][j+1]>=c[i+1][j])
				{
					c[i+1][j+1] = c[i][j+1];
					b[i+1][j+1] = 2;
				}
				else
				{
					c[i+1][j+1] = c[i+1][j];
					b[i+1][j+1] = 3;
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
		Stack<String> same = new Stack<String>();		//创建栈same用来存放lcs
		Stack<Integer> same1 = new Stack<Integer>();   //栈same1，same2用来存放公共子序列的下标
		Stack<Integer> same2 = new Stack<Integer>();
		for(int i=m-1,j=n-1;i>=0&&j>=0;) 
		{
			if(b[i][j] == 1)
			{
				i--;j--;
				same.push(x[i]);	//将项目推送到此堆栈的顶部
				same1.push(i);
				same2.push(j);
			}
			else if(b[i][j] == 2)
					i--;
				else
					j--;
		}
		System.out.println(s1);	//输出字符串s1
		for(int i=0;i<m && !same1.empty();i++)	//输出s1的公共子串下标
		{
			if(i==same1.peek())	//if i与栈首相等
			{
				System.out.print(1);	//输出下标
				same1.pop();	//删除此堆栈顶部的对象。 
			}
			else
				System.out.print(" ");	
		}
		System.out.println();
		System.out.println(s2);		//输出字符串s2
		for(int i=0;i<n && !same2.empty();i++)	//输出s2公共子串下标
		{
			if(i==same2.peek())
			{
				System.out.print(1);
				same2.pop();
			}
			else
				System.out.print(" ");
		}
		System.out.println();
		System.out.print("The longest common subsequence is: ");
		while(!same.empty())	//如果栈不为空
		{
			System.out.print(same.peek());
			same.pop();	
		}
		System.out.println("\n"+"The length is : "+c[m-1][n-1]);	//输出最大公共子序列
	}
}
