
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
public class MapTest
{
	public static void main(String[] args)
	{
		Map map = new HashMap();
		// 成對放入多個key-value對
		map.put("瘋狂Java講義" , 109);
		map.put("瘋狂iOS講義" , 10);
		map.put("瘋狂Ajax講義" , 79);
		// 多次放入的key-value對中value可以重複
		map.put("輕量級Java EE企業應用實戰" , 99);
		// 放入重複的key時，新的value會覆蓋原有的value
		// 如果新的value覆蓋了原有的value，該方法返回被覆蓋的value
		System.out.println(map.put("瘋狂iOS講義" , 99)); // 輸出10
		System.out.println(map); // 輸出的Map集合包含4個key-value對
		// 判斷是否包含指定key
		System.out.println("是否包含值為 瘋狂iOS講義 key："
			+ map.containsKey("瘋狂iOS講義")); // 輸出true
		// 判斷是否包含指定value
		System.out.println("是否包含值為 99 value："
			+ map.containsValue(99)); // 輸出true
		// 獲取Map集合的所有key組成的集合，通過遍歷key來實作遍歷所有key-value對
		for (Object key : map.keySet() )
		{
			// map.get(key)方法獲取指定key對應的value
			System.out.println(key + "-->" + map.get(key));
		}
		map.remove("瘋狂Ajax講義"); // 根據key來刪除key-value對。
		System.out.println(map); // 輸出結果不再包含 瘋狂Ajax講義=79 的key-value對
	}
}
