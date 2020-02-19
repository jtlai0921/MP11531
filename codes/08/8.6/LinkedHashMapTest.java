
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
public class LinkedHashMapTest
{
	public static void main(String[] args)
	{
		LinkedHashMap scores = new LinkedHashMap();
		scores.put("語文" , 80);
		scores.put("英文" , 82);
		scores.put("數學" , 76);
		// 呼叫forEach方法遍歷scores裡的所有key-value對
		scores.forEach((key, value) -> System.out.println(key + "-->" + value));
	}
}
