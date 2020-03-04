package basics;
/**		回文数
 *时间限制：1.0s   内存限制：512.0MB 
 *1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。 
 *按从小到大的顺序输出满足条件的四位十进制数。 
 *时间46ms	
 *内存20.24MB
 * */
public class Main8 {

	public static void main(String[] args) {
		int a=0,b=0,c=0,d=0,test=0;
		for(int i=1000;i<=9999;i++) {
			a=i/1000;		//个位
			b=i/100%10;		//十位
			c=i%100/10;		//百位
			d=i%10;			//千位
			if(a==d&&b==c)
				System.out.println(i);
		}

	}

}
