package arithmetic;
import java.util.Scanner;
/**		圆的面积
 * 	时间限制：1.0s   内存限制：256.0MB
 * 给定圆的半径r，求圆的面积
 *输入包含一个整数r，表示圆的半径 
 *输出一行，包含一个实数，四舍五入保留小数点后7位，表示圆的面积
 *1 <= r <= 10000
 * 时间140ms
 * 内存	22.25MB
 * */

public class Main3 {
	public static final double PI = 3.14159265358979323;
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int r = sca.nextInt();
		if(r>10000||r<1) {
			System.out.println("please imput 0and10001 between the two");
			r = sca.nextInt();
		}
			
		double area = 0;
		area = PI*r*r;
		System.out.println(String.format("%.7f", area));	//保留小数
	}

}
