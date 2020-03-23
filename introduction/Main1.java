package introduction;
import java.util.Arrays;
import java.util.Scanner;
public class Main1 {
/**		区间k大数查询	(排序 查找)
 * 	时间限制：1.0s   内存限制：256.0MB
 * 	问题描述
	给定一个序列，每次询问序列中第l个数到第r个数中第K大的数是哪个。
 * 	输入格式
		第一行包含一个数n，表示序列长度。
		第二行包含n个正整数，表示给定的序列。
		第三个包含一个正整数m，表示询问个数。
		接下来m行，每行三个数l,r,K，表示询问序列从左往右第l个数到第r个数中，从大往小第K大的数是哪个。序列元素从1开始标号。
 * 	输出格式
		总共输出m行，每行一个数，表示询问的答案。
 * 	样例输入
	5
	1 2 3 4 5
	2
	1 5 2
	2 3 2
 * 	样例输出
	4
	2
 * 	数据规模与约定
	对于30%的数据，n,m<=100；
	对于100%的数据，n,m<=1000；
	保证k<=(r-l+1)，序列中的数<=106。
 *	 时间	281ms
 * 	内存	33.42MB
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sca.nextInt();
		int m = sca.nextInt();
		int l,r,k;
		for(int i=0;i<m;i++) {
			l = sca.nextInt();
			r = sca.nextInt();
			k = sca.nextInt(); 
			System.out.println(find(k,Arrays.copyOfRange(arr, l-1, r)));	
			//copyOfRange(int[] original, int from, int to)将指定数组的指定范围复制到新数组中。 
			}
		}
		private static int find(int k, int[] array) {
			Arrays.sort(array);		//升序排列
			return array[array.length - k];
		}
}
