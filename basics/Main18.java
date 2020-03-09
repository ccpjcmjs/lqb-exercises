package basics;
import java.util.Scanner;
public class Main18 {
/**		矩形面积交(判断 线段交)
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述
　　	平面上有两个矩形，它们的边平行于直角坐标系的X轴或Y轴。对于每个矩形，我们给出它的一对相对顶点的坐标，请你编程算出两个矩形的交的面积。
 * 输入格式
　　	输入仅包含两行，每行描述一个矩形。
　　	在每行中，给出矩形的一对相对顶点的坐标，每个点的坐标都用两个绝对值不超过10^7的实数表示。
 * 输出格式
　　	输出仅包含一个实数，为交的面积，保留到小数后两位。
 * 样例输入
	1 1 3 3
	2 2 4 4
         样例输出
	1.00
 * 时间	109ms	
 * 内存	23.09MB
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		double x1 = sca.nextDouble();
		double y1 = sca.nextDouble();
		double x2 = sca.nextDouble();
		double y2 = sca.nextDouble();
		double x3 = sca.nextDouble();
		double y3 = sca.nextDouble();
		double x4 = sca.nextDouble();
		double y4 = sca.nextDouble();
		double n1,m1;	//交集左边界
		double n2,m2;   //交集右边界
		n1 = Math.max(Math.min(x1, x2), Math.min(x3, x4));
		m1 = Math.max(Math.min(y1, y2), Math.min(y3, y4));
		n2 = Math.min(Math.max(x1, x2), Math.max(x3, x4));
		m2 = Math.min(Math.max(y1, y2), Math.max(y3, y4));
		double length = n2 - n1 ;
		double wide = m2 - m1 ;
		double s= length * wide;
		if(length>0&&wide>0)
			System.out.printf("%.2f",s);		//保留小数点后两位
		else 
			System.out.println("0.00");			//当没有交集的时候为0
	}

}
