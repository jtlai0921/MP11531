
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
public class CollectionTest
{
	public static void main(String[] args)
	{
		Collection c = new ArrayList();
		// 添加元素
		c.add("孫悟空");
		// 雖然集合裡不能放基本類型的值，但Java支援自動裝箱
		c.add(6);
		System.out.println("c集合的元素個數為:" + c.size()); // 輸出2
		// 刪除指定元素
		c.remove(6);
		System.out.println("c集合的元素個數為:" + c.size()); // 輸出1
		// 判斷是否包含指定字串
		System.out.println("c集合的是否包含\"孫悟空\"字串:"
			+ c.contains("孫悟空")); // 輸出true
		c.add("輕量級Java EE企業應用實戰");
		System.out.println("c集合的元素：" + c);
		Collection books = new HashSet();
		books.add("輕量級Java EE企業應用實戰");
		books.add("瘋狂Java講義");
		System.out.println("c集合是否完全包含books集合？"
			+ c.containsAll(books)); // 輸出false
		// 用c集合減去books集合裡的元素
		c.removeAll(books);
		System.out.println("c集合的元素：" + c);
		// 刪除c集合裡所有元素
		c.clear();
		System.out.println("c集合的元素：" + c);
		// 控制books集合裡只剩下c集合裡也包含的元素
		books.retainAll(c);
		System.out.println("books集合的元素:" + books);
	}
}