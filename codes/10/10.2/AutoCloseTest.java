import java.io.*;
/**
 * Description:
 * <br/>網站: <a href="http://www.crazyit.org">瘋狂Java聯盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class AutoCloseTest
{
	public static void main(String[] args)
		throws IOException
	{
		try (
			// 宣告、初始化兩個可關閉的資源
			// try語句會自動關閉這兩個資源。
			BufferedReader br = new BufferedReader(
				new FileReader("AutoCloseTest.java"));
			PrintStream ps = new PrintStream(new
				FileOutputStream("a.txt")))
		{
			// 使用兩個資源
			System.out.println(br.readLine());
			ps.println("莊生曉夢迷蝴蝶");
		}
	}
}
