package introduction;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main42{
	/**		送分啦
	 * 这题想得分吗？想，请输出“yes”；不想，请输出“no”。
	 * 输出包括一行，为“yes”或“no”。
	 * */
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		out.println("yes");
		out.flush();
	}
}
