

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
public class MultiExceptionTest
{
	public static void main(String[] args)
	{
		try
		{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a / b;
			System.out.println("您輸入的兩個數相除的結果是：" + c );
		}
		catch (IndexOutOfBoundsException|NumberFormatException
			|ArithmeticException ie)
		{
			System.out.println("程式發生了陣列越界、數字格式異常、算術異常之一");
			// 捕捉多異常時，異常變數預設有final修飾，
			// 所以下面程式碼有錯：
			ie = new ArithmeticException("test");  // ①
		}
		catch (Exception e)
		{
			System.out.println("未知異常");
			// 捕捉一個類型的異常時，異常變數沒有final修飾
			// 所以下面程式碼完全正確。
			e = new RuntimeException("test");    // ②
		}
	}
}

