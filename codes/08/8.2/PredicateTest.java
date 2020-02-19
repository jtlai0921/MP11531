
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
public class PredicateTest
{
	public static void main(String[] args)
	{
		// 建立一個集合
		Collection books = new HashSet();
		books.add(new String("輕量級Java EE企業應用實戰"));
		books.add(new String("瘋狂Java講義"));
		books.add(new String("瘋狂iOS講義"));
		books.add(new String("瘋狂Ajax講義"));
		books.add(new String("瘋狂Android講義"));
		// 使用Lambda運算式（目標類型是Predicate）過濾集合
		books.removeIf(ele -> ((String)ele).length() < 10);
		System.out.println(books);
	}
}
