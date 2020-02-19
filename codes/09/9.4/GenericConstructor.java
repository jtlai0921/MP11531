

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

class Foo
{
	public <T> Foo(T t)
	{
		System.out.println(t);
	}
}
public class GenericConstructor
{
	public static void main(String[] args)
	{
		// 泛型建構子中的T參數為String。
		new Foo("瘋狂Java講義");
		// 泛型建構子中的T參數為Integer。
		new Foo(200);
		// 顯式指定泛型建構子中的T參數為String，
		// 傳給Foo建構子的實際參數也是String物件，完全正確。
		new <String> Foo("瘋狂Android講義");
		// 顯式指定泛型建構子中的T參數為String，
		// 但傳給Foo建構子的實際參數是Double物件，下面程式碼出錯
		new <String> Foo(12.3);
	}
}
