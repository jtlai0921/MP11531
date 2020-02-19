
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
public class ThrowsTest2
{
	public static void main(String[] args)
		throws Exception
	{
		// 因為test()方法宣告拋出IOException異常，
		// 所以呼叫該方法的程式碼要麼處於try...catch區塊中，
		// 要麼處於另一個帶throws宣告拋出的方法中。
		test();
	}
	public static void test()throws IOException
	{
		// 因為FileInputStream的建構子宣告拋出IOException異常，
		// 所以呼叫FileInputStream的程式碼要麼處於try...catch區塊中，
		// 要麼處於另一個帶throws宣告拋出的方法中。
		FileInputStream fis = new FileInputStream("a.txt");
	}
}
