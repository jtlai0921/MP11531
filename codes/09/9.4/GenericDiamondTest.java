

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

class MyClass<E>
{
	public <T> MyClass(T t)
	{
		System.out.println("t參數的值為：" + t);
	}
}
public class GenericDiamondTest
{
	public static void main(String[] args)
	{
		// MyClass類別宣告中的E形式參數是String類型。
		// 泛型建構子中宣告的T形式參數是Integer類型
		MyClass<String> mc1 = new MyClass<>(5);
		// 顯式指定泛型建構子中宣告的T形式參數是Integer類型，
		MyClass<String> mc2 = new <Integer> MyClass<String>(5);
		// MyClass類別宣告中的E形式參數是String類型。
		// 如果顯式指定泛型建構子中宣告的T形式參數是Integer類型
		// 此時就不能使用"菱形"語法，下面程式碼是錯的。
//		MyClass<String> mc3 = new <Integer> MyClass<>(5);
	}
}
