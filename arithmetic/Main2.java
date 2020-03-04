package arithmetic;
import java.util.Scanner;
/**		序列求和
 * 时间限制：1.0s   内存限制：256.0MB
 * 求1+2+3+...+n的值
 *输入包括一个整数n 
 *输出一行，包括一个整数，表示1+2+3+...+n的值
 *1 <= n <= 1,000,000,000
 *方法一
 *时间500ms
 *内存22.32MB
 *方法二
 *时间125ms
 *内存22.04MB
 * */
public class Main2 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		if(n>1000000000||n<1) {
			System.out.println("please imput 0and1000000001 between the two");
			n = sca.nextInt();
		}
		long sum = 0;				//方法二
		int i = 1;
		sum = (long)(i+n)*n/2;		//数学真的牛逼
//		for(int i = 1;i<=n;i++) {		//方法一
//			sum+=i;
//		}
		System.out.println(sum);
	}

}
