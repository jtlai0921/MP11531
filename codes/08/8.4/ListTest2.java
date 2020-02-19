
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
class A
{
	public boolean equals(Object obj)
	{
		return true;
	}
}
public class ListTest2
{
	public static void main(String[] args)
	{
		List books = new ArrayList();
		books.add(new String("輕量級Java EE企業應用實戰"));
		books.add(new String("瘋狂Java講義"));
		books.add(new String("瘋狂Android講義"));
		System.out.println(books);
		// 刪除集合中A物件，將導致第一個元素被刪除
		books.remove(new A());     // ①
		System.out.println(books);
		// 刪除集合中A物件，再次刪除集合中第一個元素
		books.remove(new A());     // ②
		System.out.println(books);
	}
}
