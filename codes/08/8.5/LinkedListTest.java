
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
public class LinkedListTest
{
	public static void main(String[] args)
	{
		LinkedList books = new LinkedList();
		// 將字串元素加入佇列的尾部
		books.offer("瘋狂Java講義");
		// 將一個字串元素加入堆疊的頂部
		books.push("輕量級Java EE企業應用實戰");
		// 將字串元素添加到佇列的頭部（相當於堆疊的頂部）
		books.offerFirst("瘋狂Android講義");
		// 以List的方式（按索引存取的方式）來遍歷集合元素
		for (int i = 0; i < books.size() ; i++ )
		{
			System.out.println("遍歷中：" + books.get(i));
		}
		// 存取、並不刪除堆疊頂的元素
		System.out.println(books.peekFirst());
		// 存取、並不刪除佇列的最後一個元素
		System.out.println(books.peekLast());
		// 將堆疊頂的元素彈出「堆疊」
		System.out.println(books.pop());
		// 下面輸出將看到佇列中第一個元素被刪除
		System.out.println(books);
		// 存取、並刪除佇列的最後一個元素
		System.out.println(books.pollLast());
		// 下面輸出：[輕量級Java EE企業應用實戰]
		System.out.println(books);
	}
}
