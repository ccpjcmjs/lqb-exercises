package basics;
import java.util.*;
/**		十六进制转十进制
 * 时间限制：1.0s   内存限制：512.0MB
 * 从键盘输入一个不超过8位的正的十六进制数字符串，将它转换为正的十进制数后输出。
　　注：十六进制数中的10~15分别用大写的英文字母A、B、C、D、E、F表示。
 * 样例输入
  FFFF
 *样例输出
  65535 
 *时间 78ms
 *内存	21.39MB
 * */
public class Main11 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();		//创建哈希表
        map.put("0",0);
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        map.put("5",5);
        map.put("6",6);
        map.put("7",7);
        map.put("8",8);
        map.put("9",9);
        map.put("A",10);
        map.put("B",11);
        map.put("C",12);
        map.put("D",13);
        map.put("E",14);
        map.put("F",15);
		Scanner sca = new Scanner(System.in);
		String str = sca.next();
		long DEC = 0;
		for(int i=0;i<str.length();i++) {
			DEC+=(map.get(str.substring(str.length()-i-1,str.length()-i)))*((long)Math.pow(16, i));
/*
 substring(,) 截取字符串  Math.pow(n,m)返回n的m次方 ， map.get()
 */			
		}
		System.out.println(DEC);
	}

}
