package basics;
import java.util.Scanner;
/**		十六进制转八进制
 * 时间限制：1.0s   内存限制：512.0MB
 *给定n个十六进制正整数，输出它们对应的八进制数。 
 *　输入的第一行为一个正整数n （1<=n<=10）。
　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。 
 *输出n行，每行为输入对应的八进制正整数。 
 *【注意】
　　输入的十六进制数不会有前导0，比如012A。
　　输出的八进制数也不能有前导0。 
样例输入
　　2
　　39
　　123ABC
样例输出
　　71
　　4435274
【提示】
　　先将十六进制数转换成某进制数，再由某进制数转换成八进制。
时间187ms
内存	48.71MB
* */
public class Main12 {
	static String[] Bin = {"0000","0001","0010","0011","0100","0101",
			"0110","0111","1000","1001","1010","1011","1100","1101",
			"1110","1111"};
	static String[] Oct = {"0","1","2","3","4","5","6","7"};
	
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();			//输入字符串数量
		String[] str = new String[n]; 	//接收十六进制正整数的数组
		
		for(int i=0;i<n;i++)			//接收n个十六进制字符串
			str[i] = sca.next();	
//			str[i] = sca.nextLine(); //此处如果用nextLine（）；不能够换行输入
		
		for(int i=0;i<n;i++) {		
			String result = hexToBin(str[i]).toString();	//十六进制转换为二进制
			String octResult = binToOct(result);		//二进制转换为八进制
			if(octResult.startsWith("0"))		//String.startsWith(" ") 如果字符串以指定的前缀开始，则返回 true；否则返回 false。
				octResult = octResult.substring(1);		//去除前缀 0
			if(octResult.startsWith("0"))
				octResult = octResult.substring(1);
			System.out.println(octResult);
		}	
	}
	//十六进制转换为二进制
	private static StringBuffer hexToBin(String str) {
		StringBuffer result = new StringBuffer();
		int start = 0;
		int end = 1;
		for(int i=0;i<str.length();i++) {
			String st = str.substring(start,end);
			start++;
			end++;
			String st1 = transformHex(st);
			result.append(st1);
		}
		return result;
	}
	//二进制转换为八进制
	private static String binToOct(String str) {
		int start = 0;
		int end = 3;
		StringBuffer SB = new StringBuffer();
		if(str.length()%3==1)
			str = "00"+str;
		else if(str.length()%3==2)
			str = "0"+str;
		for(int i=0;i<str.length()/3;i++) {
			String st = str.substring(start,end);
			start += 3;
			end += 3;
			String st1 = transformBin(st);
			SB.append(st1);   //把字符串st1添加到SB中
		}
		return SB.toString();
	}
	private static String transformHex(String str) {		//将十六进制转换为二进制字符
		String result = "";
		switch(str) {
			case "0" : result = Bin[0]; break;
			case "1" : result = Bin[1]; break;
			case "2" : result = Bin[2]; break;
			case "3" : result = Bin[3]; break;
			case "4" : result = Bin[4]; break;
			case "5" : result = Bin[5]; break;
			case "6" : result = Bin[6]; break;
			case "7" : result = Bin[7]; break;
			case "8" : result = Bin[8]; break;
			case "9" : result = Bin[9]; break;
			case "A" : result = Bin[10]; break;
			case "B" : result = Bin[11]; break;
			case "C" : result = Bin[12]; break;
			case "D" : result = Bin[13]; break;
			case "E" : result = Bin[14]; break;
			case "F" : result = Bin[15]; break;
			default : break;
		}
		return result;
	}

	private static String transformBin(String str) {	//将二进制转换为八进制字符
		String result = "";
		switch(str) {
			case "000" : result = Oct[0]; break;
			case "001" : result = Oct[1]; break;
			case "010" : result = Oct[2]; break;
			case "011" : result = Oct[3]; break;
			case "100" : result = Oct[4]; break;
			case "101" : result = Oct[5]; break;
			case "110" : result = Oct[6]; break;
			case "111" : result = Oct[7]; break;
			default : break;
		}
		return result;
	} 					    
}