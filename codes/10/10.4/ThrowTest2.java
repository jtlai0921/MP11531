
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
public class ThrowTest2
{
	public static void main(String[] args)
		// Java 6認為①號程式碼可能拋出Exception，
		// 所以此處宣告拋出Exception
//		throws Exception
		// Java 7會檢查①號程式碼可能拋出異常的實際類型，
		// 因此此處只需宣告拋出FileNotFoundException即可。
		throws FileNotFoundException
	{
		try
		{
			new FileOutputStream("a.txt");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw ex;        // ①
		}
	}
}