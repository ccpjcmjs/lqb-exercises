package basics;
import java.util.Scanner;
public class Main17 {
/**		 矩阵乘法
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述
　　给定一个N阶矩阵A，输出A的M次幂（M是非负整数）
　　例如：
　　A =
　　1 2
　　3 4
　　A的2次幂
　　7 10
　　15 22
 * 输入格式
　　	第一行是一个正整数N、M（1<=N<=30, 0<=M<=5），表示矩阵A的阶数和要求的幂数
　　	接下来N行，每行N个绝对值不超过10的非负整数，描述矩阵A的值
 * 输出格式
　　	输出共N行，每行N个整数，表示A的M次幂所对应的矩阵。相邻的数之间用一个空格隔开
 * 样例输入
	2 2
	1 2
	3 4
 * 样例输出
	7 10
	15 22
 * 时间	109ms	
 * 内存	22.18MB
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int N = sca.nextInt();
		int M = sca.nextInt();
		long [][] a1 = new long[N][N];
		long [][] a2 = new long[N][N];
 	//接收N阶矩阵
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				a1[i][j] = a2[i][j] = sca.nextInt();	
		if(M==0) {			//矩阵的0次幂等于单位矩阵E
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i==j)
						System.out.print("1 ");
					else
						System.out.print("0 ");
					}
				System.out.println();
			}
		}
		else if(M==1) {		//1次幂等于本身
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++)
					System.out.print(a1[i][j]+" ");
				System.out.println();
			}
		}	
		else {		//进行矩阵的M次幂
			for(int l=1;l<M;l++) {
				long tmp[][] = new long[N][N];
				for(int i=0;i<N;i++) {		//矩阵的二次方
					for(int j=0;j<N;j++) {
						long result = 0;
						for(int k=0;k<N;k++) {	
							result += a1[i][k] * a2[k][j];	             
						}
						tmp[i][j] = result;
					}
				}
				a2 = tmp;
			}	//输出矩阵
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++)
					System.out.print(a2[i][j]+" ");
				System.out.println();
			}
		}		
	}
}
