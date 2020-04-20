package introduction;
import java.util.Scanner;
public class Main15 {
/**		旅行家的预算	(贪心)
 * 时间限制：1.0s   内存限制：256.0MB
 * 问题描述:
　　	一个旅行家想驾驶汽车以最少的费用从一个城市到另一个城市（假设出发时油箱是空的）。
	给定两个城市之间的距离D1、汽车油箱的容量C（以升为单位）、每升汽油能行驶的距离D2、
	出发点每升汽油价格P和沿途油站数N（N可以为零），油站i离出发点的距离Di、每升汽油价格
	Pi（i=1，2，……N）。计算结果四舍五入至小数点后两位。如果无法到达目的地，则输出“No Solution”。
 * 输入格式:
　　	第一行为4个实数D1、C、D2、P与一个非负整数N；
　　	接下来N行，每行两个实数Di、Pi。
 * 输出格式:
　　	如果可以到达目的地，输出一个实数（四舍五入至小数点后两位），表示最小费用；
	否则输出“No Solution”（不含引号）。
 * 样例输入:
	275.6 11.9 27.4 2.8 2
	102.0 2.9
	220.0 2.2
 * 样例输出:
	26.95
 * 内存	109ms
 * 时间	23.70MB
 * 解析:	根据贪心思想，能省钱就省钱 ，即为有便宜的油用便宜的油没有便宜的油就把当前的便宜油用完用更贵的
 		就比如，每个加油站都把油加满，假如油不会融合到一起，都是先用便宜的油，知道走完整段路程，计算用过的油的费用。
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		double D1 = in.nextDouble();	//两个城市之间的距离
		double C = in.nextDouble();	//汽车油箱的容量C（以升为单位）
		double D2 = in.nextDouble();	//每升汽油能行驶的距离
		double p = in.nextDouble();	//出发点每升汽油价格
		
		int N = in.nextInt();	//沿途油站数N
		double []D = new double[N+2];	//离出发点的距离
		double []Pi = new double[N+2];	//每个站点的油价
		double MaxDistance = D2*C; //油箱装满可跑路程
		//初始化距离和油价
		D[0] = 0;Pi[0] = p;
		D[N+1] = D1; Pi[N+1] = 0;
		for(int i=1;i<=N;i++)
		{
			D[i] = in.nextDouble();
			Pi[i] = in.nextDouble();
		}
		
		double fee = 0;
		double remain = 0;
		//判断是否无法到达
		for(int i=0;i<=N;i++) {
			if(D[i+1]-D[i]>MaxDistance)
			{
				System.out.println("No Solution");
				return ;
			}
		}
		//可以到达
		int i=0;
		while(i<=N)
		{
			int j;
			for(j=i+1;j<=N+1;j++)
			{
				if(D[j]-D[i]>MaxDistance)
				{
					j-=1;	//最大可到达距离到不了j只能到j-1
					break;
				}
				if(Pi[j]<=Pi[i])
					break;	//找到更便宜的加油站
			}
			
			if(Pi[j]<=Pi[i])	//已经找到了下一个更便宜的加油站
			{
				fee +=((D[j]-D[i])/D2 - remain)*Pi[i]; //更新费用
				remain = 0; //更新到下一个加油站剩余油量
			}
			else //没有找到更便宜的加油站 加满油
			{
				fee += (C-remain) * Pi[i];
				remain = C-(D[j] - D[i])/D2;
			}
			
			i=j;//前往下一个加油站
		}
		System.out.println(String.format("%.2f", fee));
	}

}
