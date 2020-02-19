
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
public class PriorityQueueTest
{
	public static void main(String[] args)
	{
		PriorityQueue pq = new PriorityQueue();
		// 下面程式碼依次向pq中加入四個元素
		pq.offer(6);
		pq.offer(-3);
		pq.offer(20);
		pq.offer(18);
		// 輸出pq佇列，並不是按元素的加入順序排列
		System.out.println(pq); // 輸出[-3, 6, 20, 18]
		// 存取佇列第一個元素，其實就是佇列中最小的元素：-3
		System.out.println(pq.poll());
	}
}
