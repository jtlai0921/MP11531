
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
public class WeakHashMapTest
{
	public static void main(String[] args)
	{
		WeakHashMap whm = new WeakHashMap();
		// 將WeakHashMap中添加三個key-value對，
		// 三個key都是匿名字串物件（沒有其他參照）
		whm.put(new String("語文") , new String("良好"));
		whm.put(new String("數學") , new String("及格"));
		whm.put(new String("英文") , new String("中等"));
		//將 WeakHashMap中添加一個key-value對，
		// 該key是一個系統快取的字串物件。
		whm.put("java" , new String("中等"));    // ①
		// 輸出whm物件，將看到4個key-value對。
		System.out.println(whm);
		// 通知系統立即進行垃圾回收
		System.gc();
		System.runFinalization();
		// 通常情況下，將只看到一個key-value對。
		System.out.println(whm);
	}
}
