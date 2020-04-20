package introduction;
import java.util.Scanner;
import java.util.TreeSet;

public class Main10 {
/**		集合运算	(数组 排序)
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述：
　　	给出两个整数集合A、B，求出他们的交集、并集以及B在A中的余集。
 * 输入格式：
　　	第一行为一个整数n，表示集合A中的元素个数。
　　	第二行有n个互不相同的用空格隔开的整数，表示集合A中的元素。
　　	第三行为一个整数m，表示集合B中的元素个数。
　　	第四行有m个互不相同的用空格隔开的整数，表示集合B中的元素。
　　	集合中的所有元素均为int范围内的整数，n、m<=1000。
 * 输出格式：
　　	第一行按从小到大的顺序输出A、B交集中的所有元素。
　　	第二行按从小到大的顺序输出A、B并集中的所有元素。
　　	第三行按从小到大的顺序输出B在A中的余集中的所有元素。
 * 样例输入：
	5
	1 2 3 4 5
	5
	2 4 6 8 10
 * 样例输出：
	2 4
	1 2 3 4 5 6 8 10
	1 3 5
 * 时间：	218ms
 * 内存：	30.19MB
 * 解析：TreeSet的元素具有唯一性，比较适合这种集合，且会对元素进行自然排序
 * */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in); 
		
		TreeSet<Integer> test_1 = new TreeSet<Integer>();
		TreeSet<Integer> test_2 = new TreeSet<Integer>();
		TreeSet<Integer> test_3 = new TreeSet<Integer>();
		int n = in.nextInt();
		while(n--!=0) {
			int a = in.nextInt();
			test_1.add(a);	//添加
		}
		int m = in.nextInt();
		while(m--!=0) {
			int a = in.nextInt();
			test_2.add(a);
		}
		boolean flag = true;	//用于输出首元素
		for(Integer temp:test_1)	//输出交集
		{
			if(test_2.contains(temp))	//如果test_2中存在temp返回true
			{
				if(flag)
					System.out.print(temp);
				else
					System.out.print(" "+temp);
				flag = false;
			}
		}
		System.out.println();
		flag = true;
		for(Integer temp:test_1) test_3.add(temp);
		for(Integer temp:test_2) test_3.add(temp);
		for(Integer temp:test_3)	//输出并集
		{
			if(flag)
				System.out.print(temp);
			else
				System.out.print(" "+temp);
			flag = false;
		}
		System.out.println();
		flag = true;
		for(Integer temp : test_1)	//输出B在A中的余集
		{
			if(!test_2.contains(temp))
			{
				if(flag)
					System.out.print(temp);
				else
					System.out.print(" "+temp);
				flag = false;
			}
		}
		System.out.println();
	}

}
