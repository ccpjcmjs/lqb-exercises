package basics;
import java.util.Scanner;
public class Main23 {
/**		芯片测试	(算法基础 统计 二维数组)

 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述
　　	有n（2≤n≤20）块芯片，有好有坏，已知好芯片比坏芯片多。
　　	每个芯片都能用来测试其他芯片。用好芯片测试其他芯片时，能正确给出被测试芯片是好还是坏。
        而用坏芯片测试其他芯片时，会随机给出好或是坏的测试结果（即此结果与被测试芯片实际的好坏无关）。
　　	给出所有芯片的测试结果，问哪些芯片是好芯片。
 * 输入格式
　　		输入数据第一行为一个整数n，表示芯片个数。
　　		第二行到第n+1行为n*n的一张表，每行n个数据。表中的每个数据为0或1，在这n行中的第i行第j列（1≤i, j≤n）
             的数据表示用第i块芯片测试第j块芯片时得到的测试结果，1表示好，0表示坏，i=j时一律为1（并不表示该芯片对本身的测试结果。芯片不能对本身进行测试）。
 * 输出格式
　　		按从小到大的顺序输出所有好芯片的编号
 * 样例输入
		3
		1 0 1
		0 1 0
		1 0 1
         样例输出
		1 3
 * 时间	93ms
 * 内存	22.07MB
 * 		解题思路 ：除去对角线上的不算 其它的当使用一个芯片测试其它芯片1大于等于n/2时该芯片为好芯片
 * 			         因为好的芯片多余坏的芯片
 * */
	
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		int arr[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sca.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			int s=0;
			for(int j=0;j<n;j++) {
				if(i != j)
					s += arr[j][i];
			}
			if(s >= n/2)
				System.out.print((i+1)+" ");
		}	
	}

}
