
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
public class SearchTest
{
	public static void main(String[] args)
	{
		ArrayList nums = new ArrayList();
		nums.add(2);
		nums.add(-5);
		nums.add(3);
		nums.add(0);
		System.out.println(nums); // 輸出:[2, -5, 3, 0]
		System.out.println(Collections.max(nums)); // 輸出最大元素，將輸出3
		System.out.println(Collections.min(nums)); // 輸出最小元素，將輸出-5
		Collections.replaceAll(nums , 0 , 1); // 將nums中的0使用1來代替
		System.out.println(nums); // 輸出:[2, -5, 3, 1]
		// 判斷-5在List集合中出現的次數，返回1
		System.out.println(Collections.frequency(nums , -5));
		Collections.sort(nums); // 對nums集合排序
		System.out.println(nums); // 輸出:[-5, 1, 2, 3]
		//只有排序後的List集合才可用二分法查詢，輸出3
		System.out.println(Collections.binarySearch(nums , 3));
	}
}

