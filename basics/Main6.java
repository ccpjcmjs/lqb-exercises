package basics;
import java.util.Scanner;
/**		杨辉三角形
 * 时间限制：1.0s   内存限制：256.0MB
 *杨辉三角形又称Pascal三角形，它的第i+1行是(a+b)i的展开式的系数。　
  它的一个重要性质是：三角形中的每个数字等于它两肩上的数字相加。 
 *下面给出了杨辉三角形的前4行：
   1

  1 1

 1 2 1

1 3 3 1 
 *给出n，输出它的前n行。
 *输入包含一个数n。 
 *输出杨辉三角形的前n行。每一行从这一行的第一个数开始依次输出，中间使用一个空格分隔。请不要在前面输出多余的空格。
 *1 <= n <= 34。
 *时间78ms	
 *内存22.54MB
 * */
public class Main6 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0||i==j)
					arr[i][j] = 1;
				else
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}	
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}

}
