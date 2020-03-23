package basics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main28 {
/**		Huffuman树	（贪心 Huffuman）
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述
　　	Huffman树在编码中有着广泛的应用。在这里，我们只关心Huffman树的构造过程。
　　	给出一列数{pi}={p0, p1, …, pn-1}，用这列数构造Huffman树的过程如下：
　　	1. 找到{pi}中最小的两个数，设为pa和pb，将pa和pb从{pi}中删除掉，然后将它们的和加入到{pi}中。这个过程的费用记为pa + pb。
　　	2. 重复步骤1，直到{pi}中只剩下一个数。
　　	在上面的操作过程中，把所有的费用相加，就得到了构造Huffman树的总费用。
　　	本题任务：对于给定的一个数列，现在请你求出用该数列构造Huffman树的总费用。

　　	例如，对于数列{pi}={5, 3, 8, 2, 9}，Huffman树的构造过程如下：
　　		1. 找到{5, 3, 8, 2, 9}中最小的两个数，分别是2和3，从{pi}中删除它们并将和5加入，得到{5, 8, 9, 5}，费用为5。
　　		2. 找到{5, 8, 9, 5}中最小的两个数，分别是5和5，从{pi}中删除它们并将和10加入，得到{8, 9, 10}，费用为10。
　　		3. 找到{8, 9, 10}中最小的两个数，分别是8和9，从{pi}中删除它们并将和17加入，得到{10, 17}，费用为17。
　　		4. 找到{10, 17}中最小的两个数，分别是10和17，从{pi}中删除它们并将和27加入，得到{27}，费用为27。
　　		5. 现在，数列中只剩下一个数27，构造过程结束，总费用为5+10+17+27=59。
 * 输入格式
　　	输入的第一行包含一个正整数n（n<=100）。
　　	接下来是n个正整数，表示p0, p1, …, pn-1，每个数不超过1000。
 * 输出格式
　　	输出用这些数构造Huffman树的总费用。
 * 样例输入
	5
	5 3 8 2 9
 * 样例输出
	59
 * 内存	22.62MB
 * 时间	93ms
 * 解题思路 ：每次找出两个最小的数之后都需要将数列排序
 * 		 1.在pi{}中找到pa和pb将之删除，费用为pa+pb存放到另一个数列中
 * 		 2.重复1，直到pi中只剩一个数时
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		int p[] = new int[n];
		int ans=0,i=0;
		ArrayList<Integer> tans = new ArrayList<>();	//定义数列
		for(i=0;i<n;i++)
			p[i] = sca.nextInt();	//导入pi{}
		Arrays.sort(p);	//将p排序 升序
		for(i=1;i<n;i++) {
			tans.add(p[i] + p[i-1]);	//将pa和pb的费用添加到tans中
			p[i] = p[i-1] + p[i];		//pi=pa+pb
			Arrays.sort(p,i,n);		//继续将p从i到n排序 升序
		}
		for(i=0;i<tans.size();i++)	//计算总费用
			ans += tans.get(i);
		System.out.println(ans);	//输出费用
	}

}
