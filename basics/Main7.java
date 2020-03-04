package basics;
/**		特殊的数字
 *时间限制：1.0s   内存限制：512.0MB 
 *153是一个非常特殊的数，它等于它的每位数字的立方和，即153=1*1*1+5*5*5+3*3*3。编程求所有满足这种条件的三位十进制数。 
 *按从小到大的顺序输出满足条件的三位十进制数，每个数占一行。 
 *时间 62ms
 *内存 	20.25MB
 * */
public class Main7 {

	public static void main(String[] args) {
		int a=0,b=0,c=0;
		for(int i=100;i<=999;i++) {
			a=i%10;		//个位
			b=i/10%10;	//十位
			c=i/100;	//百位
			if(i==(a*a*a+b*b*b+c*c*c))
				System.out.println(i);
		}
	}
}
