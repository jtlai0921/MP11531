
import java.util.*;
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
public class GenericMethodTest
{
	// 宣告一個泛型方法，該泛型方法中帶一個T類型形式參數，
	static <T> void fromArrayToCollection(T[] a, Collection<T> c)
	{
		for (T o : a)
		{
			c.add(o);
		}
	}
	public static void main(String[] args)
	{
		Object[] oa = new Object[100];
		Collection<Object> co = new ArrayList<>();
		// 下面程式碼中T代表Object類型
		fromArrayToCollection(oa, co);
		String[] sa = new String[100];
		Collection<String> cs = new ArrayList<>();
		// 下面程式碼中T代表String類型
		fromArrayToCollection(sa, cs);
		// 下面程式碼中T代表Object類型
		fromArrayToCollection(sa, co);
		Integer[] ia = new Integer[100];
		Float[] fa = new Float[100];
		Number[] na = new Number[100];
		Collection<Number> cn = new ArrayList<>();
		// 下面程式碼中T代表Number類型
		fromArrayToCollection(ia, cn);
		// 下面程式碼中T代表Number類型
		fromArrayToCollection(fa, cn);
		// 下面程式碼中T代表Number類型
		fromArrayToCollection(na, cn);
		// 下面程式碼中T代表Object類型
		fromArrayToCollection(na, co);
		// 下面程式碼中T代表String類型，但na是一個Number陣列，
		// 因為Number既不是String類型，
		// 也不是它的子類別，所以出現編譯錯誤
//		fromArrayToCollection(na, cs);
	}
}

