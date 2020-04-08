package introduction;
import java.util.Scanner;
public class Main9 {
/**		摆动序列	(动态规划)
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述:
 *	如果一个序列满足下面的性质，我们就将它称为摆动序列：
　　	1. 序列中的所有数都是不大于k的正整数；
　　	2. 序列中至少有两个数。
　　	3. 序列中的数两两不相等；
　　	4. 如果第i – 1个数比第i – 2个数大，则第i个数比第i – 2个数小；如果第i – 1个数比第i – 2个数小，则第i个数比第i – 2个数大。
　　	比如，当k = 3时，有下面几个这样的序列：
　　	1 2
　　	1 3
　　	2 1
　　	2 1 3
　　	2 3
　　	2 3 1
　　	3 1
　　	3 2
　　	一共有8种，给定k，请求出满足上面要求的序列的个数。
 * 输入格式
　　	输入包含了一个整数k。（k<=20）
 * 输出格式
　　	输出一个整数，表示满足要求的序列个数。
 * 样例输入
	3
 * 样例输出
	8
 * 内存	250ms
 * 时间	22.33MB
 * 解析 :如果第i – 1个数比第i – 2个数大，则第i个数比第i – 2个数小；
 * 	        如果第i – 1个数比第i – 2个数小，则第i个数比第i – 2个数大。 
 *    这句话给定了判断条件，设存放序列的数组为value[]。那么判断该序列是否满足摆动序列的条件即为
 *    (value[n-2]-value[n-3])*(value[n-1]-value[n-3])<0
 *    另外容易发现当序列长度为2时，原始序列中的任意两个数字都能构成摆动序列，所以当序列长度为2 时，当前结果直接+1。
 *    序列中的数两两不相等，建立一个数组isfind[]判断该数字是否遍历过。0为未遍历，1为已经遍历。
 *    要找出所有摆动序列，那么就是遍历整个1-k中的数，针对此题可以用dfs深度优先搜索来解决
 * */
	static int[] value;	//存放摆动序列
	static int[] isfind;  //标记是否遍历 遍历过的为1
	static int sum = 0; //摆动序列个数
	public static int k;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sca = new Scanner(System.in);
		k = sca.nextInt();
		//规律   摆动序列的个数=(2k-k-1)*2。
//		int sum = (int) Math.pow(2, k);
//		System.out.println((sum-k-1)*2);
		value = new int[k];
		isfind = new int[k+1];
		dfs(0);
		System.out.println(sum);
	}
	
	public static void dfs(int n) {	//深度优先搜索
		//n:value的索引值（长度为n的序列）
		if(n>1)
		{
			if(n==2)
				sum+=1;
			else if((value[n-2]-value[n-3])*(value[n-1]-value[n-3])<0)
				sum+=1;
			else		//不满足条件退出该搜索
				return;
		}
		for(int i=1;i<=k;i++)	//从1到k遍历
		{
			if(isfind[i]==0)
			{
				value[n]=i;
				isfind[i]=1;
				dfs(n+1);
				
				//回溯
				value[n] = 0;	
				isfind[i] = 0;
			}
		}
	}

}
