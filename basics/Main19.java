package basics;
import java.util.Scanner;
public class Main19 {
/**	完美的代价(贪心算法)
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述
　　	回文串，是一种特殊的字符串，它从左往右读和从右往左读是一样的。小龙龙认为回文串才是完美的。
	现在给你一个串，它不一定是回文的，请你计算最少的交换次数使得该串变成一个完美的回文串。
　　	交换的定义是：交换两个相邻的字符
　　	例如mamad
　　	第一次交换 ad : mamda
　　	第二次交换 md : madma
　　	第三次交换 ma : madam (回文！完美！)
 * 输入格式
　　	第一行是一个整数N，表示接下来的字符串的长度(N <= 8000)
　　	第二行是一个字符串，长度为N.只包含小写字母
 * 输出格式
　　	如果可能，输出最少的交换次数。
　　	否则输出Impossible
 * 样例输入
	5
	mamad
 * 样例输出
	3
 * 时间	140ms	
 * 内存	23.38MB	
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		String s = sca.next();
		String[]str = s.split("");	//将字符串s转换为字符串数组str
		int oddNum = 0; //奇数个数
		int end = n-1;	//字符串最后一个字符
		int cnt = 0;	//交换次数

		for(int i=0;i<n/2+1;i++) {	//只需要循环左边的数据就可以
			for(int j=end;j>=i;j--) {
				if(i==j) {	//当没有找到该字符时
					if(n%2==0||oddNum==1) {
						System.out.println("Impossible");
						System.exit(0);		//终止程序
					}
					oddNum = 1;		//奇数个数加一
					cnt += n/2 - i;	
				}
				else if(str[i].equals(str[j])) {	//此处谨记字符串数组不能直接比较两个字符串  比如str[i]==str[j] 这样是错误的
					String swap;
					for(int k=j;k<end;k++) {
						swap = str[k];		//交换
						str[k] = str[k+1];
						str[k+1] = swap;
						cnt++;
					}
					end--;		
					break ;
				}
			}
		}
		System.out.println(cnt);	//输出循环次数
	}
}
