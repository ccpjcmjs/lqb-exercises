package basics;
import java.util.Scanner;
public class Main20 {
/**		数的读法	（判断 函数）
 * 时间限制：1.0s   内存限制：512.0MB
 * 问题描述
　　	Tom教授正在给研究生讲授一门关于基因的课程，有一件事情让他颇为头疼：一条染色体上有成千上万个碱基对，它们从0开始编号，到几百万，几千万，甚至上亿。
　　	比如说，在对学生讲解第1234567009号位置上的碱基时，光看着数字是很难准确的念出来的。
　　	所以，他迫切地需要一个系统，然后当他输入12 3456 7009时，会给出相应的念法：
　　	十二亿三千四百五十六万七千零九
　　	用汉语拼音表示为
　　	shi er yi san qian si bai wu shi liu wan qi qian ling jiu
　　	这样他只需要照着念就可以了。
　　	你的任务是帮他设计这样一个系统：给定一个阿拉伯数字串，你帮他按照中文读写的规范转为汉语拼音字串，相邻的两个音节用一个空格符格开。
　　	注意必须严格按照规范，比如说“10010”读作“yi wan ling yi shi”而不
	是“yi wan ling shi”，“100000”读作“shi wan”而不是“yi shi wan”，“2000”读作“er qian”而不是“liang qian”。
 * 输入格式
　　	有一个数字串，数值大小不超过2,000,000,000。
 * 输出格式
　　	是一个由小写英文字母，逗号和空格组成的字符串，表示该数的英文读法。
 * 样例输入
	1234567009
 * 样例输出
	shi er yi san qian si bai wu shi liu wan qi qian ling jiu
 * 时间	125ms	
 * 内存	22.01MB
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		String num[] = {"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
		String wei[] = {"shi","bai","qian","wan","yi"};	
		String str[] = new String[20];	//存储结果
		int n = sca.nextInt();	//接收数值n
		boolean l[] = new boolean[2] ;
		int i=0,j=0,k;
		while(n>0) {
			k = n % 10;
			n = n / 10;
			if(k>0){
				if(i>=4&&!l[i/4-1]) {	//默认l[]为false  当i为4，8的时候进入为 wan，yi
					l[i/4-1] = true;  //第一次使l[0]为true 第二次使l[1]为true
					str[j++] = wei[i/4+2];
				}
				if(i%4!=0) {
					str[j++] = wei[i%4-1];		//传入数位
				}
				str[j++] = num[k];	//传入数值
			}
			else if(j>0&&str[j-1]!=num[0]) // k=0时 且最后一位不是0时加ling否则直接跳过 i++
				str[j++] = num[0];
			i++;
		}
		if(!(str[j-1]=="yi"&&j>1&&str[j-2]=="shi"))	//当 12这种情况读shi er而不是 yi shi er所以主要时出现这种情况时
			System.out.print(str[j-1]+" ");	//倒序输出 最后一次j++为空 所以从j-1开始
		for(int m=j-2;m>=0;m--)			
			System.out.print(str[m]+" ");
	}
}
