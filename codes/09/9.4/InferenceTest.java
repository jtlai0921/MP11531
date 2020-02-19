

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
class MyUtil<E>
{
	public static <Z> MyUtil<Z> nil()
	{
		return null;
	}
	public static <Z> MyUtil<Z> cons(Z head, MyUtil<Z> tail)
	{
		return null;
	}
	E head()
	{
		return null;
	}
}
public class InferenceTest
{
	public static void main(String[] args)
	{
		// 可以通過方法賦值的目標參數來推斷類型參數為String
		MyUtil<String> ls = MyUtil.nil();
		// 無需使用下面語句在呼叫nil()方法時指定類型參數的類型
		MyUtil<String> mu = MyUtil.<String>nil();
		// 可呼叫cons方法所需的參數類型來推斷類型參數為Integer
		MyUtil.cons(42, MyUtil.nil());
		// 無需使用下面語句在呼叫nil()方法時指定類型參數的類型
		MyUtil.cons(42, MyUtil.<Integer>nil());

		// 希望系統能推斷出呼叫nil()方法類型參數為String類型，
		// 但實際上Java 8依然推斷不出來，所以下面程式碼報錯
//		String s = MyUtil.nil().head();
		String s = MyUtil.<String>nil().head();
	}
}