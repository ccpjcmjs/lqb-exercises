package introduction;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main42{
	/**		�ͷ���
	 * ������÷����룬�������yes�������룬�������no����
	 * �������һ�У�Ϊ��yes����no����
	 * */
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		out.println("yes");
		out.flush();
	}
}
