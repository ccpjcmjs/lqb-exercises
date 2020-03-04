package basics;
import java.util.Scanner;
/**		数列特征
 * 时间限制：1.0s   内存限制：256.0MB
 * 给出n个数，找出这n个数的最大值，最小值，和。
 *第一行为整数n，表示数的个数。
   第二行有n个数，为给定的n个数，每个数的绝对值都小于10000。 
 *输出三行，每行一个整数。第一行表示这些数中的最大值，第二行表示这些数中的最小值，第三行表示这些数的和。 
 *1 <= n <= 10000。
 *时间171ms	
 *内存34.07MB 
 * */
public class Main4 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<arr.length;i++ )
			arr[i] = sca.nextInt();
		int sum = 0;
		int max = -99999;
		int min = 99999;
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
				sum+=arr[i];			
			}
			else
				sum+=arr[i];
			if(arr[i]<min)
				min = arr[i];
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(sum);
	}
}