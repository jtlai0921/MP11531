
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
public class SortTest
{
	public static void main(String[] args)
	{
		ArrayList nums = new ArrayList();
		nums.add(2);
		nums.add(-5);
		nums.add(3);
		nums.add(0);
		System.out.println(nums); // 輸出:[2, -5, 3, 0]
		Collections.reverse(nums); // 將List集合元素的次序反轉
		System.out.println(nums); // 輸出:[0, 3, -5, 2]
		Collections.sort(nums); // 將List集合元素的按自然順序排序
		System.out.println(nums); // 輸出:[-5, 0, 2, 3]
		Collections.shuffle(nums); // 將List集合元素的按隨機順序排序
		System.out.println(nums); // 每次輸出的次序不固定
	}
}
