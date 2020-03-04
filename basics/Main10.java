package basics;
import java.util.Scanner;
/**		十进制转十六进制
 * 时间限制：1.0s   内存限制：512.0MB
 *十六进制数是在程序设计时经常要使用到的一种整数的表示方式。它有0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F共16个符号，
 *分别表示十进制数的0至15。十六进制的计数方法是满16进1，所以十进制数16在十六进制中是10，而十进制的17在十六
 *进制中是11，以此类推，十进制的30在十六进制中是1E。
　　给出一个非负整数，将它表示成十六进制的形式。 
 * 输入包含一个非负整数a，表示要转换的数。0<=a<=2147483647
 *输出这个整数的16进制表示 
 *时间93ms	
 *内存21.52MB
 * */
public class Main10 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		StringBuffer s = new StringBuffer();	//调用StringBuffer类
		int a = sca.nextInt();
		String str;
		char []c = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		if(a==0)
			System.out.println(0);
		while(a!=0) {
			s = s.append(c[a%16]);	// append(char[] str) 将 char数组参数的字符串表示附加到此序列。
			
			a/=16;
		}
		str = s.reverse().toString();	// reverse() 导致该字符序列被序列的相反代替。toString() 返回表示此顺序中的数据的字符串。		
		System.out.println(str);
	}

}
