package basics;
import java.util.Scanner;
public class Main16 {
/**	分解质因数
 * 时间限制：1.0s   内存限制：512.0MB
 * 求出区间[a,b]中所有整数的质因数分解。
 * 输入格式
　　	输入两个整数a，b。
 * 输出格式
　　	每行输出一个数的分解，形如k=a1*a2*a3...(a1<=a2<=a3...，k也是从小到大的)(具体可看样例)
 * 样例输入
	3 10
 * 样例输出
	3=3
	4=2*2
	5=5
	6=2*3
	7=7
	8=2*2*2
	9=3*3
	10=2*5
 * 提示
　　先筛出所有素数，然后再分解。
 * 2<=a<=b<=10000
 * 时间  328ms	
 * 内存  33.12MB
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int start = sca.nextInt();
		int end = sca.nextInt();
		for(int i=start;i<=end;i++) {
			System.out.println(i+"="+reu(i).substring(1));
		}
	}
	private static String reu(int n) {
//		String str = "";
		for(int i=2;i<n;i++) {
			if(n%i==0)
				return "*"+i+reu(n/i);		//递归调用
		}
		return "*"+n;
	}

}
