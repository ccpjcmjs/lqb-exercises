package basics;
import java.util.Scanner;
//import java.util.concurrent.locks.Condition;
public class Main15 {
/**		字符串对比
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述
　　给定两个仅由大写字母或小写字母组成的字符串(长度介于1到10之间)，它们之间的关系是以下4中情况之一：
　　1：两个字符串长度不等。比如 Beijing 和 Hebei
　　2：两个字符串不仅长度相等，而且相应位置上的字符完全一致(区分大小写)，比如 Beijing 和 Beijing
　　3：两个字符串长度相等，相应位置上的字符仅在不区分大小写的前提下才能达到完全一致（也就是说，它并不满足情况2）。比如 beijing 和 BEIjing
　　4：两个字符串长度相等，但是即使是不区分大小写也不能使这两个字符串一致。比如 Beijing 和 Nanjing
　　编程判断输入的两个字符串之间的关系属于这四类中的哪一类，给出所属的类的编号。
 * 输入格式
　　	包括两行，每行都是一个字符串
 * 输出格式
　　	仅有一个数字，表明这两个字符串的关系编号
 * 样例输入
	BEIjing
	beiJing
 * 样例输出
	3
 * 时间 62ms	
 * 内存 21.96MB
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		String str = sca.next();
		String str1 = sca.next();
		int result=0;
		if(str.length()!=str1.length()) {
			result = 1;
			System.out.println(result);
		}
		else {
			if(str.equals(str1)) {	//str.equals(str1) 比较str和str1如果相等返回true
				result = 2;
				System.out.println(result);
			}
			else{
				int point = 0;
				for(int i=0;i<str.length();i++) {
					char []st = str.toCharArray();
					char []st1 = str1.toCharArray();
					if(st[i]>=65&&st[i]<=90)		//将小写全部转换为大写
						st[i]+=32;					//字符串可以用str.toLowerCase();转换小写	
					if(st1[i]>=65&&st1[i]<=90)		//str.toUpperCase();转换大写
						st1[i]+=32;
					if(st[i]==st1[i])
						point++;
				}
				if(point==str.length()) {
					result = 3;
					System.out.println(result);
				}
				else {
					result = 4;
					System.out.println(result);
				}
			}
		}
	}
}
