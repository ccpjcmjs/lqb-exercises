package basics;
import java.util.Scanner;
public class Main27 {
/**		2n皇后问题	（八皇后问题 搜索）
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述
　　	给定一个n*n的棋盘，棋盘中有一些位置不能放皇后。现在要向棋盘中放入n个黑皇后和n个白皇后，
	使任意的两个黑皇后都不在同一行、同一列或同一条对角线上，任意的两个白皇后都不在同一行、同
	一列或同一条对角线上。问总共有多少种放法？n小于等于8。
 * 输入格式
　　	输入的第一行为一个整数n，表示棋盘的大小。
　　	接下来n行，每行n个0或1的整数，如果一个整数为1，表示对应的位置可以放皇后，如果一个整数为0，表示对应的位置不可以放皇后。
 * 输出格式
　　	输出一个整数，表示总共有多少种放法。
 * 样例输入
	4
	1 1 1 1
	1 1 1 1
	1 1 1 1
	1 1 1 1
 * 样例输出
	2
 * 时间	140ms
 * 内存	23.07MB
 * */
	public static int n = 0;	//皇后数量 ，以2为白皇后，3为黑皇后
	public static int count = 0;	//计数
	public static int map[][] = new int [10][10];	//存放给定的棋盘
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		for(int i=0;i<map.length;i++) {	//初始化第一行第一列
			map[0][i] = -1;
			map[i][0] = -1;		
		}
		n = sca.nextInt();		//获取皇后数量
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				map[i][j] = sca.nextInt();
		res(1,2);	//先在第一行放置白皇后
		System.out.println(count);
	}
	public static void res(int row, int queen) {	//第row行放queen皇后
		if(row == n+1) { 		//判断是否已经完成一轮搜索
			if(queen==2) {		//如果等于2说明搜索的是白皇后
				res(1,3);		//开始搜索黑皇后
			}
			else {		//如果等于3 说明已经完成黑白皇后的放置，计数器+1
				count++;
				return;
			}
		} 
		for(int col=1;col<=n;col++) {	//每行放置一个皇后，搜索皇后的位置
			if(isOK(row,col,queen)) {		//判断在第row行col能否放置queen皇后
				map[row][col] = queen; 		//放置皇后
				res(row+1,queen);		//递归
				map[row][col] = 1;		//回溯
			}
		}	
	}
	private static boolean isOK(int row, int col, int queen) {
		if(map[row][col]==0) return false;		//如果为零不能放置皇后 返回false
		if(queen==3) {			
			if(map[row][col]==2)		//已经放置了白皇后不能再放放回false
				return false;	
		}
		for(int i=1;i<row;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j]==queen) {
					if(j==col) return false;	//col行放置了皇后
					if(row-i==Math.abs(col-j)) return false;  //判断对角线上是否有皇后
				}
			}
		}
		return true;
	}
}
