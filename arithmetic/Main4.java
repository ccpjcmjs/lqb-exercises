package arithmetic;
import java.util.Scanner;
/**
	Fibonacci数列
	时间限制：1.0s   内存限制：256.0MB

   Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。
当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。
	输入包含一个整数n
	输出一行，包含一个整数，表示Fn除以10007的余数。
	1 <= n <= 1,000,000
	时间125ms
	内存22.15MB
*/
public class Main4 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
//		if(n>1000000) {
//			System.out.println("please imput 0and1000001 between the two");
//			n = sca.nextInt();
//		}
		long sum=0,result=0;
		long f1=1,f2=1;
		if(n==1||n==2)
			result=1;
		else {
			for(int i=3;i<=n;i++) {
				sum=f1+f2;
				f2=f1;
				f1=sum%10007;
			}
			result=sum%10007;
		}
		System.out.println(result);
	}
}
