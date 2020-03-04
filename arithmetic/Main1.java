package arithmetic;
import java.util.Scanner;
/**
 * 	A+B问题
 * 时间限制：1.0s   内存限制：256.0MB
 *输入A、B，输出A+B 
 *输入的第一行包括两个整数，由空格分隔，分别表示A、B 
 *输出一行，包括一个整数，表示A+B的值
 *  -10000 <= A, B <= 10000 
 *时间156ms	
 *内存 22.01MB 
 * */
public class Main1 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int A = sca.nextInt();
		int B = sca.nextInt();
		if(A<-10000||B>10000) {
			System.out.println("please imput -10000 <= A, B <= 10000 ");
			A = sca.nextInt();
			B = sca.nextInt();			
		}
		int sum = A+B;
		System.out.println(sum);
	}

}
