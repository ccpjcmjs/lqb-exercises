package introduction;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main12 {
/**		幂方分解	(递归)
 * 时间限制：1.0s   内存限制：256.0MB
 * 问题描述：
　　	任何一个正整数都可以用2的幂次方表示。例如：
　　	137=27+23+20 
　　	同时约定方次用括号来表示，即ab 可表示为a（b）。
　　	由此可知，137可表示为：
　　	2（7）+2（3）+2（0）
　　	进一步：7= 22+2+20 （21用2表示）
　　	3=2+20 
　　	所以最后137可表示为：
　　	2（2（2）+2+2（0））+2（2+2（0））+2（0）
　　	又如：
　	　1315=210 +28 +25 +2+1
	所以1315最后可表示为：
	　2（2（2+2（0））+2）+2（2（2+2（0）））+2（2（2）+2（0））+2+2（0）
 * 输入格式：
　　	输入包含一个正整数N（N<=20000），为要求分解的整数。
 * 输出格式：
　　	程序输出包含一行字符串，为符合约定的n的0，2表示（在表示中不能有空格）
 * 时间：	78ms
 * 内存：	20.41MB
 * 解析 ：
 * */
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String str = func(n);
		System.out.print(str);
	}
	private static String func(double n) {
		if(n==2)
			return "2";
		else if(n==1)
			return "2(0)";
		else if(n==0)
			return "0";
		for(int i=2;;i++)	//前面排除了2的1次方所以直接从2次方开始
		{
			if(Math.pow(2, i)>n) 	//如果2的i次方大于n
			{	String str;
				if(i - 1 == 1)
					str = "2";
				else
					str = "2("+func(i-1)+")";
				if(Math.pow(2, i-1)<n)
					str += "+" + func(n-Math.pow(2, i-1));
				return str;
			}
			else if(Math.pow(2, i)==n) 
			{
				String str = "2("+func(i)+")";
				return str;
			}
		}
		
	}
}
