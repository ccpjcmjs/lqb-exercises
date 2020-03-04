package basics;
import java.util.Scanner;
/**			 特殊回文数
 *时间限制：1.0s   内存限制：512.0MB
 *123321是一个非常特殊的数，它从左边读和从右边读是一样的。
　　输入一个正整数n， 编程求所有这样的五位和六位十进制数，满足各位数字之和等于n 。 
 *输入一行，包含一个正整数n。 
 *按从小到大的顺序输出满足条件的整数，每个整数占一行。 
 *样例输入
52
样例输出
899998
989989
998899
 *1<=n<=54。 
 *时间93ms	
 *内存21.69MB
 * */
public class Main9 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		int n1=0,n2=0,n3=0,n4=0,n5=0,n6=0;
		for(int i=10000;i<=999999;i++) {
			if(i<=99999) {
				n1=i%10;
				n2=i%100/10;
				n3=i%1000/100;
				n4=i%10000/1000;
				n5=i/10000;
				if((n1==n5&&n2==n4)&&n==(n1+n2+n3+n4+n5))
					System.out.println(i);
			}
			else{
				n1=i%10;	//个位
				n2=i%100/10;
				n3=i%1000/100;
				n4=i%10000/1000;
				n5=i%100000/10000;
				n6=i/100000;	//第一位
				if((n1==n6&&n2==n5&&n3==n4)&&n==(n1+n2+n3+n4+n5+n6))
					System.out.println(i);
			}	
		}
	}

}
