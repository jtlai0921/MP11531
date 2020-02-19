
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
public class ArrayDequeQueue
{
	public static void main(String[] args)
	{
		ArrayDeque queue = new ArrayDeque();
		// 依次將三個元素加入佇列
		queue.offer("瘋狂Java講義");
		queue.offer("輕量級Java EE企業應用實戰");
		queue.offer("瘋狂Android講義");
		// 輸出：[瘋狂Java講義, 輕量級Java EE企業應用實戰, 瘋狂Android講義]
		System.out.println(queue);
		// 存取佇列頭部的元素，但並不將其poll出佇列"堆疊"，輸出：瘋狂Java講義
		System.out.println(queue.peek());
		// 依然輸出：[瘋狂Java講義, 輕量級Java EE企業應用實戰, 瘋狂Android講義]
		System.out.println(queue);
		// poll出第一個元素，輸出：瘋狂Java講義
		System.out.println(queue.poll());
		// 輸出：[輕量級Java EE企業應用實戰, 瘋狂Android講義]
		System.out.println(queue);
	}
}
