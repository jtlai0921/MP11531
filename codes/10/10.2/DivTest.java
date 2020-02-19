

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
public class DivTest
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
		catch (IndexOutOfBoundsException ie)
		{
			System.out.println("陣列越界：運行程式時輸入的參數個數不夠");
		}
		catch (NumberFormatException ne)
		{
			System.out.println("數字格式異常：程式只能接受整數參數");
		}
		catch (ArithmeticException ae)
		{
			System.out.println("算術異常");
		}
		catch (Exception e)
		{
			System.out.println("未知異常");
		}
	}
}

