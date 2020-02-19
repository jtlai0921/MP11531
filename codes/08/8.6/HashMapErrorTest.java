
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
public class HashMapErrorTest
{
	public static void main(String[] args)
	{
		HashMap ht = new HashMap();
		// 此處的A類別與前一個程式的A類別是同一個類別
		ht.put(new A(60000) , "瘋狂Java講義");
		ht.put(new A(87563) , "輕量級Java EE企業應用實戰");
		// 獲得Hashtable的key Set集合對應的Iterator迭代器
		Iterator it = ht.keySet().iterator();
		// 取出Map中第一個key，並修改它的count值
		A first = (A)it.next();
		first.count = 87563;   // ①
		// 輸出{A@1560b=瘋狂Java講義, A@1560b=輕量級Java EE企業應用實戰}
		System.out.println(ht);
		// 只能刪除沒有被修改過的key所對應的key-value對
		ht.remove(new A(87563));
		System.out.println(ht);
		// 無法獲取剩下的value，下面兩行程式碼都將輸出null。
		System.out.println(ht.get(new A(87563)));   // ② 輸出null
		System.out.println(ht.get(new A(60000)));   // ③ 輸出null
	}
}

