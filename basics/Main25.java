package basics;
import java.util.Scanner;
public class Main25 {
/**		回形取数	(二维数组 循环)
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述
　　	回形取数就是沿矩阵的边取数，若当前方向上无数可取或已经取过，则左转90度。一开始位于矩阵左上角，方向向下。
 * 输入格式
　　	输入第一行是两个不超过200的正整数m, n，表示矩阵的行和列。接下来m行每行n个整数，表示这个矩阵。
 * 输出格式
　　	输出只有一行，共mn个数，为输入矩阵回形取数得到的结果。数之间用一个空格分隔，行末不要有多余的空格。
 * 样例输入
	3 3
	1 2 3
	4 5 6
	7 8 9
        样例输出
	1 4 7 8 9 6 3 2 5
 * 样例输入
	3 2
	1 2
	3 4
	5 6
        样例输出
	1 3 5 6 4 2
 * 时间
 * 内存
 * 
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int m = sca.nextInt();
		int n = sca.nextInt();
		String arr[][] = new String[m][n];
		for(int i=0;i<m;i++)	//输入m行n列矩阵
			for(int j=0;j<n;j++)
				arr[i][j] = sca.next();
		int i=0,j=0,k=m-1,l=n-1; //左边界，上边界，下边界，右边界
		int t = m*n;
		while(t>0) {
			for(int i1=i;i1<m;i1++) {
				System.out.print(arr[i1][j]+" ");
				t--;
			}
			i++;
			j++;
			for(int j1=j;j1<n;j1++) {
				System.out.print(arr[k][j1]+" ");
				t--;
			}
			j++;
			k--;
			for(int k1=k;k1>=0;k1--) {
				System.out.print(arr[k1][l]+" ");
				t--;
			}
			k--;
			l--;
			for(int l1=l;l1>=i;l1--) {
				System.out.print(arr[j][l1]+" ");
				t--;
			}
			l--;
		}
		
	}

}
