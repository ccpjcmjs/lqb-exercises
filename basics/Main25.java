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
 * 时间	515ms
 * 内存 	49.89MB
 *		解题思路 ：此题从上到下然后再向右向上向左 ，p，q，m，n为上左下右边界
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int m = sca.nextInt();
		int n = sca.nextInt();
		String arr[][] = new String[m][n];
		for(int i=0;i<m;i++)	//输入m行n列矩阵
			for(int j=0;j<n;j++)
				arr[i][j] = sca.next();
		int i=0,j=0,p=0,q=1;	
		int t = m*n;
		while(t>0) {
			for(;i<m&&t>0;i++) {
				System.out.print(arr[i][j]+" ");
				t--;
			}
			i--;	//上面循环结束 i = m ，i--刚好到矩阵下界	
			j++;		//j++避免重复输出角处的数
			m--;		//下边界减一
			for(;j<n&&t>0;j++) {
				System.out.print(arr[i][j]+" ");
				t--;
			}
			j--;	// j--等于n-1
		    i--;	
		    n--;	//右边界减一
			for(;i>p&&t>0;i--) {
				System.out.print(arr[i][j]+" ");
				t--;
			}
			p++;	//上边界加一
			for(;j>q&&t>0;j--) {
				System.out.print(arr[i][j]+" ");
				t--;
			}
			q++;	//左边界加一
		}
		
	}

}
