

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
public class ThrowTest
{
	public static void main(String[] args)
	{
		try
		{
			// 呼叫宣告拋出Checked異常的方法，要麼顯式捕獲該異常
			// 要麼在main方法中再次宣告拋出
			throwChecked(-3);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		// 呼叫宣告拋出Runtime異常的方法既可以顯式捕獲該異常，
		// 也可不理會該異常
		throwRuntime(3);
	}
	public static void throwChecked(int a)throws Exception
	{
		if (a > 0)
		{
			// 自行拋出Exception異常
			// 該程式碼必須處於try區塊裡，或處於帶throws宣告的方法中
			throw new Exception("a的值大於0，不符合要求");
		}
	}
	public static void throwRuntime(int a)
	{
		if (a > 0)
		{
			// 自行拋出RuntimeException異常，既可以顯式捕獲該異常
			// 也可完全不理會該異常，把該異常交給該方法呼叫者處理
			throw new RuntimeException("a的值大於0，不符合要求");
		}
	}
}

