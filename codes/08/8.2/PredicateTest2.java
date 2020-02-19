
import java.util.*;
import java.util.function.*;
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
public class PredicateTest2
{
	public static void main(String[] args)
	{
		// 建立books集合、為books集合添加元素的程式碼與前一個程式相同。
		Collection books = new HashSet();
		books.add(new String("輕量級Java EE企業應用實戰"));
		books.add(new String("瘋狂Java講義"));
		books.add(new String("瘋狂iOS講義"));
		books.add(new String("瘋狂Ajax講義"));
		books.add(new String("瘋狂Android講義"));
		// 統計書名包含「瘋狂」子串的圖書數量
		System.out.println(calAll(books , ele->((String)ele).contains("瘋狂")));
		// 統計書名包含「Java」子串的圖書數量
		System.out.println(calAll(books , ele->((String)ele).contains("Java")));
		// 統計書名字串長度大於10的圖書數量
		System.out.println(calAll(books , ele->((String)ele).length() > 10));
	}
	public static int calAll(Collection books , Predicate p)
	{
		int total = 0;
		for (Object obj : books)
		{
			// 使用Predicate的test()方法判斷該物件是否滿足Predicate指定的條件
			if (p.test(obj))
			{
				total ++;
			}
		}
		return total;
	}
}
