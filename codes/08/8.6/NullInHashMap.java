
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
public class NullInHashMap
{
	public static void main(String[] args)
	{
		HashMap hm = new HashMap();
		// 試圖將兩個key為null的key-value對放入HashMap中
		hm.put(null , null);
		hm.put(null , null);    // ①
		// 將一個value為null的key-value對放入HashMap中
		hm.put("a" , null);    // ②
		// 輸出Map物件
		System.out.println(hm);
	}
}
