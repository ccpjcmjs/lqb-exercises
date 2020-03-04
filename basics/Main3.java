package basics;
import java.util.Scanner;
/**		字母图形
 * 时间限制：1.0s   内存限制：256.0MB
 *利用字母可以组成一些美丽的图形，下面给出了一个例子： 
ABCDEFG
BABCDEF
CBABCDE
DCBABCD
EDCBABC 
 *这是一个5行7列的图形，请找出这个图形的规律，并输出一个n行m列的图形
 *输入一行，包含两个整数n和m，分别表示你要输出的图形的行数的列数。
 *输出n行，每个m个字符，为你的图形 
 *1 <= n, m <= 26 
 *时间93ms		（方法一）
 *内存 21.59MB
 *时间125ms	(方法二)
 *内存22.12MB
 * */
public class Main3 {

	public static void main(String[] args) {
//		Scanner sca = new Scanner(System.in);		//  方法一 此方法要求m>=n
//		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		System.out.println("please imput n and m,n need >=1 ,m need <=26");
//		int n = sca.nextInt();
//		int m = sca.nextInt();
//		String str1 = str.substring(0,m);	//截取字符串从第0位到第m位
//		char[] str2 = str1.toCharArray();	//将字符串str1转换为字符数组str2
//		for(int i=0;i<n;i++) {
//			for(int k =i;k>0;k--)
//				System.out.print(str2[k]);
//			for(int j =i;j<m;j++) {
//				System.out.print(str2[j-i]);		
//			}
//		System.out.println();
//		
//		}
		Scanner sca = new Scanner(System.in);	//方法二
		int n = sca.nextInt();
		int m = sca.nextInt();
		char str;
		char[][] str1 = new char[26][26];
//		char[][] str1 = new char[n][m];   这样当n>m时会发生越界
		for(int i=0;i<n;i++) {		//将ABC...依次代入到数组中
			str = 'A';
			for(int j=i;j<m;j++) {
				str1[i][j] = str++;
				}
			str = 'A';
			for(int j=i-1;j>=0;j--) {	
				str1[i][j] = ++str;
			}			
		}
		for(int i=0;i<n;i++) {				//输出图形
			for(int j=0;j<m;j++) {
				System.out.print(str1[i][j]);
			}
			System.out.println();	
		}
	}
}
