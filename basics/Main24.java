package basics;
import java.util.Scanner;
public class Main24 {
/**		龟兔赛跑预测	(数组 模拟)
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述
　　   	 话说这个世界上有各种各样的兔子和乌龟，但是研究发现，所有的兔子和乌龟都有一个共同的特点——喜欢赛跑。
            于是世界上各个角落都不断在发生着乌龟和兔子的比赛，小华对此很感兴趣，于是决定研究不同兔子和乌龟的赛
            跑。他发现，兔子虽然跑比乌龟快，但它们有众所周知的毛病——骄傲且懒惰，于是在与乌龟的比赛中，一旦任一
            秒结束后兔子发现自己领先t米或以上，它们就会停下来休息s秒。对于不同的兔子，t，s的数值是不同的，但
            是所有的乌龟却是一致——它们不到终点决不停止。
　　     然而有些比赛相当漫长，全程观看会耗费大量时间，而小华发现只要在每场比赛开始后记录下兔子和乌龟的数据
	——兔子的速度v1（表示每秒兔子能跑v1米），乌龟的速度v2，以及兔子对应的t，s值，以及赛道的长度l——
	就能预测出比赛的结果。但是小华很懒，不想通过手工计算推测出比赛的结果，于是他找到了你——清华大学计算机
	系的高才生——请求帮助，请你写一个程序，对于输入的一场比赛的数据v1，v2，t，s，l，预测该场比赛的结果。
 * 输入格式
　　	输入只有一行，包含用空格隔开的五个正整数v1，v2，t，s，l，其中(v1,v2<=100;t<=300;s<=10;l<=10000且为v1,v2的公倍数)
 * 输出格式
　　	输出包含两行，第一行输出比赛结果——一个大写字母“T”或“R”或“D”，分别表示乌龟获胜，兔子获胜，或者两者同时到达终点。
　　	第二行输出一个正整数，表示获胜者（或者双方同时）到达终点所耗费的时间（秒数）。
 * 样例输入
	10 5 5 2 20
         样例输出
	D
	4
 * 样例输入
	10 5 5 1 20
 * 样例输出
	R
	3
 * 样例输入
	10 5 5 3 20
         样例输出
	T
	4
 * 时间	109ms
 * 内存	22.04MB
 * 	  解题思路 ：按正常的数学思维 使用for循环循环条件为最长时间完成比赛计乌龟跑完的时间。
 * 		           每个循环乌龟和兔子的路程加上速度，然后根据条件对比，输入推出循环即可。
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int v1 = sca.nextInt();	//兔子速度
		int v2 = sca.nextInt(); //乌龟速度
		int t = sca.nextInt(); //兔子超过乌龟路程t
		int s = sca.nextInt(); //停留时间s
		int l = sca.nextInt();	//总路程
		int RpathLength = 0;	//兔子路程
		int TpathLength = 0;	//乌龟路程
		for(int i = 1;i<=l/v2;i++) {
			RpathLength += v1;	//乌龟兔子路程相加
			TpathLength += v2;	
			if(RpathLength - TpathLength >= t ) {		//判断兔子是否超过乌龟 t
				if(TpathLength!=l&&RpathLength == l) {	//此处排除当兔子刚好到终点就不用在停了
					System.out.println("R");
					System.out.println(i);	
					break;
				}
				TpathLength += s * v2;		//兔子停下 乌龟跑
				i += s;
			}
			if(TpathLength >= l&&RpathLength != l) {	//此处TL>=l 的原因是因为上面兔子停下的时候乌龟可能已经超过终点
				System.out.println("T");	
				System.out.println(l/v2);		//所以时间不是i 而是乌龟的实际时间
				break;
			}
			else if(RpathLength == l&&TpathLength != l) {				
				System.out.println("R");		//兔子获胜
				System.out.println(i);
				break;	
			}
			else if(RpathLength == l&&TpathLength == l) {
				System.out.println("D");	//同时到终点
				System.out.println(i);				
				break;	
			}

		}
	}

}
