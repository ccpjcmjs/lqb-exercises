package basics;
import java.util.Scanner;
/**		时间转换
 * 时间限制：1.0s   内存限制：512.0MB
 * 		给定一个以秒为单位的时间t，要求用“<H>:<M>:<S>”的格式来表示这个时间。
 * <H>表示时间，<M>表示分钟，而<S>表示秒，它们都是整数且没有前导的“0”。例如，若
 * t=0，则应输出是“0:0:0”；若t=3661，则输出“1:1:1”。
 * 输入只有一行，是一个整数t（0<=t<=86399）。
 * 输出只有一行，是以“<H>:<M>:<S>”的格式所表示的时间，不包括引号。
 * 样例输入
	5436
 * 样例输出
	1:30:36
 * 时间  125ms	
 * 内存  21.50MB
 * */
public class Main14 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int t = sca.nextInt();
		int hour,minute,sec;
		hour = t/3600;		//小时
		minute = t%3600/60; //分钟
		sec = t%3600%60;	//秒钟
		System.out.println(hour+":"+minute+":"+sec);
	}
}