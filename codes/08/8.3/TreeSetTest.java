
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
public class TreeSetTest
{
	public static void main(String[] args)
	{
		TreeSet nums = new TreeSet();
		// 向TreeSet中添加四個Integer物件
		nums.add(5);
		nums.add(2);
		nums.add(10);
		nums.add(-9);
		// 輸出集合元素，看到集合元素已經處於排序狀態
		System.out.println(nums);
		// 輸出集合裡的第一個元素
		System.out.println(nums.first()); // 輸出-9
		// 輸出集合裡的最後一個元素
		System.out.println(nums.last());  // 輸出10
		// 返回小於4的子集，不包含4
		System.out.println(nums.headSet(4)); // 輸出[-9, 2]
		// 返回大於5的子集，如果Set中包含5，子集中還包含5
		System.out.println(nums.tailSet(5)); // 輸出 [5, 10]
		// 返回大於等於-3，小於4的子集。
		System.out.println(nums.subSet(-3 , 4)); // 輸出[2]
	}
}
